package guissa.com.guissamexico.local;

import android.content.Context;
import android.database.Cursor;

import guissa.com.guissamexico.modelo.Negocios;
import guissa.com.guissamexico.modelo.TipoUsuario;
import guissa.com.guissamexico.modelo.User;
import guissa.com.guissamexico.modelo.Userc;

/**
 * Created by Alfonso on 05/08/2018.
 */

public class TendenciaUser {

    private static SQLControlador dbconeccion;

    public static Negocios getDatosNegocio(Context context){
        Negocios negocios = new Negocios();

        dbconeccion = new SQLControlador( context );
        dbconeccion.abrirBaseDeDatos();
        Cursor cursor = dbconeccion.getDatosNegocio();
        if (cursor.moveToFirst()) {
            do {
                negocios.setIdNegocio(cursor.getInt(0) );
                negocios.setNombre(cursor.getString(1));
                negocios.setDireccion(cursor.getString(2));
                negocios.setTelefono(cursor.getString(3) );
                negocios.setTelefono2(cursor.getString(4));
                negocios.setDescripcion(cursor.getString(5) );
                negocios.setVisualizacion(cursor.getInt(6));
                negocios.setEstado(cursor.getInt(7) );
            } while (cursor.moveToNext());
            cursor.close();
        }
        dbconeccion.cerrar();
        return negocios.getIdNegocio() != null ? negocios : new Negocios();
    }

    /*public static void guardarDatosNegocio(Negocios negocios, Context context){
        dbconeccion = new SQLControlador( context );
        dbconeccion.abrirBaseDeDatos();
        dbconeccion.insertaMiNegocio( negocios );
        dbconeccion.cerrar();
    }*/

    public static Userc getDatosPersonales(Context context){
        Userc user = new Userc();

        dbconeccion = new SQLControlador( context );
        dbconeccion.abrirBaseDeDatos();
        Cursor cursor = dbconeccion.getDatosPersonal();
        if (cursor.moveToFirst()) {
            do {
                user.setIdUserC(cursor.getInt(1) );
                user.setCorreo(cursor.getString(2) );
            } while (cursor.moveToNext());
            cursor.close();
        }
        dbconeccion.cerrar();
        return user != null ? user : new Userc();
    }

    /*public static void setDeleteAll(Context context){
        dbconeccion = new SQLControlador( context );
        dbconeccion.abrirBaseDeDatos();
        dbconeccion.deleteNegocio();
        dbconeccion.deleteMiNegocio();
        dbconeccion.cerrar();
    }*/

}
