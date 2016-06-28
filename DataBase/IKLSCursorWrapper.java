package ikwala.com.DataBase;

import android.database.Cursor;
import android.database.CursorWrapper;


import ikwala.com.Orders;
import ikwala.com.User;

import static ikwala.com.DataBase.IKLSSchema.*;
import static ikwala.com.DataBase.IKLSSchema.UsersTable.*;

/**
 * Created by ikwal on 6/13/2016.
 */
public class IKLSCursorWrapper extends CursorWrapper
{


    /**
     * Creates a cursor wrapper.
     *
     * @param cursor The underlying cursor to wrap.
     */
    public IKLSCursorWrapper(Cursor cursor)
    {
        super(cursor);
    }

    public User getUserInfo()
    {
        String firstName = getString(getColumnIndex(Cols.firstName));
        String middleName = getString(getColumnIndex(Cols.middleName));
        String lastName = getString(getColumnIndex(Cols.lastName));
        int phoneNumber = getInt(getColumnIndex(Cols.phoneNumber));
        String city = getString(getColumnIndex(Cols.city));
        String Emirates = getString(getColumnIndex(Cols.Emirates));
        String street = getString(getColumnIndex(Cols.street));
        String eMail = getString(getColumnIndex(Cols.eMail));
        String password = getString(getColumnIndex(Cols.password));

        User user = new User(firstName,middleName,lastName,phoneNumber,city,Emirates,street,eMail,password);
        return user;
    }

    public Orders getOrdersInfo()
    {
         int orderNumber = getInt(getColumnIndex(OrdersTable.Cols.OrderNumber));
         String date = getString(getColumnIndex(OrdersTable.Cols.Date));
         String cloth1 = getString(getColumnIndex(OrdersTable.Cols.Clothe1));
         String cloth2 = getString(getColumnIndex(OrdersTable.Cols.Clothe2));
         String cloth3 = getString(getColumnIndex(OrdersTable.Cols.Clothe3));
         String cloth4 = getString(getColumnIndex(OrdersTable.Cols.Clothe4));
         int numCloth1 = getInt(getColumnIndex(OrdersTable.Cols.NumClothe1));
         int numCloth2 = getInt(getColumnIndex(OrdersTable.Cols.NumClothe2));
         int numCloth3 = getInt(getColumnIndex(OrdersTable.Cols.NumClothe3));
         int numCloth4 = getInt(getColumnIndex(OrdersTable.Cols.NumClothe4));
         String specialRequist = getString(getColumnIndex(OrdersTable.Cols.SpecialRequist));
         double locLat = getDouble(getColumnIndex(OrdersTable.Cols.LocLat));
         double locLong = getDouble(getColumnIndex(OrdersTable.Cols.LocLong));
         String orderCondetion = getString(getColumnIndex(OrdersTable.Cols.OrderCondetion));

        Orders order = new Orders(orderNumber,date,cloth1,numCloth1,cloth2,numCloth2,
                cloth3,numCloth3,cloth4,numCloth4,specialRequist,locLat,locLong,orderCondetion);
        return order;
    }


}
