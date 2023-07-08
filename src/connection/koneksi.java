/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package connection;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import view.frmConnection;

public class koneksi {
    static Connection con;

    public koneksi(Connection con){
        this.con = con;
    }
    public static Connection connectionSQL() throws FileNotFoundException, IOException {
        if (con == null) {
            String content = "localhost~printing~sa~Zaq12wsX";
            String strFile=System.getProperty("user.dir")+"\\database.txt";
            System.out.println("strFile");
            File file = new File(strFile);

            // if file doesnt exists, then create it
            if (!file.exists()) {
                file.createNewFile();
                FileWriter fw = new FileWriter(file.getAbsoluteFile());
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(content);
                bw.close();
            }
            else{
                String strDbLocation=System.getProperty("user.dir");
                System.out.println("strDbLocation:"+strDbLocation);

                BufferedReader br = new BufferedReader(new FileReader(strDbLocation + "\\database.txt"));

                String strLine;

                strLine=br.readLine();
                System.out.println("strline:"+strLine);
                String[] kata1=strLine.split("\\~");
                System.out.println(kata1[0]);
                System.out.println(kata1[1]);
                //==============================================================
                String dbHost=kata1[0];
                String dbname=kata1[1];
                String dbUser=kata1[2];
                String dbPass=kata1[3];
                if (dbPass.equals("kosong")){
                    dbPass=""; 
                }

                  try{
                      Class.forName("com.mysql.cj.jdbc.Driver");
                      con = DriverManager.getConnection("jdbc:mysql://"+dbHost+":3306/"+dbname+"",""+dbUser+"",""+dbPass+"");

                      System.out.println("Connected");
                  }
                  catch(Exception e){
                      System.out.println("Connection failed");
                      frmConnection frmconnection = new frmConnection();
                      frmconnection.setVisible(true);
                      e.getMessage();
                  }
            }
            
        
        }

        return con;
    } 
}
