package guissa.com.guissamexico.fragmentos.personal;

import android.content.DialogInterface;
import android.content.pm.ApplicationInfo;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
import com.baoyz.swipemenulistview.SwipeMenuListView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import guissa.com.guissamexico.R;
import guissa.com.guissamexico.adaptadores.AdaptadorPPedidos;
import guissa.com.guissamexico.local.SQLControlador;
import guissa.com.guissamexico.modelo.ApiError;
import guissa.com.guissamexico.modelo.Reservacion;
import guissa.com.guissamexico.modelo.Userc;
import guissa.com.guissamexico.utilidades.Constantes;
import guissa.com.guissamexico.web.SaludMockApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Alfonso on 17/02/2018.
 */

public class FragmentoPPedidos extends Fragment{

    private Retrofit mRestAdapter;
    private SaludMockApi mSaludMockApi;
    private Retrofit mRestAdapterReserva;
    private SaludMockApi mSaludMockApiReserva;

    private List<Userc> cliente;
    private List<Reservacion> listapedidos = new ArrayList<>();

    private List<ApplicationInfo> mAppList;
    private AdaptadorPPedidos mAdapter;
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
            getAcciones(view); // esta registrado
        }else{
            getLoggin();
            mapa_de_datos = getDatosPersonales();
            if(!mapa_de_datos.isEmpty()){
                getAcciones(view); // esta registrado
            }
        }
        return view;
    }



    private void iniciarSesionClienteAds(String correo){
        mRestAdapter = new Retrofit.Builder()
                .baseUrl(Constantes.GET_USERC)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mSaludMockApi = mRestAdapter.create(SaludMockApi.class);
        Call<List<Userc>> loginCall = mSaludMockApi.getClienteAdsMock( correo );
        loginCall.enqueue(new Callback<List<Userc>>() {
            @Override
            public void onResponse(Call<List<Userc>> call, Response<List<Userc>> response) {

                if (!response.isSuccessful()) {
                    String error = "Ha ocurrido un error. Contacte al administrador";
                    if (response.errorBody()
                            .contentType()
                            .subtype()
                            .equals("json")) {
                        ApiError apiError = ApiError.fromResponseBody( response.errorBody() );

                        error = apiError.getMessage() != null ? apiError.getMessage() : "";
                        Log.d("FragmentoPPedidos", apiError.getDeveloperMessage());
                    } else {
                        try {
                            Log.d("FragmentoPPedidos", response.errorBody().string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    return;
                }
                if(response.body() != null) {
                    setUserc( response.body() );
                }else{
                    Toast.makeText( getContext(), "Revisa tu conexión", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<Userc>> call, Throwable t) {
                Toast.makeText( getContext(), "Error al cargar datos", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void setUserc(List<Userc> cliente){
        for( Userc userc : cliente){
            this.cliente.add( userc );
        }
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
                iniciarSesionClienteAds( correo );
                if( !cliente.isEmpty() )
                    guardarDatosPersonales();
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
                arreglo_datos.put( "iduserc", cursor.getInt(1) );
                arreglo_datos.put( "correo", cursor.getString(2) );

            } while (cursor.moveToNext());
            cursor.close();
        }
        dbconeccion.cerrar();

        return arreglo_datos;
    }

    private void guardarDatosPersonales(){
        dbconeccion = new SQLControlador(getContext());
        dbconeccion.abrirBaseDeDatos();
        for(Userc userc : this.cliente){
            dbconeccion.insertarDatosPersonal(userc.getIdUserC(), userc.getCorreo());
        }
        dbconeccion.cerrar();
    }

    private void getAcciones(View view){

        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        mAppList = getActivity().getPackageManager().getInstalledApplications(0);
        mListView = (SwipeMenuListView) view.findViewById(R.id.pager_personal_pedidos);

        // iduser listo, traer los negocios vinculados
        for(Userc userc : this.cliente){
            getReservaciones( userc.getIdUserC() );
        }

        mAdapter = new AdaptadorPPedidos( getActivity(), listapedidos );
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

        mListView.setMenuCreator( creator );

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
            public void onSwipeStart(int position) {}

            @Override
            public void onSwipeEnd(int position) {}
        });

        mListView.setOnMenuStateChangeListener(new SwipeMenuListView.OnMenuStateChangeListener() {
            @Override
            public void onMenuOpen(int position) {}

            @Override
            public void onMenuClose(int position) {}
        });
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

    private int dp2px(int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
                getResources().getDisplayMetrics());
    }

    private void setReservaciones(List<Reservacion> reservaciones ){
        for(Reservacion reservacion : reservaciones){
            this.listapedidos.add( reservacion );
        }
    }

    private void getReservaciones(int id){
        mRestAdapterReserva = new Retrofit.Builder()
                .baseUrl(Constantes.GET_RESRVACION)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mSaludMockApiReserva = mRestAdapterReserva.create(SaludMockApi.class);
        Call< List<Reservacion> > loginCall = mSaludMockApiReserva.getReservacionMock( id );
        loginCall.enqueue(new Callback< List<Reservacion> >() {
            @Override
            public void onResponse(Call< List<Reservacion> > call, Response< List<Reservacion> > response) {

                if (!response.isSuccessful()) {
                    String error = "Ha ocurrido un error. Contacte al administrador";
                    if (response.errorBody()
                            .contentType()
                            .subtype()
                            .equals("json")) {
                        ApiError apiError = ApiError.fromResponseBody( response.errorBody() );

                        error = apiError.getMessage() != null ? apiError.getMessage() : "";
                        Log.d("FragmentoPPedidos", apiError.getDeveloperMessage());
                    } else {
                        try {
                            Log.d("FragmentoPPedidos", response.errorBody().string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    return;
                }
                if(response.body() != null) {
                    setReservaciones( response.body() );
                }else{
                    Toast.makeText( getContext(), "Revisa tu conexión", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call< List<Reservacion> > call, Throwable t) {
                Toast.makeText( getContext(), "Error al cargar datos", Toast.LENGTH_LONG).show();
            }
        });
    }
}
