/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dodan_000
 */
class InfoBorrowLend {
    int value;
    int interestRate;
    String date;
    String expiryDate;
    String infoPartner;
    int borrow_lend_id;
    int user_id;
    boolean isBorrow;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(int interestRate) {
        this.interestRate = interestRate;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getInfoPartner() {
        return infoPartner;
    }

    public void setInfoPartner(String infoPartner) {
        this.infoPartner = infoPartner;
    }

    public int getBorrow_lend_id() {
        return borrow_lend_id;
    }

    public void setBorrow_lend_id(int borrow_lend_id) {
        this.borrow_lend_id = borrow_lend_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public boolean isIsBorrow() {
        return isBorrow;
    }

    public void setIsBorrow(boolean isBorrow) {
        this.isBorrow = isBorrow;
    }
    
    public InfoBorrowLend(){
        
    }
    
    public InfoBorrowLend(int value,int interestRate,String date,String expiryDate,String infoPartner,int borrow_lend_id,int user_id, boolean isBorrow){
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
