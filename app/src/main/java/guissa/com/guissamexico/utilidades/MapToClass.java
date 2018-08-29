package guissa.com.guissamexico.utilidades;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONArray;

/**
 * <p>Esta clase convierte un mapa a una clase, las keys del mapa deben
 * ser las mismas que la propiedad de una clase, de otra manera las tomará
 * como NULL.</p>
 * <p>Para usar la clase deben de agregarse (o no) cabeceras, esto es que
 * los datos al traerlos del response, son todos cadenas o arreglos de
 * objetos, de esta manera se distinguiran al momento de agregarlos en
 * una propiedad, pues con las cabeceras se pueden especificar qué tipo
 * de valor es una propiedad.<br>Para agregar una cabecera, se crea un mapa:</p>
 * <code>
 * {@code Map<String, Object> headers = new HashMap<>();}<br>
 * {@code headers.put("date", new Date()); }<br>
 * {@code headers.put("classList", new Tarjetas());}
 * </code>
 * <p>Cuando se encuentre un arreglo que coincida con esa cabecera, se creará un
 * objeto del mismo tiempo para agregarselo.</p>
 * <p>Para usar la clase, especificamos que clase será la que tomará, y en el
 * constructor se agrega el mapa a convertir, en caso de que no se agreguen las
 * cabeceras, se usa el constructor que no contenga el header, esto creará un
 * mapa vacío (para evitar NULL)<br>
 * Seguidamente se llama al metodo {@link #getClassOfMap(Object)}
 * especificandole el tipo de retorno.</p>
 * <code>
 * {@code MapToClass<Usuarios> ms = new MapToClass<>(mapos, headers); }<br>
 * {@code ms.getClassOfMap(new Usuarios()); }
 * </code>
 * @author Alfonso Vásquez
 * @version 1.0
 * */
public class MapToClass <T>{

    private static final Log LOGGER = LogFactory.getLog(MapToClass.class);

    private Map<Object,Object> mapa;
    private Map<String,Object> headers;
    private T classeOf;
    private Class<?> goClass;
    private Object objeto = new Object();

    public MapToClass(Map<Object,Object> mapa, Map<String,Object> headers) {
        this.mapa = mapa;
        this.headers = headers;
    }

    public MapToClass(Map<Object,Object> mapa) {
        this.mapa = mapa;
        this.headers = new HashMap<>();
    }

