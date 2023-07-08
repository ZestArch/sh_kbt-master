/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import menu.Dashboard;
import menu.User;

/**
 *
 * @author AMF
 */
public class Navigator extends javax.swing.JDialog {

    public User user;
    public Konsumen konsumen;
    Dashboard dashboard;
    public Navigator(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        user = new User();
        konsumen = new Konsumen();
        execute();
    }

     private void execute(){
        user = new User();
        konsumen = new Konsumen();
        
        ImageIcon iconMenuSh = new ImageIcon(getClass().getResource("/gambar/menuSh.png"));
        ImageIcon iconMenuKbt = new ImageIcon(getClass().getResource("/gambar/menuKbt.png"));
        ImageIcon iconMenus = new ImageIcon(getClass().getResource("/gambar/menus.png"));
        ImageIcon iconSubmenuSh = new ImageIcon(getClass().getResource("/gambar/submenu1.png"));
        ImageIcon iconSubmenuKbt = new ImageIcon(getClass().getResource("/gambar/submenu2.png"));
        
        
            DropDownNavigator purchaseOrderSh = new DropDownNavigator(iconSubmenuSh, "Purchase Order", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
//              listUser.user = this;
            dashboard.jdeskDash.add(user).setVisible(true);
            user.setResizable(false);
            user.toFront();
            }
               
           });
             
             DropDownNavigator suratJalanSh = new DropDownNavigator(iconSubmenuSh, "Surat Jalan", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
//                 getDesktopPane().add(user).setVisible(true);
//                if(konsumen.isVisible()){//logika untuk memunculkan jinternalframe hanya sekali
//            konsumen.toFront();//memindahkan JInternalFrame ke depan sehingga menjadi aktif dan fokus.
//
//            }else{
//                //    setLocation(lastX, lastY);
//                
//                jdeskDash.add(konsumen).setVisible(true);
//                konsumen.setVisible(true);
//                konsumen.setResizable(false);
//                konsumen.toFront();
//            }
            }
               
           });
             
             DropDownNavigator fakturSh = new DropDownNavigator(iconSubmenuSh, "Faktur", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
//                 getDesktopPane().add(user).setVisible(true);
//                if(konsumen.isVisible()){//logika untuk memunculkan jinternalframe hanya sekali
//            konsumen.toFront();//memindahkan JInternalFrame ke depan sehingga menjadi aktif dan fokus.
//
//            }else{
//                //    setLocation(lastX, lastY);
//                
//                jdeskDash.add(konsumen).setVisible(true);
//                konsumen.setVisible(true);
//                konsumen.setResizable(false);
//                konsumen.toFront();
//            }
            }
               
           });
             
             DropDownNavigator returPenjualanSh = new DropDownNavigator(iconSubmenuSh, "Retur Penjualan", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
//                 getDesktopPane().add(user).setVisible(true);
//                if(konsumen.isVisible()){//logika untuk memunculkan jinternalframe hanya sekali
//            konsumen.toFront();//memindahkan JInternalFrame ke depan sehingga menjadi aktif dan fokus.
//
//            }else{
//                //    setLocation(lastX, lastY);
//                
//                jdeskDash.add(konsumen).setVisible(true);
//                konsumen.setVisible(true);
//                konsumen.setResizable(false);
//                konsumen.toFront();
//            }
            }
               
           });
             
        
             DropDownNavigator penjualanSh = new DropDownNavigator(iconMenus, "Penjualan", null, purchaseOrderSh, suratJalanSh, fakturSh, returPenjualanSh );
             
             
               
             
             DropDownNavigator penerimaanBarangSh = new DropDownNavigator(iconSubmenuSh, "Penerimaan Barang", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
//                 getDesktopPane().add(user).setVisible(true);
//                if(konsumen.isVisible()){//logika untuk memunculkan jinternalframe hanya sekali
//            konsumen.toFront();//memindahkan JInternalFrame ke depan sehingga menjadi aktif dan fokus.
//
//            }else{
//                //    setLocation(lastX, lastY);
//                
//                jdeskDash.add(konsumen).setVisible(true);
//                konsumen.setVisible(true);
//                konsumen.setResizable(false);
//                konsumen.toFront();
//            }
            }
               
           });
             
             DropDownNavigator ReturPembelian = new DropDownNavigator(iconSubmenuSh, "Retur Pembelian", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
//                 getDesktopPane().add(user).setVisible(true);
//                if(konsumen.isVisible()){//logika untuk memunculkan jinternalframe hanya sekali
//            konsumen.toFront();//memindahkan JInternalFrame ke depan sehingga menjadi aktif dan fokus.
//
//            }else{
//                //    setLocation(lastX, lastY);
//                
//                jdeskDash.add(konsumen).setVisible(true);
//                konsumen.setVisible(true);
//                konsumen.setResizable(false);
//                konsumen.toFront();
//            }
            }
               
           });
             
             
             DropDownNavigator PembelianSh = new DropDownNavigator(iconMenus, "Pembelian", null, penerimaanBarangSh, ReturPembelian);
             
             DropDownNavigator daftarPurchaseOrderSh = new DropDownNavigator(iconSubmenuSh, "Daftar Purchase Order", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
//                 getDesktopPane().add(user).setVisible(true);
//                if(konsumen.isVisible()){//logika untuk memunculkan jinternalframe hanya sekali
//            konsumen.toFront();//memindahkan JInternalFrame ke depan sehingga menjadi aktif dan fokus.
//
//            }else{
//                //    setLocation(lastX, lastY);
//                
//                jdeskDash.add(konsumen).setVisible(true);
//                konsumen.setVisible(true);
//                konsumen.setResizable(false);
//                konsumen.toFront();
//            }
            }
               
           });
             
             DropDownNavigator daftarSuratjalanSh = new DropDownNavigator(iconSubmenuSh, "Daftar Surat Jalan", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
//                 getDesktopPane().add(user).setVisible(true);
//                if(konsumen.isVisible()){//logika untuk memunculkan jinternalframe hanya sekali
//            konsumen.toFront();//memindahkan JInternalFrame ke depan sehingga menjadi aktif dan fokus.
//
//            }else{
//                //    setLocation(lastX, lastY);
//                
//                jdeskDash.add(konsumen).setVisible(true);
//                konsumen.setVisible(true);
//                konsumen.setResizable(false);
//                konsumen.toFront();
//            }
            }
               
           });
             
             DropDownNavigator daftarFakturSh = new DropDownNavigator(iconSubmenuSh, "Daftar Faktur", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
//                 getDesktopPane().add(user).setVisible(true);
//                if(konsumen.isVisible()){//logika untuk memunculkan jinternalframe hanya sekali
//            konsumen.toFront();//memindahkan JInternalFrame ke depan sehingga menjadi aktif dan fokus.
//
//            }else{
//                //    setLocation(lastX, lastY);
//                
//                jdeskDash.add(konsumen).setVisible(true);
//                konsumen.setVisible(true);
//                konsumen.setResizable(false);
//                konsumen.toFront();
//            }
            }
               
           });
             
             DropDownNavigator daftarReturPenjualanSh = new DropDownNavigator(iconSubmenuSh, "Daftar Retur Penjualan", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
//                 getDesktopPane().add(user).setVisible(true);
//                if(konsumen.isVisible()){//logika untuk memunculkan jinternalframe hanya sekali
//            konsumen.toFront();//memindahkan JInternalFrame ke depan sehingga menjadi aktif dan fokus.
//
//            }else{
//                //    setLocation(lastX, lastY);
//                
//                jdeskDash.add(konsumen).setVisible(true);
//                konsumen.setVisible(true);
//                konsumen.setResizable(false);
//                konsumen.toFront();
//            }
            }
               
           });
             
             DropDownNavigator daftarPenerimaanBarangSh = new DropDownNavigator(iconSubmenuSh, "Daftar Penerimaan Barang", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
//                 getDesktopPane().add(user).setVisible(true);
//                if(konsumen.isVisible()){//logika untuk memunculkan jinternalframe hanya sekali
//            konsumen.toFront();//memindahkan JInternalFrame ke depan sehingga menjadi aktif dan fokus.
//
//            }else{
//                //    setLocation(lastX, lastY);
//                
//                jdeskDash.add(konsumen).setVisible(true);
//                konsumen.setVisible(true);
//                konsumen.setResizable(false);
//                konsumen.toFront();
//            }
            }
               
           });
             
             DropDownNavigator daftarReturPembelianSh = new DropDownNavigator(iconSubmenuSh, "Daftar Retur Pembelian", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
//                 getDesktopPane().add(user).setVisible(true);
//                if(konsumen.isVisible()){//logika untuk memunculkan jinternalframe hanya sekali
//            konsumen.toFront();//memindahkan JInternalFrame ke depan sehingga menjadi aktif dan fokus.
//
//            }else{
//                //    setLocation(lastX, lastY);
//                
//                jdeskDash.add(konsumen).setVisible(true);
//                konsumen.setVisible(true);
//                konsumen.setResizable(false);
//                konsumen.toFront();
//            }
            }
               
           });
             
             DropDownNavigator DaftarSh = new DropDownNavigator(iconMenus, "Daftar SH", null, daftarPurchaseOrderSh, daftarSuratjalanSh, daftarFakturSh, daftarReturPenjualanSh, daftarPenerimaanBarangSh, daftarReturPembelianSh);
             
    DropDownNavigator sh = new DropDownNavigator(iconMenuSh, "SH", null, penjualanSh, PembelianSh, DaftarSh);
            
            DropDownNavigator penjualanKbt = new DropDownNavigator(iconSubmenuSh, "Penjualan", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
//                 getDesktopPane().add(user).setVisible(true);
//                if(konsumen.isVisible()){//logika untuk memunculkan jinternalframe hanya sekali
//            konsumen.toFront();//memindahkan JInternalFrame ke depan sehingga menjadi aktif dan fokus.
//
//            }else{
//                //    setLocation(lastX, lastY);
//                
//                jdeskDash.add(konsumen).setVisible(true);
//                konsumen.setVisible(true);
//                konsumen.setResizable(false);
//                konsumen.toFront();
//            }
            }
               
           });
             
             DropDownNavigator PembelianKbt = new DropDownNavigator(iconSubmenuKbt, "Pembelian", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(user.isVisible()){//logika untuk memunculkan jinternalframe hanya sekali
            user.toFront();//memindahkan JInternalFrame ke depan sehingga menjadi aktif dan fokus.

            }else{
                //    setLocation(lastX, lastY);
                
//               jdeskDash.add(user).setVisible(true);
                user.setVisible(true);
                user.setResizable(false);
                user.toFront();
            }
            }
               
           });
             
             DropDownNavigator DaftarKbt = new DropDownNavigator(iconSubmenuKbt, "Daftar KBT", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(user.isVisible()){//logika untuk memunculkan jinternalframe hanya sekali
            user.toFront();//memindahkan JInternalFrame ke depan sehingga menjadi aktif dan fokus.

            }else{
                //    setLocation(lastX, lastY);
                
//               jdeskDash.add(user).setVisible(true);
                user.setVisible(true);
                user.setResizable(false);
                user.toFront();
            }
            }
               
           });
            
            DropDownNavigator kbt = new DropDownNavigator(iconMenuKbt, "KBT", null, penjualanKbt, PembelianKbt, DaftarKbt);
            addMenu(sh, kbt);

    }
    
    private void addMenu(DropDownNavigator...menu){
        for(int i=0; i<menu.length; i++){
            pnlNavigasi.add(menu[i]);
            ArrayList<DropDownNavigator>subMenu=menu[i].getSubMenu();
            for(DropDownNavigator m:subMenu)
                addMenu(m);
        }
        pnlNavigasi.revalidate();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jscrolpaneNavigator = new javax.swing.JScrollPane();
        pnlNavigasi = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Navigator");
        setBackground(new java.awt.Color(255, 255, 255));

        pnlNavigasi.setLayout(new javax.swing.BoxLayout(pnlNavigasi, javax.swing.BoxLayout.Y_AXIS));
        jscrolpaneNavigator.setViewportView(pnlNavigasi);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jscrolpaneNavigator, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jscrolpaneNavigator, javax.swing.GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Navigator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Navigator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Navigator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Navigator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Navigator dialog = new Navigator(new javax.swing.JFrame(), true);
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
    private javax.swing.JScrollPane jscrolpaneNavigator;
    private javax.swing.JPanel pnlNavigasi;
    // End of variables declaration//GEN-END:variables
}
