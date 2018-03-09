package main.company.entities;

public class Transaction {

    int id;
    double amount;
    int userId;
    String type;
    User user;
    public static int transactionsId = 1;

    public Transaction(){};

    public Transaction(double amount, String type, User user){
        this.amount = amount;
        this.type = type;
        this.id = transactionsId;
        this.userId = user.getId();
        this.user = user;

        transactionsId++;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getType(){
        return type;
    }

    public void setType(){
        this.type = type;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
