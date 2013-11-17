
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
    public void setPrivilege(Privilege pv){
        try {            
            ResultSet rs = Database.stm.executeQuery("select * from privilege where from_id="+pv.from_id+" and to_id="+pv.to_id+" and type_id="+pv.type_id+" and subType_id="+pv.subType_id);            
            if(pv.isAdd==true){              
                rs.moveToInsertRow();
                rs.updateInt(2, pv.from_id);
                rs.updateInt(3, pv.to_id);
                rs.updateInt(4, pv.type_id);
                rs.updateInt(5, pv.subType_id);
                rs.insertRow();
                //Database.stm.executeUpdate("insert into privilege (from_id, to_id, type_id, subType_id)  values("+pv.from_id+","+pv.to_id+","+pv.type_id+","+pv.subType_id+")");          
            }
            else{              
                if (rs.next()){
                    rs.deleteRow();                  
                }               
            }
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
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
                rs.updateString(5, infoUser.name);
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
