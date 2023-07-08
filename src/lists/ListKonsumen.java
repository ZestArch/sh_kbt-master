/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package lists;

//import menu.JdeskDash;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.beans.PropertyVetoException;
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

import menu.Dashboard;
import menu.Konsumen;
import menu.User;


public class ListKonsumen extends javax.swing.JInternalFrame{
    private DefaultTableModel dftListKonsumen;
    private TableRowSorter filtering;
    public Konsumen konsumen = null ;
    int row;


    connection.koneksi con;
    public ListKonsumen() {
        initComponents();
        filterListUser();
        setMinimumSize(new Dimension(250,300));

    }

     public void tampilTabel(){
        
        dftListKonsumen = (DefaultTableModel) tblListKonsumen.getModel();
        tblListKonsumen.setRowHeight(25);
     
        try {
             Connection conn = (Connection) con.connectionSQL();
             Statement  statement = conn.createStatement();
             ResultSet resultset = statement.executeQuery("SELECT kode_konsumen, nama_konsumen, nama_perusahaan, alamat_konsumen, alamat_kirim,  nomor_npwp, nama_npwp, alamat_npwp, notlp_konsumen, nohp_konsumen, fax_konsumen, email_konsumen FROM konsumen");
             while(resultset.next())
                
                dftListKonsumen.addRow(new Object[]{
                resultset.getString("kode_konsumen"),
                resultset.getString("nama_konsumen"),
                resultset.getString("nama_perusahaan"),
                resultset.getString("alamat_konsumen"),
                resultset.getString("alamat_kirim"),
                resultset.getString("nomor_npwp"),
                resultset.getString("nama_npwp"),
                resultset.getString("alamat_npwp"),
                resultset.getString("notlp_konsumen"),
                resultset.getString("nohp_konsumen"),
                resultset.getString("fax_konsumen"),
                resultset.getString("email_konsumen"),
                
                });
                tblListKonsumen.setModel(dftListKonsumen);
            
         } catch (Exception e) {
             JOptionPane.showMessageDialog(null, " Gagal Tersimpan !!! " + e);
                }
            }
     
        private void filterListUser(){ //Method Membuat Filter di Jtable
        
            txtsearchListKonsumen.setPreferredSize(new Dimension(250, 25));
            txtsearchListKonsumen.getDocument().addDocumentListener(new DocumentListener() {
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
                getRowSorter().setRowFilter(RowFilter.regexFilter(txtsearchListKonsumen.getText().toUpperCase()));
            }
        });
            
            tampilTabel();
             filtering = new TableRowSorter<>(dftListKonsumen);
             tblListKonsumen.setRowSorter(getRowSorter());
         }
            
        private TableRowSorter getRowSorter(){
        if(filtering == null){
            filtering = new TableRowSorter(dftListKonsumen);
        }
        return filtering;
    }

        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtsearchListKonsumen = new javax.swing.JTextField();
        jspListKonsumen = new javax.swing.JScrollPane();
        tblListKonsumen = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("List Supplier");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        txtsearchListKonsumen.setPreferredSize(new java.awt.Dimension(64, 20));

        jspListKonsumen.setBackground(new java.awt.Color(255, 255, 255));

        tblListKonsumen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kode Konsumen", "Nama Konsumen", "Nama Perusahaan", "Alamat", "Alamat Kirim", "NPWP", "Nama NPWP", "Alamat NPWP", "Telephone", "Handphone", "Fax", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true, true, false, true, true, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblListKonsumen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblListKonsumenMouseClicked(evt);
            }
        });
        jspListKonsumen.setViewportView(tblListKonsumen);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Search");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 639, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
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
                .addComponent(txtsearchListKonsumen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(73, 73, 73))
            .addComponent(jspListKonsumen, javax.swing.GroupLayout.DEFAULT_SIZE, 639, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtsearchListKonsumen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(jspListKonsumen, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
    
    private void tblListKonsumenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListKonsumenMouseClicked
    int tabelBarang = tblListKonsumen.getSelectedRow();
    konsumen.kdKonsumen = tblListKonsumen.getValueAt(tabelBarang, 0).toString();
    konsumen.nmKonsumen = tblListKonsumen.getValueAt(tabelBarang, 1).toString();
    konsumen.nmPerusahaan = tblListKonsumen.getValueAt(tabelBarang, 2).toString();
    konsumen.alKonsumen = tblListKonsumen.getValueAt(tabelBarang, 3).toString();
    konsumen.alkKonsumen= tblListKonsumen.getValueAt(tabelBarang, 4).toString();
    konsumen.npKonsumen = tblListKonsumen.getValueAt(tabelBarang, 5).toString();
    konsumen.nmNpwp = tblListKonsumen.getValueAt(tabelBarang, 6).toString();
    konsumen.alNpwp = tblListKonsumen.getValueAt(tabelBarang, 7).toString();
    konsumen.tlpKonsumen = tblListKonsumen.getValueAt(tabelBarang, 8).toString();
    konsumen.hpKonsumen = tblListKonsumen.getValueAt(tabelBarang, 9).toString();
    konsumen.faxKonsumen= tblListKonsumen.getValueAt(tabelBarang, 10).toString();
    konsumen.emKonsumen = tblListKonsumen.getValueAt(tabelBarang, 11).toString();
    konsumen.itemTerpilih();
    konsumen.toFront();
    }//GEN-LAST:event_tblListKonsumenMouseClicked

//        public void TampilNext(){
//row = tblListUser.getSelectedRow();
//int b= dftListUser.getRowCount();
//b-=1;
//if(row==b){
//row=b;
//}
//else
//{
//row+=1;
//}
//
//tblListUser.changeSelection(row, WIDTH, false, false);
//}
//public void TampilPrev(){
//row = tblListUser.getSelectedRow();
//int b= dftListUser.getRowCount();
//if(row==0){
//row=0;
//}
//else
//{
//row-=1;
//}
//    tblListUser.changeSelection(row, WIDTH, false, false);
//}
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jspListKonsumen;
    private javax.swing.JTable tblListKonsumen;
    private javax.swing.JTextField txtsearchListKonsumen;
    // End of variables declaration//GEN-END:variables
}