    /**
     * <p>Este metodo retorna el objeto al cual se está especificando
     * con el mapa previamente configurado y con las cabeceras agregadas.
     * Cada vez que encuentre un header buscará una accion especifica para
     * agregarla como valor ( {@link #getTypeAction(Object, Object)}),
     * en cambio si no hay una cabecera, agregará el valor al
     * campo por defecto {@link #setValueToField(String, Object)}.</p>
     * @param 'T' Tipo de clase
     * @return T
     * @exception Exception
     * */
    public T getClassOfMap(T classe){
        LOGGER.info("getClassOfMap(T)");
        this.classeOf = classe;
        this.goClass = this.classeOf.getClass();

        Iterator<Map.Entry<Object,Object>> it = mapa.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Object,Object> entry = it.next();
            try {
                if(headers.containsKey( entry.getKey())) {
                    Object objType = getTypeAction(entry.getKey() , entry.getValue());
                    setValueToField( ( String ) entry.getKey(), objType);
                }else
                    setValueToField( ( String ) entry.getKey(), entry.getValue());
            }catch(Exception ex) {
                ex.getMessage();
            }
        }
        return this.classeOf;
    }

    private Object getTypeAction(Object key, Object value) throws Exception {
        switch( headers.get(key).getClass().getSimpleName() ) {
            case "Date":
                return Resources.convertStringToDate( (String) value, "yyyy-MM-dd");
            case "Integer":
                return Integer.parseInt( value.toString());
            case "Short":
                return Resources.stringToShort( Resources.integerToString ( (Integer) value) );
            default:
                if(value instanceof JSONArray ){
                    Response classResponse = new Response();
                    classResponse.setConfiguration( value.toString() );
                    getKey(key);
                    List<Map<Object,Object>> arregloDatos = classResponse.getMapResponseManyJSON();
                    return getClassArray( arregloDatos );
                }else{
                    Response classResponse = new Response( value.toString() );
                    getKey(key);
                    Map<Object,Object> arregloDatos = null;
                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                        arregloDatos = classResponse.getMapResponseOnlyOne();
                    }
                    return arregloDatos != null ? getClassObject( arregloDatos ) : "";
                }
        }

    }

    private void getKey(Object key) {
        Iterator<Map.Entry<String,Object>> it = headers.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Object> entry = it.next();
            if( entry.getKey().equals( key ) ) this.objeto = entry.getValue();
        }
    }

    /**
     * <p>Agregar un valor a la propiedad actual de la clase actual</p>
     * @param 'String'
     * @param 'Object'
     * @see #getClassOfMap(Object)
     * */
    private void setValueToField(String key, Object value) {
        try {
            Field attributo = this.goClass.getDeclaredField( (String) key );
            attributo.setAccessible(true);
            attributo.set(this.classeOf, value);
        }catch(Exception ex) {
            ex.getMessage();
        }
    }

    /**
     * <p>Convierte un arreglo de mapas a un arreglo de Clases,
     * las clases son especificadas con las cabeceras.</p>
     * @param {@code ArrayList<Map<Object,Object>> }
     * @see #getTypeAction(Object, Object)
     * @return {@code ArrayList<T> }
     * */
    @SuppressWarnings("unchecked")
    private ArrayList<T> getClassArray(List<Map<Object,Object>> mapaNewClass) {
        LOGGER.info("getClassArray(List<Map<Object,Object>>)");
        ArrayList<T> listaDeClasesGenericas = new ArrayList<>();
        for(int i = 0; i < mapaNewClass.size(); i++){
            try {
                T classe = (T) this.objeto.getClass().newInstance();
                Class<?> goNewClass = classe.getClass();

                Iterator<Map.Entry<Object,Object>> it = mapaNewClass.get(i).entrySet().iterator();
                while ( it.hasNext() ) {
                    Map.Entry<Object, Object> entry = it.next();
                    try {
                        Field attributo = goNewClass.getDeclaredField( (String) entry.getKey() );
                        attributo.setAccessible(true);
                        if(headers.containsKey( entry.getKey() )) {
                            Object objType = getTypeAction(entry.getKey() , entry.getValue());
                            attributo.set(classe, objType);
                        } else
                            attributo.set(classe, entry.getValue());
                    }catch(Exception ex) {
                        ex.getMessage();
                    }
                }

                listaDeClasesGenericas.add(classe);
            }catch(Exception ex) {
                ex.getMessage();
            }
        }

        return listaDeClasesGenericas;
    }

    private T getClassObject(Map<Object,Object> mapaNewClass){
        try {
            T classe = (T) this.objeto.getClass().newInstance();
            Class<?> goNewClass = classe.getClass();

            Iterator<Map.Entry<Object,Object>> it = mapaNewClass.entrySet().iterator();
            while ( it.hasNext() ) {
                Map.Entry<Object, Object> entry = it.next();
                try {
                    Field attributo = goNewClass.getDeclaredField( (String) entry.getKey() );
                    attributo.setAccessible(true);
                    if(headers.containsKey( entry.getKey() )) {
                        Object objType = getTypeAction(entry.getKey() , entry.getValue());
                        attributo.set(classe, objType);
                    } else
                        attributo.set(classe, entry.getValue());
                }catch(Exception ex) {
                    ex.getMessage();
                }
            }

            return classe;
        }catch(Exception ex) {
            ex.getMessage();
        }
        return classeOf ;
    }
}
