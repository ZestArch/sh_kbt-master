/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoimpl;

import connection.koneksi;
import dao.daoDiQuery;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class impldaoDiQuery implements daoDiQuery {
    Connection connection;
    
     public impldaoDiQuery() throws IOException, FileNotFoundException {
        connection = koneksi.connectionSQL();
    }

    @Override
    public String get1RecordBy1Condition(String field, String table, String fieldCondition, String valueCondition) {
        String strValue="";
        try {
            
            String caribarang = "select "+field+" from "+table+" where "+fieldCondition+"='"+valueCondition+"'";
            System.out.println(caribarang);
            PreparedStatement st = connection.prepareStatement(caribarang);
            
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                strValue=rs.getString(1);  
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return strValue; 
    }

    

   
}
