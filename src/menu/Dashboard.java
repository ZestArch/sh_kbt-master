package menu;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */


import com.formdev.flatlaf.FlatIntelliJLaf;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
//import lists.ListUser;
import menu.User;
import menu.Barang;
import menu.Konsumen;
import menu.Supplier;
import lists.ListUser;
import lists.ListBarang;
import lists.ListKonsumen;
import lists.ListSupplier;
//import menu.Navigator1;
import view.frmConnection;


public class Dashboard extends javax.swing.JFrame {
    
//    private Navigator navigator;
    private User pengguna;
    private Barang barang;
    private Konsumen konsumen;
    private Supplier supplier;
    private ListUser listUser;
    private ListBarang listBarang;
    private ListKonsumen listKonsumen;
    private ListSupplier listSupplier;
    
    public Dashboard() {
        initComponents();
        setTitle("Tekno Bumi Padjadjaran");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(MAXIMIZED_BOTH);
        setMinimumSize(new Dimension(600,400));
//       ImageIcon iconNavigator = new ImageIcon("/gambar/navigator.png");
//        navigator.setIconImage(iconNavigator.getImage());
//        navigator.setAlwaysOnTop(true);
        navigator.setTitle("Navigator");
        pengguna = new User();
        barang = new Barang();
        konsumen = new Konsumen();
        supplier = new Supplier();
        listUser = new ListUser();
        listBarang = new ListBarang();
        listKonsumen = new ListKonsumen();
        listSupplier = new ListSupplier();
        
//        execute();
    
    }
    
    
    private void execute(){
        ImageIcon iconMenu = new ImageIcon(getClass().getResource("/gambar/menu.png"));
//        ImageIcon iconMenuKbt = new ImageIcon(getClass().getResource("/gambar/menuKbt.png"));
        ImageIcon iconPenjualan = new ImageIcon(getClass().getResource("/gambar/penjualan.png"));
        ImageIcon iconPembelian = new ImageIcon(getClass().getResource("/gambar/pembelian.png"));
        ImageIcon iconListMenu = new ImageIcon(getClass().getResource("/gambar/listmenu.png"));
        ImageIcon iconSubmenu = new ImageIcon(getClass().getResource("/gambar/submenu.png"));
//        ImageIcon iconSubmenuKbt = new ImageIcon(getClass().getResource("/gambar/submenu2.png"));
        
        
                DropDownNavigator purchaseOrderSh = new DropDownNavigator(iconSubmenu, "Purchase Order", new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

    //            if(pengguna.isVisible()){//logika untuk memunculkan jinternalframe hanya sekali
    //            pengguna.toFront();//memindahkan JInternalFrame ke depan sehingga menjadi aktif dan fokus.
    //            
    //            }else{
    ////            navigator.setModal(false);
    //            pengguna.setVisible(true);
    //            jdeskDash.add(pengguna);
    //            pengguna.setResizable(false);
    //            pengguna.toFront();
    //                    }
    //            
                    }

                });

                DropDownNavigator suratJalanSh = new DropDownNavigator(iconSubmenu, "Surat Jalan", new ActionListener() {
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

                DropDownNavigator fakturSh = new DropDownNavigator(iconSubmenu, "Faktur", new ActionListener() {
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

                DropDownNavigator returPenjualanSh = new DropDownNavigator(iconSubmenu, "Retur Penjualan", new ActionListener() {
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


            DropDownNavigator penjualanSh = new DropDownNavigator(iconPenjualan, "Penjualan SH", null, purchaseOrderSh, suratJalanSh, fakturSh, returPenjualanSh );


                DropDownNavigator penerimaanBarangSh = new DropDownNavigator(iconSubmenu, "Penerimaan Barang", new ActionListener() {
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

                DropDownNavigator ReturPembelian = new DropDownNavigator(iconSubmenu, "Retur Pembelian", new ActionListener() {
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


            DropDownNavigator PembelianSh = new DropDownNavigator(iconPembelian, "Pembelian SH", null, penerimaanBarangSh, ReturPembelian);



                DropDownNavigator daftarPurchaseOrderSh = new DropDownNavigator(iconSubmenu, "Daftar Purchase Order", new ActionListener() {
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

                DropDownNavigator daftarSuratjalanSh = new DropDownNavigator(iconSubmenu, "Daftar Surat Jalan", new ActionListener() {
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

                DropDownNavigator daftarFakturSh = new DropDownNavigator(iconSubmenu, "Daftar Faktur", new ActionListener() {
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

                DropDownNavigator daftarReturPenjualanSh = new DropDownNavigator(iconSubmenu, "Daftar Retur Penjualan", new ActionListener() {
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

                DropDownNavigator daftarPenerimaanBarangSh = new DropDownNavigator(iconSubmenu, "Daftar Penerimaan Barang", new ActionListener() {
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

                DropDownNavigator daftarReturPembelianSh = new DropDownNavigator(iconSubmenu, "Daftar Retur Pembelian", new ActionListener() {
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

            DropDownNavigator DaftarSh = new DropDownNavigator(iconListMenu, "Daftar SH", null, daftarPurchaseOrderSh, daftarSuratjalanSh, daftarFakturSh, daftarReturPenjualanSh, daftarPenerimaanBarangSh, daftarReturPembelianSh);

        DropDownNavigator sh = new DropDownNavigator(iconMenu, "Sinar Harapan", null, penjualanSh, PembelianSh, DaftarSh);

        //Batas Sinar Harapan dan Kawan Baru Teknik

                DropDownNavigator purchaseOrderKbt = new DropDownNavigator(iconSubmenu, "Purchase Order", new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        if(pengguna.isVisible()){//logika untuk memunculkan jinternalframe hanya sekali
                            pengguna.toFront();//memindahkan JInternalFrame ke depan sehingga menjadi aktif dan fokus.

                        }else{
                            navigator.setModal(false);
                            pengguna.setVisible(true);
                            jdeskDash.add(pengguna);
                            pengguna.setResizable(false);
                            pengguna.toFront();
                        }

                    }

                });

                DropDownNavigator suratJalanKbt = new DropDownNavigator(iconSubmenu, "Surat Jalan", new ActionListener() {
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

                DropDownNavigator fakturKbt = new DropDownNavigator(iconSubmenu, "Faktur", new ActionListener() {
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

                DropDownNavigator returPenjualanKbt = new DropDownNavigator(iconSubmenu, "Retur Penjualan", new ActionListener() {
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

            DropDownNavigator penjualanKbt = new DropDownNavigator(iconPenjualan, "Penjualan KBT", null, purchaseOrderSh, suratJalanSh, fakturSh, returPenjualanSh );


                DropDownNavigator penerimaanBarangKbt = new DropDownNavigator(iconSubmenu, "Penerimaan Barang", new ActionListener() {
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

                DropDownNavigator ReturPembelianKbt = new DropDownNavigator(iconSubmenu, "Retur Pembelian", new ActionListener() {
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

            DropDownNavigator PembelianKbt = new DropDownNavigator(iconPembelian, "Pembelian KBT", null, penerimaanBarangKbt, ReturPembelianKbt);


                DropDownNavigator daftarPurchaseOrderKbt = new DropDownNavigator(iconSubmenu, "Daftar Purchase Order", new ActionListener() {
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

                DropDownNavigator daftarSuratjalanKbt = new DropDownNavigator(iconSubmenu, "Daftar Surat Jalan", new ActionListener() {
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

                DropDownNavigator daftarFakturKbt = new DropDownNavigator(iconSubmenu, "Daftar Faktur", new ActionListener() {
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

                DropDownNavigator daftarReturPenjualanKbt = new DropDownNavigator(iconSubmenu, "Daftar Retur Penjualan", new ActionListener() {
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

                DropDownNavigator daftarPenerimaanBarangKbt = new DropDownNavigator(iconSubmenu, "Daftar Penerimaan Barang", new ActionListener() {
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

                DropDownNavigator daftarReturPembelianKbt = new DropDownNavigator(iconSubmenu, "Daftar Retur Pembelian", new ActionListener() {
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
                DropDownNavigator DaftarKbt = new DropDownNavigator(iconListMenu, "List KBT", null, daftarPurchaseOrderKbt, daftarSuratjalanKbt, daftarFakturKbt, daftarReturPenjualanKbt, daftarPenerimaanBarangKbt, daftarReturPembelianKbt);


            DropDownNavigator kbt = new DropDownNavigator(iconMenu, "Kawan Baru Teknik", null, penjualanKbt, PembelianKbt, DaftarKbt);

            //Batas Kbt dan Master Data

                DropDownNavigator formBarang = new DropDownNavigator(iconSubmenu, "Product", new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        if(barang.isVisible()){//logika untuk memunculkan jinternalframe hanya sekali
                            barang.toFront();//memindahkan JInternalFrame ke depan sehingga menjadi aktif dan fokus.

                        }else{
            //            navigator.setModal(false);
                            barang.setVisible(true);
                            jdeskDash.add(barang);
                            barang.setResizable(false);
                            barang.toFront();
                        }

                    }

                });

                DropDownNavigator formKonsumen = new DropDownNavigator(iconSubmenu, "Konsumen", new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        if(konsumen.isVisible()){//logika untuk memunculkan jinternalframe hanya sekali
                            konsumen.toFront();//memindahkan JInternalFrame ke depan sehingga menjadi aktif dan fokus.

                        }else{
                        //    setLocation(lastX, lastY);

                            jdeskDash.add(konsumen).setVisible(true);
                            konsumen.setVisible(true);
                            konsumen.setResizable(false);
                            konsumen.toFront();
                        }
                    }

                });

                DropDownNavigator formSupplier = new DropDownNavigator(iconSubmenu, "Supplier", new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        if(supplier.isVisible()){//logika untuk memunculkan jinternalframe hanya sekali
                            supplier.toFront();//memindahkan JInternalFrame ke depan sehingga menjadi aktif dan fokus.

                        }else{
                        //    setLocation(lastX, lastY);

                            jdeskDash.add(supplier).setVisible(true);
                            supplier.setVisible(true);
                            supplier.setResizable(false);
                            supplier.toFront();
                        }

                    }

                });

                DropDownNavigator daftarBarang = new DropDownNavigator(iconSubmenu, "List Barang", new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        if(listBarang.isVisible()){//logika untuk memunculkan jinternalframe hanya sekali
                            listBarang.toFront();//memindahkan JInternalFrame ke depan sehingga menjadi aktif dan fokus.

                        }else{
                        //    setLocation(lastX, lastY);

                            jdeskDash.add(listBarang).setVisible(true);
                            listBarang.setVisible(true);
                            listBarang.setResizable(false);
                            listBarang.toFront();
                        }
                    }

                });

                DropDownNavigator daftarKonsumen = new DropDownNavigator(iconSubmenu, "List Konsumen", new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        if(listKonsumen.isVisible()){//logika untuk memunculkan jinternalframe hanya sekali
                            listKonsumen.toFront();//memindahkan JInternalFrame ke depan sehingga menjadi aktif dan fokus.

                        }else{
                        //    setLocation(lastX, lastY);

                            jdeskDash.add(listKonsumen).setVisible(true);
                            listKonsumen.setVisible(true);
                            listKonsumen.setResizable(false);
                            listKonsumen.toFront();

                        }
                    }

                });

                DropDownNavigator daftarSupplier = new DropDownNavigator(iconSubmenu, "List Suppliers", new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        if(listKonsumen.isVisible()){//logika untuk memunculkan jinternalframe hanya sekali
                            listSupplier.toFront();//memindahkan JInternalFrame ke depan sehingga menjadi aktif dan fokus.

                        }else{
                        //    setLocation(lastX, lastY);

                            jdeskDash.add(listKonsumen).setVisible(true);
                            listKonsumen.setVisible(true);
                            listKonsumen.setResizable(false);
                            listKonsumen.toFront();

                        }
                    }

                });

                DropDownNavigator riwayatStok = new DropDownNavigator(iconSubmenu, "Stock History", new ActionListener() {
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

                DropDownNavigator daftarAllData = new DropDownNavigator(iconSubmenu, "Combined Data List", new ActionListener() {
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

                DropDownNavigator backupData = new DropDownNavigator(iconSubmenu, "Data Backup", new ActionListener() {
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

            DropDownNavigator masterData = new DropDownNavigator(iconMenu, "Data Master", null, formBarang, formKonsumen, formKonsumen, formSupplier, daftarBarang, daftarKonsumen, daftarSupplier, riwayatStok, daftarAllData, backupData);

            //Batas Data Master dan Setting

                DropDownNavigator formUser = new DropDownNavigator(iconSubmenu, "User", new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(pengguna.isVisible()){//logika untuk memunculkan jinternalframe hanya sekali
                            pengguna.toFront();//memindahkan JInternalFrame ke depan sehingga menjadi aktif dan fokus.

                        }else{
        //            navigator.setModal(false);
                            pengguna.setVisible(true);
                            jdeskDash.add(pengguna);
                            pengguna.setResizable(false);
                            pengguna.toFront();
                        }

                    }

                });

                DropDownNavigator daftarUser = new DropDownNavigator(iconSubmenu, "List User", new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(listUser.isVisible()){//logika untuk memunculkan jinternalframe hanya sekali
                            listUser.toFront();//memindahkan JInternalFrame ke depan sehingga menjadi aktif dan fokus.

                        }else{
        //            navigator.setModal(false);
                            listUser.setVisible(true);
                            jdeskDash.add(listUser);
                            listUser.setResizable(false);
                            listUser.toFront();
                        }
                    }

                });

                DropDownNavigator formStockOfName = new DropDownNavigator(iconSubmenu, "Stock Of Name", new ActionListener() {
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

                DropDownNavigator formPPN = new DropDownNavigator(iconSubmenu, "%PPN", new ActionListener() {
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

            DropDownNavigator setting = new DropDownNavigator(iconMenu, "Data Master", null, formUser, daftarUser, formStockOfName, formPPN);

        addMenu(sh, kbt, masterData, setting);

    }
    
    private void addMenu(DropDownNavigator...menu){
        for(int i=0; i<menu.length; i++){
            pnlNavigator.add(menu[i]);
            ArrayList<DropDownNavigator>subMenu=menu[i].getSubMenu();
            for(DropDownNavigator m:subMenu)
                addMenu(m);
        }
        pnlNavigator.revalidate();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        navigator = new javax.swing.JDialog();
        jspNavigator = new javax.swing.JScrollPane();
        pnlNavigator = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jsrDash = new javax.swing.JScrollPane();
        jdeskDash = new javax.swing.JDesktopPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        itemNavigator = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        navigator.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        navigator.setAlwaysOnTop(true);
        navigator.setBackground(new java.awt.Color(255, 255, 255));

        pnlNavigator.setLayout(new javax.swing.BoxLayout(pnlNavigator, javax.swing.BoxLayout.Y_AXIS));
        jspNavigator.setViewportView(pnlNavigator);

        javax.swing.GroupLayout navigatorLayout = new javax.swing.GroupLayout(navigator.getContentPane());
        navigator.getContentPane().setLayout(navigatorLayout);
        navigatorLayout.setHorizontalGroup(
            navigatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jspNavigator, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
        );
        navigatorLayout.setVerticalGroup(
            navigatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jspNavigator, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(93, 166, 152));
        jPanel1.setPreferredSize(new java.awt.Dimension(813, 40));
        jPanel1.setRequestFocusEnabled(false);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/user.png"))); // NOI18N
        jLabel2.setText("KAREN");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        jdeskDash.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jdeskDashLayout = new javax.swing.GroupLayout(jdeskDash);
        jdeskDash.setLayout(jdeskDashLayout);
        jdeskDashLayout.setHorizontalGroup(
            jdeskDashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 813, Short.MAX_VALUE)
        );
        jdeskDashLayout.setVerticalGroup(
            jdeskDashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 442, Short.MAX_VALUE)
        );

        jsrDash.setViewportView(jdeskDash);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(112, 112, 112)));
        jPanel2.setPreferredSize(new java.awt.Dimension(158, 30));

        jLabel1.setText("Waktu");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addContainerGap(107, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(112, 112, 112)));
        jPanel3.setPreferredSize(new java.awt.Dimension(2, 30));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );

        jMenuBar1.setBackground(new java.awt.Color(93, 166, 152));
        jMenuBar1.setBorder(null);

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu3.setText("View");

        itemNavigator.setText("Navigator");
        itemNavigator.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemNavigatorActionPerformed(evt);
            }
        });
        jMenu3.add(itemNavigator);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("System");
        jMenuBar1.add(jMenu4);

        jMenu5.setText("Window");
        jMenuBar1.add(jMenu5);

        jMenu2.setText("Help");
        jMenuBar1.add(jMenu2);

        jMenu6.setText("DEV");

        jMenuItem1.setText("USER");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem1);

        jMenuBar1.add(jMenu6);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 657, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 815, Short.MAX_VALUE)
            .addComponent(jsrDash)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jsrDash)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        setBounds(0, 0, 829, 545);
    }// </editor-fold>//GEN-END:initComponents

    private void itemNavigatorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemNavigatorActionPerformed
        
//        if(navigator.isVisible()){//logika untuk memunculkan jinternalframe hanya sekali
//            navigator.toFront();//memindahkan JInternalFrame ke depan sehingga menjadi aktif dan fokus.
//        
//        }else{
//
//            navigator.setVisible(true);
//            navigator.toFront();
//            navigator.pack();
//        }
        
           if(navigator.isVisible()){//logika untuk memunculkan jinternalframe hanya sekali
            navigator.toFront();//memindahkan JInternalFrame ke depan sehingga menjadi aktif dan fokus.
        
        }else{

            navigator.setVisible(true);
            navigator.toFront();
            navigator.pack();
        }
        
    }//GEN-LAST:event_itemNavigatorActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        User pengguna = new User();
        jdeskDash.add(pengguna).setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

   
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            UIManager.setLookAndFeel(new FlatIntelliJLaf());
        } catch (Exception e) {
            e.printStackTrace();
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem itemNavigator;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public javax.swing.JDesktopPane jdeskDash;
    private javax.swing.JScrollPane jspNavigator;
    private javax.swing.JScrollPane jsrDash;
    private javax.swing.JDialog navigator;
    private javax.swing.JPanel pnlNavigator;
    // End of variables declaration//GEN-END:variables
}
