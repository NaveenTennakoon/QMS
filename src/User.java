/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author navee
 */
class User {
    private int qid, qty, price;
    private String cmpName, prevQ, notes;
    
    public User(int qid, int qty, int price, String cmpName, String prevQ, String notes){
        this.qid=qid;
        this.qty=qty;
        this.price=price;
        this.cmpName=cmpName;
        this.prevQ=prevQ;
        this.notes=notes;
    }
    
    public int getqid(){
        return qid;
    }
    public int getqty(){
        return qty;
    }
    public int getprice(){
        return price;
    }
    public String getname(){
        return cmpName;
    }
    public String getprevq(){
        return prevQ;
    }
    public String getnotes(){
        return notes;
    }
}
