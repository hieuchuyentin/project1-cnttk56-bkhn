/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dodan_000
 */
import java.sql.*;
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
            Statement stm = Database.createStatement();
            rs = stm.executeQuery("select * from privilege where userName = "+ userName);
            
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
    }
    
    public void setUserName(String userName){
        this.userName = userName;
    }
    public String getUserName(){
        return userName;
    }
    
    public void setPassWord(String passWord){
        this.passWord = passWord;
    }
    public String getPassWord(){
        return passWord;
    }
    
    public void setGender(boolean gender){
        this.gender = gender;
    }
    public boolean getGender(){
        return gender;
    }
    
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    
    public void setBirthDay(String birthDay){
        this.birthDay = birthDay;
    }
    public String getBirthDay(){
        return birthDay;
    }
    
    public void setAge(int age){
        this.age = age;
    }
    public int getAge(){
        return age;
    }
    
}
