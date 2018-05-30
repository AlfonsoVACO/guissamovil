package guissa.com.guissamexico.fragmentos.personal;

import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import guissa.com.guissamexico.R;
import guissa.com.guissamexico.adaptadores.AdaptadorPNegocio;
import guissa.com.guissamexico.local.SQLControlador;
import guissa.com.guissamexico.modelo.Estados;
import guissa.com.guissamexico.modelo.Negocios;
import guissa.com.guissamexico.utilidades.Constantes;

/**
 * Created by Alfonso on 17/02/2018.
 */

public class FragmentoPNegocios extends Fragment {

    TextView clave, nombre,direccion,depart,ciudad, telefono;
    Map<String,Object> mapa_de_datos;
    private SQLControlador dbconeccion;

    public FragmentoPNegocios(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmento_personal_negocio, container, false);

        mapa_de_datos = getDatosPersonales();

        if(!mapa_de_datos.isEmpty()){
            getAcciones(view); // esta registrado

        }else{
            getLoggin();
            mapa_de_datos = getDatosPersonales();
            if(!mapa_de_datos.isEmpty()){
                getAcciones(view); // esta registrado
            }
        }

        return view;
    }

    private void getAcciones(View view){

        ListView lvCities = (ListView) view.findViewById(R.id.pager_personal_negocio);
        ArrayList<Negocios> negociosAvaiable = new ArrayList<Negocios>();
/*
        try {
            // Llamamos al servicio web para recuperar los datos
            HttpGet httpGet = new HttpGet(
                    Constantes.GET_P_NEGOCIO + mapa_de_datos.get("id"));
            HttpClient httpClient = new DefaultHttpClient();
            HttpResponse response = (HttpResponse)httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            BufferedHttpEntity buffer = new BufferedHttpEntity(entity);
            InputStream iStream = buffer.getContent();

            String aux = "";

            BufferedReader r = new BufferedReader(new InputStreamReader(iStream));
            StringBuilder total = new StringBuilder();
            String line;
            while ((line = r.readLine()) != null) {
                aux += line;
            }

            // Parseamos la respuesta obtenida del servidor a un objeto JSON
            JSONObject jsonObject = new JSONObject(aux);
            JSONArray cities = jsonObject.names();

            // Recorremos el array con los elementos cities
            for(int i = 0; i < cities.length(); i++) {
                JSONObject json_negocio = cities.getJSONObject(i);

                //Negocios c = new Negocios(city.getInt("id"), city.getString("name"));
                Negocios negocio = new Negocios();
                Estados estado = new Estados();

                negocio.setNombre( json_negocio.getString("nombre") );
                negocio.setDireccion( json_negocio.getString("direccion") );
                negocio.setTelefono( json_negocio.getString("telefono") );

                JSONObject jsonObjectEstado = new JSONObject("idEstado");
                JSONArray estados = jsonObjectEstado.names();
                for(int j = 0; i < estados.length(); j++) {
                    JSONObject json_estados = estados.getJSONObject(j);
                    estado.setNombre( json_estados.getString("nombre") );
                }
                negocio.setIdEstado(estado);
                estado.setNombre("nombre");
                negocio.setImagenData(json_negocio.getString("imagen"));

                // Almacenamos el objeto en el array que hemos creado anteriormente
                negociosAvaiable.add(negocio);
            }
        }
        catch(Exception e) {
            Log.e("WebService", e.getMessage());
        }

        // Creamos el objeto CityAdapter y lo asignamos al ListView
        AdaptadorPNegocio adaptadorPNegocio = new AdaptadorPNegocio(getActivity(), negociosAvaiable);
        lvCities.setAdapter(adaptadorPNegocio);
        lvCities.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                clave = (TextView) view.findViewById(R.id.negocio_p_id);
                nombre = (TextView) view.findViewById(R.id.texto_nombre);
                direccion = (TextView) view.findViewById(R.id.texto_direccion);
                ciudad = (TextView) view.findViewById(R.id.texto_ciudad);
                telefono = (TextView) view.findViewById(R.id.texto_telefono);


                String aux_clave = clave.getText().toString();
                final String aux_nombre = nombre.getText().toString();
                final String aux_precio = direccion.getText().toString();
                final String aux_ciudad = ciudad.getText().toString();
                final String aux_telefono = telefono.getText().toString();
            }
        });*/
    }

    private Map<String,Object> getDatosPersonales(){
        Map<String,Object> arreglo_datos = new HashMap<String,Object>();

        dbconeccion = new SQLControlador(getContext());
        dbconeccion.abrirBaseDeDatos();
        Cursor cursor = dbconeccion.getDatosPersonal();
        if (cursor.moveToFirst()) {
            do {
                arreglo_datos.put( "id", cursor.getInt(0) );
                arreglo_datos.put( "correo", cursor.getString(1) );

            } while (cursor.moveToNext());
            cursor.close();
        }
        dbconeccion.cerrar();

        return arreglo_datos;
    }

    private void getLoggin(){
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Obtener mis datos");
        View viewInflated = LayoutInflater.from(getContext())
                .inflate(R.layout.login_personal, (ViewGroup) getView(), false);
        final EditText input = (EditText) viewInflated.findViewById(R.id.strCorroPersonal);

        builder.setView(viewInflated);

        builder.setPositiveButton("Acceder", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                String correo = input.getText().toString();
                guardarDatosPersonales(correo);
            }
        });
        builder.show();
    }

    private void guardarDatosPersonales(String correo){
        dbconeccion = new SQLControlador(getContext());
        dbconeccion.abrirBaseDeDatos();
        dbconeccion.insertarDatosPersonal(correo);
        dbconeccion.cerrar();
    }
}
