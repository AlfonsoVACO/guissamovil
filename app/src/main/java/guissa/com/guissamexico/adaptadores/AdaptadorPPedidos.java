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
import guissa.com.guissamexico.modelo.Userc;
import guissa.com.guissamexico.utilidades.Recursos;

/**
 * Created by Alfonso on 16/04/2018.
 */

public class AdaptadorPPedidos extends BaseAdapter {
    private Recursos recursos;
    protected Activity activity;
    protected ArrayList<Userc> items;

    public AdaptadorPPedidos(Activity activity, ArrayList<Userc> items) {
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
        return items.get(position).getIdUserC();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi = convertView;

        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            vi = inflater.inflate(R.layout.lista_p_pedidos, null);
        }

        Userc usuario = items.get(position);

        TextView direcc = (TextView) vi.findViewById(R.id.texto_direccion);
        TextView departam = (TextView) vi.findViewById(R.id.texto_departamento);
        TextView cuidad = (TextView) vi.findViewById(R.id.texto_ciudad);
        TextView telefono = (TextView) vi.findViewById(R.id.texto_telefono);

        direcc.setText(usuario.getDireccion());
        departam.setText(usuario.getNombre());
        cuidad.setText(usuario.getCorreo());
        telefono.setText(usuario.getTelefono());
        return vi;
    }
}
