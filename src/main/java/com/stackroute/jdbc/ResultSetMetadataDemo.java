package com.stackroute.jdbc;

import java.sql.*;

public class ResultSetMetadataDemo {
    public void getResultSetMetaData(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/DEMODB", "root", "Root@123");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("Select * from Employee");) {

            ResultSetMetaData resultSetMetaData=resultSet.getMetaData();

            System.out.println("Total columns: "+resultSetMetaData.getColumnCount());
            System.out.println("Column Name of 1st column: "+resultSetMetaData.getColumnName(1));
            System.out.println("Column Type Name of 1st column: "+resultSetMetaData.getColumnTypeName(1));
            System.out.println("Name of the table to which 1st column belongs: "+resultSetMetaData.getTableName(1));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
