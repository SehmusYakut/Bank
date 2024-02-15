
import java.util.Date;

/**
 *
 * @author Saadettin
 */
public class Customer {
    private String name;
    private String tc;
    private String phone;
    private String gender;
    private String adres;
    private String password;
    private int id;
    private Date date;

    public Customer(String name, String tc, String phone, String gender, String adres, String password, int id, Date date) {
        this.name = name;
        this.tc = tc;
        this.phone = phone;
        this.gender = gender;
        this.adres = adres;
        this.password = password;
        this.id = id;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTc() {
        return tc;
    }

    public void setTc(String tc) {
        this.tc = tc;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    
          
}
