package menu;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;

import lists.ListUser;


public class User extends javax.swing.JInternalFrame{
    
    connection.koneksi con;
    
    private JPanel pnlUser;
    private ListUser listUser;
    public String id, kdUser, nmUser, stUser, pswUser;
    private ArrayList<String> dataArrayList;
    private int currentIndex;

    public String getKdUser() {
        return kdUser;
    }

    public String getNmUser() {
        return nmUser;
    }

    public String getStUser() {
        return stUser;
    }

    public String getPswUser() {
        return pswUser;
    }
    public String getID() {
        return id;
    }

   
    
    
    
    public User() {
        initComponents();
        this.setResizable(false);
        btnVoid.setEnabled(false);
        btnEdit.setEnabled(false);
        btnNext.setEnabled(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        listUser = new ListUser();
        dataArrayList = new ArrayList<>();
        currentIndex = -1;
        max_data();
        
//        lbl_id.setVisible(false);
//        lbl_id_max.setVisible(false);
//        lbl_id_min.setVisible(false);
        
        
//        this.visible = false;
//        
    }
    
//    public boolean getVisible(){
//        return visible;
//    }
// 
//    public void setStatusVisible(boolean visible) {
//        this.visible = visible;
//    }
    
    public void posisiTerakhir(){
        
    }
    private void add_user(){
        try {
            String sql = "INSERT INTO nama_user VALUES (null,'"+txtKodeUser.getText()+"','"+txtNamaUser.getText()+"','"+cbStatus.getSelectedItem()
                    +"','"+txtPassword.getText()+"')";
            java.sql.Connection conn = (Connection) con.connectionSQL();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.execute();
                JOptionPane.showMessageDialog(null, "User was added");
                kosong();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "User Code Already Exist");
                System.err.println( e.getClass().getName()+": "+ e.getMessage() );
              
            }
    }
    private void update_user(){
        try {
            String sql = "update nama_user set"
                    + "kodeuser='"+txtKodeUser.getText()+"',"
                    + "namauser='"+txtNamaUser.getText()+"',statususer='"+cbStatus.getSelectedItem()+"',"
                    + "passworduser'"+txtPassword.getText()+"')";
            java.sql.Connection conn = (Connection) con.connectionSQL();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.execute();
                JOptionPane.showMessageDialog(null, "Update Successfully");
            } catch (Exception e) {
                System.err.println( e.getClass().getName()+": "+ e.getMessage() );
              
            }
    }
    private void check_max(){
        try {
        String sql = "SELECT MAX(iduser) FROM nama_user";
        Connection conn = (Connection) con.connectionSQL();
        Statement stm = conn.createStatement();
        ResultSet res = stm.executeQuery(sql);
        while (res.next()) {
            String cek = res.getString(1);
            lbl_id_max.setText(cek);
            
            int id = Integer.parseInt(lbl_id.getText());
            int id_temp = Integer.parseInt(lbl_id_max.getText());
            int idmax = Integer.parseInt(lbl_id_max.getText());
            
            if(id==id_temp){
                btnNext.setEnabled(false);
            }
            check_min();
        }
        } catch (Exception e) {
            
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
        }
    }
    private void check_min(){
        try {
        String sql = "SELECT MIN(iduser) FROM nama_user as id";
        Connection conn = (Connection) con.connectionSQL();
        Statement stm = conn.createStatement();
        ResultSet res = stm.executeQuery(sql);
        while (res.next()) {
            String cek = res.getString(1);
            lbl_id_min.setText(cek);
            
            int id = Integer.parseInt(lbl_id.getText());
            int id_temp = Integer.parseInt(lbl_id_min.getText());
            
            if(id==id_temp){
                    btnPrevious.setEnabled(false);
                    btnNext.setEnabled(true);
            }
            
            
            
        }
        } catch (Exception e) {
            
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
        }
    }
    private void next(){
        try {
            String sql = "select * from nama_user where iduser > '"+lbl_id.getText()+"' order by iduser asc limit 1";
            Connection conn = (Connection) con.connectionSQL();
            Statement stm = conn.createStatement();
            ResultSet res = stm.executeQuery(sql);
            while (res.next()) {
                String id = res.getString(1);
                String kode = res.getString(2);
                String nama = res.getString(3);
                String status = res.getString(4);
                String password = res.getString(5);
                
                lbl_id.setText(id);
                txtKodeUser.setText(kode);
                txtNamaUser.setText(nama);
                cbStatus.setSelectedItem(status);
                txtPassword.setText(password);
                
                btnPrevious.setEnabled(true);
                check_max();
                btnEdit.setEnabled(true);
                btnVoid.setEnabled(true);
                txtKodeUser.setEditable(false);
                txtNamaUser.setEditable(false);
                cbStatus.setEditable(false);
                txtPassword.setEditable(false);
            }
        } catch (Exception e) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
        }
    }
    private void previous(){
        try {
            String sql = "select * from nama_user where iduser < '"+lbl_id.getText()+"' order by iduser desc limit 1";
            Connection conn = (Connection) con.connectionSQL();
            Statement stm = conn.createStatement();
            ResultSet res = stm.executeQuery(sql);
            while (res.next()) {
                String id = res.getString(1);
                String kode = res.getString(2);
                String nama = res.getString(3);
                String status = res.getString(4);
                String password = res.getString(5);
                
                lbl_id.setText(id);
                txtKodeUser.setText(kode);
                txtNamaUser.setText(nama);
                cbStatus.setSelectedItem(status);
                txtPassword.setText(password);
                
                check_min();
                btnNext.setEnabled(true);
                btnEdit.setEnabled(true);
                btnVoid.setEnabled(true);
                txtKodeUser.setEditable(false);
                txtNamaUser.setEditable(false);
                cbStatus.setEnabled(false);
                txtPassword.setEditable(false);
            }
        } catch (Exception e) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
        }
    }
    private void max_data(){
        try {
            String sql = "select max(iduser) from nama_user";
            Connection conn = (Connection) con.connectionSQL();
            Statement stm = conn.createStatement();
            ResultSet res = stm.executeQuery(sql);
            while (res.next()) {
                String max = res.getString(1);
                
                int idmax = Integer.parseInt(max)+1;
                lbl_id.setText(Integer.toString(idmax));
            }
        } catch (Exception e) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlUserData = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtKodeUser = new javax.swing.JTextField();
        txtNamaUser = new javax.swing.JTextField();
        txtPassword = new javax.swing.JTextField();
        cbStatus = new javax.swing.JComboBox<>();
        btnCancelUser = new javax.swing.JButton();
        lbl_id = new javax.swing.JLabel();
        lbl_id_max = new javax.swing.JLabel();
        lbl_id_min = new javax.swing.JLabel();
        btnSaveUser = new javax.swing.JButton();
        jToolBar2 = new javax.swing.JToolBar();
        btnNew = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnVoid = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btnPrevious = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnRefresh1 = new javax.swing.JButton();
        btnList = new javax.swing.JButton();
        btnPrint = new javax.swing.JButton();

        setBackground(new java.awt.Color(51, 51, 255));
        setClosable(true);
        setIconifiable(true);
        setTitle("Data Pengguna");

        pnlUserData.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setText("Kode User");

        jLabel10.setText("Nama User");

        jLabel11.setText("Status");

        jLabel12.setText("Password");

        txtKodeUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtKodeUserMouseClicked(evt);
            }
        });

        cbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "STAFF", "KEPALA", " " }));

        btnCancelUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/cancel.png"))); // NOI18N
        btnCancelUser.setText("Cancel");
        btnCancelUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelUserActionPerformed(evt);
            }
        });

        lbl_id.setText("ID");

        lbl_id_max.setText("0");

        lbl_id_min.setText("ID");

        btnSaveUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/save.png"))); // NOI18N
        btnSaveUser.setText("Save");
        btnSaveUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveUserActionPerformed(evt);
            }
        });

        jToolBar2.setRollover(true);

        btnNew.setBackground(new java.awt.Color(242, 242, 242));
        btnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/new.png"))); // NOI18N
        btnNew.setPreferredSize(new java.awt.Dimension(25, 25));
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });
        jToolBar2.add(btnNew);

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/edit.png"))); // NOI18N
        btnEdit.setPreferredSize(new java.awt.Dimension(25, 25));
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        jToolBar2.add(btnEdit);

        btnVoid.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/void.png"))); // NOI18N
        btnVoid.setPreferredSize(new java.awt.Dimension(25, 25));
        btnVoid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoidActionPerformed(evt);
            }
        });
        jToolBar2.add(btnVoid);
        jToolBar2.add(jSeparator2);

        btnPrevious.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/left.png"))); // NOI18N
        btnPrevious.setPreferredSize(new java.awt.Dimension(25, 25));
        btnPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviousActionPerformed(evt);
            }
        });
        jToolBar2.add(btnPrevious);

        btnNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/right.png"))); // NOI18N
        btnNext.setPreferredSize(new java.awt.Dimension(25, 25));
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });
        jToolBar2.add(btnNext);

        btnRefresh1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/refresh.png"))); // NOI18N
        btnRefresh1.setFocusable(false);
        btnRefresh1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRefresh1.setMaximumSize(new java.awt.Dimension(35, 35));
        btnRefresh1.setMinimumSize(new java.awt.Dimension(35, 35));
        btnRefresh1.setPreferredSize(new java.awt.Dimension(35, 35));
        btnRefresh1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(btnRefresh1);

        btnList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/list.png"))); // NOI18N
        btnList.setPreferredSize(new java.awt.Dimension(25, 25));
        btnList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListActionPerformed(evt);
            }
        });
        jToolBar2.add(btnList);

        btnPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/printer.png"))); // NOI18N
        btnPrint.setPreferredSize(new java.awt.Dimension(25, 25));
        jToolBar2.add(btnPrint);

        javax.swing.GroupLayout pnlUserDataLayout = new javax.swing.GroupLayout(pnlUserData);
        pnlUserData.setLayout(pnlUserDataLayout);
        pnlUserDataLayout.setHorizontalGroup(
            pnlUserDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUserDataLayout.createSequentialGroup()
                .addGroup(pnlUserDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlUserDataLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(pnlUserDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlUserDataLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addGroup(pnlUserDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNamaUser, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlUserDataLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(lbl_id)
                        .addGap(27, 27, 27)
                        .addComponent(lbl_id_max)
                        .addGap(36, 36, 36)
                        .addComponent(lbl_id_min)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSaveUser, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelUser))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlUserDataLayout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jLabel2)
                        .addGap(23, 23, 23)
                        .addComponent(txtKodeUser, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(51, Short.MAX_VALUE))
            .addComponent(jToolBar2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlUserDataLayout.setVerticalGroup(
            pnlUserDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUserDataLayout.createSequentialGroup()
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(pnlUserDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtKodeUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(pnlUserDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNamaUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(pnlUserDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(cbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(pnlUserDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(pnlUserDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlUserDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCancelUser)
                        .addComponent(btnSaveUser))
                    .addGroup(pnlUserDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl_id)
                        .addComponent(lbl_id_max)
                        .addComponent(lbl_id_min)))
                .addContainerGap(63, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlUserData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlUserData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
      String kodeUser = txtKodeUser.getText().toUpperCase();
      String namaUser = txtNamaUser.getText().toUpperCase();
//      String statusUser = cbStatus.getSelectedItem().toString();
      String passwordUser = txtPassword.getText().toUpperCase();
             
      if(kodeUser.isBlank() & namaUser.isBlank() & passwordUser.isBlank()){
          txtKodeUser.requestFocus();
      }else{
          int hasil = JOptionPane.showConfirmDialog(null, "Apakah data ingin di simpan ?", "Confirm", JOptionPane.YES_NO_OPTION);
            if(hasil==JOptionPane.YES_OPTION){
//            btnSaveUser1.doClick();
            kosong();
            txtKodeUser.requestFocus();
            btnEdit.setEnabled(false);
            btnVoid.setEnabled(false);
            repaint();
            revalidate();
          }else{
            kosong();
            }
        
      }
      
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnCancelUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelUserActionPerformed
      String kodeUser = txtKodeUser.getText().toUpperCase();
      String namaUser = txtNamaUser.getText().toUpperCase();
//      String statusUser = cbStatus.getSelectedItem().toString();
      String passwordUser = txtPassword.getText().toUpperCase();
        
        if(kodeUser.isBlank()& namaUser.isBlank()& passwordUser.isBlank()){
            
            dispose();
            
        }else{
            
            int hasil = JOptionPane.showConfirmDialog(null, "Apakah data ingin di simpan ?", "Confirm", JOptionPane.YES_NO_OPTION);
            if(hasil==JOptionPane.YES_OPTION){
//                btnSaveUser1.doClick();
            }
//                lastX = getX();
//                lastY = getY();
                dispose();
                
        }
        
    }//GEN-LAST:event_btnCancelUserActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed

        next();
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        String kodeUser = txtKodeUser.getText().toUpperCase();
        String namaUser = txtNamaUser.getText().toUpperCase();
        String statusUser = cbStatus.getSelectedItem().toString();
        String passwordUser = txtPassword.getText().toUpperCase();
        
        if(kodeUser.isBlank()& namaUser.isBlank()& passwordUser.isBlank()){
            
            JOptionPane.showMessageDialog(null, "Tidak ada data di kolom !!!");
            
        }else{
            
            int hasil = JOptionPane.showConfirmDialog(null, "Apakah anda ingin melanjutkan mengedit ?", "Confirm", JOptionPane.YES_NO_OPTION);
            if(hasil==JOptionPane.YES_OPTION){
                btnVoid.setEnabled(false);
                btnEdit.setEnabled(false);
                repaint();
                revalidate();
            }else{
                kosong();
                btnVoid.setEnabled(false);
                btnEdit.setEnabled(false);
                repaint();
                revalidate();
            }
                
        }
                
                cbStatus.setEnabled(true);
                
                txtKodeUser.setEditable(true);
                txtNamaUser.setEditable(true);
                cbStatus.setEditable(true);
                txtPassword.setEditable(true);
                
            
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousActionPerformed
       
//    int idmax = Integer.parseInt(lbl_id_max.getText()); 
//    if(idmax==0){
//        btnNext.setEnabled(false);
//        previous(); 
//    }else{
        previous(); 
//    }
    }//GEN-LAST:event_btnPreviousActionPerformed
   
    
    private void btnVoidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoidActionPerformed
        int hasil = JOptionPane.showConfirmDialog(null, "Apakah anda ingin menghapus data ?", "Confirm", JOptionPane.YES_NO_OPTION);
            if(hasil==JOptionPane.YES_OPTION){
                btnVoid.setEnabled(false);
                btnEdit.setEnabled(false);
            try {
                hapus();
            } catch (IOException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
                kosong();
                repaint();
                revalidate();
            }
    }//GEN-LAST:event_btnVoidActionPerformed

    private void txtKodeUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtKodeUserMouseClicked
//         private Object obj=btnEdit.setEnabled(false);
        if (evt.getClickCount() == 2 && !evt.isConsumed()) {
             if(btnEdit.isEnabled()){
                 
             }else{
                 if(listUser.isVisible()){//logika untuk memunculkan jinternalframe hanya sekali
                    listUser.toFront();//memindahkan JInternalFrame ke depan sehingga menjadi aktif dan fokus.
        
                }else{
//    setLocation(lastX, lastY);
                listUser.user = this;
                getDesktopPane().add(listUser).setVisible(true);
                listUser.setResizable(false);
                listUser.toFront(); 
                }
             }
         }
    }//GEN-LAST:event_txtKodeUserMouseClicked

    private void btnListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListActionPerformed
        

        if(listUser.isVisible()){//logika untuk memunculkan jinternalframe hanya sekali
        listUser.toFront();//memindahkan JInternalFrame ke depan sehingga menjadi aktif dan fokus.
        
    }else{
//    setLocation(lastX, lastY);
        listUser.user = this;
        getDesktopPane().add(listUser).setVisible(true);
        listUser.setResizable(false);
        listUser.toFront(); 
        }
    }//GEN-LAST:event_btnListActionPerformed

    private void btnSaveUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveUserActionPerformed
    
    try {
        String sql = "select count(*) from nama_user where kodeuser='"+txtKodeUser.getText()+"'";
        Connection conn = (Connection) con.connectionSQL();
        Statement stm = conn.createStatement();
        ResultSet res = stm.executeQuery(sql);
        while (res.next()) {
           String cek = res.getString(1);
                if(cek.equals(1)){
                    update_user();
                }else{
                    add_user();
                }
           
           }
        } catch (Exception e) {
            
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
    }
    }//GEN-LAST:event_btnSaveUserActionPerformed

    public void itemTerpilih(){
        listUser = new ListUser();
        listUser.user = this;
        lbl_id.setText(id);
        txtKodeUser.setText(kdUser);
        txtNamaUser.setText(nmUser);
        cbStatus.setSelectedItem(stUser);
        txtPassword.setText(pswUser);
        btnEdit.setEnabled(true);
        btnVoid.setEnabled(true);
        
    }

    
    public void Simpan() throws IOException{
        try {
             Connection conn = (Connection) con.connectionSQL();
             conn.setAutoCommit(false);
             
             String kodeUser = txtKodeUser.getText().toUpperCase();
             String namaUser = txtNamaUser.getText().toUpperCase();
             String statusUser = cbStatus.getSelectedItem().toString();
             String passwordUser = txtPassword.getText().toUpperCase();
             
              if(kodeUser.isBlank()|| namaUser.isBlank() || statusUser.isBlank() || passwordUser.isBlank()){
                  
                String sql = "INSERT INTO nama_user (kodeuser, namauser, statususer, passworduser) VALUES (?, ?, ?, ?)";
             
                PreparedStatement preparedstatement = conn.prepareStatement(sql);
                preparedstatement.setString(1, kodeUser);
                preparedstatement.setString(2, namaUser);
                preparedstatement.setString(3, statusUser);
                preparedstatement.setString(4, passwordUser);
             
                preparedstatement.executeUpdate();
                preparedstatement.close();
                conn.rollback();
                JOptionPane.showMessageDialog(null, "Ada kolom yang belum di isi");
                
               }else if(kodeUser.isBlank()& namaUser.isBlank() & statusUser.isBlank() & passwordUser.isBlank()){
                   
                JOptionPane.showMessageDialog(null, "Ada kolom yang belum di isi !!!");
                   
               }else{
                  
                String sql = "INSERT INTO nama_user (kodeuser, namauser, statususer, passworduser) VALUES (?, ?, ?, ?)";

                PreparedStatement saveStatement = conn.prepareStatement(sql);
                saveStatement.setString(1, kodeUser);
                saveStatement.setString(2, namaUser);
                saveStatement.setString(3, statusUser);
                saveStatement.setString(4, passwordUser);

                saveStatement.executeUpdate();
                saveStatement.close();
                conn.commit();
                kosong();
                }
              
//             conn.close();
            
        }catch(SQLException e){
            
            JOptionPane.showMessageDialog(null, "Error saat menyimpan !!!");
            
        }
    }
    
    public void edit() throws IOException{
        try {
             Connection conn = (Connection) con.connectionSQL();
             conn.setAutoCommit(false);
             
             String kodeUser = txtKodeUser.getText().toUpperCase();
             String namaUser = txtNamaUser.getText().toUpperCase();
             String statusUser = cbStatus.getSelectedItem().toString();
             String passwordUser = txtPassword.getText().toUpperCase();
             
              if(kodeUser.isBlank()|| namaUser.isBlank() || statusUser.isBlank() || passwordUser.isBlank()){
                  
                    String sql = "UPDATE nama_user SET kodeuser = ?, namauser = ?, statususer = ?, passworduser = ? WHERE kodeuser = ?";
             
                    PreparedStatement editStatement = conn.prepareStatement(sql);
                    editStatement.setString(1, kodeUser);
                    editStatement.setString(2, namaUser);
                    editStatement.setString(3, statusUser);
                    editStatement.setString(4, passwordUser);
                    editStatement.setString(5, kodeUser); 
             
                    editStatement.executeUpdate();
                    editStatement.close();
                    conn.rollback();
                    JOptionPane.showMessageDialog(null, "Ada kolom yang belum di isi");
                
               }else if(kodeUser.isBlank()& namaUser.isBlank() & statusUser.isBlank() & passwordUser.isBlank()){
                   JOptionPane.showMessageDialog(null, "Ada kolom yang belum di isi");
               }
              else{

                    String sql = "UPDATE nama_user SET kodeuser = ?, namauser = ?, statususer = ?, passworduser = ? WHERE kodeuser = ?";
             
                    PreparedStatement updatestatement = conn.prepareStatement(sql);
                    updatestatement.setString(1, kodeUser);       
                    updatestatement.setString(2, namaUser);
                    updatestatement.setString(3, statusUser);
                    updatestatement.setString(4, passwordUser);
                    updatestatement.setString(5, kodeUser); 
             
                    updatestatement.executeUpdate();
                    updatestatement.close();
                    conn.commit();
                    kosong();
            }
              
//             conn.close();
             
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error saat mengedit !!!" + e);
        }
    }

    
    public void hapus() throws IOException{
        try {
             Connection conn = (Connection) con.connectionSQL();
             conn.setAutoCommit(false);
             
             String kodeUser = txtKodeUser.getText().toUpperCase();
             
             String sql = "DELETE FROM nama_user WHERE kodeuser = ?";
             
             PreparedStatement deleteStatement = conn.prepareStatement(sql);
             deleteStatement.setString(1, kodeUser);
             
             deleteStatement.executeUpdate();
             deleteStatement.close();
             conn.commit();
             conn.close();
             
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error saat menghapus !!!" + e);
        }
    }
    
    public void kosong(){
        txtKodeUser.setText("");
        txtNamaUser.setText("");
        cbStatus.setSelectedItem("STAFF");
        txtPassword.setText("");
        txtKodeUser.requestFocus();
}
   


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelUser;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnList;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrevious;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnRefresh1;
    private javax.swing.JButton btnSaveUser;
    private javax.swing.JButton btnVoid;
    private javax.swing.JComboBox<String> cbStatus;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JLabel lbl_id;
    private javax.swing.JLabel lbl_id_max;
    private javax.swing.JLabel lbl_id_min;
    private javax.swing.JPanel pnlUserData;
    private javax.swing.JTextField txtKodeUser;
    private javax.swing.JTextField txtNamaUser;
    private javax.swing.JTextField txtPassword;
    // End of variables declaration//GEN-END:variables
}
