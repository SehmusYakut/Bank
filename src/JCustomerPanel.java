
import java.util.ArrayList;
import java.util.Random;
import javax.swing.table.DefaultTableModel;


public class JCustomerPanel extends javax.swing.JFrame {

    
    CustomerTransaction trans = new CustomerTransaction();
    private String tc = CustomerTransaction.tc;
    private String name = trans.CustomerName(tc).replace("#", "");
    ArrayList<Account> account = trans.hesapGetir(tc);
    DovizKuru dovizKuru = new DovizKuru();
    int transferOnay;
    
    DefaultTableModel model;
    DefaultTableModel transferModel;
    DefaultTableModel transferKayitModel;
    DefaultTableModel yatirimHesaplariModel;
    DefaultTableModel paraHesaplariModel;
    DefaultTableModel paraHesaplariModel1;
    
    public JCustomerPanel() {
        initComponents();
        nameText.setText(name);
        System.out.println(tc);
        model = (DefaultTableModel)account_table.getModel();
        transferModel = (DefaultTableModel)transferTable.getModel();
        transferKayitModel = (DefaultTableModel)transferKayitliTable.getModel();
        paraHesaplariModel = (DefaultTableModel)hesaplar_table.getModel();
        paraHesaplariModel1 = (DefaultTableModel)hesaplar_table1.getModel();
        yatirimHesaplariModel = (DefaultTableModel)yatirim_table.getModel();
        
        hesaplariGoruntule();
        hesaplariGoruntuleTransfer();
        hesaplariGoruntuleTransferKayit();
        paraHesaplariGoruntule1(tc);
        yatirimHesaplariGoruntule(tc);
        transferOnay = 0;
        paraTransName.setText("");
        transferConfirm.setText("");
        
        dolarTl.setText(""+dovizKuru.Dolar);
        euroTl.setText(""+dovizKuru.Euro);
        altınTl.setText(""+dovizKuru.Altın);
    }
    
    
    public void yatirimHesaplariGoruntule(String tcNo){
        
        yatirimHesaplariModel.setRowCount(0);
        
        ArrayList<Account> yatirimHesaplari = new ArrayList<Account>();
        
        yatirimHesaplari = trans.yatirimHesaplariGetir(tcNo);
        
        if(yatirimHesaplari!= null){
        
        for(Account yatirim : yatirimHesaplari){
            Object[] ekle = {yatirim.getType(),yatirim.getIban(),yatirim.getAmount()};
            
            yatirimHesaplariModel.addRow(ekle);
        }
    }
        
    }
    
    public void paraHesaplariGoruntule1(String tcNo){
        
        paraHesaplariModel1.setRowCount(0);
        
        ArrayList<Account> paraHesaplari = new ArrayList<Account>();
        
        paraHesaplari = trans.paraHesaplariGetir(tcNo);
        
        if(paraHesaplari!= null){
        
        for(Account account2 : paraHesaplari){
            Object[] ekle = {account2.getType(),account2.getAmount(),account2.getIban()};
            
            paraHesaplariModel1.addRow(ekle);
        }
    }
        
    }
    
    public void paraHesaplariGoruntule(String tcNo){
        
        paraHesaplariModel.setRowCount(0);
        
        ArrayList<Account> paraHesaplari = new ArrayList<Account>();
        
        paraHesaplari = trans.paraHesaplariGetir(tcNo);
        
        if(paraHesaplari!= null){
        
        for(Account account2 : paraHesaplari){
            Object[] ekle = {account2.getType(),account2.getAmount(),account2.getIban()};
            
            paraHesaplariModel.addRow(ekle);
        }
    }
        
    }
    
    public void hesaplariGoruntule(){
        model.setRowCount(0);
        if(account != null){
            for(Account aa : account){
                Object[] adder = {aa.getIban(), aa.getType(), aa.getAmount()};
                model.addRow(adder);
            }
        }
    }
    
    public void hesaplariGoruntuleTransfer(){
        transferModel.setRowCount(0);
        if(account != null){
            for(Account aa : account){
                String type = aa.getType();
                if( !(type.contains("Yat")) ){
                    Object[] adder = {aa.getIban(), aa.getAmount()};
                    transferModel.addRow(adder);
                }
                
        }
    }
}
    
