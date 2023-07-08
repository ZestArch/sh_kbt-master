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
import lists.ListKonsumen;

public class Konsumen extends javax.swing.JInternalFrame {
    ListKonsumen listKonsumen;
    public String id, kdKonsumen, nmKonsumen, nmPerusahaan, alKonsumen, alkKonsumen, npKonsumen, nmNpwp, alNpwp, tlpKonsumen, hpKonsumen, faxKonsumen, emKonsumen ;
    private ArrayList<String> dataArrayList;
    private int currentIndex;
    connection.koneksi con;
    
    public Konsumen() {
        initComponents();
        this.setResizable(false);
        btnVoid.setEnabled(false);
        btnEdit.setEnabled(false);
        btnNext.setEnabled(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        listKonsumen = new ListKonsumen();
        dataArrayList = new ArrayList<>();
        currentIndex = -1;
        max_data();
        
//        lbl_id.setVisible(false);
//        lbl_id_max.setVisible(false);
//        lbl_id_min.setVisible(false);
    }

    private void add_user(){
        try {
            String sql = "INSERT INTO konsumen VALUES (null,'"+txtKodeKonsumen.getText()+"','"+txtNamaKonsumen.getText()+"','"+txtNamaPerusahaan.getText()
                    +"','"+taAlamat.getText()+taAlamatKirim.getText()+"','"+txtNomorNpwp.getText()+"','"+txtNamaNpwp.getText()+"','"+taAlamatNpwp.getText()
                    +txtTlpKonsumen.getText()+"','"+txtHpKonsumen.getText()+txtFaxKonsumen.getText()+"','"+txtEmailKonsumen.getText()+"','"+ "statuskonsumen = Aktif "+"')";
            java.sql.Connection conn = (Connection) con.connectionSQL();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.execute();
                JOptionPane.showMessageDialog(null, "Konsumen was added");
                kosong();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "User Code Already Exist");
                System.err.println( e.getClass().getName()+": "+ e.getMessage() );
              
            }
    }
    private void check_max(){
        try {
        String sql = "SELECT MAX(id_konsumen) FROM konsumen";
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
        String sql = "SELECT MIN(id_konsumen) FROM konsumen as id";
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
            String sql = "select * from konsumen where id_konsumen > '"+lbl_id.getText()+"' order by id_konsumen asc limit 1";
            Connection conn = (Connection) con.connectionSQL();
            Statement stm = conn.createStatement();
            ResultSet res = stm.executeQuery(sql);
            while (res.next()) {
                String id = res.getString(1);
                String kode = res.getString(2);
                String nama = res.getString(3);
                String namaPerusahaan = res.getString(4);
                String alamat = res.getString(5);
                String alamatKirim = res.getString(6);
                String nomorNpwp = res.getString(7);
                String namaNpwp = res.getString(8);
                String alamatNpwp = res.getString(9);
                String tlpKonsumen = res.getString(10);
                String hpKonsumen = res.getString(11);
                String faxkonsumen = res.getString(12);
                String emailkonsumen = res.getString(13);
//                String statuskonsumen = res.getString(14);
                
                lbl_id.setText(id);
                txtKodeKonsumen.setText(kode);
                txtNamaKonsumen.setText(nama);
                txtNamaPerusahaan.setText(namaPerusahaan);
                taAlamat.setText(alamat);
                taAlamatKirim.setText(alamatKirim);
                txtNomorNpwp.setText(nomorNpwp);
                txtNamaNpwp.setText(namaNpwp);
                taAlamatNpwp.setText(alamatNpwp);
                txtTlpKonsumen.setText(tlpKonsumen);
                txtHpKonsumen.setText(hpKonsumen);
                txtFaxKonsumen.setText(faxkonsumen);
                txtEmailKonsumen.setText(emailkonsumen);
                
                btnPrevious.setEnabled(true);
                check_max();
                btnEdit.setEnabled(true);
                btnVoid.setEnabled(true);
                txtKodeKonsumen.setEditable(false);
                txtNamaKonsumen.setEditable(false);
                txtNamaPerusahaan.setEditable(false);
                taAlamat.setEditable(false);
                taAlamatKirim.setEditable(false);
                txtNomorNpwp.setEditable(false);
                txtNamaNpwp.setEditable(false);
                taAlamatNpwp.setEditable(false);
                txtTlpKonsumen.setEditable(false);
                txtHpKonsumen.setEditable(false);
                txtFaxKonsumen.setEditable(false);
                txtEmailKonsumen.setEditable(false);
            }
        } catch (Exception e) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
        }
    }
    private void previous(){
        try {
            String sql = "select * from konsumen where id_konsumen < '"+lbl_id.getText()+"' order by id_konsumen desc limit 1";
            Connection conn = (Connection) con.connectionSQL();
            Statement stm = conn.createStatement();
            ResultSet res = stm.executeQuery(sql);
            while (res.next()) {
                String id = res.getString(1);
                String kode = res.getString(2);
                String nama = res.getString(3);
                String namaPerusahaan = res.getString(4);
                String alamat = res.getString(5);
                String alamatKirim = res.getString(6);
                String nomorNpwp = res.getString(7);
                String namaNpwp = res.getString(8);
                String alamatNpwp = res.getString(9);
                String tlpKonsumen = res.getString(10);
                String hpKonsumen = res.getString(11);
                String faxkonsumen = res.getString(12);
                String emailkonsumen = res.getString(13);
//                String statuskonsumen = res.getString(14);
                
                lbl_id.setText(id);
                txtKodeKonsumen.setText(kode);
                txtNamaKonsumen.setText(nama);
                txtNamaPerusahaan.setText(namaPerusahaan);
                taAlamat.setText(alamat);
                taAlamatKirim.setText(alamatKirim);
                txtNomorNpwp.setText(nomorNpwp);
                txtNamaNpwp.setText(namaNpwp);
                taAlamatNpwp.setText(alamatNpwp);
                txtTlpKonsumen.setText(tlpKonsumen);
                txtHpKonsumen.setText(hpKonsumen);
                txtFaxKonsumen.setText(faxkonsumen);
                txtEmailKonsumen.setText(emailkonsumen);
                
                check_min();
                btnNext.setEnabled(true);
                btnEdit.setEnabled(true);
                btnVoid.setEnabled(true);
                txtKodeKonsumen.setEditable(false);
                txtNamaKonsumen.setEditable(false);
                txtNamaPerusahaan.setEditable(false);
                taAlamat.setEditable(false);
                taAlamatKirim.setEditable(false);
                txtNomorNpwp.setEditable(false);
                txtNamaNpwp.setEditable(false);
                taAlamatNpwp.setEditable(false);
                txtTlpKonsumen.setEditable(false);
                txtHpKonsumen.setEditable(false);
                txtFaxKonsumen.setEditable(false);
                txtEmailKonsumen.setEditable(false);
            }
        } catch (Exception e) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
        }
    }
    private void max_data(){
        try {
            String sql = "select max(id_konsumen) from konsumen";
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
        txtNamaKonsumen = new javax.swing.JTextField();
        txtKodeKonsumen = new javax.swing.JTextField();
        txtTlpKonsumen = new javax.swing.JTextField();
        txtHpKonsumen = new javax.swing.JTextField();
        txtEmailKonsumen = new javax.swing.JTextField();
        txtNomorNpwp = new javax.swing.JTextField();
        btnSaveKonsumen = new javax.swing.JButton();
        btnCancelKonsumen = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtNamaPerusahaan = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtNamaNpwp = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtFaxKonsumen = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        taAlamat = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        taAlamatKirim = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        taAlamatNpwp = new javax.swing.JTextArea();
        lbl_id_max = new javax.swing.JLabel();
        lbl_id = new javax.swing.JLabel();
        lbl_id_min = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Data Konsumen");

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

        jLabel1.setText("Kode Konsumen");

        jLabel2.setText("Nama Konsumen");

        jLabel3.setText("No.Telephone");

        jLabel4.setText("No.Handphone");

        jLabel5.setText("Email");

        jLabel6.setText("NPWP");

        btnSaveKonsumen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/save.png"))); // NOI18N
        btnSaveKonsumen.setText("Save");
        btnSaveKonsumen.setMaximumSize(new java.awt.Dimension(85, 22));
        btnSaveKonsumen.setMinimumSize(new java.awt.Dimension(85, 22));
        btnSaveKonsumen.setPreferredSize(new java.awt.Dimension(85, 22));
        btnSaveKonsumen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveKonsumenActionPerformed(evt);
            }
        });

        btnCancelKonsumen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/cancel.png"))); // NOI18N
        btnCancelKonsumen.setText("Cancel");
        btnCancelKonsumen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelKonsumenActionPerformed(evt);
            }
        });

        jLabel7.setText("Nama Perusahaan");

        jLabel8.setText("Alamat");

        jLabel9.setText("Nama NPWP");

        jLabel10.setText("Alamat Kirim");

        jLabel11.setText("Alamat NPWP");

        jLabel12.setText("No.Fax");

        taAlamat.setColumns(20);
        taAlamat.setRows(5);
        jScrollPane1.setViewportView(taAlamat);

        taAlamatKirim.setColumns(20);
        taAlamatKirim.setRows(5);
        jScrollPane2.setViewportView(taAlamatKirim);

        taAlamatNpwp.setColumns(20);
        taAlamatNpwp.setRows(5);
        jScrollPane3.setViewportView(taAlamatNpwp);

        lbl_id_max.setText("ID");

        lbl_id.setText("ID");

        lbl_id_min.setText("ID");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                            .addComponent(jScrollPane2)
                            .addComponent(txtNamaKonsumen)
                            .addComponent(txtNamaPerusahaan)
                            .addComponent(txtKodeKonsumen))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel6))
                                .addGap(27, 27, 27))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNomorNpwp)
                            .addComponent(txtNamaNpwp)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                            .addComponent(txtTlpKonsumen)
                            .addComponent(txtHpKonsumen)
                            .addComponent(txtFaxKonsumen)
                            .addComponent(txtEmailKonsumen)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl_id_max)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addComponent(lbl_id)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_id_min)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSaveKonsumen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(btnCancelKonsumen)
                        .addGap(19, 19, 19)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtNomorNpwp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNamaNpwp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTlpKonsumen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtHpKonsumen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFaxKonsumen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEmailKonsumen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtKodeKonsumen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNamaKonsumen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNamaPerusahaan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSaveKonsumen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelKonsumen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_id_max)
                    .addComponent(lbl_id)
                    .addComponent(lbl_id_min))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
            String kodeKonsumen = txtKodeKonsumen.getText().toUpperCase();
            String namaKonsumen = txtNamaKonsumen.getText().toUpperCase();
            String namaPerusahaan = txtNamaPerusahaan.getText().toUpperCase();
            String alamat = taAlamat.getText().toUpperCase();
            String alamatKirim = taAlamatKirim.getText().toUpperCase();
            String nomorNpwp = txtNomorNpwp.getText().toUpperCase();
            String namaNpwp = txtNamaNpwp.getText().toUpperCase();
            String alamatNpwp = taAlamatNpwp.getText().toUpperCase();
            String tlpKonsumen = txtTlpKonsumen.getText().toUpperCase();
            String hpKonsumen = txtHpKonsumen.getText().toUpperCase();
            String faxKonsumen = txtFaxKonsumen.getText().toUpperCase();
            String emailKonsumen = txtEmailKonsumen.getText().toUpperCase();

        if(kodeKonsumen.isBlank() & namaKonsumen.isBlank() & namaPerusahaan.isBlank() & alamat.isBlank() & alamatKirim.isBlank() & nomorNpwp.isBlank() & namaNpwp.isBlank()
           & alamatNpwp.isBlank() & tlpKonsumen.isBlank() & hpKonsumen.isBlank() & faxKonsumen.isBlank() & emailKonsumen.isBlank()){
            txtKodeKonsumen.requestFocus();
        }else{
            int hasil = JOptionPane.showConfirmDialog(null, "Apakah data ingin di simpan ?", "Confirm", JOptionPane.YES_NO_CANCEL_OPTION);
            if(hasil==JOptionPane.YES_OPTION){
                btnSaveKonsumen.doClick();
                kosong();
                txtKodeKonsumen.requestFocus();
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
            String kodeKonsumen = txtKodeKonsumen.getText().toUpperCase();
            String namaKonsumen = txtNamaKonsumen.getText().toUpperCase();
            String namaPerusahaan = txtNamaPerusahaan.getText().toUpperCase();
            String alamat = taAlamat.getText().toUpperCase();
            String alamatKirim = taAlamatKirim.getText().toUpperCase();
            String nomorNpwp = txtNomorNpwp.getText().toUpperCase();
            String namaNpwp = txtNamaNpwp.getText().toUpperCase();
            String alamatNpwp = taAlamatNpwp.getText().toUpperCase();
            String tlpKonsumen = txtTlpKonsumen.getText().toUpperCase();
            String hpKonsumen = txtHpKonsumen.getText().toUpperCase();
            String faxKonsumen = txtFaxKonsumen.getText().toUpperCase();
            String emailKonsumen = txtEmailKonsumen.getText().toUpperCase();

        if(kodeKonsumen.isBlank() & namaKonsumen.isBlank() & namaPerusahaan.isBlank() & alamat.isBlank() & alamatKirim.isBlank() & nomorNpwp.isBlank() & namaNpwp.isBlank()
           & alamatNpwp.isBlank() & tlpKonsumen.isBlank() & hpKonsumen.isBlank() & faxKonsumen.isBlank() & emailKonsumen.isBlank()){

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

                txtKodeKonsumen.setEditable(true);
                txtNamaKonsumen.setEditable(true);
                txtNamaPerusahaan.setEditable(true);
                taAlamat.setEditable(true);
                taAlamatKirim.setEditable(true);
                txtNomorNpwp.setEditable(true);
                txtNamaNpwp.setEditable(true);
                taAlamatNpwp.setEditable(true);
                txtTlpKonsumen.setEditable(true);
                txtHpKonsumen.setEditable(true);
                txtFaxKonsumen.setEditable(true);
                txtEmailKonsumen.setEditable(true);
        
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
//        

    }//GEN-LAST:event_btnVoidActionPerformed

    private void btnPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousActionPerformed
        previous();
    }//GEN-LAST:event_btnPreviousActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        next();
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListActionPerformed

        if(listKonsumen.isVisible()){//logika untuk memunculkan jinternalframe hanya sekali
            listKonsumen.toFront();//memindahkan JInternalFrame ke depan sehingga menjadi aktif dan fokus.

        }else{
            //    setLocation(lastX, lastY);
            listKonsumen.konsumen = this;
            getDesktopPane().add(listKonsumen).setVisible(true);
            listKonsumen.setResizable(false);
            listKonsumen.toFront();
        }
    }//GEN-LAST:event_btnListActionPerformed

    private void btnSaveKonsumenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveKonsumenActionPerformed
        try {
        String sql = "select count(*) from konsumen where kode_konsumen='"+txtKodeKonsumen.getText()+"'";
        Connection conn = (Connection) con.connectionSQL();
        Statement stm = conn.createStatement();
        ResultSet res = stm.executeQuery(sql);
        while (res.next()) {
           String cek = res.getString(1);
                if(cek.equals(1)){
                    JOptionPane.showMessageDialog(null, "konsumen Code Already Exist");
                }else{
                    add_user();
                }
           
           }
        } catch (Exception e) {
            
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
    }
    }//GEN-LAST:event_btnSaveKonsumenActionPerformed

    private void btnCancelKonsumenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelKonsumenActionPerformed
            String kodeKonsumen = txtKodeKonsumen.getText().toUpperCase();
            String namaKonsumen = txtNamaKonsumen.getText().toUpperCase();
            String namaPerusahaan = txtNamaPerusahaan.getText().toUpperCase();
            String alamat = taAlamat.getText().toUpperCase();
            String alamatKirim = taAlamatKirim.getText().toUpperCase();
            String nomorNpwp = txtNomorNpwp.getText().toUpperCase();
            String namaNpwp = txtNamaNpwp.getText().toUpperCase();
            String alamatNpwp = taAlamatNpwp.getText().toUpperCase();
            String tlpKonsumen = txtTlpKonsumen.getText().toUpperCase();
            String hpKonsumen = txtHpKonsumen.getText().toUpperCase();
            String faxKonsumen = txtFaxKonsumen.getText().toUpperCase();
            String emailKonsumen = txtEmailKonsumen.getText().toUpperCase();

        if(kodeKonsumen.isBlank() & namaKonsumen.isBlank() & namaPerusahaan.isBlank() & alamat.isBlank() & alamatKirim.isBlank() & nomorNpwp.isBlank() & namaNpwp.isBlank()
           & alamatNpwp.isBlank() & tlpKonsumen.isBlank() & hpKonsumen.isBlank() & faxKonsumen.isBlank() & emailKonsumen.isBlank()){

            dispose();

        }else{

            int hasil = JOptionPane.showConfirmDialog(null, "Apakah data ingin di simpan ?", "Confirm", JOptionPane.YES_NO_CANCEL_OPTION);
            if(hasil==JOptionPane.YES_OPTION){
                btnSaveKonsumen.doClick();
            } else if(hasil==JOptionPane.NO_OPTION){
                dispose();
            }else{
                
            }
            
        }

    }//GEN-LAST:event_btnCancelKonsumenActionPerformed

      public void itemTerpilih(){
        listKonsumen = new ListKonsumen();
        listKonsumen.konsumen = this;
        lbl_id.setText(id);
        txtKodeKonsumen.setText(kdKonsumen);
        txtNamaKonsumen.setText(nmKonsumen);
        txtNamaPerusahaan.setText(nmPerusahaan);
        taAlamat.setText(alKonsumen);
        taAlamatKirim.setText(alkKonsumen);
        txtNomorNpwp.setText(npKonsumen);
        txtNamaNpwp.setText(nmNpwp);
        taAlamatNpwp.setText(alNpwp);
        txtTlpKonsumen.setText(tlpKonsumen);
        txtHpKonsumen.setText(hpKonsumen);
        txtFaxKonsumen.setText(faxKonsumen);
        txtEmailKonsumen.setText(emKonsumen);
        btnEdit.setEnabled(true);
        btnVoid.setEnabled(true);
    }
    
    public void Simpan() throws IOException{
        try {
             Connection conn = (Connection) con.connectionSQL();
             conn.setAutoCommit(false);
             
            String kodeKonsumen = txtKodeKonsumen.getText().toUpperCase();
            String namaKonsumen = txtNamaKonsumen.getText().toUpperCase();
            String namaPerusahaan = txtNamaPerusahaan.getText().toUpperCase();
            String alamat = taAlamat.getText().toUpperCase();
            String alamatKirim = taAlamatKirim.getText().toUpperCase();
            String nomorNpwp = txtNomorNpwp.getText().toUpperCase();
            String namaNpwp = txtNamaNpwp.getText().toUpperCase();
            String alamatNpwp = taAlamatNpwp.getText().toUpperCase();
            String tlpKonsumen = txtTlpKonsumen.getText().toUpperCase();
            String hpKonsumen = txtHpKonsumen.getText().toUpperCase();
            String faxKonsumen = txtFaxKonsumen.getText().toUpperCase();
            String emailKonsumen = txtEmailKonsumen.getText().toUpperCase();
            
             
              if(kodeKonsumen.isBlank()|| namaKonsumen.isBlank()){
                  
                String sql = "INSERT INTO konsumen (kode_konsumen, nama_konsumen, nama_perusahaan, alamat_konsumen, alamat_kirim,  nomor_npwp, nama_npwp, alamat_npwp, notlp_konsumen, nohp_konsumen, fax_konsumen, email_konsumen, status_konsumen) VALUES (?, ?, ?, ?,?, ?, ?, ?, ?, ?, ?, ?, ?)";
             
                PreparedStatement preparedstatement = conn.prepareStatement(sql);
                preparedstatement.setString(1, kodeKonsumen);
                preparedstatement.setString(2, namaKonsumen);
                preparedstatement.setString(3, namaPerusahaan);
                preparedstatement.setString(4, alamat);
                preparedstatement.setString(5, alamatKirim);
                preparedstatement.setString(6, nomorNpwp);
                preparedstatement.setString(7, namaNpwp);
                preparedstatement.setString(8, alamatNpwp);
                preparedstatement.setString(9, tlpKonsumen);
                preparedstatement.setString(10, hpKonsumen);
                preparedstatement.setString(11, faxKonsumen);
                preparedstatement.setString(12, emailKonsumen);
                preparedstatement.setString(13, "AKTIF");
             
             
                preparedstatement.executeUpdate();
                preparedstatement.close();
                conn.rollback();
                JOptionPane.showMessageDialog(null, "Ada kolom yang belum di isi");
                
               }else if(kodeKonsumen.isBlank()& namaKonsumen.isBlank()){
                   
                JOptionPane.showMessageDialog(null, "Ada kolom yang belum di isi !!!");
                   
               }else{
                  
                String sql = "INSERT INTO konsumen (kode_konsumen, nama_konsumen, nama_perusahaan, alamat_konsumen, alamat_kirim,  nomor_npwp, nama_npwp, alamat_npwp, notlp_konsumen, nohp_konsumen, fax_konsumen, email_konsumen, status_konsumen) VALUES (?, ?, ?, ?,?, ?, ?, ?, ?, ?, ?, ?, ?)";

                PreparedStatement saveStatement = conn.prepareStatement(sql);
                saveStatement.setString(1, kodeKonsumen);
                saveStatement.setString(2, namaKonsumen);
                saveStatement.setString(3, namaPerusahaan);
                saveStatement.setString(4, alamat);
                saveStatement.setString(5, alamatKirim);
                saveStatement.setString(6, nomorNpwp);
                saveStatement.setString(7, namaNpwp);
                saveStatement.setString(8, alamatNpwp);
                saveStatement.setString(9, tlpKonsumen);
                saveStatement.setString(10, hpKonsumen);
                saveStatement.setString(11, faxKonsumen);
                saveStatement.setString(12, emailKonsumen);
                saveStatement.setString(13, "AKTIF");

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
             
            String kodeKonsumen = txtKodeKonsumen.getText().toUpperCase();
            String namaKonsumen = txtNamaKonsumen.getText().toUpperCase();
            String namaPerusahaan = txtNamaPerusahaan.getText().toUpperCase();
            String alamat = taAlamat.getText().toUpperCase();
            String alamatKirim = taAlamatKirim.getText().toUpperCase();
            String nomorNpwp = txtNomorNpwp.getText().toUpperCase();
            String namaNpwp = txtNamaNpwp.getText().toUpperCase();
            String alamatNpwp = taAlamatNpwp.getText().toUpperCase();
            String tlpKonsumen = txtTlpKonsumen.getText().toUpperCase();
            String hpKonsumen = txtHpKonsumen.getText().toUpperCase();
            String faxKonsumen = txtFaxKonsumen.getText().toUpperCase();
            String emailKonsumen = txtEmailKonsumen.getText().toUpperCase();
             
              if(kodeKonsumen.isBlank()|| namaKonsumen.isBlank()){
                  
                    String sql = "UPDATE konsumen SET kode_konsumen = ?, nama_konsumen = ?, nama_perusahaan = ?, alamat_konsumen = ?, alamat_kirim = ?,  nomor_npwp = ?, nama_npwp = ?, alamat_npwp = ?, notlp_konsumen = ?, nohp_konsumen = ?, fax_konsumen = ?, email_konsumen = ? WHERE kode_konsumen = ?";
                    
                    PreparedStatement editStatement = conn.prepareStatement(sql); 
                    editStatement.setString(1, kodeKonsumen);
                    editStatement.setString(2, namaKonsumen);
                    editStatement.setString(3, namaPerusahaan);
                    editStatement.setString(4, alamat);
                    editStatement.setString(5, alamatKirim);
                    editStatement.setString(6, nomorNpwp);
                    editStatement.setString(7, namaNpwp);
                    editStatement.setString(8, alamatNpwp);
                    editStatement.setString(9, tlpKonsumen);
                    editStatement.setString(10, hpKonsumen);
                    editStatement.setString(11, faxKonsumen);
                    editStatement.setString(12, emailKonsumen);
                    editStatement.setString(13, kodeKonsumen);
                    
             
                    editStatement.executeUpdate();
                    editStatement.close();
                    conn.rollback();
                    JOptionPane.showMessageDialog(null, "Ada kolom yang belum di isi");
                
               }else if(kodeKonsumen.isBlank()& namaKonsumen.isBlank()){
                   JOptionPane.showMessageDialog(null, "Ada kolom yang belum di isi");
               }
              else{

                    String sql = "UPDATE konsumen SET kode_konsumen = ?, nama_konsumen = ?, nama_perusahaan = ?, alamat_konsumen = ?, alamat_kirim = ?,  nomor_npwp = ?, nama_npwp = ?, alamat_npwp = ?, notlp_konsumen = ?, nohp_konsumen = ?, fax_konsumen = ?, email_konsumen = ? WHERE kode_konsumen = ?";
                    
                    PreparedStatement updatestatement = conn.prepareStatement(sql);
                    updatestatement.setString(1, kodeKonsumen);
                    updatestatement.setString(2, namaKonsumen);
                    updatestatement.setString(3, namaPerusahaan);
                    updatestatement.setString(4, alamat);
                    updatestatement.setString(5, alamatKirim);
                    updatestatement.setString(6, nomorNpwp);
                    updatestatement.setString(7, namaNpwp);
                    updatestatement.setString(8, alamatNpwp);
                    updatestatement.setString(9, tlpKonsumen);
                    updatestatement.setString(10, hpKonsumen);
                    updatestatement.setString(11, faxKonsumen);
                    updatestatement.setString(12, emailKonsumen);
                    updatestatement.setString(13, kodeKonsumen);
             
                    updatestatement.executeUpdate();
                    updatestatement.close();
                    conn.commit();
                    kosong();
            }
              
//             con.close();
             
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error saat mengedit !!!" + e);
        }
    }

    
    public void hapus() throws IOException{
        try {
             Connection conn = (Connection) con.connectionSQL();
             conn.setAutoCommit(false);
             
             String kodeKonsumen = txtKodeKonsumen.getText().toUpperCase();
             
             String sql = "DELETE FROM konsumen WHERE kode_konsumen = ?";
             
             PreparedStatement deleteStatement = conn.prepareStatement(sql);
             deleteStatement.setString(1, kodeKonsumen);
             
             deleteStatement.executeUpdate();
             deleteStatement.close();
             conn.commit();
             conn.close();
             
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error saat menghapus !!!" + e);
        }
    }
    public void kosong(){
        txtKodeKonsumen.setText("");
        txtNamaKonsumen.setText("");
        txtNamaPerusahaan.setText("");
        taAlamat.setText("");
        taAlamatKirim.setText("");
        txtNomorNpwp.setText("");
        txtNamaNpwp.setText("");
        taAlamatNpwp.setText("");
        txtTlpKonsumen.setText("");
        txtHpKonsumen.setText("");
        txtFaxKonsumen.setText("");
        txtEmailKonsumen.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelKonsumen;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnList;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrevious;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSaveKonsumen;
    private javax.swing.JButton btnVoid;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lbl_id;
    private javax.swing.JLabel lbl_id_max;
    private javax.swing.JLabel lbl_id_min;
    private javax.swing.JTextArea taAlamat;
    private javax.swing.JTextArea taAlamatKirim;
    private javax.swing.JTextArea taAlamatNpwp;
    private javax.swing.JTextField txtEmailKonsumen;
    private javax.swing.JTextField txtFaxKonsumen;
    private javax.swing.JTextField txtHpKonsumen;
    private javax.swing.JTextField txtKodeKonsumen;
    private javax.swing.JTextField txtNamaKonsumen;
    private javax.swing.JTextField txtNamaNpwp;
    private javax.swing.JTextField txtNamaPerusahaan;
    private javax.swing.JTextField txtNomorNpwp;
    private javax.swing.JTextField txtTlpKonsumen;
    // End of variables declaration//GEN-END:variables
}
