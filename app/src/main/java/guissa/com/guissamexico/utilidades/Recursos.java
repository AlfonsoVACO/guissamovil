package guissa.com.guissamexico.utilidades;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.annotation.RequiresApi;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Alfonso on 20/02/2018.
 */

public class Recursos {

    private static String cadena_json = "";
    private static JSONObject jsonObj = null;

    public Bitmap conertByteArrayToBitMap(byte[] arreglo_bytes){
        return BitmapFactory.decodeByteArray(arreglo_bytes, 0, arreglo_bytes.length);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static Object getMapFromHttpResponse(String response, boolean type) throws JSONException {
        if (!response.isEmpty()) {
            if(type) {
                Response class_response = new Response(response);
                return class_response.getMapResponseOnlyOne();
            }else{
                Response class_response = new Response();
                class_response.setConfiguration( response);
                return class_response.getMapResponseManyJSON();
            }
        }

        return new HashMap<>();
    }
}
