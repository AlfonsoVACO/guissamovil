package guissa.com.guissamexico.fragmentos.negocios;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import guissa.com.guissamexico.R;

/**
 * Created by Alfonso on 17/02/2018.
 */

public class FragmentoNNegocios extends Fragment {

    public FragmentoNNegocios(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragmento_negocio_negocio, container, false);
    }

}
