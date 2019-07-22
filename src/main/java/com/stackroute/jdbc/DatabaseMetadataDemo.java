package com.stackroute.jdbc;

import java.sql.*;

public class DatabaseMetadataDemo {
    public void getDatabaseMetadata(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/DEMODB", "root", "Root@123")) {

            DatabaseMetaData databaseMetaData = connection.getMetaData();
            System.out.println("Driver Name: "+databaseMetaData.getDriverName());
            System.out.println("Driver Version: "+databaseMetaData.getDriverVersion());
            System.out.println("UserName: "+databaseMetaData.getUserName());
            System.out.println("Database Product Name: "+databaseMetaData.getDatabaseProductName());
            System.out.println("Database Product Version: "+databaseMetaData.getDatabaseProductVersion());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
