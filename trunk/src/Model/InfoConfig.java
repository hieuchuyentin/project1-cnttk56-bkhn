/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import NewGUI.Preferences;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dodan_000
 */
public class InfoConfig {
    public String url_db;
    public String user_name_db;
    public String pass_word_db;
    
    public InfoConfig(String url,String user_name,String pass_word){
        this.url_db = url;
        this.user_name_db=user_name;
        this.pass_word_db=pass_word;
    }
    
    public InfoConfig(){
        
    }
    
    public void getConfig(){
        try {
            //fstream = new FileInputStream("config.ini");
            //DataInputStream in = new DataInputStream(fstream);
            FileReader file = new FileReader("config.ini");
            BufferedReader bf = new BufferedReader(file);
            try {

                String[] url = bf.readLine().split(" ");
                url_db = url[2];

                String[] userName = bf.readLine().split(" ");
                user_name_db = userName[2];

                String[] passWord = bf.readLine().split(" ");
                pass_word_db = passWord[2];
                
                bf.close();          
            } catch (IOException ex) {
                Logger.getLogger(Preferences.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (FileNotFoundException ex) {
            System.out.println("Không tìm thấy file config.ini");
        }        
    }
}
