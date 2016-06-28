package ikwala.com;

/**
 * Created by ikwal on 6/12/2016.
 */
public class User
{
    private String firstName;
    private String middleName;
    private String lastName;
    private int phoneNumber;
    private String city;
    private String Emirates;
    private String street;
    private String eMail;
    private String password;

    public User(String firstName, String middleName, String lastName, int phoneNumber,
                String city, String emirates, String street, String eMail, String password)
    {
        this.setFirstName(firstName);
        this.setMiddleName(middleName);
        this.setLastName(lastName);
        this.setPhoneNumber(phoneNumber);
        this.setCity(city);
        setEmirates(emirates);
        this.setStreet(street);
        this.seteMail(eMail);
        this.setPassword(password);
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmirates() {
        return Emirates;
    }

    public void setEmirates(String emirates) {
        Emirates = emirates;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
