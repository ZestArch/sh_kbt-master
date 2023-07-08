/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package menu;

import java.awt.Dimension;
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
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;


public class Barang extends javax.swing.JInternalFrame {
//    ListBarang listbarang;
    private DefaultTableModel dftDialogBarang, dftDialogSatuan, dftDialogKategori;
    private TableRowSorter filtering;
    public String id, nmBarang, ktgBarang, stBarang,kdBarang, jmlBarang, pilKategori, pilSatuan;
    private ArrayList<String> dataArrayList;
    private int currentIndex;
    connection.koneksi con;
    private Dashboard dashboard;

    
    public Barang() {
        initComponents();
        this.setResizable(false);
        btnVoid.setEnabled(false);
        btnEdit.setEnabled(false);
        btnNext.setEnabled(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//        listbarang = new ListBarang();
//        dialogBarang = new DialogBarang1(dashboard, true);
        dataArrayList = new ArrayList<>();
        currentIndex = -1;
        max_data();
        
        lbl_id.setVisible(false);
        lbl_id_max.setVisible(false);
        lbl_id_min.setVisible(false);
    
        filterListUser();
        filterDialogKategori();
        filterDialogSatuan();
//        autoNomor();
    }
    
    private void add_user(){
        try {
            String sql = "INSERT INTO barang VALUES (null,'"+txtKodeBarang.getText()+"','"+txtNamaBarang.getText()+"','"+txtKategori.getText()+"','"+txtSatuan.getText()+"')";
            java.sql.Connection conn = (Connection) con.connectionSQL();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.execute();
                JOptionPane.showMessageDialog(null, "Barang was added");
                kosong();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Barang Already Exist");
                System.err.println( e.getClass().getName()+": "+ e.getMessage() );
              
            }
    }
    private void check_max(){
        try {
        String sql = "SELECT MAX(id_barang) FROM barang";
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
        String sql = "SELECT MIN(id_barang) FROM barang as id";
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
                pilihKategori.setEnabled(false);
                pilihSatuan.setEnabled(false);
            }
        }
        } catch (Exception e) {
            
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
        }
    }
    private void next(){
        try {
            String sql = "select * from barang where id_barang > '"+lbl_id.getText()+"' order by id_barang asc limit 1";
            Connection conn = (Connection) con.connectionSQL();
            Statement stm = conn.createStatement();
            ResultSet res = stm.executeQuery(sql);
            while (res.next()) {
                String id = res.getString(1);
                String kode = res.getString(2);
                String nama = res.getString(3);
                String kategori = res.getString(4);
                String jumlah = res.getString(5);
                String satuan = res.getString(6);
                
                lbl_id.setText(id);
                txtKodeBarang.setText(kode);
                txtNamaBarang.setText(nama);
                txtKategori.setText(kategori);
//                txtJumlah.setText(jumlah);
                txtSatuan.setText(satuan);
                
                btnPrevious.setEnabled(true);
                check_max();
                btnEdit.setEnabled(true);
                btnVoid.setEnabled(true);
                pilihKategori.setEnabled(false);
                pilihSatuan.setEnabled(false);
                txtKodeBarang.setEditable(false);
                txtNamaBarang.setEditable(false);
                txtKategori.setEditable(false);
//                txtJumlah.setEditable(false);
                txtSatuan.setEditable(false);
            }
        } catch (Exception e) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
        }
    }
    private void previous(){
        try {
            String sql = "select * from barang where id_barang < '"+lbl_id.getText()+"' order by id_barang desc limit 1";
            Connection conn = (Connection) con.connectionSQL();
            Statement stm = conn.createStatement();
            ResultSet res = stm.executeQuery(sql);
            while (res.next()) {
               String id = res.getString(1);
                String kode = res.getString(2);
                String nama = res.getString(3);
                String kategori = res.getString(4);
                String jumlah = res.getString(5);
                String satuan = res.getString(6);
                
                lbl_id.setText(id);
                txtKodeBarang.setText(kode);
                txtNamaBarang.setText(nama);
                txtKategori.setText(kategori);
//                txtJumlah.setText(jumlah);
                txtSatuan.setText(satuan);
                
                check_min();
                btnNext.setEnabled(true);
                btnEdit.setEnabled(true);
                btnVoid.setEnabled(true);
                pilihKategori.setEnabled(false);
                pilihSatuan.setEnabled(false);
                txtKodeBarang.setEditable(false);
                txtNamaBarang.setEditable(false);
                txtKategori.setEditable(false);
//                txtJumlah.setEditable(false);
                txtSatuan.setEditable(false);
            }
        } catch (Exception e) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
        }
    }
    private void max_data(){
        try {
            String sql = "select max(id_barang) from barang";
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
    
     public void autoNomor(){

           try {
             Connection conn = (Connection) con.connectionSQL();
             Statement st = conn.createStatement();
             String sql = " SELECT MAX(kode_barang) AS no FROM barang";
//              String sql = " SELECT MAX(RIGHT(kodebarang,8))AS no FROM databarang";
             ResultSet rs = st.executeQuery(sql);
             while(rs.next()){
                 if(rs.first()==false){
                     txtKodeBarang.setText("00000001");
                 }else{
                     rs.last();
                     int autoNo=rs.getInt(1)+1;
                     String no = String.valueOf(autoNo);
                     int nomor = no.length();
                     for(int i=0; i<8-nomor; i++){
                         no="0"+no;
                     }
                     txtKodeBarang.setText(no);
                 }
                 
             }
         } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "Penomoran Salah" +e);
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

        dialogBarang = new javax.swing.JDialog();
        jLabel6 = new javax.swing.JLabel();
        txtDialogBarang = new javax.swing.JTextField();
        jspDialogBarang = new javax.swing.JScrollPane();
        tblDialogBarang = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        dialogKategori = new javax.swing.JDialog();
        jLabel4 = new javax.swing.JLabel();
        txtSearchDialogKategori = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDialogKategori = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        dialogSatuan = new javax.swing.JDialog();
        txtSearchDialogSatuan = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDialogSatuan = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
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
        jLabel5 = new javax.swing.JLabel();
        txtNamaBarang = new javax.swing.JTextField();
        txtKodeBarang = new javax.swing.JTextField();
        txtKategori = new javax.swing.JTextField();
        txtSatuan = new javax.swing.JTextField();
        btnSaveBarang = new javax.swing.JButton();
        btnCancelBarang = new javax.swing.JButton();
        lbl_id_max = new javax.swing.JLabel();
        lbl_id = new javax.swing.JLabel();
        lbl_id_min = new javax.swing.JLabel();
        pilihKategori = new javax.swing.JButton();
        pilihSatuan = new javax.swing.JButton();

        dialogBarang.setPreferredSize(new java.awt.Dimension(570, 410));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Search");

        txtDialogBarang.setPreferredSize(new java.awt.Dimension(64, 20));

        jspDialogBarang.setBackground(new java.awt.Color(255, 255, 255));

        tblDialogBarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kode Barang", "Nama Barang", "Kategori", "Qty", "Satuan"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDialogBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDialogBarangMouseClicked(evt);
            }
        });
        jspDialogBarang.setViewportView(tblDialogBarang);
        if (tblDialogBarang.getColumnModel().getColumnCount() > 0) {
            tblDialogBarang.getColumnModel().getColumn(2).setMinWidth(0);
            tblDialogBarang.getColumnModel().getColumn(2).setMaxWidth(0);
            tblDialogBarang.getColumnModel().getColumn(3).setMinWidth(0);
            tblDialogBarang.getColumnModel().getColumn(3).setMaxWidth(0);
            tblDialogBarang.getColumnModel().getColumn(4).setMinWidth(0);
            tblDialogBarang.getColumnModel().getColumn(4).setMaxWidth(0);
        }

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(570, 25));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 570, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 27, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout dialogBarangLayout = new javax.swing.GroupLayout(dialogBarang.getContentPane());
        dialogBarang.getContentPane().setLayout(dialogBarangLayout);
        dialogBarangLayout.setHorizontalGroup(
            dialogBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(dialogBarangLayout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(txtDialogBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(dialogBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jspDialogBarang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE))
        );
        dialogBarangLayout.setVerticalGroup(
            dialogBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dialogBarangLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(dialogBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDialogBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 348, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(dialogBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(dialogBarangLayout.createSequentialGroup()
                    .addGap(55, 55, 55)
                    .addComponent(jspDialogBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(29, Short.MAX_VALUE)))
        );

        jLabel4.setText("Search");

        jScrollPane2.setPreferredSize(new java.awt.Dimension(301, 80));

        tblDialogKategori.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nama"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDialogKategori.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDialogKategoriMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblDialogKategori);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 26, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout dialogKategoriLayout = new javax.swing.GroupLayout(dialogKategori.getContentPane());
        dialogKategori.getContentPane().setLayout(dialogKategoriLayout);
        dialogKategoriLayout.setHorizontalGroup(
            dialogKategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addGroup(dialogKategoriLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSearchDialogKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        dialogKategoriLayout.setVerticalGroup(
            dialogKategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dialogKategoriLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dialogKategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearchDialogKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel7.setText("Search");

        jScrollPane1.setPreferredSize(new java.awt.Dimension(301, 80));

        tblDialogSatuan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Satuan"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDialogSatuan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDialogSatuanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDialogSatuan);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 26, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout dialogSatuanLayout = new javax.swing.GroupLayout(dialogSatuan.getContentPane());
        dialogSatuan.getContentPane().setLayout(dialogSatuanLayout);
        dialogSatuanLayout.setHorizontalGroup(
            dialogSatuanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
            .addGroup(dialogSatuanLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSearchDialogSatuan, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        dialogSatuanLayout.setVerticalGroup(
            dialogSatuanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dialogSatuanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dialogSatuanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearchDialogSatuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        setClosable(true);
        setIconifiable(true);
        setTitle("Data Barang");
        setPreferredSize(new java.awt.Dimension(435, 360));

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

        jLabel1.setText("Kode Barang");

        jLabel2.setText("Nama Barang");

        jLabel3.setText("Kategori");

        jLabel5.setText("Satuan");

        btnSaveBarang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/save.png"))); // NOI18N
        btnSaveBarang.setText("Save");
        btnSaveBarang.setMaximumSize(new java.awt.Dimension(85, 22));
        btnSaveBarang.setMinimumSize(new java.awt.Dimension(85, 22));
        btnSaveBarang.setPreferredSize(new java.awt.Dimension(85, 22));
        btnSaveBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveBarangActionPerformed(evt);
            }
        });

        btnCancelBarang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/cancel.png"))); // NOI18N
        btnCancelBarang.setText("Cancel");
        btnCancelBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelBarangActionPerformed(evt);
            }
        });

        lbl_id_max.setText("ID");

        lbl_id.setText("ID");

        lbl_id_min.setText("ID");

        pilihKategori.setText("...");
        pilihKategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pilihKategoriActionPerformed(evt);
            }
        });

        pilihSatuan.setText("...");
        pilihSatuan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pilihSatuanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbl_id_max)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_id)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_id_min))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtSatuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pilihSatuan))
                            .addComponent(txtNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtKodeBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(btnSaveBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnCancelBarang))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pilihKategori)))))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtKodeBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pilihKategori))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtSatuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pilihSatuan))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSaveBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_id_max)
                    .addComponent(lbl_id)
                    .addComponent(lbl_id_min))
                .addContainerGap(68, Short.MAX_VALUE))
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
        String kodeBarang = txtKodeBarang.getText().toUpperCase();
        String namaBarang = txtNamaBarang.getText().toUpperCase();
        String kategoriBarang = txtKategori.getText().toUpperCase();
