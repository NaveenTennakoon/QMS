class User {
    private int qid, qty, price, contact;
    private String cmpName, prevQ, notes;
    
    public User(int qid, int qty, int price, String cmpName, String prevQ, String notes, int contact){
        this.qid=qid;
        this.qty=qty;
        this.price=price;
        this.cmpName=cmpName;
        this.prevQ=prevQ;
        this.notes=notes;
        this.contact=contact;
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
    public int getcontact(){
        return contact;
    }
}
