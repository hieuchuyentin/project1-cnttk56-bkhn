/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dodan_000
 */
class infoBorrowLend {
    int value;
    int interestRate;
    String date;
    String expiryDate;
    String infoPartner;
    int borrow_lend_id;
    int user_id;
    boolean isBorrow;
    
    public infoBorrowLend(){
        
    }
    
    public infoBorrowLend(int value,int interestRate,String date,String expiryDate,String infoPartner,int borrow_lend_id,int user_id, boolean isBorrow){
        this.value = value;
        this.interestRate = interestRate;
        this.date = date;
        this.expiryDate = expiryDate;
        this.infoPartner = infoPartner;
        this.borrow_lend_id = borrow_lend_id;
        this.user_id = user_id;
        this.isBorrow = isBorrow;
       
    }
    
}
