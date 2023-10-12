package com.jooby.app.repository;

import com.jooby.app.model.JobListing;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcJobListingEmployersRepository {

    public JdbcJobListingEmployersRepository() {

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

    public void addJobListingToEmployer(int employerID, int jobListingID) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO joblisting_employers (employerID, " +
                     "jobListingID) VALUES (?, ?)")) {
            preparedStatement.setInt(1, employerID);
            preparedStatement.setInt(2, jobListingID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<JobListing> getAllJobListingbyEmployer(int employerID) {
        List<JobListing> jobListingList = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT employers_joblisting.jobListingID, joblisting.jobTitle" +
                     "FROM employers_joblisting" +
                     "JOIN joblisting ON employers_joblisting.jobListingID = joblisting.jobListingID" +
                     "WHERE employers_joblisting.employerID = ?")) {

            preparedStatement.setInt(1, employerID);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int jobListingID = resultSet.getInt("jobListID");
                String jobListingTitle = resultSet.getString(" jobListingTitle");
                JobListing jobListing = new JobListing(jobListingID, jobListingTitle);
                jobListingList.add(jobListing);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jobListingList;
    }
}
