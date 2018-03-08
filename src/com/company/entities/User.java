package com.company.entities;

public class User {

    public Integer id;
    public String username;
    public String password;
    public Checking checking;

    public static int numOfUsers = 1;

    public User(){};

    public User(String username, String password){

        this.username = username;
        this.password = password;
        this.id = numOfUsers;

        Checking newChecking = new Checking(this);

        this.checking = newChecking;

        numOfUsers++;
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

    public Checking getChecking() {
        return checking;
    }

    public void setChecking(Checking checking) {
        this.checking = checking;
    }
}
