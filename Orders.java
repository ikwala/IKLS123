package ikwala.com;

/**
 * Created by ikwal on 6/22/2016.
 */
public class Orders
{
    private int orderNumber;
    private String date;
    private String cloth1;
    private String cloth2;
    private String cloth3;
    private String cloth4;
    private int numCloth1;
    private int numCloth2;
    private int numCloth3;
    private int numCloth4;
    private String specialRequist;
    private double locLat;
    private double locLong;
    private String orderCondition;



    public Orders(int orderNumber,String date, String cloth1, int numCloth1, String cloth2, int numCloth2, String cloth3,int numCloth3,
                  String cloth4, int numCloth4, String specialRequist, double locLat,double locLong, String orderCondition) {
        this.orderNumber = orderNumber;
        this.date = date;
        this.cloth1 = cloth1;
        this.numCloth1 = numCloth1;
        this.cloth2 = cloth2;
        this.numCloth2 = numCloth2;
        this.cloth3 = cloth3;
        this.numCloth3 = numCloth3;
        this.cloth4 = cloth4;
        this.numCloth4 = numCloth4;
        this.specialRequist = specialRequist;
        this.locLat = locLat;
        this.locLong = locLong;
        this.orderCondition = orderCondition;
    }

    public String getOrderCondition()
    {
        return orderCondition;
    }

    public double getLocLat() {
        return locLat;
    }

    public void setLocLat(double locLat) {
        this.locLat = locLat;
    }

    public double getLocLong() {
        return locLong;
    }

    public void setLocLong(double locLong) {
        this.locLong = locLong;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getCloth1() {
        return cloth1;
    }

    public void setCloth1(String cloth1) {
        this.cloth1 = cloth1;
    }

    public String getCloth2() {
        return cloth2;
    }

    public void setCloth2(String cloth2) {
        this.cloth2 = cloth2;
    }

    public String getCloth3() {
        return cloth3;
    }

    public void setCloth3(String cloth3) {
        this.cloth3 = cloth3;
    }

    public String getCloth4() {
        return cloth4;
    }

    public void setCloth4(String cloth4) {
        this.cloth4 = cloth4;
    }

    public int getNumCloth1() {
        return numCloth1;
    }

    public void setNumCloth1(int numCloth1) {
        this.numCloth1 = numCloth1;
    }

    public int getNumCloth2() {
        return numCloth2;
    }

    public void setNumCloth2(int numCloth2) {
        this.numCloth2 = numCloth2;
    }

    public int getNumCloth3() {
        return numCloth3;
    }

    public void setNumCloth3(int numCloth3) {
        this.numCloth3 = numCloth3;
    }

    public int getNumCloth4() {
        return numCloth4;
    }

    public void setNumCloth4(int numCloth4) {
        this.numCloth4 = numCloth4;
    }

    public String getSpecialRequist() {
        return specialRequist;
    }

    public void setSpecialRequist(String specialRequist) {
        this.specialRequist = specialRequist;
    }
}
