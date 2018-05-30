package guissa.com.guissamexico.fragmentos.personal;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import guissa.com.guissamexico.R;
import guissa.com.guissamexico.fragmentos.negocios.FragmentoNClientes;
import guissa.com.guissamexico.fragmentos.negocios.FragmentoNNegocios;
import guissa.com.guissamexico.fragmentos.negocios.FragmentoNPedidos;
import guissa.com.guissamexico.fragmentos.negocios.FragmentoNPerfil;
import guissa.com.guissamexico.fragmentos.negocios.FragmentoNegocio;

/**
 * Created by Alfonso on 17/02/2018.
 */

public class FragmentoPersonal extends Fragment {

    private AppBarLayout appBar;
    private TabLayout pestanas;
    private ViewPager viewPager;

    public FragmentoPersonal(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmento_personal, container, false);

        if (savedInstanceState == null) {
            insertarTabs(container);

            // Setear adaptador al viewpager.
            viewPager = (ViewPager) view.findViewById(R.id.pager_personal);
            poblarViewPager(viewPager);
            pestanas.setupWithViewPager(viewPager);
        }

        return view;
    }

    private void insertarTabs(ViewGroup container) {
        View padre = (View) container.getParent();
        appBar = (AppBarLayout) padre.findViewById(R.id.appbar);
        pestanas = new TabLayout(getActivity());
        pestanas.setTabTextColors(Color.parseColor("#FFFFFF"), Color.parseColor("#FFFFFF"));
        appBar.addView(pestanas);
    }

    private void poblarViewPager(ViewPager viewPager) {
        FragmentoPersonal.AdaptadorSecciones adapter = new FragmentoPersonal.AdaptadorSecciones(getFragmentManager());
        adapter.addFragment(new FragmentoPPedidos(), getString(R.string.titulo_tab_p_pedidos));
        adapter.addFragment(new FragmentoPNegocios(), getString(R.string.titulo_tab_p_negocios));
        viewPager.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        appBar.removeView(pestanas);
    }

    /**
     * Un {@link FragmentStatePagerAdapter} que gestiona las secciones, fragmentos y
     * títulos de las pestañas
     */
    public class AdaptadorSecciones extends FragmentStatePagerAdapter {
        private final List<Fragment> fragmentos = new ArrayList<>();
        private final List<String> titulosFragmentos = new ArrayList<>();

        public AdaptadorSecciones(FragmentManager fm) {
            super(fm);
        }

        @Override
        public android.support.v4.app.Fragment getItem(int position) {
            return fragmentos.get(position);
        }

        @Override
        public int getCount() {
            return fragmentos.size();
        }

        public void addFragment(android.support.v4.app.Fragment fragment, String title) {
            fragmentos.add(fragment);
            titulosFragmentos.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titulosFragmentos.get(position);
        }
    }

}