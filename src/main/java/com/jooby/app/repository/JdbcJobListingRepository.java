package com.jooby.app.repository;

import com.jooby.app.model.Employer;
import com.jooby.app.model.JobListing;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcJobListingRepository {

    public JdbcJobListingRepository() {

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



    public void deleteJobListing(String jobTitle) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM joblisting WHERE jobTitle=?")) {

            statement.setString(1, jobTitle);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


