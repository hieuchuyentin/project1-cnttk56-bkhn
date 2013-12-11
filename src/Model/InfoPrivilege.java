package Model;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dodan_000
 */
public class InfoPrivilege {
    public int from_id;
    public int to_id;
    public int type_id;
    public int subType_id;
    
    public InfoPrivilege(int from, int to, int type, int subType){
        from_id = from;
        to_id = to;
        type_id = type;
        subType_id = subType;
    }
      
}
