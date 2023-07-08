package main;

import connection.koneksi;

import java.io.IOException;
import java.sql.Connection;
import javax.swing.UnsupportedLookAndFeelException;
import view.frmLogin;


public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        Connection connection;
        connection = koneksi.connectionSQL();
        System.out.println("connection:"+connection);
        if(connection!=null){
            frmLogin frmlogin = new frmLogin();
            frmlogin.setVisible(true);
            
        }
                
    }
}
