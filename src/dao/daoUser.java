/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.util.List;
import model.User;

public interface daoUser {
    public String insertUser(User user);
    public List<User> getUser();
}
