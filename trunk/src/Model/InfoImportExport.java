package Model;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dodan_000
 */
public class InfoImportExport {
    public String date;
    public int value;
    public String note;
    public String imageURL;
    public int user_id;
    public int type_id;
    public int id_chung;
    public boolean isImport;
    
    public InfoImportExport(){
        
    }
    
    public InfoImportExport(String date, int value, String note,String imageURL, int user_id, int type_id, boolean isImport){
        this.date = date;
        this.value = value;
        this.note = note;
        this.imageURL = imageURL;
        this.user_id = user_id;
        this.type_id = type_id;
        this.isImport = isImport;
    }
    
    
    
}
