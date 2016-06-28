package ikwala.com.DataBase;

/**
 * Created by ikwal on 6/12/2016.
 */
public class IKLSSchema
{
    public static final class UsersTable
    {
        public static final String NAME = "USER";

        public static final class Cols
        {
            public static final String firstName ="firstName";
            public static final String middleName = "middleName";
            public static final String lastName = "lastName";
            public static final String phoneNumber = "phoneNumber";
            public static final String city = "city";
            public static final String Emirates = "emirates";
            public static final String street = "street";
            public static final String eMail = "email";
            public static final String password = "password";
        }
    }

    public static final class OrdersTable
    {
        public static final String NAME = "Orders";

        public static final class Cols
        {
            public static final String OrderNumber = "orderNumber";
            public static final String Date = "date";
            public static final String Clothe1 ="clothe1";
            public static final String Clothe2 = "clothe2";
            public static final String Clothe3 = "clothe3";
            public static final String Clothe4 = "clothe4";
            public static final String NumClothe1 = "numClothe1";
            public static final String NumClothe2 = "numClothe2";
            public static final String NumClothe3 = "numClothe3";
            public static final String NumClothe4 = "sumClothe4";
            public static final String SpecialRequist = "specialRequist";
            public static final String LocLat = "locLat";
            public static final String LocLong = "LocLong";
            public static final String OrderCondetion = "orderCondetion";
        }
    }
}
