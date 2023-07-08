/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utility;

import dao.daoDiQuery;
import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;

public class Util {
    daoDiQuery daodiquery;

  public String checkMySQLConnection(String strIPAddress,String strPort,String strDatabase,String strUsername,String strPassword){
      String strReturn="OK"; 
      try{
            if(strPassword.equals("kosong")){
                strPassword="";
            }
            Connection con;
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://"+strIPAddress+":"+strPort+"/"+strDatabase+"",""+strUsername+"",""+strPassword+"");

            strReturn="OK";
        }
        catch(Exception e){

            e.getMessage();
            strReturn="E";
        }
      return strReturn;
  }
   public String getMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);
            // Now we need to zero pad it if you actually want the full 32 chars.
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
   public String getIPAddressDB() {
       String strReturn="";
       try{
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
            
            strReturn=dbHost;
       }catch(Exception e){
           System.out.println(e.getMessage());
           strReturn="E";
       }
           return strReturn;
            
   }
   
    public static void main(String[] args) {
        

}
    
}
