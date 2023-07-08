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
import menu.User;


public class ListUser extends javax.swing.JInternalFrame{
    private DefaultTableModel dftListUser;
    private TableRowSorter filtering;
    public User user = null ;
    int row;


    connection.koneksi con;
    public ListUser() {
        initComponents();
        filterListUser();
        setMinimumSize(new Dimension(250,300));

    }

     public void tampilTabel(){
        
        dftListUser = (DefaultTableModel) tblListUser.getModel();
        tblListUser.setRowHeight(25);
     
        try {
             Connection conn = (Connection) con.connectionSQL();
             Statement  statement = conn.createStatement();
             ResultSet resultset = statement.executeQuery("SELECT iduser, kodeuser, namauser, statususer, passworduser FROM nama_user");
             while(resultset.next())
                
                dftListUser.addRow(new Object[]{
                resultset.getString("iduser"),
                resultset.getString("kodeuser"),
                resultset.getString("namauser"),
                resultset.getString("statususer"),
                resultset.getString("passworduser"),
                });
                tblListUser.setModel(dftListUser);
            
         } catch (Exception e) {
             JOptionPane.showMessageDialog(null, " Gagal Tersimpan !!! ");
                }
            }
     
        private void filterListUser(){ //Method Membuat Filter di Jtable
        
            txtsearchListUser.setPreferredSize(new Dimension(250, 25));
            txtsearchListUser.getDocument().addDocumentListener(new DocumentListener() {
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
                getRowSorter().setRowFilter(RowFilter.regexFilter(txtsearchListUser.getText().toUpperCase()));
            }
        });
            
            tampilTabel();
             filtering = new TableRowSorter<>(dftListUser);
             tblListUser.setRowSorter(getRowSorter());
         }
            
        private TableRowSorter getRowSorter(){
        if(filtering == null){
            filtering = new TableRowSorter(dftListUser);
        }
        return filtering;
    }

        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtsearchListUser = new javax.swing.JTextField();
        jspListUser = new javax.swing.JScrollPane();
        tblListUser = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnAddUser = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("List User");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        txtsearchListUser.setPreferredSize(new java.awt.Dimension(64, 20));

        jspListUser.setBackground(new java.awt.Color(255, 255, 255));

        tblListUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Kode User", "Nama User", "Status", "Password"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblListUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblListUserMouseClicked(evt);
            }
        });
        jspListUser.setViewportView(tblListUser);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Search");

        btnAddUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/add1_1.png"))); // NOI18N
        btnAddUser.setPreferredSize(new java.awt.Dimension(25, 25));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(btnAddUser, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnAddUser, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
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
                .addComponent(txtsearchListUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(73, 73, 73))
            .addComponent(jspListUser, javax.swing.GroupLayout.DEFAULT_SIZE, 639, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtsearchListUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(jspListUser, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
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
    
    private void tblListUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListUserMouseClicked
    int tabelBarang = tblListUser.getSelectedRow();
    user.id = tblListUser.getValueAt(tabelBarang, 0).toString();
    user.kdUser = tblListUser.getValueAt(tabelBarang, 1).toString();
    user.nmUser = tblListUser.getValueAt(tabelBarang, 2).toString();
    user.stUser = tblListUser.getValueAt(tabelBarang, 3).toString();
    user.pswUser = tblListUser.getValueAt(tabelBarang, 4).toString();
    
    user.itemTerpilih();
    
    user.toFront();
    }//GEN-LAST:event_tblListUserMouseClicked

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
    private javax.swing.JButton btnAddUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jspListUser;
    private javax.swing.JTable tblListUser;
    private javax.swing.JTextField txtsearchListUser;
    // End of variables declaration//GEN-END:variables
}
