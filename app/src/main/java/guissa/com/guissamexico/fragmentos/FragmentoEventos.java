package guissa.com.guissamexico.fragmentos;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import guissa.com.guissamexico.R;

/**
 * Created by Alfonso on 17/02/2018.
 */

public class FragmentoEventos  extends Fragment {

    private ImageButton imgButton;
    private TextView txtevento;

    public FragmentoEventos(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmento_eventos, container, false);
        setAcciones(view);

        return view;
    }

    private void setAcciones(View view){
        imgButton = (ImageButton) view.findViewById(R.id.btnEventos);
        txtevento = (TextView) view.findViewById(R.id.txtBuscaEvent);

        imgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //txtevento.getText();
            }
        });
    }
}
