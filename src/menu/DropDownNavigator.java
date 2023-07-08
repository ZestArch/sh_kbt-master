
package menu;

import java.awt.Dimension;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import javax.swing.Icon;

public class DropDownNavigator extends javax.swing.JPanel {

    private final ArrayList<DropDownNavigator>subMenu = new ArrayList<>();
    private ActionListener act;
    
    public DropDownNavigator(Icon icon, String menuName, ActionListener act, DropDownNavigator...subMenu) {
        initComponents();
        lblIcon.setIcon(icon);
        lblName.setText(menuName);
        if(act!=null){
            this.act=act;
        }
        this.setSize(new Dimension(Integer.MAX_VALUE, 35));
        this.setMaximumSize(new Dimension(Integer.MAX_VALUE, 35));
        this.setMinimumSize(new Dimension(Integer.MAX_VALUE, 35));
        for(int i=0; i<subMenu.length; i++){
            this.subMenu.add(subMenu[i]);
            subMenu[i].setVisible(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        lblIcon = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(200, 29));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });

        lblIcon.setBackground(new java.awt.Color(255, 255, 255));

        lblName.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblName, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIcon, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                    .addComponent(lblName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private boolean showing=false;
    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
    if(showing){
         hideMenu();
         
     }else{
         showMenu();
         
     }
      if (act != null) {
            act.actionPerformed(null);
        }
    }//GEN-LAST:event_formMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblIcon;
    private javax.swing.JLabel lblName;
    // End of variables declaration//GEN-END:variables

private void showMenu(){
       new Thread(new Runnable() {
           @Override
           public void run() {
               for(int i=0; i<subMenu.size(); i++){
                sleep();
                subMenu.get(i).setVisible(true);
               }
               showing = true;
               getParent().repaint();
               getParent().revalidate();
               }
       }).start();
   }
   
    private void hideMenu(){
        new Thread(new Runnable() {
           @Override
           public void run() {
               for(int i=subMenu.size()-1; i>=0; i--){
                sleep();
                subMenu.get(i).setVisible(false);
                subMenu.get(i).hideMenu();
               }
               getParent().repaint();
               getParent().revalidate();
               showing = false;
               }
       }).start();
   }
    
    private void sleep(){
        try {
            Thread.sleep(20);
        } catch (Exception e) {
        }
    }
    
    public ArrayList<DropDownNavigator> getSubMenu() {
        return subMenu;
    }

     public void setShowing(boolean showing) {
        this.showing = showing;
    }
}
