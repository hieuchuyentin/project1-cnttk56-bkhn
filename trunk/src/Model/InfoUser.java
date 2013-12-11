package Model;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dodan_000
 */
public class InfoUser {
    public int id;
    public String userName;
    public String passWord;
    public boolean gender;
    public String name;
    public String birthDay;
    public int age;
    
    public InfoUser(){
        userName = "";
        passWord = "";
        gender = false;
        name = "";
        birthDay = "";
        age = 0;
    }
    
    public InfoUser(String userName,String passWord,boolean gender, String name, String birthDay, int age){
        
        this.userName = userName;
        this.passWord = passWord;
        this.gender = gender;
        this.name = name;
        this.birthDay = birthDay;
        this.age = age;
    }
}
