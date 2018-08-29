package guissa.com.guissamexico.web;

import java.util.List;

import guissa.com.guissamexico.modelo.Negocios;
import guissa.com.guissamexico.modelo.Reservacion;
import guissa.com.guissamexico.modelo.User;
import guissa.com.guissamexico.modelo.Userc;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Alfonso on 05/08/2018.
 */

public interface SaludMockApi {
    @GET("user/correo/{correo}/pass/{pass}")
    Call<Userc> login(@Path("correo") String correo, @Path("pass") String pass);

    @GET("user/{id}")
    Call<Negocios> getNegocioMock(@Path("id") int id);

    @GET("negocio/userc/{id}")
    Call<List<Reservacion>> getReservacionMock(@Path("id") int id);

    @GET("correo/{correo}")
    Call<List<Userc>> getClienteAdsMock(@Path("correo") String correo);
}
