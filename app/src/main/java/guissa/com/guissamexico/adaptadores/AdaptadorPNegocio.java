package guissa.com.guissamexico.adaptadores;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import guissa.com.guissamexico.R;
import guissa.com.guissamexico.modelo.Negocios;
import guissa.com.guissamexico.utilidades.Recursos;

/**
 * Created by Alfonso on 24/02/2018.
 */

public class AdaptadorPNegocio extends BaseAdapter {
    private Recursos recursos;
    protected Activity activity;
    protected ArrayList<Negocios> items;

    public AdaptadorPNegocio(Activity activity, ArrayList<Negocios> items) {
        this.activity = activity;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return items.get(position).getIdNegocio();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi=convertView;

        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            vi = inflater.inflate(R.layout.lista_p_negocio, null);
        }

        Negocios negocio = items.get(position);

        ImageView image = (ImageView) vi.findViewById(R.id.circle_image);
        image.setImageBitmap( recursos.conertByteArrayToBitMap( negocio
                .getImagennegociosList()
                        .get( negocio.getImagennegociosList().size() - 1 )
                        .getImagen() ) );

        TextView clave = (TextView) vi.findViewById(R.id.negocio_p_id);
        TextView nombre = (TextView) vi.findViewById(R.id.texto_nombre);
        TextView direccion = (TextView) vi.findViewById(R.id.texto_direccion);
        TextView ciudad = (TextView) vi.findViewById(R.id.texto_ciudad);
        TextView telefono = (TextView) vi.findViewById(R.id.texto_telefono);

        clave.setText(negocio.getIdEstado().toString());
        nombre.setText(negocio.getNombre());
        direccion.setText(negocio.getDireccion());
        ciudad.setText(negocio.getIdEstado().getNombre());
        telefono.setText(negocio.getTelefono());

        return vi;
    }
}