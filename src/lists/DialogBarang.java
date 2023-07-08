/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package lists;

import java.awt.Dimension;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import menu.Barang;
//import koneksi.Koneksi1;

/**
 *
 * @author AMF
 */
public class DialogBarang extends javax.swing.JDialog {

    private DefaultTableModel dftDialogSupplier;
    private TableRowSorter filtering;
    public Barang barang = null ;
    connection.koneksi con;
   
    public DialogBarang(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        filterDialogSupplier();
    }

    public void tampilTabel(){
        
        dftDialogSupplier = (DefaultTableModel) tableDialogBarang.getModel();
        tableDialogBarang.setRowHeight(25);
     
        try {
             Connection conn = (Connection) con.connectionSQL();
             Statement  statement = conn.createStatement();
             ResultSet resultset = statement.executeQuery("SELECT kode_barang, nama_barang FROM barang");
             while(resultset.next())
                
                dftDialogSupplier.addRow(new Object[]{
                resultset.getString("kode_barang"),
                resultset.getString("nama_barang"),
                });
                tableDialogBarang.setModel(dftDialogSupplier);
                
            
         } catch (Exception e) {
             JOptionPane.showMessageDialog(null, " Gagal di Tampilkan !!! " + e);
                }
            }
    
    
    private void filterDialogSupplier(){ //Method Membuat Filter di Jtable
        
            txtSearchDialogBarang.setPreferredSize(new Dimension(250, 25));
            txtSearchDialogBarang.getDocument().addDocumentListener(new DocumentListener() {
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
                getRowSorter().setRowFilter(RowFilter.regexFilter(txtSearchDialogBarang.getText().toUpperCase()));
            }
        });
            
            tampilTabel();
             filtering = new TableRowSorter<>(dftDialogSupplier);
             tableDialogBarang.setRowSorter(getRowSorter());
         }
            
        private TableRowSorter getRowSorter(){
        if(filtering == null){
            filtering = new TableRowSorter(dftDialogSupplier);
        }
        return filtering;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableDialogBarang = new javax.swing.JTable();
        txtSearchDialogBarang = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 26, Short.MAX_VALUE)
        );

        jScrollPane1.setPreferredSize(new java.awt.Dimension(301, 80));

        tableDialogBarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kode", "Nama"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableDialogBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableDialogBarangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableDialogBarang);
        if (tableDialogBarang.getColumnModel().getColumnCount() > 0) {
            tableDialogBarang.getColumnModel().getColumn(0).setMaxWidth(100);
        }

        jLabel1.setText("Search");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSearchDialogBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearchDialogBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableDialogBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDialogBarangMouseClicked
        int tabelBarang = tableDialogBarang.getSelectedRow();
        barang.kdBarang = tableDialogBarang.getValueAt(tabelBarang, 0).toString();
        barang.nmBarang = tableDialogBarang.getValueAt(tabelBarang, 1).toString();
//        barang.ktgBarang = tableDialogBarang.getValueAt(tabelBarang, 2).toString();
//        barang.jmlBarang = tableDialogBarang.getValueAt(tabelBarang, 3).toString();
//        barang.stBarang= tableDialogBarang.getValueAt(tabelBarang, 4).toString();
        barang.itemTerpilih();
        barang.toFront();
    }//GEN-LAST:event_tableDialogBarangMouseClicked

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
            java.util.logging.Logger.getLogger(DialogBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DialogBarang dialog = new DialogBarang(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableDialogBarang;
    private javax.swing.JTextField txtSearchDialogBarang;
    // End of variables declaration//GEN-END:variables
}
