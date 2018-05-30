package guissa.com.guissamexico.adaptadores;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import guissa.com.guissamexico.R;
import guissa.com.guissamexico.modelo.Banner;
import guissa.com.guissamexico.utilidades.Converter;
import guissa.com.guissamexico.utilidades.Recursos;

/**
 * Created by Alfonso on 18/02/2018.
 */

public class AdaptadorInicio extends ArrayAdapter<Banner> {
    private final Context context;
    private final List<Banner> itemname;

    public AdaptadorInicio(Context context, List<Banner> itemname){
        super(context, R.layout.lista_inicio, itemname);
        this.context = context;
        this.itemname = itemname;
    }



    public View getView(int posicion, View view, ViewGroup parent){

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View rowView = inflater.inflate(R.layout.lista_inicio, null);

        TextView titulo = (TextView) rowView.findViewById(R.id.titulo_banner);
        TextView subttulo = (TextView) rowView.findViewById(R.id.subtitulo_banner);
        ImageView imagen = (ImageView) rowView.findViewById(R.id.miniatura_comida);

        titulo.setText( itemname.get(posicion).getNombre() );
        subttulo.setText(itemname.get(posicion).getSubTitle());

        ByteArrayInputStream imageStream = new ByteArrayInputStream(itemname.get(posicion).getImagen());
        Bitmap img = BitmapFactory.decodeStream(imageStream);
        imagen.setImageBitmap(img);

        return rowView;
    }
}
