package com.jooby.app.repository;

import com.jooby.app.model.Applicant;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcApplicantRepository {

    public JdbcApplicantRepository() {

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

    public List<Applicant> getAllApplicants() {
        List<Applicant> applicantsList = new ArrayList<>();

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM applicants ORDER BY applicantID")) {

            while (resultSet.next()) {
                int applicantID = resultSet.getInt("applicantID");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                String phoneNumber = resultSet.getString("phoneNumber");
                String emailAddress = resultSet.getString("emailAddress");
                String addressLine1 = resultSet.getString("addressLine1");
                String addressLine2 = resultSet.getString("addressLine2");
                String country = resultSet.getString("country");
                String state = resultSet.getString("state");
                String city = resultSet.getString("city");
                String personalidentificationnumber = resultSet.getString("personalidentificationnumber");

                Applicant applicant = new Applicant(applicantID,firstName,lastName,phoneNumber,emailAddress,addressLine1,addressLine2,country,state,city, personalidentificationnumber);

                applicant.setApplicantID(applicantID);
                applicant.setFirstName(firstName);
                applicant.setLastName(lastName);
                applicant.setPhoneNumber(phoneNumber);
                applicant.setEmailAddress(emailAddress);
                applicant.setAddressLine1(addressLine1);
                applicant.setAddressLine2(addressLine2);
                applicant.setCountry(country);
                applicant.setState(state);
                applicant.setCity(city);

                applicantsList.add(applicant);

            }
        }catch (SQLException e) {
            e.printStackTrace();
        }

        return applicantsList;
    }

    public void addApplicant(Applicant applicant) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM applicants WHERE personalidentificationnumber=?")) {

            statement.setString(1, applicant.getPersonalIdentificationNumber());

            ResultSet resultSet = statement.executeQuery();

            int counter = 0;

            while (resultSet.next()) {
                counter++;
            }

            if (counter > 0) {
                JOptionPane.showMessageDialog(null, "Applicant already added!");

            } else

                try (Connection connection1 = getConnection();
                     PreparedStatement statement1 = connection.prepareStatement("INSERT INTO applicants(firstName,lastName,phoneNumber,emailAddress, " +
                             "addressLine1, addressLine2,country, state, city" +
                             "personalidentificationnumber) VALUES(?,?,?,?)")) {

                    statement1.setString(1, applicant.getFirstName());
                    statement1.setString(2, applicant.getLastName());
                    statement1.setString(3, applicant.getPhoneNumber());
                    statement1.setString(4, applicant.getEmailAddress());
                    statement1.setString(5, applicant.getAddressLine1());
                    statement1.setString(6, applicant.getAddressLine2());
                    statement1.setString(7, applicant.getCountry());
                    statement1.setString(8, applicant.getState());
                    statement1.setString(9, applicant.getCity());
                    statement1.setString(10, applicant.getPersonalIdentificationNumber());

                    statement1.executeUpdate();

                } catch (SQLException e) {
                    e.printStackTrace();
                }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateApplicant(Applicant applicant) {
        try (Connection connection = getConnection();
             PreparedStatement statement2 = connection.prepareStatement("UPDATE applicants SET firstName=?, lastName=?, phoneNumber=?, emailAddress=?, addressLine1=?," +
                     "addressLine2=?, country=?, state=?, city=? WHERE personalidentificationnumber=?")) {


            statement2.setString(1, applicant.getFirstName());
            statement2.setString(2, applicant.getLastName());
            statement2.setString(3, applicant.getPhoneNumber());
            statement2.setString(4, applicant.getEmailAddress());
            statement2.setString(5, applicant.getAddressLine1());
            statement2.setString(6, applicant.getAddressLine2());
            statement2.setString(7, applicant.getCountry());
            statement2.setString(8, applicant.getState());
            statement2.setString(9, applicant.getCity());
            statement2.setString(10, applicant.getPersonalIdentificationNumber());

            statement2.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteApplicant(String personalidentificationnumber) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM applicants WHERE personalidentificationnumber=?")) {

            statement.setString(1, personalidentificationnumber);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
