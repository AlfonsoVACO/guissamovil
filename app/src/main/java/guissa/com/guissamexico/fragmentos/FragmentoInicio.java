package guissa.com.guissamexico.fragmentos;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

import guissa.com.guissamexico.R;
import guissa.com.guissamexico.adaptadores.AdaptadorInicio;
import guissa.com.guissamexico.modelo.Banner;
import guissa.com.guissamexico.modelo.Userc;
import guissa.com.guissamexico.utilidades.Constantes;
import guissa.com.guissamexico.utilidades.Recursos;
import guissa.com.guissamexico.web.VolleySingleton;


/**
 * Created by Alfonso on 17/02/2018.
 */

public class FragmentoInicio extends Fragment  {

    private ListView lista;

    public FragmentoInicio() {
    }

    //@RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmento_inicio, container, false);
        cargaBanner( view );
        try {
            getAll();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return view;
    }

    //@RequiresApi(api = Build.VERSION_CODES.O)
    private void cargaBanner(View view){
        lista = (ListView) view.findViewById(R.id.listabanner);
        List<Banner> from = getBannerVolley();
        AdaptadorInicio adapter = new AdaptadorInicio( getContext(), from);
        adapter.notifyDataSetChanged();
        lista.setAdapter(adapter);
    }

    private void getAll() throws IOException {
        URL githubEndpoint = new URL( Constantes.GET_BANNER );
        HttpsURLConnection myConnection =  (HttpsURLConnection) githubEndpoint.openConnection();
        if (myConnection.getResponseCode() == 200) {
            InputStream responseBody = myConnection.getInputStream();
            InputStreamReader responseBodyReader = new InputStreamReader(responseBody, "UTF-8");
            JsonReader jsonReader = new JsonReader(responseBodyReader);
            jsonReader.beginObject();
            String value = "";
            while (jsonReader.hasNext()) {
                String key = jsonReader.nextName();
                if (key.equals("idBanner")) {
                    value += jsonReader.nextString();
                    break; // Break out of the loop
                } else {
                    jsonReader.skipValue(); // Skip values of other keys
                }
            }
            jsonReader.close();
            myConnection.disconnect();
            Toast.makeText(getContext(), value, Toast.LENGTH_SHORT);
        }
    }

    //@RequiresApi(api = Build.VERSION_CODES.O)
    private ArrayList<Banner> getBannerVolley() {
        ArrayList<Banner> lstBanner = new ArrayList<>();
        try {
            HttpGet httpGet = new HttpGet( Constantes.GET_BANNER );
            HttpClient httpClient = new DefaultHttpClient();
            HttpResponse response = (HttpResponse) httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            BufferedHttpEntity buffer = new BufferedHttpEntity(entity);
            InputStream iStream = buffer.getContent();

            String aux = "";

            BufferedReader r = new BufferedReader(new InputStreamReader(iStream));
            String line;
            while ((line = r.readLine()) != null) {
                aux += line;
            }
            Toast.makeText(getContext(), aux, Toast.LENGTH_SHORT);
            /*ArrayList<Map<Object,Object>> mapaBanner = (ArrayList<Map<Object,Object>>) Recursos.getMapFromHttpResponse(aux, false);

            for(Map<Object,Object> item : mapaBanner){
                Banner banner = new Banner(
                        toInt( item.get("idBanner").toString() ),
                        item.get("nombre").toString(),
                        item.get("subTitle").toString(),
                        (byte[]) item.get("imagen") );
                lstBanner.add(banner);
            }*/

        } catch (Exception e) {
            Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT);
        }
        return lstBanner;
    }

    private int toInt(String cadena){
        return Integer.parseInt(cadena);
    }

}
