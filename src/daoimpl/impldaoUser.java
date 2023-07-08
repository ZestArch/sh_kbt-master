/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoimpl;

import connection.koneksi;
import dao.daoUser;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;

public class impldaoUser implements daoUser {
    Connection connection;
    
     public impldaoUser() throws IOException {
        connection = koneksi.connectionSQL();
    }

    @Override
    public List<User> getUser() {
        List<User> ra = null;
        
        try {
            String query = "select a.username,b.role_manajement from m_user as a inner join m_role_manajement as b\n" +
"on a.id_role=b.id_role order by role_manajement";
            
            System.out.println(query);
            
            ra = new ArrayList<User>();
            PreparedStatement st = connection.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                User b = new User();
                b.setUsername(rs.getString(1));
                b.setRole(rs.getString(2));
                ra.add(b);
            }
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return ra;
    }

    @Override
    public String insertUser(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
