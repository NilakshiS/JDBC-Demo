package com.stackroute.jdbc;

import java.sql.*;

public class JdbcBatchDemo {
    public void insertEmployeeDetails() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/DEMODB", "root", "Root@123");
             Statement statement = connection.createStatement();
             ) {

            connection.setAutoCommit(false);
            statement.addBatch("insert into Employee values (6,'Shirin',22,'female')");
            statement.addBatch("insert into Employee values (7,'Monica',22,'female')");
            statement.addBatch("insert into Employee values (8,'Kirti',22,'female')");

            statement.executeBatch();

            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void getEmployeeDetails() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/DEMODB", "root", "Root@123");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("Select * from Employee");) {
            while (resultSet.next()) {
                System.out.println("Id: " + resultSet.getInt(1) + " Name: " + resultSet.getString(2));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
