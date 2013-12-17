package Control;


import Model.InfoConfig;
import NewGUI.Preferences;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dodan_000
 */
public class Database {
    public static String url = "";
    public static String user = "";
    public static String pass = "";
    public static Connection conn = null;
    public static Statement stm = null;
    
  
    static private void setProperties(){
        InfoConfig ifConfig = new InfoConfig();
        ifConfig.getConfig();
        url = ifConfig.url_db;
        user = ifConfig.user_name_db;
        pass = ifConfig.pass_word_db;
        
    }
    
    static public void setState(){
        setProperties();   
        try {
            conn = DriverManager.getConnection(url, user, pass);
            stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        } catch (SQLException ex) {
            int n = JOptionPane.showConfirmDialog(null, "Giá trị kết nối đến Database không đúng!, Bạn cần phải thiết lập lại giá trị kết nối?", "Error Connection", JOptionPane.YES_NO_OPTION);  
            if(n== JOptionPane.OK_OPTION){
                Preferences preferences = new Preferences();
                preferences.setVisible(true);
                
            }
            else{
                
            }
            
            //Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }  
   
        
}
