package Control;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
public class Database {
    static String url = "jdbc:mysql://localhost:3306/mydb";
    static String user = "root";
    static String pass = "1234";
    static Connection conn = null;
    public static Statement stm = null;
    
  
    
    static public void setState(){
        try {
            conn = DriverManager.getConnection(url, user, pass);
            stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }  
   
        
}
