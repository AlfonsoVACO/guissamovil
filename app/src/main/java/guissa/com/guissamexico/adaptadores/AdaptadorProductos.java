package guissa.com.guissamexico.adaptadores;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import java.io.ByteArrayInputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import guissa.com.guissamexico.R;
import guissa.com.guissamexico.modelo.Producto;
import guissa.com.guissamexico.utilidades.Constantes;
import guissa.com.guissamexico.utilidades.Resources;
import guissa.com.guissamexico.web.VolleySingleton;

import static com.android.volley.VolleyLog.TAG;

/**
 * Created by Alfonso on 31/05/2018.
 */

public class AdaptadorProductos extends RecyclerView.Adapter<AdaptadorProductos.ProductoHolder> {
    List<Producto> items;

    public AdaptadorProductos(List<Producto> items){
        this.items = items;
    }

    @Override
    public ProductoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from( parent.getContext()).inflate( R.layout.lista_productos,
                parent, false) ;

        RecyclerView.LayoutParams layoutParams= new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        vista.setLayoutParams( layoutParams );
        return new ProductoHolder(vista);
    }

    @Override
    public void onBindViewHolder(ProductoHolder holder, int position) {
        holder.nombre.setText( items.get(position).getNombre() );
        holder.precio.setText( items.get(position).getFechaH().toString() );
        holder.imagen.setImageResource(R.drawable.material_background2);
        /*if(items.get(position).getGaleriaList().size() > 0
                && items.get(position).getGaleriaList().get( 0 ).getImagen() != null){
            ByteArrayInputStream imageStream = new ByteArrayInputStream(items.get(position).getGaleriaList().get( 0 ).getImagen());
            Bitmap img = BitmapFactory.decodeStream(imageStream);
            holder.imagen.setImageBitmap( img );
        }*/
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ProductoHolder extends RecyclerView.ViewHolder{
        TextView nombre, precio;
        ImageView imagen;

        public ProductoHolder(View listItemView){
            super(listItemView);
            precio = (TextView) listItemView.findViewById(R.id.precio_comida);
            nombre = (TextView) listItemView.findViewById(R.id.nombre_comida);
            imagen = (ImageView) listItemView.findViewById(R.id.miniatura_comida);
        }
    }
}


