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
public class BorrowLend{
    public BorrowLend(){
    }
    
    public boolean insert_Borrowing(InfoBorrowLend infoBL){
        try {
            String sql = "insert into borrowing (id,value,interestRate,dateBorrow,expiryDate,infoLender,borrow_lend_type_id,user_id) values ";
            sql += "(null,"+infoBL.value+","+infoBL.interestRate+",'"+infoBL.date+"','"+infoBL.expiryDate+"','"+infoBL.infoPartner+"',"+infoBL.borrow_lend_id+","+infoBL.user_id+")";
//            System.out.println(sql);
            Database.stm.executeUpdate(sql);
            return true;
        } catch (Exception e) {
            return false;
            //Database.stm.executeUpdate/e.printStackTrace();
            
        }
     
    }
    
    public boolean insert_Lending(InfoBorrowLend infoBL){
        try {
            String sql = "insert into lending (id,value,interestRate,dateLend,infoBorrower,expiryDate,borrow_lend_type_id,user_id) values ";
            sql += "(null,"+infoBL.value+","+infoBL.interestRate+",'"+infoBL.date+"','"+infoBL.infoPartner+"','"+infoBL.expiryDate+"',"+infoBL.borrow_lend_id+","+infoBL.user_id+")";
//            System.out.println(sql);
            Database.stm.executeUpdate(sql);
            return true;
        } catch (Exception e) {
            //e.printStackTrace();
            return false;
        }
        
    }
    
    public boolean insert(InfoBorrowLend infoBL){
        if(infoBL.isBorrow){
            return this.insert_Borrowing(infoBL);
        }
        else{
            return this.insert_Lending(infoBL);
        }
    }
    
    public boolean update_Borrow(int id, InfoBorrowLend infoBL) {
        try {
            String sql = "update borrowing set value = "+infoBL.value+",interestRate ="+infoBL.interestRate+",dateBorrow = "+"'"+infoBL.date+"'"+",";
            sql+= "expiryDate = "+"'"+infoBL.expiryDate+"'"+
                    ",infoLender = "+"'"+infoBL.infoPartner+"'"+
                    ",borrow_lend_type_id = "+infoBL.borrow_lend_id+
                    ",user_id = "+infoBL.user_id;
            sql+=" where id="+id+";";
            Database.stm.executeUpdate(sql);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean update_Lend(int id, InfoBorrowLend infoBL) {
        try {
            String sql = "update lending set value = "+infoBL.value+",interestRate ="+infoBL.interestRate+",dateLend = "+"'"+infoBL.date+"'"+",";
            sql += "infoBorrower = "+"'"+infoBL.infoPartner+"'"
                    +",expiryDate = "+"'"+infoBL.expiryDate+"'"+",borrow_lend_type_id = "+infoBL.borrow_lend_id+",user_id = "+infoBL.user_id;
            sql+=" where id="+id+";";
            Database.stm.executeUpdate(sql);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean update(int id, InfoBorrowLend infoBL){
        if(infoBL.isBorrow)
            return this.update_Borrow(id, infoBL);
        else
            return this.update_Lend(id, infoBL);
        
    }
    
    public boolean delete_Borrow(int id){
        try {
            
            String sql="delete from borrowing where id = "+id;
            Database.stm.executeUpdate(sql);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
            
        }
        
    }
    
    public boolean delete_Lend(int id){
        try {
            
            String sql="delete from Lending where id = "+id;
            Database.stm.executeUpdate(sql);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        
    }
    
    public boolean delete(int id, boolean isBorrow){
        if(isBorrow)
            return this.delete_Borrow(id);
        else
            return this.delete_Lend(id);
    }
        
}


