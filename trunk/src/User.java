/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dodan_000
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class User extends InfoUser{
    
   
    
    public User(){
        super();      
    }
    
    public int getUserId(String userName){
        int id=0;
        ResultSet rs;
        try {
            rs = Database.stm.executeQuery("select id from user where userName = '"+ userName+"';");
            rs.next();
            id = rs.getInt(1);
            //System.out.print(un);
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
    
    public ResultSet getPrivilege(){
        ResultSet rs = null;
        try {
            rs = Database.stm.executeQuery("select * from privilege where userName = "+ userName);
            
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
   public  ArrayList getUserList(){
       ArrayList<String> list = new ArrayList<String>(  );         
           try {
               ResultSet rs=Database.stm.executeQuery("select userName from user");
               while(rs.next()){
                   list.add(rs.getString(1));
               }
         
           } catch (SQLException ex) {
               Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
           }          
    return list;
   }   
    
}