    public void hesaplariGoruntuleTransferKayit(){
        transferKayitModel.setRowCount(0);
        ArrayList<Account> kayitli = trans.kayitliHesap(tc);
        if(account != null){
            for(Account aa : kayitli){
                String name = aa.getName();
                String iban = aa.getIban();
                String type = trans.getAccountType(iban);
                    if(name.contains("#")){
                        name = name.replace("#", "");
                    }
                    if( !(type.contains("Yat")) ){
                        Object[] adder = {iban, name};
                        transferKayitModel.addRow(adder);
                    }
                    
                    
                    
            }
        }
    }
    
    public String createIBAN(){
        
        Random rand = new Random();
        int randomNumber1 = rand.nextInt(10);
        String random = String.valueOf(randomNumber1);
        String temp = "TR73 000"+random+" 100";
        int randomNumber2 = rand.nextInt(10);
        random = String.valueOf(randomNumber2);
        temp = temp + random+" ";
        int randomNumber3 = rand.nextInt(9000)+1000;
        random = String.valueOf(randomNumber3);
        temp = temp+random+" ";
        int randomNumber4 = rand.nextInt(9000)+1000;
        random = String.valueOf(randomNumber4);
        temp = temp+random+" ";
        int randomNumber5 = rand.nextInt(9000)+1000;
        random = String.valueOf(randomNumber5);
        temp = temp+random+" ";
        int randomNumber6 = rand.nextInt(90)+10;
        random = String.valueOf(randomNumber6);
        temp = temp+random;
        return temp;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jOptionPane1 = new javax.swing.JOptionPane();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jSpinner1 = new javax.swing.JSpinner();
        label1 = new java.awt.Label();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        yatirim_table = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        hesaplar_table1 = new javax.swing.JTable();
        tldendovize_btn = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        cevirimMiktari = new javax.swing.JTextField();
        dovizdenTlye_btn = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        dolarTl = new javax.swing.JLabel();
        yatirimUyari = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        euroTl = new javax.swing.JLabel();
        altınTl = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        transferKayitliTable = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        paraTransIBAN = new javax.swing.JTextField();
        paraTransAmount = new javax.swing.JTextField();
        paraTransName = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        transferConfirm = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        transferTable = new javax.swing.JTable();
        transferHesaplar = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        account_table = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        ibanText = new javax.swing.JLabel();
        typeText = new javax.swing.JLabel();
        amountType = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        typeCombobox = new javax.swing.JComboBox<>();
        hesapEkleText = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        deleteText = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        kayitliHesaplarimaEkle = new javax.swing.JButton();
        kayıtHesaplarımEkleText = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        fatura_secimi = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        tc_no = new javax.swing.JTextField();
        sorgula = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        hesaplar_table = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        borc_miktari = new javax.swing.JLabel();
        uyari = new javax.swing.JLabel();
        hesaplar_btn = new javax.swing.JButton();
        borcu_ode = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        hosgeldiniz = new javax.swing.JLabel();
        nameText = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        label1.setText("label1");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 359, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 438, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(225, 207, 252));
        addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                formComponentAdded(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jTabbedPane1.setOpaque(true);
        jTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane1StateChanged(evt);
            }
        });

        jPanel14.setBackground(new java.awt.Color(183, 242, 164));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        yatirim_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Hesap Adı", "İban", "Miktar"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane9.setViewportView(yatirim_table);

        jPanel14.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 380, 110));

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 102));
        jLabel13.setText("YATIRIM HESAPLARIM");
        jLabel13.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel14.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 162, 34));

        jLabel14.setText("Dolar/TL = 19.37");
        jPanel14.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(721, 79, 97, 25));

        jLabel15.setText("Gr Altın/TL = 1038");
        jPanel14.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(721, 143, -1, 25));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel17.setText("BANKA HESAPLARIM");
        jPanel14.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 153, -1));

        hesaplar_table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Hesap", "Para Miktarı", "İban"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane10.setViewportView(hesaplar_table1);

        jPanel14.add(jScrollPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 380, 110));

        tldendovize_btn.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        tldendovize_btn.setText("TL'den Dövize Çevir");
        tldendovize_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tldendovize_btnActionPerformed(evt);
            }
        });
        jPanel14.add(tldendovize_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 170, 30));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setText("Çevrilecek Miktar");
        jPanel14.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 340, 120, 30));
        jPanel14.add(cevirimMiktari, new org.netbeans.lib.awtextra.AbsoluteConstraints(274, 340, 110, 30));

        dovizdenTlye_btn.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        dovizdenTlye_btn.setText("Dövizden TL'ye Çevir");
        dovizdenTlye_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dovizdenTlye_btnActionPerformed(evt);
            }
        });
        jPanel14.add(dovizdenTlye_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 390, 180, 30));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel16.setText("DOLAR / TL : ");
        jPanel14.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 450, 110, -1));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel19.setText("GR ALTIN / TL : ");
        jPanel14.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 530, 130, -1));

        dolarTl.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        dolarTl.setText("..........");
        jPanel14.add(dolarTl, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 450, 80, -1));

        yatirimUyari.setForeground(new java.awt.Color(255, 0, 0));
        jPanel14.add(yatirimUyari, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 516, 224, -1));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel20.setText("EURO / TL : ");
        jPanel14.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 490, 100, 20));

        euroTl.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        euroTl.setText("..........");
        jPanel14.add(euroTl, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 490, 90, 20));

        altınTl.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        altınTl.setText("..........");
        jPanel14.add(altınTl, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 530, 90, 30));

        jTabbedPane1.addTab("Yatırım İşlemleri", jPanel14);

        jPanel11.setBackground(new java.awt.Color(245, 195, 238));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        transferKayitliTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "IBAN", "İsim"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        transferKayitliTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                transferKayitliTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(transferKayitliTable);

        jPanel11.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 54, 182, 171));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("IBAN");
        jPanel11.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(194, 19, 88, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Name");
        jPanel11.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(194, 54, 88, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Tutar");
        jPanel11.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(194, 92, 88, -1));

        paraTransIBAN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                paraTransIBANMouseEntered(evt);
            }
        });
        paraTransIBAN.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                paraTransIBANİnputMethodTextChanged(evt);
            }
        });
        jPanel11.add(paraTransIBAN, new org.netbeans.lib.awtextra.AbsoluteConstraints(288, 19, 127, -1));

        paraTransAmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paraTransAmountActionPerformed(evt);
            }
        });
        jPanel11.add(paraTransAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(288, 90, 127, -1));

        paraTransName.setText(".");
        jPanel11.add(paraTransName, new org.netbeans.lib.awtextra.AbsoluteConstraints(288, 57, 145, -1));

        jButton3.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jButton3.setText("Doğrula");
        jButton3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton3.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jButton3AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
                jButton3AncestorRemoved(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel11.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 132, 90, 30));

        transferConfirm.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        transferConfirm.setForeground(new java.awt.Color(255, 0, 0));
        transferConfirm.setText(".");
        jPanel11.add(transferConfirm, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 240, 270, 20));

        jButton4.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jButton4.setText("Gönder");
        jButton4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel11.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 172, 90, 30));

        transferTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "IBAN", "Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(transferTable);

        jPanel11.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 413, 111));

        transferHesaplar.setFont(new java.awt.Font("Segoe UI", 2, 13)); // NOI18N
        transferHesaplar.setText("Aşağıdan hangi hesabınızdan para göndermek istiyorsanız seçiniz.");
        jPanel11.add(transferHesaplar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 460, 30));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel9.setText("Kayıtlı IBAN");
        jPanel11.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 6, -1, 45));

        jButton5.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jButton5.setText("Kaydet");
        jButton5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel11.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 210, 90, 29));

        jTabbedPane1.addTab("Para Transferi", jPanel11);

        jPanel10.setBackground(new java.awt.Color(255, 239, 228));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        account_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "IBAN", "Tipi", "Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        account_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                account_tableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(account_table);

        jPanel10.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 410, 130));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel1.setText("IBAN:");
        jPanel10.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel2.setText("TİPİ :");
        jPanel10.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 40, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel3.setText("MİKTAR :");
        jPanel10.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 210, 70, 30));
        jPanel10.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(519, 56, -1, -1));

        ibanText.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        ibanText.setText("...");
        jPanel10.add(ibanText, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 320, 20));

        typeText.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        typeText.setText("...");
        jPanel10.add(typeText, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 210, 110, 30));

        amountType.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        amountType.setText("....");
        jPanel10.add(amountType, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 210, 130, 30));

        jButton1.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jButton1.setText("Hesap Ekle");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, 160, -1));

        typeCombobox.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        typeCombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seçiniz...", "Vadeli/Banka", "Vadesiz/Banka", "Kredi", "Yatırım/Altın", "Yatırım/Dolar", "Yatırım/Euro" }));
        typeCombobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeComboboxActionPerformed(evt);
            }
        });
        jPanel10.add(typeCombobox, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 250, 160, -1));

        hesapEkleText.setForeground(new java.awt.Color(255, 0, 0));
        hesapEkleText.setText("Hesap eklemek istiyorsanız seçiniz lütfen...");
        jPanel10.add(hesapEkleText, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, 328, -1));

        jButton2.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jButton2.setText("Hesap Sil");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, 160, 30));

        deleteText.setForeground(new java.awt.Color(255, 0, 0));
        deleteText.setText("Silmek için hesap seçin...");
        jPanel10.add(deleteText, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, 210, 20));

        jButton6.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jButton6.setText("Şifre Değiştir");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, 160, 40));

        kayitliHesaplarimaEkle.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        kayitliHesaplarimaEkle.setText("Kayıtlı Hesaplarıma Ekle");
        kayitliHesaplarimaEkle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kayitliHesaplarimaEkleActionPerformed(evt);
            }
        });
        jPanel10.add(kayitliHesaplarimaEkle, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 440, 160, 40));

        kayıtHesaplarımEkleText.setForeground(new java.awt.Color(255, 0, 51));
        kayıtHesaplarımEkleText.setText(".");
        jPanel10.add(kayıtHesaplarımEkleText, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 364, 158, -1));

        jTabbedPane1.addTab("Hesaplarım", jPanel10);

        jPanel15.setBackground(new java.awt.Color(199, 221, 255));
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fatura_secimi.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        fatura_secimi.setForeground(new java.awt.Color(255, 102, 0));
        fatura_secimi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ELEKTRİK", "GAZ", "SU" }));
        fatura_secimi.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        fatura_secimi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fatura_secimiActionPerformed(evt);
            }
        });
        jPanel15.add(fatura_secimi, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 40, 159, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Hesaba Ait Borç Miktarı:");
        jPanel15.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 179, 35));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Kullanıcının Kimlik Numarası:");
        jLabel10.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                jLabel10ComponentHidden(evt);
            }
        });
        jPanel15.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 210, 25));

        tc_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tc_noActionPerformed(evt);
            }
        });
        jPanel15.add(tc_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 100, 160, -1));

        sorgula.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        sorgula.setText("Fatura Sorgula");
        sorgula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sorgulaActionPerformed(evt);
            }
        });
        jPanel15.add(sorgula, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 140, 159, 37));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel11.setText("Borcun Ödeneceği Hesabı Seçin");
        jPanel15.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 260, 26));

        hesaplar_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Hesap", "Para Miktarı", "İban"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane8.setViewportView(hesaplar_table);

        jPanel15.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 370, 430, 140));
        jPanel15.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 263, 180, -1));

        borc_miktari.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        borc_miktari.setForeground(new java.awt.Color(255, 0, 51));
        borc_miktari.setText("........");
        jPanel15.add(borc_miktari, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 190, 159, -1));

        uyari.setForeground(new java.awt.Color(255, 51, 51));
        jPanel15.add(uyari, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 269, 259, -1));

        hesaplar_btn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        hesaplar_btn.setText("Hesaplarımı Göster");
        hesaplar_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hesaplar_btnActionPerformed(evt);
            }
        });
        jPanel15.add(hesaplar_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 270, 160, 39));

        borcu_ode.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        borcu_ode.setText("Borcu Öde");
        borcu_ode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borcu_odeActionPerformed(evt);
            }
        });
        jPanel15.add(borcu_ode, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 520, 160, 50));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Ödeme Türü Seçiniz :");
        jPanel15.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 220, 37));

        jTabbedPane1.addTab("Ödemeler", jPanel15);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 111, 470, 629));

        hosgeldiniz.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        hosgeldiniz.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        hosgeldiniz.setText("Hoşgeldiniz ");
        getContentPane().add(hosgeldiniz, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 61, 154, -1));

        nameText.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        getContentPane().add(nameText, new org.netbeans.lib.awtextra.AbsoluteConstraints(166, 61, 212, 32));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pastel-clouds-presentation-background-slides.jpg"))); // NOI18N
        background.setText("background");
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(-35, -10, 520, 780));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tldendovize_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tldendovize_btnActionPerformed

        int selectedRow = yatirim_table.getSelectedRow();
        int selectedRow1 = hesaplar_table1.getSelectedRow();

        double deger = Double.parseDouble(cevirimMiktari.getText());
        if(cevirimMiktari.getText() == ""){
            yatirimUyari.setText("Herhangi bir değer girmediniz");
        }
        if(selectedRow == -1 && selectedRow1 == -1){
            yatirimUyari.setText("Herhangi bir hesap seçmediniz!");
        }
        else if(selectedRow == -1){
            yatirimUyari.setText("Yatırım hesabı seçmediniz!");
        }
        else if(selectedRow1 == -1){
            yatirimUyari.setText("Banka hesabı seçmediniz!");
        }

        String hesap_tipi = yatirim_table.getValueAt(selectedRow,0).toString();
        String yatırımIban = yatirim_table.getValueAt(selectedRow, 1).toString();
        double miktar = (double)yatirim_table.getValueAt(selectedRow, 2);

        String hesap_adi = hesaplar_table1.getValueAt(selectedRow1, 0).toString();
        double amount = (double)hesaplar_table1.getValueAt(selectedRow1, 1);
        String bankaIban = hesaplar_table1.getValueAt(selectedRow1, 2).toString();

        if(deger>amount){
            yatirimUyari.setText("Hesapta Yeterli Para Yok");

        }
        else{
            double newDeger = amount - deger;
            if(hesap_tipi.contains("Alt")){
                double newAltın = miktar + deger/dovizKuru.Altın;
                trans.yatirimGuncelle(newAltın,newDeger,yatırımIban,bankaIban);
            }
            if(hesap_tipi.contains("Dol")){
                double newDolar = miktar + deger/dovizKuru.Dolar;
                trans.yatirimGuncelle(newDolar,newDeger,yatırımIban,bankaIban);
            }
            if(hesap_tipi.contains("Eur")){
                double newEuro = miktar + deger/dovizKuru.Euro;
                trans.yatirimGuncelle(newEuro,newDeger,yatırımIban,bankaIban);
            }
        }

        paraHesaplariGoruntule1(tc);
        yatirimHesaplariGoruntule(tc);
        hesaplariGoruntule();

        yatirimUyari.setText("Başarıyla Çevrildi");

    }//GEN-LAST:event_tldendovize_btnActionPerformed

    private void dovizdenTlye_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dovizdenTlye_btnActionPerformed

        int selectedRow = yatirim_table.getSelectedRow();
        int selectedRow1 = hesaplar_table1.getSelectedRow();

        double deger = Double.parseDouble(cevirimMiktari.getText());

        if(selectedRow == -1 && selectedRow1 == -1){
            yatirimUyari.setText("Herhangi bir hesap seçmediniz!");
        }
        else if(selectedRow == -1){
            yatirimUyari.setText("Yatırım hesabı seçmediniz!");
        }
        else if(selectedRow1 == -1){
            yatirimUyari.setText("Banka hesabı seçmediniz!");
        }

        String hesap_tipi = yatirim_table.getValueAt(selectedRow,0).toString();
        String yatırımIban = yatirim_table.getValueAt(selectedRow, 1).toString();
        double miktar = (double)yatirim_table.getValueAt(selectedRow, 2);

        String hesap_adi = hesaplar_table1.getValueAt(selectedRow1, 0).toString();
        double amount = (double)hesaplar_table1.getValueAt(selectedRow1, 1);
        String bankaIban = hesaplar_table1.getValueAt(selectedRow1, 2).toString();

        if(deger>miktar){
            yatirimUyari.setText("Yeterli Miktar Yok");

        }
        else{

            if(hesap_tipi.contains("Alt")){
                double newAltın = miktar - deger;
                double newDeger = amount + deger*dovizKuru.Altın;
                trans.yatirimGuncelle(newAltın,newDeger,yatırımIban,bankaIban);
            }
            if(hesap_tipi.contains("Dol")){
                double newDolar = miktar - deger;
                double newDeger = amount + deger*dovizKuru.Dolar;
                trans.yatirimGuncelle(newDolar,newDeger,yatırımIban,bankaIban);
            }
            if(hesap_tipi.contains("Eur")){
                double newEuro = miktar -  deger;
                double newDeger = amount + deger*dovizKuru.Euro;
                trans.yatirimGuncelle(newEuro,newDeger,yatırımIban,bankaIban);
            }
        }

        paraHesaplariGoruntule1(tc);
        yatirimHesaplariGoruntule(tc);

        yatirimUyari.setText("Başarıyla Çevrildi");

    }//GEN-LAST:event_dovizdenTlye_btnActionPerformed

    private void jLabel10ComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jLabel10ComponentHidden
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel10ComponentHidden

    private void tc_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tc_noActionPerformed

    }//GEN-LAST:event_tc_noActionPerformed

    private void sorgulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sorgulaActionPerformed
        borc_miktari.setText("");
        uyari.setText("");
        String tcNo = tc_no.getText();
        String faturaTipi = fatura_secimi.getItemAt(fatura_secimi.getSelectedIndex());
        String su = "SU"; String elk = "ELEKTRİK"; String gaz = "GAZ";
        if(faturaTipi.equals(su)){
            faturaTipi = "su";
        };
        if(faturaTipi.equals(elk)){
            faturaTipi = "elektrik";
        };
        if(faturaTipi.equals(gaz)){
            faturaTipi = "gaz";
        };

        double borcMiktari = trans.borcSorgula(tcNo, faturaTipi);
        if(tcNo == "" && borcMiktari == -5){
            uyari.setText("Kimlik no giriniz");
        }
        if( tcNo!= "" && borcMiktari == -5){
            uyari.setText("Kullanıcı bulunamadı");
        }
        if(borcMiktari == 0){
            uyari.setText("Borcunuz bulunmamaktadır");
            borc_miktari.setText("0 TL");
        }
        else
        borc_miktari.setText(String.valueOf(borcMiktari+"TL"));

    }//GEN-LAST:event_sorgulaActionPerformed

    private void hesaplar_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hesaplar_btnActionPerformed

        paraHesaplariGoruntule(tc);

    }//GEN-LAST:event_hesaplar_btnActionPerformed

    private void borcu_odeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borcu_odeActionPerformed
        uyari.setText("");
        int selectedRow = hesaplar_table.getSelectedRow();
        if (selectedRow == -1){
            if(hesaplar_table.getRowCount() == 0){
                uyari.setText("Henüz herhangi bir banka hesabınız yok");
            }
            else
            uyari.setText("Borcu odeyecek hesap seçmediniz!!!");
        }
        String hesapTuru = hesaplar_table.getValueAt(selectedRow,0).toString();
        String iban = hesaplar_table.getValueAt(selectedRow, 2).toString();

        Double amount = (Double)hesaplar_table.getValueAt(selectedRow,1);
        String borcMiktari = borc_miktari.getText().replace("TL","");
        Double borcunuz = Double.valueOf(borcMiktari);

        if(amount >= borcunuz){
            double yeniAmount = amount - borcunuz;
            String tcNo = tc_no.getText();
            String faturaTipi = fatura_secimi.getItemAt(fatura_secimi.getSelectedIndex());
            String su = "SU"; String elk = "ELEKTRİK"; String gaz = "GAZ";
            if(faturaTipi.equals(su)){
                faturaTipi = "su";
            };
            if(faturaTipi.equals(elk)){
                faturaTipi = "elektrik";
            };
            if(faturaTipi.equals(gaz)){
                faturaTipi = "gaz";
            };

            trans.borcOde(iban,yeniAmount,faturaTipi,tcNo);
            paraHesaplariGoruntule(tc);
            uyari.setText("Borcunuz başarıyla ödendi");
        }
        else{
            uyari.setText("Hesaptaki Bakiye Yetersiz!!!!");
        }

    }//GEN-LAST:event_borcu_odeActionPerformed

    private void transferKayitliTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transferKayitliTableMouseClicked
        int selectRow = transferKayitliTable.getSelectedRow();
        paraTransIBAN.setText(transferKayitliTable.getValueAt(selectRow, 0).toString());
        paraTransName.setText(transferKayitliTable.getValueAt(selectRow, 1).toString());
        transferOnay = 1;
        transferConfirm.setText("Geçerli IBAN mevcut");
    }//GEN-LAST:event_transferKayitliTableMouseClicked

    private void paraTransIBANMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paraTransIBANMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_paraTransIBANMouseEntered

    private void paraTransIBANİnputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_paraTransIBANİnputMethodTextChanged
        transferOnay = 0;
    }//GEN-LAST:event_paraTransIBANİnputMethodTextChanged

    private void jButton3AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jButton3AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3AncestorAdded

    private void jButton3AncestorRemoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jButton3AncestorRemoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3AncestorRemoved

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        paraTransName.setText("");
        kayıtHesaplarımEkleText.setText("");
        String iban = paraTransIBAN.getText();
        if(transferEmpty()){
            transferConfirm.setText("Bilgilerinizi eksik girdiniz.");
            transferOnay = 0;
        }
        else if( trans.dogrulaHesap(iban)){
            transferConfirm.setText("Geçerli IBAN mevcut");
            paraTransName.setText(trans.ibanName(iban));
            transferOnay = 1;
        }
        else{
            transferConfirm.setText("Geçerli IBAN giriniz");
            transferOnay = 0;
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if(transferOnay == 0){
            transferConfirm.setText("Doğrulamadan transfer yapamazsınız.");
            return;
        }

        String iban = paraTransIBAN.getText();//Parası artacak
        String amount = paraTransAmount.getText();
        int selectRow = transferTable.getSelectedRow();
        String iban2;
        if(selectRow == -1){
            transferHesaplar.setText("Lütfen aşağıdaki hesaplarınızdan hesap seçin");
            transferOnay = 0;
            return;
        }
        iban2 = transferTable.getValueAt(selectRow, 0).toString(); //Parası azalacak
        double amountInt = 0;
        boolean onay = false;
        if(amount.length() != 0){
            amountInt = Double.parseDouble(amount);
            onay = true;
        }
        if(amountInt < 0){
            transferConfirm.setText("Tutar kısmına eksi değer giremezsiniz.");
            return;
        }
        int index2 = indexAccount(iban2);
        double para2 = trans.kayitHesapAmount(iban);
        Account tmp2 = account.get(index2);
        if(!onay){
            transferConfirm.setText("Tutar kısmına değer giriniz.");
        }
        else if(transferOnay == 1 && tmp2.getAmount() >= amountInt){
            double ekle = para2 + amountInt;
            double kalan =  tmp2.getAmount() - amountInt;
            if(iban.equals(iban2)){
                transferConfirm.setText("Aynı olan hesaba para atamazsın.");
            }
            else{
                trans.transferAmount(iban, ekle);
                trans.transferAmount(iban2, kalan);
                tmp2.setAmount(kalan);
                account = trans.hesapGetir(tc);
                hesaplariGoruntule();
                hesaplariGoruntuleTransfer();
                yatirimHesaplariGoruntule(tc);
                paraHesaplariGoruntule1(tc);
                paraHesaplariGoruntule(tc);
                paraTransAmount.setText("");
                transferConfirm.setText("Transfer başarıyla gerçekleşti.");
            }

        }
        else if(transferOnay == 1){
            transferConfirm.setText("Yeterli bakiyeniz yok.");
        }
        transferOnay = 0;
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        String iban = paraTransIBAN.getText();
        if(trans.dogrulaHesap(iban)){
            if(trans.kayitHesapVarMi(tc, iban)){
                transferConfirm.setText("Zaten bu hesap kayıtlı.");
            }
            else{
                String name = trans.ibanName(iban);
                trans.kayitHesapEkle(tc, iban, name);
                hesaplariGoruntuleTransferKayit();
                transferConfirm.setText("Başarıyla hesap kaydedildi.");
            }
        }
        else{
            transferConfirm.setText("Kaydedemezsiniz");
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void account_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_account_tableMouseClicked
        transferHesaplar.setText("Aşağıdan hangi hesabınızdan para göndermek istiyorsanız seçiniz.");
        hesapEkleText.setText("Hesap eklemek istiyorsanız seçiniz lütfen...");
        deleteText.setText("Silmek için hesap seçin...");
        kayıtHesaplarımEkleText.setText("");
        int selectRow = account_table.getSelectedRow();
        ibanText.setText(account_table.getValueAt(selectRow, 0).toString());
        typeText.setText(account_table.getValueAt(selectRow, 1).toString());
        amountType.setText(account_table.getValueAt(selectRow, 2).toString());
    }//GEN-LAST:event_account_tableMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String type = typeCombobox.getItemAt(typeCombobox.getSelectedIndex());
        if(type.equals("Seçiniz...")){
            hesapEkleText.setText("Hesap eklemek için herhangi bir hesabın tipi seçmelisiniz.");
        }
        else{
            String iban = createIBAN();
            trans.addAccount(tc, type, 0, iban);
            hesapEkleText.setText("Hesabınız başarılıyla eklendi.");
            account.add(new Account(type, 0, iban));
            hesaplariGoruntule();
            hesaplariGoruntuleTransfer();
            typeCombobox.setSelectedItem("Seçiniz...");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void typeComboboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeComboboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_typeComboboxActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int selectRow = account_table.getSelectedRow();
        if(selectRow < 0){
            if(model.getRowCount() == 0){
                deleteText.setText("Mevcut hesabınız şuanda yoktur...");
            }
            else
            deleteText.setText("Seçili bir hesap silinebilir. Lütfen hesap seçin...");
            return;
        }
        String amount = account_table.getValueAt(selectRow, 2).toString();
        if(amount.length() == 0){
            return;
        }
        double Intamount = Double.parseDouble(amount);

        if( Intamount != 0 ){
            deleteText.setText("Silmek istediğiniz hesapta para var. Önce içindeki paraları başka hesaba aktarın");
        }
        else{
            String iban = account_table.getValueAt(selectRow, 0).toString();
            trans.HesapSil(iban);
            account.remove(indexAccount(iban));
            deleteText.setText("Hesabınız başarıyla silindi.");
            trans.deleteKayitliHEsap(iban);
            hesaplariGoruntule();
            hesaplariGoruntuleTransferKayit();
            hesaplariGoruntuleTransfer();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        JChangePassword jchanged = new JChangePassword();
        jchanged.setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void kayitliHesaplarimaEkleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kayitliHesaplarimaEkleActionPerformed
        int selectedRow = account_table.getSelectedRow();
        if(selectedRow == -1){
            kayıtHesaplarımEkleText.setText("Tablodan hesap seçiniz...");
            return;
        }
        String iban = account_table.getValueAt(selectedRow, 0).toString();
        if(trans.kayitHesapVarMi(tc, iban)){
            kayıtHesaplarımEkleText.setText("Bu hesap zaten kayıtlı...");
            return;
        }

        trans.kayitHesapEkle(tc, iban, name);
        hesaplariGoruntuleTransferKayit();
        hesaplariGoruntuleTransfer();
        kayıtHesaplarımEkleText.setText("Başarıyla kaydedildi");
    }//GEN-LAST:event_kayitliHesaplarimaEkleActionPerformed

    private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane1StateChanged
        yatirimUyari.setText("");
        deleteText.setText("Silmek için hesap seçin...");
        hesapEkleText.setText("Hesap eklemek istiyorsanız seçiniz lütfen...");
        uyari.setText("");
        borc_miktari.setText("........");
        tc_no.setText("");
        paraTransIBAN.setText("");
        paraTransAmount.setText("");
        cevirimMiktari.setText("");
        paraTransName.setText("");
        transferConfirm.setText("");
        ibanText.setText("");
        typeText.setText("");
        amountType.setText("");
        transferKayitliTable.clearSelection();
        transferTable.clearSelection();
        yatirim_table.clearSelection();
        hesaplar_table1.clearSelection();
        account_table.clearSelection();
       
    }//GEN-LAST:event_jTabbedPane1StateChanged

    private void paraTransAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paraTransAmountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_paraTransAmountActionPerformed

    private void fatura_secimiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fatura_secimiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fatura_secimiActionPerformed

    private void formComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_formComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_formComponentAdded

    public boolean transferEmpty(){
        if(paraTransIBAN.getText().length() == 0 && paraTransAmount.getText().length() == 0)
            return true;
        return false;
    }
    public int indexAccount(String iban){
        int i = 0;
        for(Account aa : account){
            if(aa.getIban().equals(iban))
                return i;
            i++;
        }
        return -1;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JCustomerPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JCustomerPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JCustomerPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JCustomerPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JCustomerPanel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable account_table;
    private javax.swing.JLabel altınTl;
    private javax.swing.JLabel amountType;
    private javax.swing.JLabel background;
    private javax.swing.JLabel borc_miktari;
    private javax.swing.JButton borcu_ode;
    private javax.swing.JTextField cevirimMiktari;
    private javax.swing.JLabel deleteText;
    private javax.swing.JLabel dolarTl;
    private javax.swing.JButton dovizdenTlye_btn;
    private javax.swing.JLabel euroTl;
    private javax.swing.JComboBox<String> fatura_secimi;
    private javax.swing.JLabel hesapEkleText;
    private javax.swing.JButton hesaplar_btn;
    private javax.swing.JTable hesaplar_table;
    private javax.swing.JTable hesaplar_table1;
    private javax.swing.JLabel hosgeldiniz;
    private javax.swing.JLabel ibanText;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton kayitliHesaplarimaEkle;
    private javax.swing.JLabel kayıtHesaplarımEkleText;
    private java.awt.Label label1;
    private javax.swing.JLabel nameText;
    private javax.swing.JTextField paraTransAmount;
    private javax.swing.JTextField paraTransIBAN;
    private javax.swing.JLabel paraTransName;
    private javax.swing.JButton sorgula;
    private javax.swing.JTextField tc_no;
    private javax.swing.JButton tldendovize_btn;
    private javax.swing.JLabel transferConfirm;
    private javax.swing.JLabel transferHesaplar;
    private javax.swing.JTable transferKayitliTable;
    private javax.swing.JTable transferTable;
    private javax.swing.JComboBox<String> typeCombobox;
    private javax.swing.JLabel typeText;
    private javax.swing.JLabel uyari;
    private javax.swing.JLabel yatirimUyari;
    private javax.swing.JTable yatirim_table;
    // End of variables declaration//GEN-END:variables
}
