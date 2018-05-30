package guissa.com.guissamexico.fragmentos.personal;

import android.content.DialogInterface;
import android.content.pm.ApplicationInfo;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
import com.baoyz.swipemenulistview.SwipeMenuListView;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import guissa.com.guissamexico.R;
import guissa.com.guissamexico.adaptadores.AdaptadorPNegocio;
import guissa.com.guissamexico.adaptadores.AdaptadorPPedidos;
import guissa.com.guissamexico.local.SQLControlador;
import guissa.com.guissamexico.modelo.Estados;
import guissa.com.guissamexico.modelo.Municipios;
import guissa.com.guissamexico.modelo.Negocios;
import guissa.com.guissamexico.modelo.TipoUsuario;
import guissa.com.guissamexico.modelo.User;
import guissa.com.guissamexico.modelo.Userc;
import guissa.com.guissamexico.swiplist.BaseSwipListAdapter;

/**
 * Created by Alfonso on 17/02/2018.
 */

public class FragmentoPPedidos extends Fragment {

    private List<ApplicationInfo> mAppList;
    private AppAdapter mAdapter;
    private SwipeMenuListView mListView;
    private SQLControlador dbconeccion;
    Map<String,Object> mapa_de_datos;

    public FragmentoPPedidos(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmento_personal_pedidos, container, false);

        mapa_de_datos = getDatosPersonales();

