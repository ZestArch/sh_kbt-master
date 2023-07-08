/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package menu;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import lists.ListSupplier;

public class Supplier extends javax.swing.JInternalFrame {
    ListSupplier listSupplier;
    public String id, kdSupplier, nmSupplier, tlpSupplier, hpSupplier, emSupplier, npSupplier;
    private ArrayList<String> dataArrayList;
    private int currentIndex;
    connection.koneksi con;

    public String getKdSupplier() {
        return kdSupplier;
    }

    public String getNmSupplier() {
        return nmSupplier;
    }

    public String getTlpSupplier() {
        return tlpSupplier;
    }

    public String getHpSupplier() {
        return hpSupplier;
    }

    public String getEmSupplier() {
        return emSupplier;
    }

    public String getNpSupplier() {
        return npSupplier;
    }

    
    public Supplier() {
        initComponents();
        this.setResizable(false);
        btnVoid.setEnabled(false);
        btnEdit.setEnabled(false);
        btnNext.setEnabled(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        listSupplier = new ListSupplier();
        dataArrayList = new ArrayList<>();
        currentIndex = -1;
        max_data();
        
        lbl_id.setVisible(false);
        lbl_id_max.setVisible(false);
        lbl_id_min.setVisible(false);
    }
        
    private void add_user(){
        try {
            String sql = "INSERT INTO supplier VALUES (null,'"+txtKodeSupplier.getText()+"','"+txtNamaSupplier.getText()+"','"+txtTlpSupplier.getText()+"','"+txtHpSupplier.getText()+txtEmailSupplier.getText()+"','"+txtNpwpSupplier.getText()+"')";
            java.sql.Connection conn = (Connection) con.connectionSQL();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.execute();
                JOptionPane.showMessageDialog(null, "Supplier was added");
                kosong();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "User Code Already Exist");
                System.err.println( e.getClass().getName()+": "+ e.getMessage() );
              
            }
    }
    private void check_max(){
        try {
        String sql = "SELECT MAX(id_supplier) FROM supplier";
        Connection conn = (Connection) con.connectionSQL();
        Statement stm = conn.createStatement();
        ResultSet res = stm.executeQuery(sql);
        while (res.next()) {
            String cek = res.getString(1);
            lbl_id_max.setText(cek);
            
            int id = Integer.parseInt(lbl_id.getText());
            int id_temp = Integer.parseInt(lbl_id_max.getText());
            
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
        String sql = "SELECT MIN(id_supplier) FROM supplier as id";
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
            String sql = "select * from supplier where id_supplier > '"+lbl_id.getText()+"' order by id_supplier asc limit 1";
            Connection conn = (Connection) con.connectionSQL();
            Statement stm = conn.createStatement();
            ResultSet res = stm.executeQuery(sql);
            while (res.next()) {
                String id = res.getString(1);
                String kode = res.getString(2);
                String nama = res.getString(3);
                String tlpsupplier = res.getString(4);
                String hpsupplier = res.getString(5);
                String emailsupplier = res.getString(6);
                String npwpsupplier = res.getString(7);
                
                lbl_id.setText(id);
                txtKodeSupplier.setText(kode);
                txtNamaSupplier.setText(nama);
                txtTlpSupplier.setText(tlpsupplier);
                txtHpSupplier.setText(hpsupplier);
                txtEmailSupplier.setText(emailsupplier);
                txtNpwpSupplier.setText(npwpsupplier);
                
                btnPrevious.setEnabled(true);
                check_max();
                btnEdit.setEnabled(true);
                btnVoid.setEnabled(true);
                txtKodeSupplier.setEditable(false);
                txtNamaSupplier.setEditable(false);
                txtTlpSupplier.setEditable(false);
                txtHpSupplier.setEditable(false);
                txtEmailSupplier.setEditable(false);
                txtNpwpSupplier.setEditable(false);
            }
        } catch (Exception e) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
        }
    }
    private void previous(){
        try {
            String sql = "select * from supplier where id_supplier < '"+lbl_id.getText()+"' order by id_supplier desc limit 1";
            Connection conn = (Connection) con.connectionSQL();
            Statement stm = conn.createStatement();
            ResultSet res = stm.executeQuery(sql);
            while (res.next()) {
                String id = res.getString(1);
                String kode = res.getString(2);
                String nama = res.getString(3);
                String tlpsupplier = res.getString(4);
                String hpsupplier = res.getString(5);
                String emailsupplier = res.getString(6);
                String npwpsupplier = res.getString(7);
                
                lbl_id.setText(id);
                txtKodeSupplier.setText(kode);
                txtNamaSupplier.setText(nama);
                txtTlpSupplier.setText(tlpsupplier);
                txtHpSupplier.setText(hpsupplier);
                txtEmailSupplier.setText(emailsupplier);
                txtNpwpSupplier.setText(npwpsupplier);
                
                check_min();
                btnNext.setEnabled(true);
                btnEdit.setEnabled(true);
                btnVoid.setEnabled(true);
                txtKodeSupplier.setEditable(false);
                txtNamaSupplier.setEditable(false);
                txtTlpSupplier.setEditable(false);
                txtHpSupplier.setEditable(false);
                txtEmailSupplier.setEditable(false);
                txtNpwpSupplier.setEditable(false);
            }
        } catch (Exception e) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
        }
    }
    private void max_data(){
        try {
            String sql = "select max(id_supplier) from supplier";
            Connection conn = (Connection) con.connectionSQL();
            Statement stm = conn.createStatement();
            ResultSet res = stm.executeQuery(sql);
            while (res.next()) {
                String max = res.getString(1);
                
                lbl_id.setText(max);
            }
        } catch (Exception e) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        btnNew = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnVoid = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnPrevious = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        btnList = new javax.swing.JButton();
        btnPrint = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNamaSupplier = new javax.swing.JTextField();
        txtKodeSupplier = new javax.swing.JTextField();
        txtTlpSupplier = new javax.swing.JTextField();
        txtHpSupplier = new javax.swing.JTextField();
        txtEmailSupplier = new javax.swing.JTextField();
        txtNpwpSupplier = new javax.swing.JTextField();
        btnSaveSupplier = new javax.swing.JButton();
        btnCancelSupplier = new javax.swing.JButton();
        lbl_id_max = new javax.swing.JLabel();
        lbl_id = new javax.swing.JLabel();
        lbl_id_min = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Data Supplier");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jToolBar1.setRollover(true);

        btnNew.setBackground(new java.awt.Color(242, 242, 242));
        btnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/new.png"))); // NOI18N
        btnNew.setFocusable(false);
        btnNew.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNew.setMaximumSize(new java.awt.Dimension(35, 35));
        btnNew.setMinimumSize(new java.awt.Dimension(35, 35));
        btnNew.setPreferredSize(new java.awt.Dimension(35, 35));
        btnNew.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });
        jToolBar1.add(btnNew);

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/edit.png"))); // NOI18N
        btnEdit.setFocusable(false);
        btnEdit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEdit.setMaximumSize(new java.awt.Dimension(35, 35));
        btnEdit.setMinimumSize(new java.awt.Dimension(35, 35));
        btnEdit.setPreferredSize(new java.awt.Dimension(35, 35));
        btnEdit.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        jToolBar1.add(btnEdit);

        btnVoid.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/void.png"))); // NOI18N
        btnVoid.setFocusable(false);
        btnVoid.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnVoid.setMaximumSize(new java.awt.Dimension(35, 35));
        btnVoid.setMinimumSize(new java.awt.Dimension(35, 35));
        btnVoid.setPreferredSize(new java.awt.Dimension(35, 35));
        btnVoid.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnVoid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoidActionPerformed(evt);
            }
        });
        jToolBar1.add(btnVoid);
        jToolBar1.add(jSeparator1);

        btnPrevious.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/left.png"))); // NOI18N
        btnPrevious.setFocusable(false);
        btnPrevious.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPrevious.setMaximumSize(new java.awt.Dimension(35, 35));
        btnPrevious.setMinimumSize(new java.awt.Dimension(35, 35));
        btnPrevious.setPreferredSize(new java.awt.Dimension(35, 35));
        btnPrevious.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviousActionPerformed(evt);
            }
        });
        jToolBar1.add(btnPrevious);

        btnNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/right.png"))); // NOI18N
        btnNext.setFocusable(false);
        btnNext.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNext.setMaximumSize(new java.awt.Dimension(35, 35));
        btnNext.setMinimumSize(new java.awt.Dimension(35, 35));
        btnNext.setPreferredSize(new java.awt.Dimension(35, 35));
        btnNext.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });
        jToolBar1.add(btnNext);

        btnRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/refresh.png"))); // NOI18N
        btnRefresh.setFocusable(false);
        btnRefresh.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRefresh.setMaximumSize(new java.awt.Dimension(35, 35));
        btnRefresh.setMinimumSize(new java.awt.Dimension(35, 35));
        btnRefresh.setPreferredSize(new java.awt.Dimension(35, 35));
        btnRefresh.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnRefresh);

        btnList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/list.png"))); // NOI18N
        btnList.setFocusable(false);
        btnList.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnList.setMaximumSize(new java.awt.Dimension(35, 35));
        btnList.setMinimumSize(new java.awt.Dimension(35, 35));
        btnList.setPreferredSize(new java.awt.Dimension(35, 35));
        btnList.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListActionPerformed(evt);
            }
        });
        jToolBar1.add(btnList);

        btnPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/printer.png"))); // NOI18N
        btnPrint.setFocusable(false);
        btnPrint.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPrint.setMaximumSize(new java.awt.Dimension(35, 35));
        btnPrint.setMinimumSize(new java.awt.Dimension(35, 35));
        btnPrint.setPreferredSize(new java.awt.Dimension(35, 35));
        btnPrint.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnPrint);

        jLabel1.setText("Kode Supplier");

        jLabel2.setText("Nama Supplier");

        jLabel3.setText("No.Telephone");

        jLabel4.setText("No.Handphone");

        jLabel5.setText("Email");

        jLabel6.setText("NPWP");

        btnSaveSupplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/save.png"))); // NOI18N
        btnSaveSupplier.setText("Save");
        btnSaveSupplier.setMaximumSize(new java.awt.Dimension(85, 22));
        btnSaveSupplier.setMinimumSize(new java.awt.Dimension(85, 22));
        btnSaveSupplier.setPreferredSize(new java.awt.Dimension(85, 22));
        btnSaveSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveSupplierActionPerformed(evt);
            }
        });

        btnCancelSupplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/cancel.png"))); // NOI18N
        btnCancelSupplier.setText("Cancel");
        btnCancelSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelSupplierActionPerformed(evt);
            }
        });

        lbl_id_max.setText("ID");

        lbl_id.setText("ID");

        lbl_id_min.setText("ID");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtTlpSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHpSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbl_id_max)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbl_id)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbl_id_min)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSaveSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnCancelSupplier))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNamaSupplier, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtEmailSupplier, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNpwpSupplier, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtKodeSupplier, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(28, 28, 28))
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtKodeSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNamaSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTlpSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtHpSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtEmailSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtNpwpSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSaveSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_id_max)
                    .addComponent(lbl_id)
                    .addComponent(lbl_id_min))
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        String kodeSupplier = txtKodeSupplier.getText().toUpperCase();
        String namaSupplier = txtNamaSupplier.getText().toUpperCase();
        String tlpSupplier = txtTlpSupplier.getText().toUpperCase();
        String hpSupplier = txtHpSupplier.getText().toUpperCase();
        String emailSupplier = txtEmailSupplier.getText().toUpperCase();
        String npwpSupplier = txtNpwpSupplier.getText().toUpperCase();

        if(kodeSupplier.isBlank() & namaSupplier.isBlank() & tlpSupplier.isBlank() & hpSupplier.isBlank() & emailSupplier.isBlank() & npwpSupplier.isBlank()){
            txtKodeSupplier.requestFocus();
        }else{
            int hasil = JOptionPane.showConfirmDialog(null, "Apakah data ingin di simpan ?", "Confirm", JOptionPane.YES_NO_CANCEL_OPTION);
            if(hasil==JOptionPane.YES_OPTION){
                btnSaveSupplier.doClick();
                kosong();
                txtKodeSupplier.requestFocus();
                btnEdit.setEnabled(false);
                btnVoid.setEnabled(false);
                repaint();
                revalidate();
            }else if(hasil==JOptionPane.NO_OPTION){
                kosong();
            }else{
                
            }

        }

    }//GEN-LAST:event_btnNewActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        String kodeSupplier = txtKodeSupplier.getText().toUpperCase();
        String namaSupplier = txtNamaSupplier.getText().toUpperCase();
        String tlpSupplier = txtTlpSupplier.getText().toUpperCase();
        String hpSupplier = txtHpSupplier.getText().toUpperCase();
        String emailSupplier = txtEmailSupplier.getText().toUpperCase();
        String npwpSupplier = txtNpwpSupplier.getText().toUpperCase();

        if(kodeSupplier.isBlank() & namaSupplier.isBlank() & tlpSupplier.isBlank() & hpSupplier.isBlank() & emailSupplier.isBlank() & npwpSupplier.isBlank()){

            JOptionPane.showMessageDialog(null, "Tidak ada data di kolom !!!");

        }else{

            int hasil = JOptionPane.showConfirmDialog(null, "Apakah anda ingin melanjutkan mengedit ?", "Confirm", JOptionPane.YES_NO_CANCEL_OPTION);
            if(hasil==JOptionPane.YES_OPTION){
                btnVoid.setEnabled(false);
                btnEdit.setEnabled(false);
                repaint();
                revalidate();
            }else if(hasil==JOptionPane.NO_OPTION){
                kosong();
                btnVoid.setEnabled(false);
                btnEdit.setEnabled(false);
                repaint();
                revalidate();
            }else{
                
            }

        }
