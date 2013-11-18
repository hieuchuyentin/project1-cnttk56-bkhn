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
public class ImportExport {
    public ImportExport(){
        
    }
    private boolean insert_import(InfoImportExport infoIE) {
        ResultSet kq=null;
        int sohang=0;
        String lenh="insert into importing(id,date,value,note,import_type_id,user_id)values";
        try
        {
            lenh+="(";
            lenh+="null"+",";//cho nay thieu truong id
            lenh+="'"+infoIE.date+"',";
            lenh+=infoIE.value+",";
            lenh+="'"+infoIE.note+"',";
            lenh+=+infoIE.type_id+",";
            lenh+=+infoIE.user_id+");";
            Database.stm.executeUpdate(lenh);
        }
        catch(Exception e)
        {
            System.err.println("Khong them duoc thong tin import");
            return false;
        }
        return true;
    }
    private boolean insert_export(InfoImportExport infoIE){
        ResultSet kq=null;
        int sohang=0;
        String lenh="insert into exporting(id,date,value,note,export_type_id,user_id)values";
        try
        {
            
            lenh+="(";
            lenh+="null"+",";//cho nay thieu truong id
            lenh+="'"+infoIE.date+"',";
            lenh+=infoIE.value+",";
            lenh+="'"+infoIE.note+"',";
            lenh+=+infoIE.type_id+",";
            lenh+=+infoIE.user_id+");";
            Database.stm.executeUpdate(lenh);
        }
        catch(Exception e)
        {
            System.err.println("Khong them duoc thong tin export");
            return false;
        }
        return true;
    }        
    
    public boolean insert(InfoImportExport infoIE) {
        if (infoIE.isImport)
            return insert_import(infoIE);
        else
            return insert_export(infoIE);
    }
    //chen import hoac export tuy thuoc vao gia tri isImport
    private boolean update_import(int id, InfoImportExport infoIE){
        try
        {         
            String lenh="update importing set ";
            lenh+="value="+infoIE.value+",";
            lenh+="date="+"'"+infoIE.date+"'"+",";
            lenh+="import_type_id="+infoIE.type_id+",";
            lenh+="note="+infoIE.note;
            //lenh+="user_id="+infoIE.user_id;
            lenh+=" where id="+id;
            lenh+=";";
            Database.stm.executeUpdate(lenh);
            
        }
        catch(Exception e)
        {
            System.err.println("Khong cap nhat duoc thong tin import");
            return false;
        }
        
        return true;
    }
    private boolean update_export(int id, InfoImportExport infoIE){
        try
        {
           
            String lenh="update exporting set ";
            lenh+="value="+infoIE.value+",";
            lenh+="date="+"'"+infoIE.date+"'"+",";
            lenh+="export_type_id="+infoIE.type_id+",";
            lenh+="note="+infoIE.note;
            //lenh+="user_id="+infoIE.user_id;
            lenh+=" where id="+id;
            lenh+=";";
            Database.stm.executeUpdate(lenh);
            
        }
        catch(Exception e)
        {
            System.err.println("Khong cap nhat duoc thong tin export");
            return false;
        }
        
        return true;
    }
    
    
    public boolean update(int id,InfoImportExport infoIE){
        if (infoIE.isImport)
            return update_import(id, infoIE);
        else
            return update_export(id, infoIE);
    }
    private boolean delete_import(int id){
        try
        {
            String lenh="delete from importing ";
            lenh+=" where id="+id;
            lenh+=";";
            
            Database.stm.executeUpdate(lenh);
            
        }
        catch(Exception e)
        {
            System.err.println("Khong xoa duoc thong tin import");
            return false;
        }
        
        return true;
    }
    private boolean delete_export(int id){
        try
        {
            String lenh="delete from exporting ";
            lenh+=" where id="+id;
            lenh+=";";
            
            Database.stm.executeUpdate(lenh);
            
        }
        catch(Exception e)
        {
            System.err.println("Khong xoa duoc thong tin export");
            return false;
        }
        
        return true;
    }
    public boolean delete(int id, boolean isImport){
        if (isImport)
            return delete_import(id);
        else
            return delete_export(id);
    }
    
    public  ArrayList getImportTypeList(){
       ArrayList<String> list = new ArrayList<String>(  );         
       
       ResultSet rs;
       try {
            rs = Database.stm.executeQuery("select type from import_type");
            while(rs.next()){
                list.add(rs.getString(1));
            }
         
       } catch (SQLException ex) {
            Logger.getLogger(ImportExport.class.getName()).log(Level.SEVERE, null, ex);
       }   
    return list;
   }  
   
   public  ArrayList getExportTypeList(){
       ArrayList<String> list = new ArrayList<String>(  );         
       
       ResultSet rs;
       try {
            rs = Database.stm.executeQuery("select type from Export_type");
            while(rs.next()){
                list.add(rs.getString(1));
            }
         
       } catch (SQLException ex) {
            Logger.getLogger(ImportExport.class.getName()).log(Level.SEVERE, null, ex);
       }   
    return list;
   } 
   Privilege privilege = new Privilege();
   public ResultSet getData(int fromUserId, int toUserId,int type_id,boolean isImport){
       String s1="",s2="",s3="",s4="",s5="";
       ResultSet rs = null;   
       Privilege p = new Privilege();
       ArrayList<Integer> list; 
       
       if(isImport){
           s1="import";
           s2="importing";
           list = p.getPrivilege(fromUserId, toUserId,1); 
       }
       else{
           s1="export";
           s2="exporting";
           list = p.getPrivilege(fromUserId, toUserId,2); 
       }
       
       if(fromUserId==toUserId){
           s3="";
       }
       else{   
           if(list.size()>0){
               for(int i=0;i<list.size()-1;i++)
                   s4+= list.get(i)+",";
               s4+=list.get(list.size()-1);
           s3 = " and "+s1+"_type_id in("+ s4 +")";    
           }
       }
       
       if(type_id==0){
           s5="";
       }
       else{
           s5=" and "+ s1 + "_type_id = " + type_id;
       }
       
       String sql = "select x.id,user.userName as UserName,x.date as Date,"+s1+"_type.type,x.value as Value,x.note as Note" 
               +" from (select * from "+s2+" where user_id="+toUserId + s3 + s5 + ")as x,user,"+s1+"_type"
               +" where x.user_id=user.id  and x."+s1+"_type_id = "+s1+"_type.id";
       System.out.println(sql);
       try {
            rs = Database.stm.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ImportExport.class.getName()).log(Level.SEVERE, null, ex);
        }
       return rs;
   }
                       
}
