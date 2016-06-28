package ikwala.com;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import ikwala.com.DataBase.IKLSCursorWrapper;
import ikwala.com.DataBase.IKLSDBHelper;
import ikwala.com.DataBase.IKLSSchema;

import java.util.ArrayList;
import java.util.List;

import static ikwala.com.DataBase.IKLSSchema.*;
import static ikwala.com.DataBase.IKLSSchema.UsersTable.*;

/**
 * Created by ikwal on 6/13/2016.
 */
public class IKLSModulator
{
    private static IKLSModulator sIKIklsModulator;
    private Context context;
    private SQLiteDatabase database;

    public IKLSModulator(Context context)
    {
        this.context = context;
        database = new IKLSDBHelper(this.context).getWritableDatabase();
    }

    public static IKLSModulator getsIKIklsModulator(Context context)
    {
        if (sIKIklsModulator == null)
        {
            sIKIklsModulator = new IKLSModulator(context);
        }

        return sIKIklsModulator;
    }


    public List<User> getUsers()
    {
        List<User> usersList = new ArrayList<>();
        IKLSCursorWrapper cursorWrapper = queryUsers(null,null);

        try
        {
            cursorWrapper.moveToFirst();
            while (!cursorWrapper.isAfterLast())
            {
                usersList.add(cursorWrapper.getUserInfo());
                cursorWrapper.moveToNext();
            }
        }

        finally
        {
            cursorWrapper.close();
        }

        return usersList;

    }

    private IKLSCursorWrapper queryUsers(String whereClause, String [] whereAvrg)
    {
        Cursor cursor = database.query(
                NAME,
                null,
                whereClause,
                whereAvrg,
                null,
                null,
                null
        );

        return new IKLSCursorWrapper(cursor);
    }

    public void addUser(User user)
    {
        ContentValues values = getContentValuesUser(user);
        database.insert(NAME,null,values);
        Toast.makeText(context,"Saved",Toast.LENGTH_LONG).show();
    }

    private ContentValues getContentValuesUser(User user)
    {
        ContentValues values = new ContentValues();
        values.put(Cols.firstName, user.getFirstName());
        values.put(Cols.middleName, user.getMiddleName());
        values.put(Cols.lastName, user.getLastName());
        values.put(Cols.phoneNumber, user.getPhoneNumber());
        values.put(Cols.city, user.getCity());
        values.put(Cols.Emirates, user.getEmirates());
        values.put(Cols.street, user.getStreet());
        values.put(Cols.eMail, user.geteMail());
        values.put(Cols.password, user.geteMail());

        return values;
    }

    public List<Orders> getOrder()
    {
        List<Orders> ordersList = new ArrayList<>();
        IKLSCursorWrapper cursorWrapper = queryOrders(null,null);

        try
        {
            cursorWrapper.moveToFirst();
            while (!cursorWrapper.isAfterLast())
            {
                ordersList.add(cursorWrapper.getOrdersInfo());
                cursorWrapper.moveToNext();
            }
        }

        finally
        {
            cursorWrapper.close();
        }

        return ordersList;

    }

    private IKLSCursorWrapper queryOrders(String whereClause, String [] whereAvrg) {
        Cursor cursor = database.query(
                OrdersTable.NAME,
                null,
                whereClause,
                whereAvrg,
                null,
                null,
                null
        );

        return new IKLSCursorWrapper(cursor);

    }

    public void addOrders(Orders orders)
    {
        ContentValues values = getContentValueOrder(orders);
        database.insert(OrdersTable.NAME,null,values);
        Toast.makeText(context,"Saved",Toast.LENGTH_LONG).show();
    }

    private ContentValues getContentValueOrder(Orders orders)
    {

        ContentValues values = new ContentValues();
        values.put(OrdersTable.Cols.OrderNumber, orders.getOrderNumber());
        values.put(OrdersTable.Cols.Date, orders.getDate());
        values.put(OrdersTable.Cols.Clothe1, orders.getCloth1());
        values.put(OrdersTable.Cols.NumClothe1, orders.getNumCloth1());
        values.put(OrdersTable.Cols.Clothe2, orders.getCloth2());
        values.put(OrdersTable.Cols.NumClothe2, orders.getCloth2());
        values.put(OrdersTable.Cols.Clothe3, orders.getCloth3());
        values.put(OrdersTable.Cols.NumClothe3, orders.getNumCloth3());
        values.put(OrdersTable.Cols.Clothe4, orders.getCloth4());
        values.put(OrdersTable.Cols.NumClothe4, orders.getNumCloth4());
        values.put(OrdersTable.Cols.SpecialRequist, orders.getSpecialRequist());
        values.put(OrdersTable.Cols.LocLat, orders.getLocLat());
        values.put(OrdersTable.Cols.LocLong, orders.getLocLong());
        values.put(OrdersTable.Cols.OrderCondetion, orders.getOrderCondition());

        return values;
    }



}
