/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dodan_000
 */
import java.sql.*;
public class ImportExport {
    public ImportExport(){
        
    }
    private boolean insert_import(infoImportExport infoIE)
    {
        ResultSet kq=null;
        int sohang=0;
        String lenh="insert into importing(id,date,value,note,import_type_id,user_id)values";
        try
        {
            //kq=Database.stm.executeQuery("select count(id)from import;");
            //kq.next();
            //sohang=kq.getInt(1);
            //sohang++;
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
    private boolean insert_export(infoImportExport infoIE)
    {
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
    
    public boolean insert(infoImportExport infoIE)
    {
        if (infoIE.isImport)
            return insert_import(infoIE);
        else
            return insert_export(infoIE);
    }
    //chen import hoac export tuy thuoc vao gia tri isImport
    private boolean update_import(int id, infoImportExport infoIE)
    {
        try
        {
           
            String lenh="update importing set ";
            lenh+="value="+infoIE.value+",";
            lenh+="date="+"'"+infoIE.date+"'"+",";
            lenh+="import_type_id="+infoIE.type_id+",";
            lenh+="user_id="+infoIE.user_id;
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
    private boolean update_export(int id, infoImportExport infoIE)
    {
        try
        {
           
            String lenh="update exporting set ";
            lenh+="value="+infoIE.value+",";
            lenh+="date="+"'"+infoIE.date+"'"+",";
            lenh+="export_type_id="+infoIE.type_id+",";
            lenh+="user_id="+infoIE.user_id;
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
    
    
    public boolean update(int id,infoImportExport infoIE)
    {
        if (infoIE.isImport)
            return update_import(id, infoIE);
        else
            return update_export(id, infoIE);
    }
    private boolean delete_import(int id)
    {
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
    private boolean delete_export(int id)
    {
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
    public boolean delete(int id, boolean isImport)
    {
        if (isImport)
            return delete_import(id);
        else
            return delete_export(id);
    }
    
    public static void main(String args [])
    {
        Database.setState();
        ImportExport ie=new ImportExport();
        infoImportExport info1=new infoImportExport("2013-3-23",1000,"abc",1,1,true);
        ie.insert(info1);
        infoImportExport info2=new infoImportExport("2013-3-23",1000,"abc",1,1,false);
        ie.insert(info2);
        
        ie.update(1,info1);
        ie.update(1,info2);
        ie.delete(1,true);
        ie.delete(1,false);
    }
}
