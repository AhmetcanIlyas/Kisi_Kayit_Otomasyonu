

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class VTPencere extends javax.swing.JFrame {

    private Connection conn = null; 
    private String url = "jdbc:mysql://localhost:3306/";
    private String dbName = "vt"; 
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String userName = "root"; 
    private String password = ""; 
    private ResultSet res; 


    public VTPencere() {
        
        initComponents(); 
        setLocationRelativeTo(null);
        Statement st; 
        try {
            st = baglantiAc(); 
            res = st.executeQuery("SELECT * FROM  kisiler"); 
        } catch (Exception ex) {
            
            JOptionPane.showConfirmDialog(null, "Bağlantı Başarısız", "MySQL Bağlantısı", JOptionPane.PLAIN_MESSAGE);
        }

        KayitGetir("ileri"); 
    }
    
    public Statement baglantiAc() throws Exception {
        Class.forName(driver).newInstance();
        conn = DriverManager.getConnection(url + dbName, userName, password);          
        return conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        
    }

    public void baglantiKapat() throws Exception {
        conn.close();
    }

    public void KayitGetir(String yon) {
        try {

            if (yon.equals("ileri")) {
                res.next();
            } else if (yon.equals("geri")) {
                res.previous();
            } else if (yon.equals("ilk")) {
                res.first();
            } else if (yon.equals("son")) {
                res.last();
            } else if (yon.equals("mutlak")) {
                res.absolute(Integer.parseInt(noTextField.getText()));

            }

            adTextField.setText(res.getString("Ad"));
            soyadTextField.setText(res.getString("Soyad"));
            yasTextField.setText(res.getString("Yas"));
            if (res.getInt("Cinsiyet") == 1) {
                cinsiyetComboBox.setSelectedIndex(0);
            } else {
                cinsiyetComboBox.setSelectedIndex(1);
            }
            if (res.getInt("Yas") > 18) {
                durumLabel.setText("Kişi 18 yaşından büyük");
            } else {
                durumLabel.setText("Kişi 18 yaşından küçük");
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Kayıt Mevcut Değil", "Kişiler Tablosu", JOptionPane.PLAIN_MESSAGE);
        }

    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        adTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        soyadTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        yasTextField = new javax.swing.JTextField();
        ilkButton = new javax.swing.JButton();
        oncekiButton = new javax.swing.JButton();
        sonrakiButton = new javax.swing.JButton();
        sonButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        cinsiyetComboBox = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        guncelleButon = new javax.swing.JButton();
        yeniButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        ekleButton = new javax.swing.JButton();
        silButton = new javax.swing.JButton();
        gitButon = new javax.swing.JButton();
        durumLabel = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        noTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Kişi Kayıt Listesi");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Kayıtlar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(0, 102, 204))); // NOI18N

        jLabel1.setText("Ad:");

        jLabel2.setText("Soyad:");

        jLabel3.setText("Yas:");

        ilkButton.setText("İlk");
        ilkButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ilkButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ilkButtonActionPerformed(evt);
            }
        });

        oncekiButton.setText("Önceki");
        oncekiButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        oncekiButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oncekiButtonActionPerformed(evt);
            }
        });

        sonrakiButton.setText("Sonraki");
        sonrakiButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sonrakiButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sonrakiButtonActionPerformed(evt);
            }
        });

        sonButton.setText("Son");
        sonButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sonButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sonButtonActionPerformed(evt);
            }
        });

        jLabel4.setText("Cinsiyet:");

        cinsiyetComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Erkek", "Kadın" }));
        cinsiyetComboBox.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(yasTextField)
                        .addComponent(soyadTextField)
                        .addComponent(adTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE))
                    .addComponent(cinsiyetComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(sonButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sonrakiButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(oncekiButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ilkButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(adTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ilkButton)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(soyadTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(oncekiButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(yasTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sonrakiButton)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sonButton)
                    .addComponent(jLabel4)
                    .addComponent(cinsiyetComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "İşlemler", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(0, 51, 153))); // NOI18N

        guncelleButon.setBackground(new java.awt.Color(51, 102, 255));
        guncelleButon.setForeground(new java.awt.Color(0, 0, 0));
        guncelleButon.setText("Güncelle");
        guncelleButon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        guncelleButon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guncelleButonActionPerformed(evt);
            }
        });

        yeniButton.setBackground(new java.awt.Color(0, 204, 204));
        yeniButton.setForeground(new java.awt.Color(0, 0, 0));
        yeniButton.setText("Yeni");
        yeniButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        yeniButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yeniButtonActionPerformed(evt);
            }
        });

        jLabel6.setText("Kayıt No:");

        ekleButton.setBackground(new java.awt.Color(0, 204, 0));
        ekleButton.setForeground(new java.awt.Color(0, 0, 0));
        ekleButton.setText("Ekle");
        ekleButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ekleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ekleButtonActionPerformed(evt);
            }
        });

        silButton.setBackground(new java.awt.Color(255, 0, 0));
        silButton.setForeground(new java.awt.Color(0, 0, 0));
        silButton.setText("Sil");
        silButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        silButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                silButtonActionPerformed(evt);
            }
        });

        gitButon.setText("Git");
        gitButon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        gitButon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gitButonActionPerformed(evt);
            }
        });

        durumLabel.setText("Kişinin yaş durumu");

        jLabel5.setText("Durum:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(durumLabel))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(yeniButton, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(guncelleButon, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(noTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(ekleButton)
                                .addGap(10, 10, 10)
                                .addComponent(silButton, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(gitButon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {ekleButton, guncelleButon, silButton, yeniButton});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(noTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gitButon))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(durumLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(yeniButton)
                    .addComponent(ekleButton)
                    .addComponent(silButton)
                    .addComponent(guncelleButon))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sonrakiButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sonrakiButtonActionPerformed
        KayitGetir("ileri"); 
    }//GEN-LAST:event_sonrakiButtonActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        try {
            baglantiKapat(); 
        } catch (Exception ex) {
            Logger.getLogger(VTPencere.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowClosed

    private void oncekiButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oncekiButtonActionPerformed
        KayitGetir("geri");        
    }//GEN-LAST:event_oncekiButtonActionPerformed

    private void ilkButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ilkButtonActionPerformed
        KayitGetir("ilk");
    }//GEN-LAST:event_ilkButtonActionPerformed

    private void sonButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sonButtonActionPerformed
        KayitGetir("son");
    }//GEN-LAST:event_sonButtonActionPerformed

    private void ekleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ekleButtonActionPerformed
        try {
            res.moveToInsertRow(); 
            res.updateString("Ad", adTextField.getText()); 
            res.updateString("Soyad", soyadTextField.getText()); 
            res.updateInt("yas", Integer.parseInt(yasTextField.getText()));
            boolean cns;
            if (cinsiyetComboBox.getSelectedIndex() == 0) {
                cns = true;
            } else {
                cns = false;
            }
            res.updateBoolean("cinsiyet", cns); 
            res.insertRow(); 
            JOptionPane.showConfirmDialog(null, "Kayıt Eklendi", "Kişiler Tablosu", JOptionPane.PLAIN_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null, "Kayıt Eklenemedi", "Kişiler Tablosu", JOptionPane.PLAIN_MESSAGE);
        }
    }//GEN-LAST:event_ekleButtonActionPerformed

    private void yeniButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yeniButtonActionPerformed
        adTextField.setText("");
        soyadTextField.setText("");
        yasTextField.setText("");
        cinsiyetComboBox.setSelectedIndex(0);   
        JOptionPane.showConfirmDialog(null, "Kişi Bilgilerini Giriniz", "Kişiler Tablosu", JOptionPane.PLAIN_MESSAGE);
    }//GEN-LAST:event_yeniButtonActionPerformed

    private void guncelleButonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guncelleButonActionPerformed
        try {
            res.updateString("Ad", adTextField.getText());
            res.updateString("Soyad", soyadTextField.getText());
            res.updateInt("yas", Integer.parseInt(yasTextField.getText()));
            boolean cns;
            if (cinsiyetComboBox.getSelectedIndex() == 0) {
                cns = true;
            } else {
                cns = false;
            }
            res.updateBoolean("cinsiyet", cns);
            res.updateRow();
            JOptionPane.showConfirmDialog(null, "Kayıt Güncellendi", "Kişiler Tablosu", JOptionPane.PLAIN_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null, "Kayıt Eklenemedi", "Kişiler Tablosu", JOptionPane.PLAIN_MESSAGE);
        }
    }//GEN-LAST:event_guncelleButonActionPerformed

    private void silButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_silButtonActionPerformed
        try {
            int onay = JOptionPane.showConfirmDialog(null, "Emin misiniz?", "Kişiler Tablosu", JOptionPane.YES_NO_OPTION);

            if (onay == 0) {    
                res.deleteRow();
                JOptionPane.showConfirmDialog(null, "Kayıt Silindi", "Kişiler Tablosu", JOptionPane.PLAIN_MESSAGE);
                KayitGetir("ilk");
            } else {            

            }
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null, "Kayıt Silinemedi", "Kişiler Tablosu", JOptionPane.PLAIN_MESSAGE);
        }
    }//GEN-LAST:event_silButtonActionPerformed

    private void gitButonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gitButonActionPerformed
        KayitGetir("mutlak");
    }//GEN-LAST:event_gitButonActionPerformed
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new VTPencere().setVisible(false);
                girisekran gekran=new girisekran();
                gekran.setVisible(true);
                gekran.setLocationRelativeTo(null);
        
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField adTextField;
    private javax.swing.JComboBox cinsiyetComboBox;
    private javax.swing.JLabel durumLabel;
    private javax.swing.JButton ekleButton;
    private javax.swing.JButton gitButon;
    private javax.swing.JButton guncelleButon;
    private javax.swing.JButton ilkButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField noTextField;
    private javax.swing.JButton oncekiButton;
    private javax.swing.JButton silButton;
    private javax.swing.JButton sonButton;
    private javax.swing.JButton sonrakiButton;
    private javax.swing.JTextField soyadTextField;
    private javax.swing.JTextField yasTextField;
    private javax.swing.JButton yeniButton;
    // End of variables declaration//GEN-END:variables
}