//                txtKodeSupplier.setEnabled(true);
//                txtNamaSupplier.setEnabled(true);
//                txtTlpSupplier.setEnabled(true);
//                txtHpSupplier.setEnabled(true);
//                txtEmailSupplier.setEnabled(true);
//                txtNpwpSupplier.setEnabled(true);
        
                txtKodeSupplier.setEditable(true);
                txtNamaSupplier.setEditable(true);
                txtTlpSupplier.setEditable(true);
                txtHpSupplier.setEditable(true);
                txtEmailSupplier.setEditable(true);
                txtNpwpSupplier.setEditable(true);

    }//GEN-LAST:event_btnEditActionPerformed

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
//            hapus();
//            kosong();
//            repaint();
//            revalidate();
        

    }//GEN-LAST:event_btnVoidActionPerformed

    private void btnPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousActionPerformed

        previous();
    }//GEN-LAST:event_btnPreviousActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed

        next();
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListActionPerformed

        if(listSupplier.isVisible()){//logika untuk memunculkan jinternalframe hanya sekali
            listSupplier.toFront();//memindahkan JInternalFrame ke depan sehingga menjadi aktif dan fokus.

        }else{
            //    setLocation(lastX, lastY);
            listSupplier.supplier = this;
            getDesktopPane().add(listSupplier).setVisible(true);
            listSupplier.setResizable(false);
            listSupplier.toFront();
        }
    }//GEN-LAST:event_btnListActionPerformed

    private void btnSaveSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveSupplierActionPerformed

     try {
        String sql = "select count(*) from supplier where kode_supplier='"+txtKodeSupplier.getText()+"'";
        Connection conn = (Connection) con.connectionSQL();
        Statement stm = conn.createStatement();
        ResultSet res = stm.executeQuery(sql);
        while (res.next()) {
           String cek = res.getString(1);
                if(cek.equals(1)){
                    JOptionPane.showMessageDialog(null, "supplier Code Already Exist");
                }else{
                    add_user();
                }
           
           }
        } catch (Exception e) {
            
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
    }
    }//GEN-LAST:event_btnSaveSupplierActionPerformed

    private void btnCancelSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelSupplierActionPerformed
        String kodeSupplier = txtKodeSupplier.getText().toUpperCase();
        String namaSupplier = txtNamaSupplier.getText().toUpperCase();
        String tlpSupplier = txtTlpSupplier.getText().toUpperCase();
        String hpSupplier = txtHpSupplier.getText().toUpperCase();
        String emailSupplier = txtEmailSupplier.getText().toUpperCase();
        String npwpSupplier = txtNpwpSupplier.getText().toUpperCase();

        if(kodeSupplier.isBlank() & namaSupplier.isBlank() & tlpSupplier.isBlank() & hpSupplier.isBlank() & emailSupplier.isBlank() & npwpSupplier.isBlank()){

            dispose();

        }else{

            int hasil = JOptionPane.showConfirmDialog(null, "Apakah data ingin di simpan ?", "Confirm", JOptionPane.YES_NO_OPTION);
            if(hasil==JOptionPane.YES_OPTION){
                btnSaveSupplier.doClick();
            }
            //                lastX = getX();
            //                lastY = getY();
            dispose();

        }

    }//GEN-LAST:event_btnCancelSupplierActionPerformed

      public void itemTerpilih(){
        listSupplier = new ListSupplier();
        listSupplier.supplier = this;
        lbl_id.setText(id);
        txtKodeSupplier.setText(kdSupplier);
        txtNamaSupplier.setText(nmSupplier);
        txtTlpSupplier.setText(tlpSupplier);
        txtHpSupplier.setText(hpSupplier);
        txtEmailSupplier.setText(emSupplier);
        txtNpwpSupplier.setText(npSupplier);
        btnEdit.setEnabled(true);
        btnVoid.setEnabled(true);
    }
    
     public void Simpan() throws IOException{
        try {
             Connection conn = (Connection) con.connectionSQL();
             conn.setAutoCommit(false);
             
            String kodeSupplier = txtKodeSupplier.getText().toUpperCase();
            String namaSupplier = txtNamaSupplier.getText().toUpperCase();
            String tlpSupplier = txtTlpSupplier.getText().toUpperCase();
            String hpSupplier = txtHpSupplier.getText().toUpperCase();
            String emailSupplier = txtEmailSupplier.getText().toUpperCase();
            String npwpSupplier = txtNpwpSupplier.getText().toUpperCase();
             
              if(kodeSupplier.isBlank()|| namaSupplier.isBlank()){
                  
                String sql = "INSERT INTO supplier (kode_supplier, nama_supplier, notlp_supplier, nohp_supplier, email_supplier, npwp_supplier, status_supplier) VALUES (?, ?, ?, ?,?, ?, ?)";
             
                PreparedStatement preparedstatement = conn.prepareStatement(sql);
                preparedstatement.setString(1, kodeSupplier);
                preparedstatement.setString(2, namaSupplier);
                preparedstatement.setString(3, tlpSupplier);
                preparedstatement.setString(4, hpSupplier);
                preparedstatement.setString(5, emailSupplier);
                preparedstatement.setString(6, npwpSupplier);
                preparedstatement.setString(7, "AKTIF");
             
                preparedstatement.executeUpdate();
                preparedstatement.close();
                conn.rollback();
                JOptionPane.showMessageDialog(null, "Ada kolom yang belum di isi");
                
               }else if(kodeSupplier.isBlank()& namaSupplier.isBlank()){
                   
                JOptionPane.showMessageDialog(null, "Ada kolom yang belum di isi !!!");
                   
               }else{
                  
                String sql = "INSERT INTO supplier (kode_supplier, nama_supplier, notlp_supplier, nohp_supplier, email_supplier, npwp_supplier, status_supplier) VALUES (?, ?, ?, ?,?, ?, ?)";

                PreparedStatement saveStatement = conn.prepareStatement(sql);
                saveStatement.setString(1, kodeSupplier);
                saveStatement.setString(2, namaSupplier);
                saveStatement.setString(3, tlpSupplier);
                saveStatement.setString(4, hpSupplier);
                saveStatement.setString(5, emailSupplier);
                saveStatement.setString(6, npwpSupplier);
                saveStatement.setString(7, "AKTIF");

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
             
             String kodeSupplier = txtKodeSupplier.getText().toUpperCase();
            String namaSupplier = txtNamaSupplier.getText().toUpperCase();
            String tlpSupplier = txtTlpSupplier.getText().toUpperCase();
            String hpSupplier = txtHpSupplier.getText().toUpperCase();
            String emailSupplier = txtEmailSupplier.getText().toUpperCase();
            String npwpSupplier = txtNpwpSupplier.getText().toUpperCase();
             
              if(kodeSupplier.isBlank()|| namaSupplier.isBlank()){
                  
                    String sql = "UPDATE supplier SET kode_supplier = ?, nama_supplier = ?, notlp_supplier = ?, nohp_supplier = ?, email_supplier = ?, npwp_supplier = ? WHERE kode_supplier = ?";
             
                    PreparedStatement editStatement = conn.prepareStatement(sql);
                    editStatement.setString(1, kodeSupplier);
                    editStatement.setString(2, namaSupplier);
                    editStatement.setString(3, tlpSupplier);
                    editStatement.setString(4, hpSupplier);
                    editStatement.setString(5, emailSupplier); 
                    editStatement.setString(6, npwpSupplier); 
                    editStatement.setString(7, kodeSupplier); 
             
                    editStatement.executeUpdate();
                    editStatement.close();
                    conn.rollback();
                    JOptionPane.showMessageDialog(null, "Ada kolom yang belum di isi");
                
               }else if(kodeSupplier.isBlank()& namaSupplier.isBlank()){
                   JOptionPane.showMessageDialog(null, "Ada kolom yang belum di isi");
               }
              else{

                    String sql = "UPDATE supplier SET kode_supplier = ?, nama_supplier = ?, notlp_supplier = ?, nohp_supplier = ?, email_supplier = ?, npwp_supplier = ? WHERE kode_supplier = ?";
             
                    PreparedStatement updatestatement = conn.prepareStatement(sql);
                    updatestatement.setString(1, kodeSupplier);
                    updatestatement.setString(2, namaSupplier);
                    updatestatement.setString(3, tlpSupplier);
                    updatestatement.setString(4, hpSupplier);
                    updatestatement.setString(5, emailSupplier); 
                    updatestatement.setString(6, npwpSupplier);
                    updatestatement.setString(7, kodeSupplier); 
             
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
             
             String kodeUser = txtKodeSupplier.getText().toUpperCase();
             
             String sql = "DELETE FROM supplier WHERE kode_supplier = ?";
             
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
        txtKodeSupplier.setText("");
        txtNamaSupplier.setText("");
        txtTlpSupplier.setText("");
        txtHpSupplier.setText("");
        txtEmailSupplier.setText("");
        txtNpwpSupplier.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelSupplier;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnList;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrevious;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSaveSupplier;
    private javax.swing.JButton btnVoid;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lbl_id;
    private javax.swing.JLabel lbl_id_max;
    private javax.swing.JLabel lbl_id_min;
    private javax.swing.JTextField txtEmailSupplier;
    private javax.swing.JTextField txtHpSupplier;
    private javax.swing.JTextField txtKodeSupplier;
    private javax.swing.JTextField txtNamaSupplier;
    private javax.swing.JTextField txtNpwpSupplier;
    private javax.swing.JTextField txtTlpSupplier;
    // End of variables declaration//GEN-END:variables
}
