package com.stackroute.jdbc;

public class App 
{
    public static void main( String[] args )
    {
        //Operations using SimpleJdbcDemo
        SimpleJdbcDemo simpleJdbcDemo = new SimpleJdbcDemo();

        simpleJdbcDemo.getEmployeeDetails();
        System.out.println("\n\n");
        simpleJdbcDemo.getEmployeeDetailsInReverse();
        System.out.println("\n\n");
        simpleJdbcDemo.getEmployeeDetailsFromSecondRowInReverse();
        System.out.println("\n\n");
        simpleJdbcDemo.getEmployeeDetailsByNameAndGender("Nilakshi","Female");
        System.out.println("\n\n");

        //printing Database meta data
        DatabaseMetadataDemo databaseMetadataDemo = new DatabaseMetadataDemo();
        databaseMetadataDemo.getDatabaseMetadata();
        System.out.println("\n\n");

        //printing result set metadata
        ResultSetMetadataDemo resultSetMetadataDemo = new ResultSetMetadataDemo();
        resultSetMetadataDemo.getResultSetMetaData();

        //Operations using Rowset
        RowSetDemo rowSetDemo = new RowSetDemo();
        rowSetDemo.getEmployeeDetails();
        System.out.println("\n\n");
        rowSetDemo.getEmployeeDetailsInReverse();
        System.out.println("\n\n");
        rowSetDemo.getEmployeeDetailsFromSecondRowInReverse();
        System.out.println("\n\n");
        rowSetDemo.getEmployeeDetailsByNameAndGender("Nilakshi","Female");
        System.out.println("\n\n");

        //JDBC Batch queries
        JdbcBatchDemo jdbcBatchDemo = new JdbcBatchDemo();
        jdbcBatchDemo.insertEmployeeDetails();
        jdbcBatchDemo.getEmployeeDetails();
        System.out.println("\n\n");

        //JDBC transactions
        JdbcTransactionDemo jdbcTransactionDemo = new JdbcTransactionDemo();
        jdbcTransactionDemo.insertWithTransaction();
    }
}
