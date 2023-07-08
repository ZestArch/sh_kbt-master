/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
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
public class Navigator2 extends javax.swing.JFrame {
    User user;
    /**
     * Creates new form Navigator2
     */
    public Navigator2() {
        initComponents();
         user = new User();
    }

     private void execute(){
    ImageIcon iconAdmin=new ImageIcon(getClass().getResource("/gambar/admin.png"));
        ImageIcon iconListMenu=new ImageIcon(getClass().getResource("/gambar/listmenu.png"));
        ImageIcon iconListSubMenu=new ImageIcon(getClass().getResource("/gambar/listsubmenu.png"));
        ImageIcon iconMasterData=new ImageIcon(getClass().getResource("/gambar/database.png"));
        ImageIcon iconListSubMenu2=new ImageIcon(getClass().getResource("/gambar/listsubmenu2.png"));
//        ImageIcon iconSubMenu=new ImageIcon(getClass().getResource("/menu/subMenu.png"));
//        ImageIcon iconNext=new ImageIcon(getClass().getResource("/menu/next.png"));
//        subMenu staff
        

        DropDownNavigator dataUser=new DropDownNavigator(iconListSubMenu2, "Data User",new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(user.isVisible()){//logika untuk memunculkan jinternalframe hanya sekali
            user.toFront();//memindahkan JInternalFrame ke depan sehingga menjadi aktif dan fokus.

            }else{
                //    setLocation(lastX, lastY);

               getContentPane().add(user).setVisible(true);
                user.setResizable(false);
                user.toFront();
            }
                
            }
        });
        
        
        DropDownNavigator dataList=new DropDownNavigator(iconListMenu, "Data Master",null, dataUser);
//        DropDownNavigator menuMasterData=new DropDownNavigator(iconMasterData, "MASTER DATA",null, dataSupplier, dataKonsumen, dataBarang);
       
        addMenu(dataList);
//        addMenu(menuAdmin, menuLaporan, menuMasterData);
    
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

        jScrollPane1 = new javax.swing.JScrollPane();
        pnlNavigasi = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlNavigasi.setLayout(new javax.swing.BoxLayout(pnlNavigasi, javax.swing.BoxLayout.LINE_AXIS));
        jScrollPane1.setViewportView(pnlNavigasi);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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
            java.util.logging.Logger.getLogger(Navigator2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Navigator2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Navigator2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Navigator2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Navigator2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlNavigasi;
    // End of variables declaration//GEN-END:variables
}
