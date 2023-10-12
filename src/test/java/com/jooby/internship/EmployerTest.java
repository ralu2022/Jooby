package com.jooby.internship;

import com.jooby.app.model.Employer;
import com.jooby.app.repository.JdbcEmployerRepository;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;
public class EmployerTest extends JdbcEmployerRepository {

    private JdbcEmployerRepository employerTest = new JdbcEmployerRepository();

    @Test

    public void allEmployersTest() throws SQLException, ClassNotFoundException {
        List<Employer> employerList = employerTest.getAllEmployers();

        employerList.forEach(System.out::println);
    }
}