//        String jumlahBarang = txtJumlah.getText().toUpperCase();
        String satuanBarang = txtSatuan.getText().toUpperCase();

        if(kodeBarang.isBlank() & namaBarang.isBlank() & kategoriBarang.isBlank() & satuanBarang.isBlank()){
            txtKodeBarang.requestFocus();
        }else{
            int hasil = JOptionPane.showConfirmDialog(null, "Apakah data ingin di simpan ?", "Confirm", JOptionPane.YES_NO_OPTION);
            if(hasil==JOptionPane.YES_OPTION){
                btnSaveBarang.doClick();
                kosong();
                txtKodeBarang.requestFocus();
                btnEdit.setEnabled(false);
                btnVoid.setEnabled(false);
                pilihKategori.setEnabled(true);
                pilihSatuan.setEnabled(true);
                autoNomor();
                repaint();
                revalidate();
            }else{
                kosong();
                pilihKategori.setEnabled(true);
                pilihSatuan.setEnabled(true);
                txtKodeBarang.setEditable(true);
                txtNamaBarang.setEditable(true);
                txtKategori.setEditable(true);
//                txtJumlah.setEditable(false);
                txtSatuan.setEditable(true);
                pilihKategori.setEnabled(true);
                pilihSatuan.setEnabled(true);
            }

        }

    }//GEN-LAST:event_btnNewActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        String kodeBarang = txtKodeBarang.getText().toUpperCase();
        String namaBarang = txtNamaBarang.getText().toUpperCase();
        String kategoriBarang = txtKategori.getText().toUpperCase();
