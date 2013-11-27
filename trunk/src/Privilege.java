
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
public class Privilege {
    public ArrayList<Integer> getPrivilegeId(int fromUserId, int toUserId,int type_id){
        ArrayList<Integer> list = new ArrayList<>();
        ResultSet rs=null;
        try {
            rs = Database.stm.executeQuery("select subType_id from privilege where from_id="+fromUserId+" and to_id="+toUserId + " and type_id="+type_id);
        } catch (SQLException ex) {
            Logger.getLogger(Privilege.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
             while(rs.next()) list.add(rs.getInt(1));
        } catch (SQLException ex) {
            Logger.getLogger(Privilege.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public boolean setPrivilege(ArrayList<InfoPrivilege> listPrivilege,int fromId, int toId){
        try {
            Database.stm.executeUpdate("delete from privilege where from_id="+fromId+" and to_id="+toId+";");
            for(InfoPrivilege ip:listPrivilege){
                Database.stm.executeUpdate("insert into privilege (`id`,`from_id`,`to_id`,`type_id`,`subType_id`) values(null,"+ip.from_id+","+ip.to_id+","+ip.type_id+","+ip.subType_id+");");    
            }
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Privilege.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }       
    }

    public ArrayList<String> getPrivilegeType(int fromUserId, int toUserId, int type_id) {
        ArrayList<String> list = new ArrayList<>();
        ResultSet rs=null;
        String sql="";
        if(type_id==1) sql="select import_type.type from import_type,(select * from privilege where from_id="+fromUserId+" and to_id="+toUserId + " and type_id="+type_id+")as p where import_type.id=p.subType_id";
        if(type_id==2) sql="select export_type.type from export_type,(select * from privilege where from_id="+fromUserId+" and to_id="+toUserId + " and type_id="+type_id+")as p where export_type.id=p.subType_id";
        if(type_id==3 || type_id==4) sql="select * from privilege where from_id="+fromUserId+" and to_id="+toUserId+" and type_id="+type_id;
        System.out.println(sql);
        try {
            rs = Database.stm.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Privilege.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(type_id==1 || type_id==2){
            try {
                while(rs.next()) list.add(rs.getString(1));
            } catch (SQLException ex) {
                Logger.getLogger(Privilege.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(type_id==3 || type_id==4){
            try {
                if(rs.next()) list.add("has");
            } catch (SQLException ex) {
                Logger.getLogger(Privilege.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

}
