package guissa.com.guissamexico.utilidades;

/**
 * Created by Alfonso on 18/02/2018.
 */

public class Constantes {

    public enum Claves{
        ID_P_NEGOCIO;

        public String getString(){
            switch(this){
                case ID_P_NEGOCIO: return "";
            }

            return "0";
        }
    }

    public static final int CODIGO_DETALLE = 100;
    public static final int CODIGO_ACTUALIZACION = 101;
    private static final String PUERTO_HOST = ":8080";
    private static final String IP = "192.168.0.83";
    private static final String SERVICE = "webresources/api";

    /**
     * URLs del Web Service
     */
    public static final String GET = "http://" + IP + PUERTO_HOST + "/guissa/webresources/api/banner";
    public static final String GET_BANNER = "http://" + IP + PUERTO_HOST + "/guissa/webresources/api/banner";

    public static final String GET_P_NEGOCIO = "http://" + IP + PUERTO_HOST + "/guissa/webresources/api/negocios/cliente/";


    public static final String GET_BY_ID = "http://" + IP + PUERTO_HOST + "/guisa/"+ SERVICE +"/obtener_meta_por_id.php";




    public static final String UPDATE = "http://" + IP + PUERTO_HOST + "/guissa/"+ SERVICE +"/actualizar_meta.php";
    public static final String DELETE = "http://" + IP + PUERTO_HOST + "/guissa/"+ SERVICE +"/borrar_meta.php";
    public static final String INSERT = "http://" + IP + PUERTO_HOST + "/guissa/"+ SERVICE +"/insertar_meta.php";

}
