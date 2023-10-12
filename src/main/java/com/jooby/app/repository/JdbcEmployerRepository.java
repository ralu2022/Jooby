package com.jooby.app.repository;

import com.jooby.app.model.Employer;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcEmployerRepository {


    public JdbcEmployerRepository() {

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

    public List<Employer> getAllEmployers() {
        List<Employer> employerList = new ArrayList<>();

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM employers ORDER BY employerName")) {

            while (resultSet.next()) {
                int employerID = resultSet.getInt("employerID");
                String employerName = resultSet.getString("employerName");
                String addressLine1 = resultSet.getString("addressLine1");
                String addressLine2 = resultSet.getString("addressLine2");
                String city = resultSet.getString("city");
                String domain = resultSet.getString("domain");
                String country = resultSet.getString("country");

                Employer employer = new Employer(employerID, employerName, addressLine1, addressLine2, city, domain, country);

                employer.setEmployerID(employerID);
                employer.setEmployerName(employerName);
                employer.setAddressLine1(addressLine1);
                employer.setAddressLine2(addressLine2);
                employer.setCity(city);
                employer.setDomain(domain);
                employer.setCountry(country);

                employerList.add(employer);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employerList;


    }

    public void addEmployer(Employer employer) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM employers WHERE employerName=?")) {

            statement.setString(1, employer.getEmployerName());

            ResultSet resultSet = statement.executeQuery();

            int counter = 0;

            while (resultSet.next()) {
                counter++;
            }

            if (counter > 0) {
                JOptionPane.showMessageDialog(null, "Employer already added!");

            } else

                try (Connection connection1 = getConnection();
                     PreparedStatement statement1 = connection.prepareStatement("INSERT INTO authors(employerName, addressLine1, addressLine2, city, domain) VALUES(?,?,?,?,?)")) {

                    statement1.setString(1, employer.getEmployerName());
                    statement1.setString(2, employer.getAddressLine1());
                    statement1.setString(3, employer.getAddressLine2());
                    statement1.setString(4, employer.getCity());
                    statement1.setString(5, employer.getDomain());

                    statement1.executeUpdate();

                } catch (SQLException e) {
                    e.printStackTrace();
                }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateEmployer(Employer employer) {
      try (Connection connection = getConnection();
    PreparedStatement statement1 = connection.prepareStatement("UPDATE employers SET employerName=?, addressLine1=?, addressLine2=?, city=?, domain=?" +
            ", country=? WHERE employerName=?")) {


        statement1.setString(1, employer.getEmployerName());
        statement1.setString(2, employer.getAddressLine2());
        statement1.setString(3, employer.getAddressLine2());
        statement1.setString(4, employer.getCity());
        statement1.setString(5, employer.getDomain());
        statement1.setString(6,employer.getCountry());

        statement1.executeUpdate();

    } catch (SQLException e) {
        e.printStackTrace();
    }
}

    public void deleteEmployer(String employerName) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM employers WHERE employerName=?")) {

            statement.setString(1, employerName);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
