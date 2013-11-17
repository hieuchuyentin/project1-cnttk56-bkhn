/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dodan_000
 */
public class infoImportExport {
    String date;
    int value;
    String note;
    int user_id;
    int type_id;
    int id_chung;
    boolean isImport;
    
    public infoImportExport(){
        
    }
    
    public infoImportExport(String date, int value, String note, int user_id, int type_id, boolean isImport){
        this.date = date;
        this.value = value;
        this.note = note;
        this.user_id = user_id;
        this.type_id = type_id;
        this.isImport = isImport;
    }
    
    
    
}