//        String jumlahBarang = txtJumlah.getText().toUpperCase();
        String satuanBarang = txtSatuan.getText().toUpperCase();

        if(kodeBarang.isBlank() & namaBarang.isBlank() & kategoriBarang.isBlank() & satuanBarang.isBlank()){

            JOptionPane.showMessageDialog(null, "Tidak ada data di kolom !!!");

        }else{

            int hasil = JOptionPane.showConfirmDialog(null, "Apakah anda ingin melanjutkan mengedit ?", "Confirm", JOptionPane.YES_NO_OPTION);
            if(hasil==JOptionPane.YES_NO_OPTION){
                btnVoid.setEnabled(false);
                btnEdit.setEnabled(false);
                pilihKategori.setEnabled(true);
                pilihSatuan.setEnabled(true);
                repaint();
                revalidate();
            }else{
                kosong();
                btnVoid.setEnabled(false);
                btnEdit.setEnabled(false);
                pilihKategori.setEnabled(true);
                pilihSatuan.setEnabled(true);
                repaint();
                revalidate();
            }

        }

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
        

    }//GEN-LAST:event_btnVoidActionPerformed

    private void btnPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousActionPerformed
        previous();
    }//GEN-LAST:event_btnPreviousActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
       next();
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListActionPerformed

