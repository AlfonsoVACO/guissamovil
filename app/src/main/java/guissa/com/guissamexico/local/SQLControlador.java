package guissa.com.guissamexico.local;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Alfonso on 22/02/2018.
 */

public class SQLControlador {

    private DBhelper dbhelper;
    private Context ourcontext;
    private SQLiteDatabase database;

    public SQLControlador(Context c) {
        ourcontext = c;
    }

    public SQLControlador abrirBaseDeDatos() throws SQLException {
        dbhelper = new DBhelper(ourcontext);
        database = dbhelper.getWritableDatabase();
        return this;
    }

    public void cerrar() {
        dbhelper.close();
    }

    public void insertarDatosNegocio(String correo, String password) {
        ContentValues cv = new ContentValues();
        cv.put(DBhelper.NEGOCIO_CORREO, correo);
        cv.put(DBhelper.NEGOCIO_PASS, password);
        database.insert(DBhelper.TABLE_MIS_NEGOCIOS, null, cv);
    }

    public void insertarDatosPersonal(int id, String correo) {
        ContentValues cv = new ContentValues();
        cv.put(DBhelper.PERSONAL_CORREO, correo);
        cv.put(DBhelper.USERC_ID, id);

        database.insert(DBhelper.TABLE_MIS_DATOS, null, cv);
    }

    public Cursor getDatosPersonal() {
        String[] todasLasColumnas = new String[] { DBhelper.PERSONAL_ID, DBhelper.USERC_ID, DBhelper.PERSONAL_CORREO };
        Cursor c = database.query(DBhelper.TABLE_MIS_DATOS, todasLasColumnas,
                null, null, null, null, null);

        if (c != null) {
            c.moveToFirst();
        }
        return c;
    }

    public Cursor getDatosNegocio() {
        String[] todasLasColumnas = new String[] { DBhelper.NEGOCIO_ID, DBhelper.NEGOCIO_CORREO, DBhelper.NEGOCIO_PASS };
        Cursor c = database.query(DBhelper.TABLE_MIS_NEGOCIOS, todasLasColumnas, null,
                null, null, null, null);

        if (c != null) {
            c.moveToFirst();
        }
        return c;
    }

    public int actualizarDatosPersonal(long claveID, String correo) {
        ContentValues cvActualizar = new ContentValues();
        cvActualizar.put(DBhelper.PERSONAL_CORREO, correo);
        int i = database.update(DBhelper.TABLE_MIS_DATOS, cvActualizar, DBhelper.PERSONAL_ID + " = " + claveID, null);
        return i;
    }

    public int actualizarDatosNegocio(long claveID, String correo) {
        ContentValues cvActualizar = new ContentValues();
        cvActualizar.put(DBhelper.NEGOCIO_CORREO, correo);
        int i = database.update(DBhelper.TABLE_MIS_NEGOCIOS, cvActualizar, DBhelper.NEGOCIO_ID + " = " + claveID, null);
        return i;
    }

    public void deleteNegocio(long claveID) {
        database.delete(DBhelper.TABLE_MIS_NEGOCIOS, DBhelper.NEGOCIO_ID + "=" + claveID, null);
    }

    public void deletePersonal(Integer claveID) {
        database.delete(DBhelper.CREATE_TABLE_PERSONAL, DBhelper.PERSONAL_ID + "=" + claveID, null);
    }

}
