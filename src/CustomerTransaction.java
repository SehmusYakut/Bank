
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CustomerTransaction {
    private Connection con = null;
    
    private Statement statement = null;
    
    private PreparedStatement preparedStatement = null;
    
    public static String tc = "";

    
    public  CustomerTransaction(){
        String url = "jdbc:mysql://" + Database.host + ":" + Database.port + "/" + Database.db_ismi + "?useUnicode=true&characterEncoding=utf8";
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch( ClassNotFoundException ex){
            System.out.println("Driver bulunamadi");
        }
        
        try {
            con = DriverManager.getConnection(url, Database.kullanici_adi, Database.parola);
            System.out.println("Baglanti basarili");
        } catch (SQLException ex) {
            System.out.println("Baglanti basarisiz");
            System.exit(-1);
        }
    }
    
    public boolean girisYap(String password, String tc){
        try {
            String sorgu = "Select * from customer where password = ? and tc = ?";
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setString(1, password);
            preparedStatement.setString(2, tc);
            
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()){
                int id = rs.getInt("id");
                if(id == 0){
                    return false;
                }
                return true;
            }
        } catch (SQLException ex) {
            return false;
        }
        return false;
    }
    
    public void addCustomer(String name, String tc, String phone, String gender, Date date, String adres, String password){
        try {
            String sorgu = "Insert Into customer (name,tc,phone,gender,id,date, adres,password) VALUES(?,?,?,?,?,?,?,?)";
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, tc);
            preparedStatement.setString(3, phone);
            preparedStatement.setString(4, gender);
            preparedStatement.setInt(5, 0);
            preparedStatement.setDate(6, sqlDate);
            preparedStatement.setString(7, adres);
            preparedStatement.setString(8, password);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerTransaction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String CustomerName(String tc){
        try {
            String sorgu = "Select * From customer where tc like ?";
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setString(1, tc);
            ResultSet rs = preparedStatement.executeQuery();
            
            if(rs.next()){
                String name = rs.getString("name");
                return name;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerTransaction.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Bos";
    }
    
    public String CustomerTC(){
        try {
            String sorgu = "Select * From customer where name like '#%'";
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sorgu);
            
            if(rs.next()){
                String tc = rs.getString("tc");
                return tc;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerTransaction.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Bos";
    }
    
    public void isaretle(String name, String tc){
        try {
            String tmp = "#" + name;
            statement = con.createStatement();
            String sorgu = "Update customer Set name = '"+ tmp +"' where tc like '"+ tc + "'";
            statement.executeUpdate(sorgu);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerTransaction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void back(){
        try {
            statement = con.createStatement();
            String sorgu = "Select * From customer where name like '#%'";
            ResultSet rs = statement.executeQuery(sorgu);
            if(rs.next()){
                String name1 =  rs.getString("name");
                String name2 = name1.replace("#", "");
                String tc = rs.getString("tc");
                String sorgu2 = "Update customer Set name = '"+ name2 +"' where tc like "+ tc;
                statement.executeUpdate(sorgu2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerTransaction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void isaretle(String tc){
        this.tc = tc;
    }
    
    public ArrayList<Account> hesapGetir(String tc){
        String sorgu = "Select * from account where tc like '" + tc +"'";
        ArrayList<Account> account = new ArrayList<Account>();
        try {
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sorgu);
            
            while(rs.next()){
                String type = rs.getString("type");
                double amount = rs.getDouble("amount");
                String iban = rs.getString("iban");
                if(iban.contains("#"))
                    iban = iban.replace("#", "");
                account.add(new Account(type, amount, iban));
                
            }
            return account;
            
        } catch (SQLException ex) {
            Logger.getLogger(CustomerTransaction.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public void addAccount(String tc, String type, double amount, String iban){
        try {
            statement = con.createStatement();
            
            //Insert into calisanlar (ad, soyad, email) VALUES('Yusuf', 'ÇetinKaya', 'mucahit@gmail.com')
            String sorgu = "Insert into account (tc, type, amount,iban) VALUES(" + "'" + tc + "'" + "," + "'" + type + "'" + "," + "'" + amount+"'," + "'" + iban+"')";
            statement.executeUpdate(sorgu);
            
        } catch (SQLException ex) {
            Logger.getLogger(CustomerTransaction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void HesapSil(String iban){
        
        try {
            statement = con.createStatement();
            String sorgu = "Delete from account where iban like " + "'"+iban+"'";
            int deger = statement.executeUpdate(sorgu);
            System.out.println(deger + " kadar veri silindi");
        } catch (SQLException ex) {
            Logger.getLogger(CustomerTransaction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean dogrulaHesap(String iban){
        try {
            String sorgu = "Select * from account where iban = ?";
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setString(1, iban);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            return rs.next();
            
        } catch (SQLException ex) {
            Logger.getLogger(CustomerTransaction.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public void transferAmount(String iban, double amount){
        try {
            statement = con.createStatement();
            String sorgu = "Update account Set amount = '"+ amount +"' where iban like '"+ iban + "'";
            statement.executeUpdate(sorgu);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerTransaction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String ibanName(String iban){
        try {
            String sorgu = "Select * from account where iban = ?";
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setString(1, iban);
            
            ResultSet rs = preparedStatement.executeQuery();
            String tc = "";
            if(rs.next()){
                tc =  rs.getString("tc");
            }
            String sorgu2 = "Select * from customer where tc = ?";
            preparedStatement = con.prepareStatement(sorgu2);
            preparedStatement.setString(1, tc);
            rs = preparedStatement.executeQuery();
            if(rs.next())
                return rs.getString("name").replace("#", "");
        } catch (SQLException ex) {
            Logger.getLogger(CustomerTransaction.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
        return "";
    }
    
    public boolean kayitHesapVarMi(String tc, String iban){
        try {
            String sorgu = "Select * from iban where tc = ?";
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setString(1, tc);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                String iban2 = rs.getString("iban2");
                if(iban.equals(iban2)){
                    return true;
                }
            }
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(CustomerTransaction.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public double kayitHesapAmount(String iban){
        try {
            String sorgu = "Select * from account where iban = ?";
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setString(1, iban);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            if(rs.next()){
              return rs.getDouble("amount");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerTransaction.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
        return 0;
    }
    
    public void kayitHesapEkle(String tc, String iban, String name){
        try {
            statement = con.createStatement();
            name = name.replace("#", "");
            String sorgu = "Insert into iban (tc, iban2, name) VALUES(" + "'" + tc + "'" + "," + "'" + iban + "'" + "," + "'" + name+"')";
            statement.executeUpdate(sorgu);
            
        } catch (SQLException ex) {
            Logger.getLogger(CustomerTransaction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Account> kayitliHesap(String tc){
        String sorgu = "Select * from iban where tc like '" + tc +"'";
        ArrayList<Account> account = new ArrayList<Account>();
        try {
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sorgu);
            
            while(rs.next()){
                String name = rs.getString("name");
                String iban = rs.getString("iban2");
                account.add(new Account(iban, name));
                
            }
            return account;
            
        } catch (SQLException ex) {
            Logger.getLogger(CustomerTransaction.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public String getPassword(String tc){
        try {
            String sorgu = "Select * From customer where tc like ?";
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setString(1, tc);
            ResultSet rs = preparedStatement.executeQuery();
            
            if(rs.next()){
                String pass = rs.getString("password");
                return pass;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerTransaction.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
   public void changedPassword(String tc, String neww){
       try {
            statement = con.createStatement();
            String sorgu = "Update customer Set password = '"+ neww +"' where tc like '"+ tc + "'";
            statement.executeUpdate(sorgu);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerTransaction.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
   
   public void deleteKayitliHEsap(String iban){
       try {
            statement = con.createStatement();
            String sorgu = "Delete from iban where iban2 like " + "'"+iban+"'";
            int deger = statement.executeUpdate(sorgu);
            System.out.println(deger + " kadar veri silindi");
        } catch (SQLException ex) {
            Logger.getLogger(CustomerTransaction.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
   
   public String getAccountType(String iban){
       try {
            String sorgu = "Select * from account where iban = ?";
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setString(1, iban);
            ResultSet rs = preparedStatement.executeQuery();
            
            if(rs.next())
                return rs.getString("type");
            
        } catch (SQLException ex) {
            Logger.getLogger(CustomerTransaction.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
       return null;
   }
   
   public void yatirimGuncelle(double newDoviz,double newPara,String yatirimIban,String bankaIban){
         String sorgu = "Update account Set amount = '"+newDoviz+"' where iban like '"+yatirimIban+"'";
        
        try {
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(CustomerTransaction.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        String sorgu1 = "Update account Set amount = '"+newPara+"' where iban like '"+bankaIban+"'";
        
        try {
            preparedStatement = con.prepareStatement(sorgu1);
            preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(CustomerTransaction.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
   
   public ArrayList<Account> yatirimHesaplariGetir(String tcNo){
        String sorgu = "Select * from account where tc like '" + tcNo +"'";
         ArrayList<Account> cikti= new ArrayList<Account>();
        
        try {
            
            
            statement = con.createStatement();
            ResultSet rs = preparedStatement.executeQuery(sorgu);
            
            while(rs.next()){
                    String type= rs.getString("type");
                    if(type.contains("Yat")){
                        String iban = rs.getString("iban");
                    double amount = rs.getDouble("amount");
                    cikti.add(new Account(type,amount,iban));
                    }
                    
                
            }
            return cikti;
        } catch (SQLException ex) {
            Logger.getLogger(CustomerTransaction.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
 
    }
   
   public void borcOde(String iban,Double yeniAmount,String faturaTipi,String tcNo){
        String sorgu = "Update account Set amount = '"+yeniAmount+"' where iban like '"+iban+"'";
        
        try {
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(CustomerTransaction.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String sorgu1 = "Update fatura Set "+faturaTipi+" = '0' where tc like '"+tcNo+"'";
        
        try {
            preparedStatement = con.prepareStatement(sorgu1);
            preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(CustomerTransaction.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    public ArrayList<Account> paraHesaplariGetir(String tcNo){
        String sorgu = "Select * from account where tc like '" + tcNo +"'";
         ArrayList<Account> cikti= new ArrayList<Account>();
        
        try {
            
            
            statement = con.createStatement();
            ResultSet rs = preparedStatement.executeQuery(sorgu);
            
            while(rs.next()){
                String type = rs.getString("type");
                
                if(type.contains("Vad") || type.contains("Kre")){
                    double amount = rs.getDouble("amount");
                    String iban = rs.getString("iban");
                    cikti.add(new Account(type,amount,iban));
                }
            }
            return cikti;
        } catch (SQLException ex) {
            Logger.getLogger(CustomerTransaction.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
 
    }
    
    
    
    
    public double borcSorgula(String tcNo,String faturaTipi){
        
        
        try {
            String sorgu = "SELECT * FROM fatura WHERE tc = ?";
            
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setString(1, tcNo);
            
            double borcMiktari = -0;
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()){
             borcMiktari = rs.getInt(faturaTipi);
             return borcMiktari;
        }
            return borcMiktari;
            
           
        } catch (SQLException ex) {
            Logger.getLogger(CustomerTransaction.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
        
    }
    
    public ArrayList<Account> hesapGetir(){
        String sorgu = "Select * from account ";
        ArrayList<Account> account = new ArrayList<Account>();
        try {
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sorgu);
            
            while(rs.next()){
                String type = rs.getString("type");
                int amount = rs.getInt("amount");
                String iban = rs.getString("iban");
                String tc = rs.getString("tc");
                if(iban.contains("#"))
                    iban = iban.replace("#", "");
                account.add(new Account(type, amount, iban, tc));
                
            }
            return account;
            
        } catch (SQLException ex) {
            Logger.getLogger(CustomerTransaction.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
   
   public ArrayList<Customer> customerGetir(){
        String sorgu = "Select * from customer ";
        ArrayList<Customer> customer = new ArrayList<Customer>();
        try {
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sorgu);
            
            while(rs.next()){
                String tc = rs.getString("tc");
                int id = rs.getInt("id");
                String adres = rs.getString("adres");
                String name = rs.getString("name");
                String password = rs.getString("password");
                String phone = rs.getString("phone");
                String gender = rs.getString("gender");
                Date date = rs.getDate("date");
                customer.add(new Customer(name, tc, phone, gender, adres, password, id, date));
                
            }
            return customer;
            
        } catch (SQLException ex) {
            Logger.getLogger(CustomerTransaction.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
     public void AccountGuncelle(String tc, String type, double amount, String iban){
        try {
            String sorgu = "Update account set type = ? , amount = ? , iban = ? where tc = '" + tc + "'";
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setString(1, type);
            preparedStatement.setDouble(2, amount);
            preparedStatement.setString(3, iban);
            //preparedStatement.setString(4, tc);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerTransaction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
     public void customerConfirm(String tc){
        try {
            String sorgu = "Update customer set id = ? where tc = ?";
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setInt(1, 1);
            preparedStatement.setString(2, tc);
            
            preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(CustomerTransaction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
     
     public void deleteCustomer(String tc){
       try {
            statement = con.createStatement();
            String sorgu = "Delete from customer where tc like " + "'"+tc+"'";
            statement.executeUpdate(sorgu);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerTransaction.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
     
   public void deleteKayitliHesapFull(String tc){
       try {
            statement = con.createStatement();
            String sorgu = "Delete from account where tc like " + "'"+tc+"'";
            int deger = statement.executeUpdate(sorgu);
            System.out.println(deger + " kadar veri silindi");
        } catch (SQLException ex) {
            Logger.getLogger(CustomerTransaction.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
   
   public void CustomerGuncelle(String tc, String name, String phone, String gender, String adres, int id, Date date){
        try {
            String sorgu = "Update customer set name = ? , phone = ? , gender = ?, adres = ?, id = ?, date = ? where tc = '" + tc + "'";
            preparedStatement = con.prepareStatement(sorgu);
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, phone);
            preparedStatement.setString(3, gender);
            preparedStatement.setString(4, adres);
            preparedStatement.setInt(5, id);
            preparedStatement.setDate(6, sqlDate);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerTransaction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
   
   
}







































