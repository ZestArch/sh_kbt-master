/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import connection.koneksi;
import dao.daoDiQuery;
import dao.daoUser;
import daoimpl.impldaoDiQuery;
import daoimpl.impldaoUser;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import menu.Dashboard;
import model.User;
import utility.Util;
import view.frmLogin;
import view.mnuMain;


public class controllerUser {
    frmLogin frmlogin;
    mnuMain mnumain;
    daoDiQuery daodiquery;
    daoUser daouser;
    List<User> lu;
    Connection connection;
    public controllerUser(frmLogin frmlogin) throws IOException, FileNotFoundException {
        this.frmlogin = frmlogin;    
        daodiquery=new impldaoDiQuery();
        daouser=new impldaoUser();
    }
    
    
    public controllerUser(mnuMain mnumain) throws IOException, FileNotFoundException {
        connection = koneksi.connectionSQL();
        this.mnumain = mnumain;    
        daodiquery=new impldaoDiQuery();
    }
    
    public void Login() throws UnknownHostException {
        Util util=new Util();
        String strCheckingField=checkingField();
        String strUserLogin=frmlogin.getUsername().getText().toString();
        if(strCheckingField.equals("OK")){
            String strGetPassword=daodiquery.get1RecordBy1Condition("password", "m_user", "username", strUserLogin);
            System.out.println("strGetPassword:"+strGetPassword);
         
            if(strGetPassword.equals(util.getMD5(frmlogin.getPassword().getText().toString()))){
                Dashboard formUtama = new Dashboard();
                formUtama.setExtendedState(JFrame.MAXIMIZED_BOTH);
                formUtama.setVisible(true);
//                formUtama.getUserLogin().setText(strUserLogin);

                
                
                
                frmlogin.dispose();
                
                
            }
            else{
                JOptionPane.showMessageDialog(frmlogin, "Please fill correct username/password");
            }
        }
        else{
            JOptionPane.showMessageDialog(frmlogin, "Please fill the required fields");
        }
    }
    

    public String checkingField(){
        String strReturn="";
        if(!frmlogin.getUsername().getText().toString().equals("")||!frmlogin.getPassword().getText().toString().equals("")){
            strReturn="OK";
        }
        else{
            strReturn="E";
        }
        
        return strReturn;
    }
    
 
    
   
}
