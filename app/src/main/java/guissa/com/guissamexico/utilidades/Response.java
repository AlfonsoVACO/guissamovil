package guissa.com.guissamexico.utilidades;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Alfonso on 13/05/2018.
 */

public class Response {

    private String cadena_json = "";
    private JSONObject jsonObj = null;

    public Response(String response_body) throws JSONException {
        this.cadena_json = response_body;
        jsonObj = new JSONObject(cadena_json);
    }

    public Response() {}

    private JSONArray arregloindexcero;
    private ArrayList<Map<Object,Object>> map_all;

    public void setConfiguration(String response_body) throws JSONException {
        arregloindexcero = new JSONArray(response_body);
    }

    public ArrayList<Map<Object,Object>> getMapResponseManyJSON() throws JSONException {
        map_all = new ArrayList<>();
        for(int i = 0; i < arregloindexcero.length(); i++){
            JSONObject itemObjetoJSON = (JSONObject) arregloindexcero.get(i);
            Iterator<String> datos = itemObjetoJSON.keys();
            setToMapArray( datos, itemObjetoJSON );
        }
        return map_all;
    }

    private void setToMapArray(Iterator<String> datos, JSONObject jsonObj) throws JSONException {
        Map<Object,Object> mapa = new HashMap<>();
        while ( datos.hasNext() ) {
            String key = datos.next();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                if( jsonObj.get(key).getClass().getTypeName().equals( "org.json.JSONObject" ) ) {
                    mapa.put(key, (JSONObject) jsonObj.get(key) );
                }else
                    mapa.put(key, jsonObj.get(key) );
            }
        }
        map_all.add(mapa);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public Map<Object,Object> getMapResponseOnlyOne() throws JSONException {
        Map<Object,Object> mapa = new HashMap<>();
        Iterator<String> datos = jsonObj.keys();
        return getMapa(mapa,datos);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private Map<Object,Object> getMapa(Map<Object,Object> mapa, Iterator<String> datos) throws JSONException{
        while ( datos.hasNext() ) {
            String key = datos.next();
            System.out.println(jsonObj.get(key).getClass().getTypeName());
            if(jsonObj.get(key).getClass().getTypeName().equals("org.json.JSONObject")) {
                mapa.put(key, (JSONObject) jsonObj.get(key) );
            }else
                mapa.put(key, jsonObj.get(key) );
        }
        return mapa;
    }

}
