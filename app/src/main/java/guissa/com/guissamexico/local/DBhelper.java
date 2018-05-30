package guissa.com.guissamexico.local;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static android.provider.BaseColumns._ID;

/**
 * Created by Alfonso on 22/02/2018.
 */

public class DBhelper extends SQLiteOpenHelper {

    public DBhelper(Context context) {
        super(context, DB_NAME, null,DB_VERSION);
    }

    static final String DB_NAME = "guissa_nexico";
    static final int DB_VERSION = 1;

    public static final String TABLE_MIS_NEGOCIOS = "negocios";
    public static final String TABLE_MIS_DATOS = "personal";

    public static final String NEGOCIO_ID = _ID;
    public static final String NEGOCIO_CORREO = "correo";

    public static final String PERSONAL_ID = _ID;
    public static final String PERSONAL_CORREO ="correo";

    public static final String CREATE_TABLE_NEGOCIOS = "create table " +TABLE_MIS_NEGOCIOS+"(" +
            NEGOCIO_ID + " integer primary key AUTOINCREMENT," +
            NEGOCIO_CORREO + " char(70) not null);";

    public static final String CREATE_TABLE_PERSONAL = "create table " +TABLE_MIS_DATOS+"(" +
            PERSONAL_ID + " integer primary key AUTOINCREMENT," +
            PERSONAL_CORREO + " char(70) not null);";

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_NEGOCIOS);
        db.execSQL(CREATE_TABLE_PERSONAL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + CREATE_TABLE_NEGOCIOS);
        db.execSQL("DROP TABLE IF EXISTS " + CREATE_TABLE_PERSONAL);
        onCreate(db);
    }
}
