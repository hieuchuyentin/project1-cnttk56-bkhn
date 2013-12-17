package Control;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dodan_000
 */
import Model.InfoUser;
import Control.Database;
import Control.Database;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class User extends InfoUser{
    
   
    
    public User(){
        super();      
    }
    public User(String userName,String passWord,boolean gender, String name, String birthDay, int age)
    {
        super();
        this.userName = userName;
        this.passWord = passWord;
        this.gender = gender;
        //this.name = name;
        this.birthDay = birthDay;
        this.age = age;
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
    
    /*public ResultSet getPrivilege(){
        ResultSet rs = null;
        try {
            rs = Database.stm.executeQuery("select * from privilege where userName = "+ userName);
            
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }*/
    
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
   public boolean addUser(InfoUser infoUser){
        ResultSet rs = null;
        ResultSet rs1=null;
        
        try {
            rs1=Database.stm.executeQuery("select user from present_id;");
            rs1.next();
            int idnext = rs1.getInt(1)+1;
            Database.stm.executeUpdate(
                        "update present_id set user="+idnext);
            rs = Database.stm.executeQuery("select * from user where userName="+"'"+infoUser.userName+"';");
            if (rs.next()) return false;
            else
            {
                rs.moveToInsertRow();
                
                rs.updateInt(1, idnext);
                
                rs.updateString(2, infoUser.userName);
                rs.updateString(3, infoUser.passWord);
                rs.updateBoolean(4, infoUser.gender);
                rs.updateString(5, infoUser.birthDay);
                rs.updateString(6, infoUser.email);
                rs.updateString(7, infoUser.phone);
                
                rs.insertRow();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
        
    }
    
    
    public boolean deleteUser(int idUser){
        try {
            Database.stm.executeUpdate("delete from user where id="+idUser);
            
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
   public boolean updateUser(InfoUser infoUser){
        ResultSet rs = null;
        try 
        {
            String sql = "update user set ";
            sql += "userName="+"'"+infoUser.userName+"',";
            sql += "passWord="+"'"+infoUser.passWord+"',";
            if (infoUser.gender)
                sql += "gender="+1+",";
            else
                sql += "gender="+2+",";
            sql += "birthDay="+"'"+infoUser.birthDay+"',";
            sql += "email="+"'"+infoUser.email+"',";
            sql += "phone="+"'"+infoUser.phone+"' ";
            sql += "where id="+infoUser.id+";";
            if(Database.stm.executeUpdate(sql)==0)
            {
                //System.out.println("update that bai");
                return false;
            }
            else
            {
                //System.out.println("update thanh cong");
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return false;
        
    }
   public void setInfoFromId()
   {
       try
       {
           ResultSet rs=Database.stm.executeQuery("select * from user where id="+this.id+";");
           if (rs.next())
           {
                this.userName = rs.getString("userName");
                this.passWord = rs.getString("passWord");
                this.gender = rs.getInt("gender") == 1;
                //this.name = name;
                this.birthDay = rs.getString("birthDay");
                //this.age = rs.getInt("age");
                this.email = rs.getString("email");
                
                this.phone = rs.getString("phone");
           }
       }
       catch(Exception e)
       {
       }
   }
   /*public ArrayList getUserListWithPrivilege(int fromUserId, int type_id, int subType_id){
       ArrayList<String> list = new ArrayList<>();
       String s1="";
       if(subType_id!=0) s1 = " and privilege.subType_id="+subType_id;
       
       ResultSet rs = null;
        try {
            rs = Database.stm.executeQuery("select user.userName from user, privilege where privilege.from_id="+fromUserId+" and privilege.type_id="+type_id+ s1+" and privilege.to_id=user.id group by user.userName");
            while(rs.next()) list.add(rs.getString(1));
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
   }*/
    
}
