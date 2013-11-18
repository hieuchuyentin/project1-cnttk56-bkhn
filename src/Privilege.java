
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
    public ArrayList<Integer> getPrivilege(int fromUserId, int toUserId,int type_id){
        ArrayList<Integer> list = new ArrayList<>();
        ResultSet rs=null;
        try {
            rs = Database.stm.executeQuery("select subType_id from privilege where type_id="+type_id+" and from_id="+fromUserId+" and to_id="+toUserId);
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
}
