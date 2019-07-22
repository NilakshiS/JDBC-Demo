package com.stackroute.jdbc;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.*;

public class RowSetDemo {

    public void getEmployeeDetails() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (JdbcRowSet rowSet = RowSetProvider.newFactory().createJdbcRowSet();) {

            rowSet.setUrl("jdbc:mysql://localhost:3306/DEMODB");
            rowSet.setUsername("root");
            rowSet.setPassword("Root@123");
            rowSet.setCommand("select * from Employee");
            rowSet.execute();

            while (rowSet.next()) {
                System.out.println("Id: " + rowSet.getInt(1) + " Name: " + rowSet.getString(2));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /*Print ResultSet in reverse order*/
    public void getEmployeeDetailsInReverse() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (JdbcRowSet rowSet = RowSetProvider.newFactory().createJdbcRowSet();) {

            rowSet.setUrl("jdbc:mysql://localhost:3306/DEMODB");
            rowSet.setUsername("root");
            rowSet.setPassword("Root@123");
            rowSet.setCommand("select * from Employee");
            rowSet.execute();

            rowSet.afterLast();
            while (rowSet.previous()) {
                System.out.println("Id: " + rowSet.getInt(1) + " Name: " + rowSet.getString(2));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*Move ResultSet to second row and print in reverse order*/
    public void getEmployeeDetailsFromSecondRowInReverse() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (JdbcRowSet rowSet = RowSetProvider.newFactory().createJdbcRowSet();) {

            rowSet.setUrl("jdbc:mysql://localhost:3306/DEMODB");
            rowSet.setUsername("root");
            rowSet.setPassword("Root@123");
            rowSet.setCommand("select * from Employee");
            rowSet.execute();

            rowSet.absolute(5);
            while (rowSet.previous()) {
                System.out.println("Id: " + rowSet.getInt(1) + " Name: " + rowSet.getString(2));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Use PreparedStatement to display by name and gender

    public void getEmployeeDetailsByNameAndGender(String name, String gender) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (JdbcRowSet rowSet = RowSetProvider.newFactory().createJdbcRowSet();
        ) {

            rowSet.setUrl("jdbc:mysql://localhost:3306/DEMODB");
            rowSet.setUsername("root");
            rowSet.setPassword("Root@123");
            rowSet.setCommand("select * from Employee where name=? and gender=?");

            rowSet.setString(1,name);
            rowSet.setString(2,gender);

            rowSet.execute();

            while (rowSet.next()) {
                System.out.println("Id: " + rowSet.getInt(1) + " Name: " + rowSet.getString(2));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
