package ikwala.com.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import ikwala.com.DataBase.IKLSSchema.UsersTable;
import ikwala.com.Orders;

import static ikwala.com.DataBase.IKLSSchema.*;


/**
 * Created by ikwal on 6/12/2016.
 */
public class IKLSDBHelper  extends SQLiteOpenHelper{

    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "IKLS.db";

    public IKLSDBHelper(Context context)
    {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("create table " + UsersTable.NAME + "( " +
                UsersTable.Cols.firstName + "," +
                UsersTable.Cols.middleName + "," +
                UsersTable.Cols.lastName + "," +
                UsersTable.Cols.city + "," +
                UsersTable.Cols.Emirates + "," +
                UsersTable.Cols.street + "," +
                UsersTable.Cols.eMail + "," +
                UsersTable.Cols.password + "," +
                UsersTable.Cols.phoneNumber+ ")");

        db.execSQL("create table " + OrdersTable.NAME + "( " +
                OrdersTable.Cols.OrderNumber + "," +
                OrdersTable.Cols.Date + "," +
                OrdersTable.Cols.Clothe1 + "," +
                OrdersTable.Cols.NumClothe1 + "," +
                OrdersTable.Cols.Clothe2 + "," +
                OrdersTable.Cols.NumClothe2 + "," +
                OrdersTable.Cols.Clothe3 + "," +
                OrdersTable.Cols.NumClothe3 + "," +
                OrdersTable.Cols.Clothe4 + "," +
                OrdersTable.Cols.NumClothe4 + "," +
                OrdersTable.Cols.SpecialRequist + "," +
                OrdersTable.Cols.LocLat + "," +
                OrdersTable.Cols.LocLong + "," +
                OrdersTable.Cols.OrderCondetion + ")");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