        if(!mapa_de_datos.isEmpty()){
            //getAcciones(view); // esta registrado

        }else{
            getLoggin();
            mapa_de_datos = getDatosPersonales();
            if(!mapa_de_datos.isEmpty()){
                //getAcciones(view); // esta registrado
            }
        }
        getLogginVolley(view);
        return view;
    }

    public String loadJSONFromAsset(String flName) {
        String json = null;
        try {
            InputStream is = getContext().getAssets().open(flName);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
            Log.v("MainActivity", "Load json ok");
        } catch (IOException ex) {
            Log.v("MainActivity", "Error: " + ex.getMessage());
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    private void getLogginVolley(View view){
        ListView lvCities = (ListView) view.findViewById(R.id.pager_personal_pedidos);
        ArrayList<Userc> lstuserc = new ArrayList<Userc>();

        try {
            Toast.makeText(getContext(), loadJSONFromAsset("userc.json"), Toast.LENGTH_LONG);
            HttpGet httpGet = new HttpGet(loadJSONFromAsset("userc.json"));
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

            JSONObject jsonObject = new JSONObject(aux);
            JSONArray cities = jsonObject.names();

            for(int i = 0; i < cities.length(); i++) {
                JSONObject json_negocio = cities.getJSONObject(i);

                Userc userc = new Userc();

                userc.setApellidos( json_negocio.getString("apellidos") );
                userc.setCorreo( json_negocio.getString("correo") );
                userc.setDireccion( json_negocio.getString("direccion") );
                userc.setIdUserC( json_negocio.getInt("idUserC") );
                userc.setNombre( json_negocio.getString("nombre") );
                userc.setTelefono( json_negocio.getString("telefono") );

                Negocios negocio = new Negocios();

                negocio.setDescripcion(json_negocio.getJSONObject("idNegocio").getString("descripcion"));
                negocio.setDireccion(json_negocio.getJSONObject("idNegocio").getString("direccion"));
                negocio.setEstado(json_negocio.getJSONObject("idNegocio").getInt("estado"));
                //negocio.setFecha(json_negocio.getJSONObject("idNegocio").getString("fecha"));
                negocio.setIdNegocio(json_negocio.getJSONObject("idNegocio").getInt("idNegocio"));
                negocio.setNombre(json_negocio.getJSONObject("idNegocio").getString("nombre"));
                negocio.setTelefono(json_negocio.getJSONObject("idNegocio").getString("telefono"));
                negocio.setTelefono2(json_negocio.getJSONObject("idNegocio").getString("telefono2"));
                negocio.setVisualizacion(json_negocio.getJSONObject("idNegocio").getInt("visualizacion"));

                Estados estado = new Estados();

                estado.setIdEstado(json_negocio.getJSONObject("idNegocio").getJSONObject("idEstado").getInt("idEstado"));
                estado.setNombre(json_negocio.getJSONObject("idNegocio").getJSONObject("idEstado").getString("nombre"));

                Municipios muni = new Municipios();
                muni.setIdMunicipio(json_negocio.getJSONObject("idNegocio").getJSONObject("idMunicipio").getInt("idMunicipio"));
                muni.setIdMunicipio(json_negocio.getJSONObject("idNegocio").getJSONObject("idMunicipio").getInt("nombreMun"));

                negocio.setIdEstado(estado);
                negocio.setIdMunicipio(muni);

                User user = new User();
                user.setIdUser(json_negocio.getJSONObject("idNegocio").getJSONObject("idUser").getInt("idUser"));
                user.setApellidos(json_negocio.getJSONObject("idNegocio").getJSONObject("idUser").getString("apellidos"));
                //user.setAvatar(json_negocio.getJSONObject("idNegocio").getJSONObject("idUser").getString("avatar"));
                user.setCorreo(json_negocio.getJSONObject("idNegocio").getJSONObject("idUser").getString("correo"));
                user.setNic(json_negocio.getJSONObject("idNegocio").getJSONObject("idUser").getString("nic"));
                user.setNombre(json_negocio.getJSONObject("idNegocio").getJSONObject("idUser").getString("nombre"));
                user.setPass(json_negocio.getJSONObject("idNegocio").getJSONObject("idUser").getString("pass"));

                TipoUsuario tipo = new TipoUsuario();
                tipo.setIdTipoUsuario(json_negocio.getJSONObject("idNegocio").getJSONObject("idUser").getJSONObject("idTipousuario").getInt("idTipousuario"));
                tipo.setDescripcion(json_negocio.getJSONObject("idNegocio").getJSONObject("idUser").getJSONObject("idTipousuario").getString("descripcion"));

                user.setIdTipousuario(tipo);
                negocio.setIdUser(user);
                userc.setIdNegocio(negocio);

                lstuserc.add(userc);
            }
        }
        catch(Exception e) {
            Log.e("WebService", e.getMessage());
        }

        AdaptadorPPedidos adaptadorPNegocio = new AdaptadorPPedidos(getActivity(), lstuserc);
        lvCities.setAdapter(adaptadorPNegocio);
        lvCities.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                /*clave = (TextView) view.findViewById(R.id.negocio_p_id);
                nombre = (TextView) view.findViewById(R.id.texto_nombre);
                direccion = (TextView) view.findViewById(R.id.texto_direccion);
                ciudad = (TextView) view.findViewById(R.id.texto_ciudad);
                telefono = (TextView) view.findViewById(R.id.texto_telefono);


                String aux_clave = clave.getText().toString();
                final String aux_nombre = nombre.getText().toString();
                final String aux_precio = direccion.getText().toString();
                final String aux_ciudad = ciudad.getText().toString();
                final String aux_telefono = telefono.getText().toString();*/
            }
        });
    }

    private boolean showAccessDenied(){
        final boolean[] verificalogin = {true};
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Acceso denegado");
        builder.setMessage("Ese usuario no existe, ¿Deseas volver a intentar?");

        builder.setPositiveButton("Si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                verificalogin[0] = true;
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                verificalogin[0] = false;
            }
        });
        builder.show();
        return verificalogin[0];
    }

    private void getLoggin(){
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Obtener mis datos");
        View viewInflated = LayoutInflater.from(getContext())
                .inflate(R.layout.login_personal, (ViewGroup) getView(), false);
        final EditText input = (EditText) viewInflated.findViewById(R.id.strCorroPersonal);

        builder.setView(viewInflated);

        builder.setPositiveButton("Acceder", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                String correo = input.getText().toString();
                guardarDatosPersonales(correo);
            }
        });
        builder.show();
    }

    private Map<String,Object> getDatosPersonales(){
        Map<String,Object> arreglo_datos = new HashMap<String,Object>();

        dbconeccion = new SQLControlador(getContext());
        dbconeccion.abrirBaseDeDatos();
        Cursor cursor = dbconeccion.getDatosPersonal();
        if (cursor.moveToFirst()) {
            do {
                arreglo_datos.put( "id", cursor.getInt(0) );
                arreglo_datos.put( "correo", cursor.getString(1) );

            } while (cursor.moveToNext());
            cursor.close();
        }
        dbconeccion.cerrar();

        return arreglo_datos;
    }

    private void guardarDatosPersonales(String correo){
        dbconeccion = new SQLControlador(getContext());
        dbconeccion.abrirBaseDeDatos();
        dbconeccion.insertarDatosPersonal(correo);
        dbconeccion.cerrar();
    }

    private void getAcciones(View view){

        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
            }
        });

        mAppList = getActivity().getPackageManager().getInstalledApplications(0);

        mListView = (SwipeMenuListView) view.findViewById(R.id.pager_personal_pedidos);

        mAdapter = new AppAdapter();
        mListView.setAdapter(mAdapter);

        mListView.setSwipeDirection(SwipeMenuListView.DIRECTION_LEFT);


        SwipeMenuCreator creator = new SwipeMenuCreator() {
            @Override
            public void create(SwipeMenu menu) {
                SwipeMenuItem openItem = new SwipeMenuItem( getContext() );
                openItem.setBackground(new ColorDrawable(Color.rgb(0xC9, 0xC9, 0xCE)));

                openItem.setWidth(dp2px(90));
                openItem.setTitle("Detalles");
                openItem.setTitleSize(18);
                openItem.setTitleColor(Color.MAGENTA);

                menu.addMenuItem(openItem);

                SwipeMenuItem deleteItem = new SwipeMenuItem( getContext() );

                deleteItem.setBackground(new ColorDrawable(Color.rgb(0xF9, 0x3F, 0x25)));
                deleteItem.setWidth(dp2px(90));
                deleteItem.setIcon(R.drawable.ic_delete);

                menu.addMenuItem(deleteItem);
            }
        };

        mListView.setMenuCreator(creator);

        mListView.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {
                ApplicationInfo item = mAppList.get(position);
                switch (index) {
                    case 0:
                        // abrir un cuadro de dialogo con info
                        break;
                    case 1:
                        accionEliminar(position).show();
                        break;
                }
                return false;
            }
        });

        mListView.setOnSwipeListener(new SwipeMenuListView.OnSwipeListener() {

            @Override
            public void onSwipeStart(int position) {
                // swipe start
            }

            @Override
            public void onSwipeEnd(int position) {
                // swipe end
            }
        });

        mListView.setOnMenuStateChangeListener(new SwipeMenuListView.OnMenuStateChangeListener() {
            @Override
            public void onMenuOpen(int position) {
            }

            @Override
            public void onMenuClose(int position) {
            }
        });

        /*mListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view,
                                           int position, long id) {
                Toast.makeText(getContext(), position + " long click", Toast.LENGTH_SHORT).show();
                return false;
            }
        });*/
    }

    private AlertDialog accionEliminar(int id){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("¿Estas seguro de eliminar el registro?")
                .setPositiveButton("Eliminar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Toast.makeText(getContext(),"Eliminando registro",Toast.LENGTH_SHORT);
                    }
                });
        return builder.create();
    }

    class AppAdapter extends BaseSwipListAdapter {

        @Override
        public int getCount() {
            return mAppList.size();
        }

        @Override
        public ApplicationInfo getItem(int position) {
            return mAppList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = View.inflate(getContext(),
                        R.layout.lista_p_pedidos, null);
                new ViewHolder(convertView);
            }
            ViewHolder holder = (ViewHolder) convertView.getTag();
            ApplicationInfo item = getItem(position);
            holder.tv_name.setText(item.loadLabel(getActivity().getPackageManager()));
            /*holder.tv_name.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getContext(),"iv_icon_click",Toast.LENGTH_SHORT).show();
                }
            });*/
            return convertView;
        }

        class ViewHolder {
            ImageView iv_icon;
            TextView tv_name;

            public ViewHolder(View view) {
                //iv_icon = (ImageView) view.findViewById(R.id.iv_icon);
                tv_name = (TextView) view.findViewById(R.id.texto_departamento);
                view.setTag(this);
            }
        }

        @Override
        public boolean getSwipEnableByPosition(int position) {
            if(position % 2 == 0){
                return false;
            }
            return true;
        }
    }

    private int dp2px(int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
                getResources().getDisplayMetrics());
    }

   /* @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.main, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_left) {
            mListView.setSwipeDirection(SwipeMenuListView.DIRECTION_LEFT);
            return true;
        }
        if (id == R.id.action_right) {
            mListView.setSwipeDirection(SwipeMenuListView.DIRECTION_RIGHT);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }**/
}
