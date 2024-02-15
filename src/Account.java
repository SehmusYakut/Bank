

/**
 *
 * @author Saadettin
 */
public class Account{
           private String type;
           private double amount;
           private String iban;
           private String name;
           private String TC;

        public Account(String type, double amount, String iban) {
            this.type = type;
            this.amount = amount;
            this.iban = iban;
        }

    public Account(String type, double amount, String iban, String TC) {
        this.type = type;
        this.amount = amount;
        this.iban = iban;
        this.TC = TC;
    }
        

    public Account(String iban, String name) {
        this.iban = iban;
        this.name = name;
    }
        
        

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public String getIban() {
        return iban;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public String getTC() {
        return TC;
    }
        
    
           
    }
