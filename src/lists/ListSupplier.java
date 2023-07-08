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
import menu.Dashboard;
import menu.Supplier;
import menu.User;


public class ListSupplier extends javax.swing.JInternalFrame{
    private DefaultTableModel dftListSupplier;
    private TableRowSorter filtering;
    public Supplier supplier = null ;
    int row;


    connection.koneksi con;
    public ListSupplier() {
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
             ResultSet resultset = statement.executeQuery("SELECT kode_supplier, nama_supplier, notlp_supplier, nohp_supplier, email_supplier, npwp_supplier FROM supplier");
             while(resultset.next())
                
                dftListSupplier.addRow(new Object[]{
                resultset.getString("kode_supplier"),
                resultset.getString("nama_supplier"),
                resultset.getString("notlp_supplier"),
                resultset.getString("nohp_supplier"),
                resultset.getString("email_supplier"),
                resultset.getString("npwp_supplier"),
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
                "Kode Supplier", "Nama Supplier", "Telephone", "Handphone", "Email", "Npwp"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
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

        jPanel2.setPreferredSize(new java.awt.Dimension(639, 25));

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
                .addComponent(jspListSupplier, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
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
    supplier.kdSupplier = tblListSupplier.getValueAt(tabelBarang, 0).toString();
    supplier.nmSupplier = tblListSupplier.getValueAt(tabelBarang, 1).toString();
    supplier.tlpSupplier = tblListSupplier.getValueAt(tabelBarang, 2).toString();
    supplier.hpSupplier = tblListSupplier.getValueAt(tabelBarang, 3).toString();
    supplier.emSupplier= tblListSupplier.getValueAt(tabelBarang, 4).toString();
    supplier.npSupplier = tblListSupplier.getValueAt(tabelBarang, 5).toString();
    supplier.itemTerpilih();
    supplier.toFront();
    }//GEN-LAST:event_tblListSupplierMouseClicked

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
    private javax.swing.JScrollPane jspListSupplier;
    private javax.swing.JTable tblListSupplier;
    private javax.swing.JTextField txtsearchListSupplier;
    // End of variables declaration//GEN-END:variables
}