//        if(listbarang.isVisible()){//logika untuk memunculkan jinternalframe hanya sekali
//            listbarang.toFront();//memindahkan JInternalFrame ke depan sehingga menjadi aktif dan fokus.
//
//        }else{
//            //    setLocation(lastX, lastY);
//            listbarang.barang = this;
//            getDesktopPane().add(listbarang).setVisible(true);
//            listbarang.setResizable(false);
//            listbarang.toFront();
//        }
        if(dialogBarang.isVisible()){//logika untuk memunculkan jinternalframe hanya sekali
            dialogBarang.toFront();//memindahkan JInternalFrame ke depan sehingga menjadi aktif dan fokus.
        
        }else{
            dialogBarang.setLocationRelativeTo(dashboard);
            dialogBarang.setVisible(true);
            dialogBarang.toFront();
            dialogBarang.pack();
        }
    }//GEN-LAST:event_btnListActionPerformed

    private void btnSaveBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveBarangActionPerformed
        try {
        String sql = "select count(*) from barang where kode_barang='"+txtKodeBarang.getText()+"'";
        Connection conn = (Connection) con.connectionSQL();
        Statement stm = conn.createStatement();
        ResultSet res = stm.executeQuery(sql);
        while (res.next()) {
           String cek = res.getString(1);
                if(cek.equals(1)){
                    JOptionPane.showMessageDialog(null, "Barang Already Exist");
                }else{
                    add_user();
                }
           
           }
        autoNomor();
        } catch (Exception e) {
            
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
    }
    }//GEN-LAST:event_btnSaveBarangActionPerformed

    private void btnCancelBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelBarangActionPerformed
        String kodeBarang = txtKodeBarang.getText();
        String namaBarang = txtNamaBarang.getText().toUpperCase();
        String kategoriBarang = txtKategori.getText().toUpperCase();
