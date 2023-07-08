/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package lists;

//import menu.JdeskDash;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import connection.koneksi;
import menu.Dashboard;
import menu.Barang;



public class ListBarang extends javax.swing.JInternalFrame{
    private DefaultTableModel dftListSupplier;
    private TableRowSorter filtering;
    public Barang barang = null ;
    int row;

    koneksi con;
    public ListBarang() {
        initComponents();
        filterListUser();
        setMinimumSize(new Dimension(250,300));

    }

     public void tampilTabel(){
        
        dftListSupplier = (DefaultTableModel) tblListSupplier.getModel();
        tblListSupplier.setRowHeight(25);
     
        try {
             Connection conn = (Connection) con.connectionSQL();
             Statement  statement = conn.createStatement();
             ResultSet resultset = statement.executeQuery("SELECT kode_barang, nama_barang, idkategori, idkategori, quality_barang, idsatuan FROM barang");
             while(resultset.next())
                
                dftListSupplier.addRow(new Object[]{
                resultset.getString("kode_barang"),
                resultset.getString("nama_barang"),
                resultset.getString("idkategori"),
                resultset.getString("quality_barang"),
                resultset.getString("idsatuan"),
                });
                tblListSupplier.setModel(dftListSupplier);
            
         } catch (Exception e) {
             JOptionPane.showMessageDialog(null, " Gagal Tersimpan !!! " + e);
                }
            }
     
        private void filterListUser(){ //Method Membuat Filter di Jtable
        
            txtsearchListSupplier.setPreferredSize(new Dimension(250, 25));
            txtsearchListSupplier.getDocument().addDocumentListener(new DocumentListener() {
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
                getRowSorter().setRowFilter(RowFilter.regexFilter(txtsearchListSupplier.getText().toUpperCase()));
            }
        });
            
            tampilTabel();
             filtering = new TableRowSorter<>(dftListSupplier);
             tblListSupplier.setRowSorter(getRowSorter());
         }
            
        private TableRowSorter getRowSorter(){
        if(filtering == null){
            filtering = new TableRowSorter(dftListSupplier);
        }
        return filtering;
    }

        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtsearchListSupplier = new javax.swing.JTextField();
        jspListSupplier = new javax.swing.JScrollPane();
        tblListSupplier = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnAddSupplier = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("List Supplier");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        txtsearchListSupplier.setPreferredSize(new java.awt.Dimension(64, 20));

        jspListSupplier.setBackground(new java.awt.Color(255, 255, 255));

        tblListSupplier.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kode Barang", "Nama Barang", "Kategori", "Jumlah", "Satuan"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblListSupplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblListSupplierMouseClicked(evt);
            }
        });
        jspListSupplier.setViewportView(tblListSupplier);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Search");

        btnAddSupplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/add1_1.png"))); // NOI18N
        btnAddSupplier.setPreferredSize(new java.awt.Dimension(25, 25));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(btnAddSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnAddSupplier, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(txtsearchListSupplier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(73, 73, 73))
            .addComponent(jspListSupplier, javax.swing.GroupLayout.DEFAULT_SIZE, 639, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtsearchListSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(jspListSupplier, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
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
    
    private void tblListSupplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListSupplierMouseClicked
    int tabelBarang = tblListSupplier.getSelectedRow();
    barang.kdBarang = tblListSupplier.getValueAt(tabelBarang, 0).toString();
    barang.nmBarang = tblListSupplier.getValueAt(tabelBarang, 1).toString();
    barang.ktgBarang = tblListSupplier.getValueAt(tabelBarang, 2).toString();
    barang.jmlBarang = tblListSupplier.getValueAt(tabelBarang, 3).toString();
    barang.stBarang= tblListSupplier.getValueAt(tabelBarang, 4).toString();
    barang.itemTerpilih();
    barang.toFront();
    }//GEN-LAST:event_tblListSupplierMouseClicked

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddSupplier;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jspListSupplier;
    private javax.swing.JTable tblListSupplier;
    private javax.swing.JTextField txtsearchListSupplier;
    // End of variables declaration//GEN-END:variables
}
