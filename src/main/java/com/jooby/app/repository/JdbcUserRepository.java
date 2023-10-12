/*
 *  The class is used to connect to the database and extract data related to users.
 *  It also contains all the CRUD methods, created based on the columns existing in the users table:

 * */


package com.jooby.app.repository;

import com.jooby.app.model.User;

import javax.swing.*;
import java.sql.*;


public class JdbcUserRepository {
    public JdbcUserRepository() {

        getConnection();
    }

    public static final String JDBC_DRIVER = "org.postgresql.Driver";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/joobydb";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "4891";

    public Connection getConnection() {
        try {
            Class.forName(JDBC_DRIVER);
            return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (Exception e) {
            throw new RuntimeException("Can't connect to the db" + e.getMessage());
        }
    }

    public void addUser(User user) throws SQLException {

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE userName=?")) {

            statement.setString(1, user.getUserName());

            ResultSet resultSet = statement.executeQuery();

            int counter = 0;

            while (resultSet.next()) {
                counter++;
            }

            if (counter > 0) {
                JOptionPane.showMessageDialog(null, "User name not available");

            } else {
                try (Connection connection2 = getConnection();
                     PreparedStatement statement2 = connection2.prepareStatement("INSERT INTO users (userName, password, userType) VALUES (?, ?, ?)")) {

                    statement2.setString(1, user.getUserName());
                    statement2.setString(2, user.getPassword());
                    statement2.setString(3, user.getUserType());

                    statement2.executeUpdate();

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void userLogin(User user) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE userName=? AND password=?")) {

            statement.setString(1, user.getUserName());
            statement.setString(2, user.getPassword());

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {

                //String userType = resultSet.getString("userType");
                //  if ("admin".equals(userType)) {

                //should add redirect functionality to admin html page, but didn't manage to do that.

                //  } else
                //should add redirect functionality to a simple user html page, but didn't manage to do that.


            } else {
                JOptionPane.showMessageDialog(null, "Please Sign-up");
            }

        } catch (SQLException e) {
            e.printStackTrace();


        }


    }
}



