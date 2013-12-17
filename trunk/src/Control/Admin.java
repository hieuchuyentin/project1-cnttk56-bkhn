package Control;

import Model.InfoUser;
import Control.Database;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dodan_000
 */
public class Admin extends User{
        
    public boolean addUser(InfoUser infoUser){
        ResultSet rs = null;
        try {
            rs = Database.stm.executeQuery("select * from User where userName="+infoUser.userName);
            if (rs.next()) return false;
            else{
                rs.moveToInsertRow();
                rs.updateString(2, infoUser.userName);
                rs.updateString(3, infoUser.passWord);
                rs.updateBoolean(4, infoUser.gender);               
                rs.updateString(6, infoUser.birthDay);
                rs.updateInt(7, infoUser.age);
                rs.insertRow();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return true;
        
    }
    
    public boolean deleteUser(int idUser){
        try {
            ResultSet rs = Database.stm.executeQuery("delete * from user where id="+idUser);
            
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
    
    
}
