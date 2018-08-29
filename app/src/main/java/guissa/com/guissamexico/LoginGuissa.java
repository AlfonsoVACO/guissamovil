package guissa.com.guissamexico;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import guissa.com.guissamexico.local.SQLControlador;
import guissa.com.guissamexico.local.TendenciaUser;
import guissa.com.guissamexico.modelo.ApiError;
import guissa.com.guissamexico.modelo.Userc;
import guissa.com.guissamexico.utilidades.Constantes;
import guissa.com.guissamexico.web.SaludMockApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Alfonso on 05/08/2018.
 */

public class LoginGuissa extends AppCompatActivity{
    private Retrofit mRestAdapter;
    private SaludMockApi mSaludMockApi;

    private EditText mUserIdView;
    private TextInputLayout mFloatLabelUserId;
    private View mProgressView;
    private View mLoginFormView;
    private Thread splashTread;
    private List<Userc> lista_user = new ArrayList<>();

    private SQLControlador dbconeccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final Userc userTendencia = TendenciaUser.getDatosPersonales( getApplicationContext() );

        mRestAdapter = new Retrofit.Builder()
                .baseUrl( Constantes.GET_USERC )
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mSaludMockApi = mRestAdapter.create(SaludMockApi.class);

        mUserIdView = (EditText) findViewById(R.id.email);
        mFloatLabelUserId = (TextInputLayout) findViewById(R.id.float_label_user_id);
        Button mSignInButton = (Button) findViewById(R.id.email_sign_in_button);
        Button mLosSNButton = (Button) findViewById(R.id.btn_access_not_user);
        mLoginFormView = findViewById(R.id.login_form);
        mProgressView = findViewById(R.id.login_progress);


        mSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isOnline()) {
                    showLoginError(getString(R.string.error_network));
                    return;
                }
                attemptLogin();

            }
        });

        mLosSNButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                showAppointmentsScreen();
            }
        });

        splashTread = new Thread() {
            @Override
            public void run() {
                try {
                    int waited = 0;
                    while (waited < 3500) {
                        sleep(100);
                        waited += 100;
                    }
                    if(userTendencia.getIdUserC() != null)
                        showAppointmentsScreen();
                } catch (InterruptedException e) {

                }

            }
        };
        splashTread.start();

    }

    private void attemptLogin() {

        mFloatLabelUserId.setError(null);
        String userId = mUserIdView.getText().toString();

        boolean cancel = false;
        View focusView = null;

        if (TextUtils.isEmpty(userId)) {
            mFloatLabelUserId.setError(getString(R.string.error_field_required));
            focusView = mFloatLabelUserId;
            cancel = true;
        }

        if (cancel) {
            focusView.requestFocus();
        } else {
            showProgress(true);
            Call<List<Userc>> loginCall = mSaludMockApi.getClienteAdsMock( userId );
            loginCall.enqueue(new Callback<List<Userc>>() {
                @Override
                public void onResponse(Call<List<Userc>> call, Response<List<Userc>> response) {
                    showProgress(false);

                    if (!response.isSuccessful()) {
                        String error = "Ha ocurrido un error. Contacte al administrador";
                        if (response.errorBody()
                                .contentType()
                                .subtype()
                                .equals("json")) {
                            ApiError apiError = ApiError.fromResponseBody(response.errorBody());

                            error = apiError.getMessage() != null ? apiError.getMessage() : "";
                            Log.d("LoginActivity", apiError.getDeveloperMessage());
                        } else {
                            try {
                                Log.d("LoginActivity", response.errorBody().string());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }

                        showLoginError(error);
                        return;
                    }

                    if(response.body() != null) {
                        setArrayUserc( response.body() );
                        showAppointmentsScreen();
                    }else{
                        showLoginError("Revisa tu conexión");
                    }
                }

                @Override
                public void onFailure(Call<List<Userc>> call, Throwable t) {
                    showProgress(false);
                    showLoginError(t.getMessage());
                }
            });
        }
    }

    private void setArrayUserc(List<Userc> userc){
        for(Userc user : userc){
            this.lista_user.add( user );
        }
    }

    private void showProgress(boolean show) {
        mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);

        int visibility = show ? View.GONE : View.VISIBLE;
        //mLogoView.setVisibility(visibility);
        mLoginFormView.setVisibility(visibility);
    }

    private void showAppointmentsScreen() {
        Intent modify_intent = new Intent( this, MainActivity.class);
        int[] claves = new int[this.lista_user.size()];
        for(int i = 0; i < this.lista_user.size() ; i++){
            claves[i] = this.lista_user.get(i).getIdUserC();
        }
        modify_intent.putExtra("claveId", claves);
        startActivity( modify_intent );
        finish();
    }

    private void showLoginError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show();
    }

    private boolean isOnline() {
        ConnectivityManager cm =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnected();
    }

    private void guardarDatosPersonales(Userc userpar){
        dbconeccion = new SQLControlador(getApplicationContext());
        dbconeccion.abrirBaseDeDatos();
        dbconeccion.insertarDatosPersonal( userpar.getIdUserC(), userpar.getCorreo() );
        dbconeccion.cerrar();
    }
}