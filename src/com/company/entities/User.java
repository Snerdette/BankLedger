package com.company.entities;

public class User {

    public Integer id;
    public String username;
    public String password;

    public User(){};

    public User(String username, String password, int numOfUsers, int transactionsId){
        numOfUsers++; //Used to set ID's, originally 0, set to 1 for first ID.
        this.username = username;
        this.password = password;
        this.id = numOfUsers;

        Checking newChecking = new Checking(this, transactionsId);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsernamee(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