//        String jumlahBarang = txtJumlah.getText();
        String satuanBarang = txtSatuan.getText().toUpperCase();
        
         if(kodeBarang.isBlank() & namaBarang.isBlank() & kategoriBarang.isBlank() & satuanBarang.isBlank()){
              dispose();

        }else{

            int hasil = JOptionPane.showConfirmDialog(null, "Apakah data ingin di simpan ?", "Confirm", JOptionPane.YES_NO_OPTION);
            if(hasil==JOptionPane.YES_OPTION){
                btnSaveBarang.doClick();
            }
            //                lastX = getX();
            //                lastY = getY();
            dispose();

        }
         
        

    }//GEN-LAST:event_btnCancelBarangActionPerformed

    private void pilihKategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pilihKategoriActionPerformed
//        if (evt.getSource()==pilihKategori) {//untuk membuat double klik
           
         if(dialogKategori.isVisible()){//logika untuk memunculkan jinternalframe hanya sekali
                dialogKategori.toFront();//memindahkan JInternalFrame ke depan sehingga menjadi aktif dan fokus.

            }else{
                dialogKategori.setLocationRelativeTo(dashboard);
                dialogKategori.setVisible(true);
                dialogKategori.setModal(true);
                dialogKategori.pack();
        }
    }//GEN-LAST:event_pilihKategoriActionPerformed

    private void pilihSatuanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pilihSatuanActionPerformed
        if(dialogSatuan.isVisible()){//logika untuk memunculkan jinternalframe hanya sekali
                dialogSatuan.toFront();//memindahkan JInternalFrame ke depan sehingga menjadi aktif dan fokus.

            }else{
                dialogSatuan.setLocationRelativeTo(dashboard);
                dialogSatuan.setVisible(true);
                dialogSatuan.setModal(true);
                dialogSatuan.pack();
        }
    }//GEN-LAST:event_pilihSatuanActionPerformed

    private void tblDialogBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDialogBarangMouseClicked
        txtDialogBarang.setText("");
        int tabelBarang = tblDialogBarang.getSelectedRow();
        if (evt.getClickCount() == 2 && !evt.isConsumed()) {
            kdBarang = tblDialogBarang.getValueAt(tabelBarang, 0).toString();
            nmBarang = tblDialogBarang.getValueAt(tabelBarang, 1).toString();
            ktgBarang = tblDialogBarang.getValueAt(tabelBarang, 2).toString();
//            jmlBarang = tblDialogBarang.getValueAt(tabelBarang, 3).toString();
            stBarang= tblDialogBarang.getValueAt(tabelBarang, 3).toString();
            itemTerpilih();
            dialogBarang.dispose();
            pilihKategori.setEnabled(false);
            pilihSatuan.setEnabled(false);
        }
    }//GEN-LAST:event_tblDialogBarangMouseClicked

    private void tblDialogSatuanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDialogSatuanMouseClicked
        txtSearchDialogSatuan.setText("");
        int tabelBarang = tblDialogSatuan.getSelectedRow();
        if (evt.getClickCount() == 2 && !evt.isConsumed()) {
           pilSatuan = tblDialogSatuan.getValueAt(tabelBarang, 0).toString();
           txtSatuan.setText(pilSatuan);
           dialogSatuan.dispose();
        }
    }//GEN-LAST:event_tblDialogSatuanMouseClicked

    private void tblDialogKategoriMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDialogKategoriMouseClicked
        
        txtSearchDialogKategori.setText("");
        int tabelBarang = tblDialogKategori.getSelectedRow();
        if (evt.getClickCount() == 2 && !evt.isConsumed()) {
           pilKategori = tblDialogKategori.getValueAt(tabelBarang, 0).toString();
           txtKategori.setText(pilKategori);
           dialogKategori.dispose();
        }
    }//GEN-LAST:event_tblDialogKategoriMouseClicked

      public void itemTerpilih(){
//        listbarang = new ListBarang();
//        listbarang.barang = this;
//        dialogBarang = new DialogBarang1(dashboard, true);
//        dialogBarang.barang = this;
        lbl_id.setText(id);
        txtKodeBarang.setText(kdBarang);
        txtNamaBarang.setText(nmBarang);
        txtKategori.setText(ktgBarang);
//        txtJumlah.setText(jmlBarang);
        txtSatuan.setText(stBarang);
        btnEdit.setEnabled(true);
        btnVoid.setEnabled(true);
    }
      
    
     public void Simpan() throws IOException{
        try {
             Connection conn = (Connection) con.connectionSQL();
             conn.setAutoCommit(false);
             
            String kodeBarang = txtKodeBarang.getText();
            String namaBarang = txtNamaBarang.getText().toUpperCase();
            String kategoriBarang = txtKategori.getText().toUpperCase();
//            String jumlahBarang = txtJumlah.getText();
            String satuanBarang = txtSatuan.getText().toUpperCase();
             
              if(kodeBarang.isBlank() || namaBarang.isBlank() || kategoriBarang.isBlank() || satuanBarang.isBlank()){
                  
                String sql = "INSERT INTO barang (kode_barang, nama_barang, idkategori, quality_barang, idsatuan, status_barang) VALUES (?, ?, ?, ?, ?, ?)";
             
                PreparedStatement preparedstatement = conn.prepareStatement(sql);
                preparedstatement.setString(1, kodeBarang);
                preparedstatement.setString(2, namaBarang);
                preparedstatement.setString(3, kategoriBarang);
                preparedstatement.setString(4, "0");
                preparedstatement.setString(5, satuanBarang);
                preparedstatement.setString(6, "AKTIF");
             
             
                preparedstatement.executeUpdate();
                preparedstatement.close();
                conn.rollback();
                JOptionPane.showMessageDialog(null, "Ada kolom yang belum di isi");
                
               }else if(kodeBarang.isBlank() & namaBarang.isBlank() & kategoriBarang.isBlank() & satuanBarang.isBlank()){
                   
                JOptionPane.showMessageDialog(null, "Ada kolom yang belum di isi !!!");
                   
               }else{
                  
                String sql = "INSERT INTO barang (kode_barang, nama_barang, idkategori, quality_barang, idsatuan, status_barang) VALUES (?, ?, ?, ?, ?, ?)";

                PreparedStatement saveStatement = conn.prepareStatement(sql);
                saveStatement.setString(1, kodeBarang);
                saveStatement.setString(2, namaBarang);
                saveStatement.setString(3, kategoriBarang);
                saveStatement.setString(4, "0");
                saveStatement.setString(5, satuanBarang);
                saveStatement.setString(6, "AKTIF");

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
             
            String kodeBarang = txtKodeBarang.getText();
            String namaBarang = txtNamaBarang.getText().toUpperCase();
            String kategoriBarang = txtKategori.getText().toUpperCase();
//            String jumlahBarang = txtJumlah.getText();
            String satuanBarang = txtSatuan.getText().toUpperCase();
             
              if(kodeBarang.isBlank() || namaBarang.isBlank() || kategoriBarang.isBlank() || satuanBarang.isBlank()){
                  
                    String sql = "UPDATE barang SET kode_barang = ?, nama_barang = ?, idkategori = ?, idsatuan = ? WHERE kode_barang = ?";
             
                    PreparedStatement editStatement = conn.prepareStatement(sql);
                    editStatement.setString(1, kodeBarang);
                    editStatement.setString(2, namaBarang);
                    editStatement.setString(3, kategoriBarang);
//                    editStatement.setString(4, "0");
                    editStatement.setString(4, satuanBarang); 
                    editStatement.setString(5, kodeBarang);
                    
             
                    editStatement.executeUpdate();
                    editStatement.close();
                    conn.rollback();
                    JOptionPane.showMessageDialog(null, "Ada kolom yang belum di isi");
                
               }else if(kodeBarang.isBlank() & namaBarang.isBlank() & kategoriBarang.isBlank() & satuanBarang.isBlank()){
                   JOptionPane.showMessageDialog(null, "Ada kolom yang belum di isi");
               }
              else{

                    String sql = "UPDATE barang SET kode_barang = ?, nama_barang = ?, idkategori = ?, idsatuan = ? WHERE kode_barang = ?";
             
                    PreparedStatement updatestatement = conn.prepareStatement(sql);
                    updatestatement.setString(1, kodeBarang);
                    updatestatement.setString(2, namaBarang);
                    updatestatement.setString(3, kategoriBarang);
//                    updatestatement.setString(4, "0");
                    updatestatement.setString(4, satuanBarang); 
                    updatestatement.setString(5, kodeBarang);
             
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
             
             String kodeBarang = txtKodeBarang.getText().toUpperCase();
             
             String sql = "DELETE FROM barang WHERE kode_barang = ?";
             
             PreparedStatement deleteStatement = conn.prepareStatement(sql);
             deleteStatement.setString(1, kodeBarang);
             
             deleteStatement.executeUpdate();
             deleteStatement.close();
             conn.commit();
             conn.close();
             
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error saat menghapus !!!" + e);
        }
    }
    public void kosong(){
        txtKodeBarang.setText("");
        txtNamaBarang.setText("");
        txtKategori.setText("");
//        txtJumlah.setText("");
        txtSatuan.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelBarang;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnList;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrevious;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSaveBarang;
    private javax.swing.JButton btnVoid;
    private javax.swing.JDialog dialogBarang;
    private javax.swing.JDialog dialogKategori;
    private javax.swing.JDialog dialogSatuan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JScrollPane jspDialogBarang;
    private javax.swing.JLabel lbl_id;
    private javax.swing.JLabel lbl_id_max;
    private javax.swing.JLabel lbl_id_min;
    private javax.swing.JButton pilihKategori;
    private javax.swing.JButton pilihSatuan;
    private javax.swing.JTable tblDialogBarang;
    private javax.swing.JTable tblDialogKategori;
    private javax.swing.JTable tblDialogSatuan;
    private javax.swing.JTextField txtDialogBarang;
    private javax.swing.JTextField txtKategori;
    private javax.swing.JTextField txtKodeBarang;
    private javax.swing.JTextField txtNamaBarang;
    private javax.swing.JTextField txtSatuan;
    private javax.swing.JTextField txtSearchDialogKategori;
    private javax.swing.JTextField txtSearchDialogSatuan;
    // End of variables declaration//GEN-END:variables

    //untuk Dialog Barang
    public void tampilTabel(){
        
        dftDialogBarang = (DefaultTableModel) tblDialogBarang.getModel();
        tblDialogBarang.setRowHeight(25);
     
        try {
             Connection conn = (Connection) con.connectionSQL();
             Statement  statement = conn.createStatement();
             ResultSet resultset = statement.executeQuery("SELECT kode_barang, nama_barang, idkategori, idkategori, quality_barang, idsatuan FROM barang");
             while(resultset.next())
                
                dftDialogBarang.addRow(new Object[]{
                resultset.getString("kode_barang"),
                resultset.getString("nama_barang"),
                resultset.getString("idkategori"),
                resultset.getString("quality_barang"),
                resultset.getString("idsatuan"),
                });
                tblDialogBarang.setModel(dftDialogBarang);
            
         } catch (Exception e) {
             JOptionPane.showMessageDialog(null, " Gagal Tersimpan !!! " + e);
                }
            }
     
    private void filterListUser(){ //Method Membuat Filter di Jtable
        
            txtDialogBarang.setPreferredSize(new Dimension(250, 25));
            txtDialogBarang.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                changedUpdate(e);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                changedUpdate(e);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                getRowSorter().setRowFilter(RowFilter.regexFilter(txtDialogBarang.getText().toUpperCase()));
            }
        });
            tampilTabel();
             filtering = new TableRowSorter<>(dftDialogBarang);
             tblDialogBarang.setRowSorter(getRowSorter());
         }
            
        private TableRowSorter getRowSorter(){
        if(filtering == null){
            filtering = new TableRowSorter(dftDialogBarang);
        }
        return filtering;
    }
        
     //untuk Dialog Kategori       
    public void tampilTabelKategori(){
        
        dftDialogKategori = (DefaultTableModel) tblDialogKategori.getModel();
        tblDialogKategori.setRowHeight(25);
     
        try {
             Connection conn = (Connection) con.connectionSQL();
             Statement  statement = conn.createStatement();
             ResultSet resultset = statement.executeQuery("SELECT nama_kategori FROM kategori");
             while(resultset.next())
                
                dftDialogKategori.addRow(new Object[]{
//                resultset.getString("kode_kategori"),
                resultset.getString("nama_kategori"),
                });
                tblDialogKategori.setModel(dftDialogKategori);
                
            
         } catch (Exception e) {
             JOptionPane.showMessageDialog(null, " Gagal di Tampilkan !!! " + e);
                }
            }
    
    
    private void filterDialogKategori(){ //Method Membuat Filter di Jtable
        
            txtSearchDialogKategori.setPreferredSize(new Dimension(250, 25));
            txtSearchDialogKategori.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                changedUpdate(e);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                changedUpdate(e);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                getRowSorterKategori().setRowFilter(RowFilter.regexFilter(txtSearchDialogKategori.getText().toUpperCase()));
            }
        });
            
            tampilTabelKategori();
             filtering = new TableRowSorter<>(dftDialogKategori);
             tblDialogKategori.setRowSorter(getRowSorterKategori());
         }
            
        private TableRowSorter getRowSorterKategori(){
        if(filtering == null){
            filtering = new TableRowSorter(dftDialogKategori);
        }
        return filtering;
    }
      
    
        //untuk Tabel Satuan
        public void tampilTabelSatuan(){
        
        dftDialogSatuan = (DefaultTableModel) tblDialogSatuan.getModel();
        tblDialogSatuan.setRowHeight(25);
     
        try {
             Connection conn = (Connection) con.connectionSQL();
             Statement  statement = conn.createStatement();
             ResultSet resultset = statement.executeQuery("SELECT  namasatuan FROM satuan");
             while(resultset.next())
                
                dftDialogSatuan.addRow(new Object[]{
//                resultset.getString("idsatuan"),
                resultset.getString("namasatuan"),
                });
                tblDialogSatuan.setModel(dftDialogSatuan);
                
            
         } catch (Exception e) {
             JOptionPane.showMessageDialog(null, " Gagal di Tampilkan !!! " + e);
                }
            }
    
    
    private void filterDialogSatuan(){ //Method Membuat Filter di Jtable
        
            txtSearchDialogSatuan.setPreferredSize(new Dimension(250, 25));
            txtSearchDialogSatuan.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                changedUpdate(e);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                changedUpdate(e);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                getRowSorterSatuan().setRowFilter(RowFilter.regexFilter(txtSearchDialogSatuan.getText().toUpperCase()));
            }
        });
            
            tampilTabelSatuan();
             filtering = new TableRowSorter<>(dftDialogSatuan);
             tblDialogSatuan.setRowSorter(getRowSorterSatuan());
         }
            
        private TableRowSorter getRowSorterSatuan(){
        if(filtering == null){
            filtering = new TableRowSorter(dftDialogSatuan);
        }
        return filtering;
    }
}
