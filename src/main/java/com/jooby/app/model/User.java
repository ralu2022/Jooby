package com.jooby.app.model;

/*
 * Main class that supports the JDBCUser class for adding a new username and checking if the username is in the database.
 * */

import lombok.Data;

@Data
public class User {

    private int userID;
    private String userName;
    private String password;
    private String userType;

    public User(String userName, String password, String userType) {
        this.userName = userName;
        this.password = password;
        this.userType = userType;
    }
}
