/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dodan_000
 */
public class InfoPrivilege {
    int from_id;
    int to_id;
    int type_id;
    int subType_id;
    boolean isAdd;
    
    public InfoPrivilege(int from, int to, int type, int subType, boolean isAdd){
        from_id = from;
        to_id = to;
        type_id = type;
        subType_id = subType;
        this.isAdd = isAdd;
    }
      
}
