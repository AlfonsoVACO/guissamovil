package guissa.com.guissamexico.fragmentos;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.util.ArrayList;

import guissa.com.guissamexico.R;
import guissa.com.guissamexico.adaptadores.AdaptadorProductos;
import guissa.com.guissamexico.modelo.Producto;
import guissa.com.guissamexico.utilidades.Constantes;
import guissa.com.guissamexico.utilidades.Resources;


/**
 * Created by Alfonso on 17/02/2018.
 */

public class FragmentoProductos extends Fragment implements Response.Listener<JSONObject>, Response.ErrorListener{
    private Log LOGGER =  LogFactory.getLog(FragmentoProductos.class);
    private ListView lista;
    private ImageButton imgButton;
    private TextView txtproducto;

    private RecyclerView recyclerView;
    ArrayList<Producto> listProducto;
    ProgressDialog progressDialog;
    RequestQueue requestQueue;
    JsonObjectRequest jsonObjectRequest;

    public FragmentoProductos(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragmento_productos, container, false);

        listProducto = new ArrayList<>();
        recyclerView = (RecyclerView) view.findViewById(R.id.reciclador_productos);
        recyclerView.setLayoutManager( new LinearLayoutManager( getContext() ) );
        recyclerView.setHasFixedSize( true );

        requestQueue = Volley.newRequestQueue( getContext() );

        getRequestAdapter();

        return view;
    }


    private void getRequestAdapter(){
        progressDialog = new ProgressDialog( getContext() );
        progressDialog.setMessage("Espere un momento...");
        progressDialog.show();

        jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,
                Constantes.GET_PRODUCTO,null, this, this);
        //requestQueue.add(jsonObjectRequest);

        int socketTimeout = 30000;//30 seconds - change to what you want
        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(
                DefaultRetryPolicy.DEFAULT_TIMEOUT_MS * 2,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        requestQueue.add(jsonObjectRequest);
    }

    @Override
    public void onResponse(JSONObject response) {
        Toast.makeText(getContext(), "Ejexutando: OnResponse()", Toast.LENGTH_LONG);
        Producto producto = null;
        Toast.makeText(getContext(), response.toString(), Toast.LENGTH_LONG);
        try{
            JSONArray json = new JSONArray( response.toString() );//response.optJSONArray("");

            for(int i = 0; i < json.length(); i++){
                producto = new Producto();
                JSONObject jsonObject = null;
                jsonObject = json.getJSONObject(i);

                producto.setFechaH( Resources.convertStringToDate( jsonObject.optString("fechaH"), "yyyy-MM-dd" ));
                producto.setNombre( jsonObject.optString("nombre"));

                /*Galeria galeria = new Galeria();
                galeria.setNombre( jsonObject.optString("imagen"));*/

                listProducto.add( producto );
            }

            progressDialog.hide();
            AdaptadorProductos adaptadorProductos = new AdaptadorProductos(listProducto);
            recyclerView.setAdapter( adaptadorProductos );
        } catch (JSONException e) {
            Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_LONG);
            progressDialog.hide();
        } catch (ParseException e) {
            Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_LONG);
            progressDialog.hide();
        }
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        if(error instanceof TimeoutError){
            Toast.makeText(getContext(), "Tiempo de espera: "+error.getMessage(), Toast.LENGTH_LONG);
        }
    }
}
