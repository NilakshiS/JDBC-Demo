package com.stackroute.jdbc;

import java.sql.*;
import java.util.Scanner;

public class JdbcTransactionDemo {
    public void insertWithTransaction(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/DEMODB", "root", "Root@123");
             PreparedStatement ps=connection.prepareStatement("insert into Employee values(?,?,?,?)")){

            connection.setAutoCommit(false);

            Scanner input = new Scanner(System.in);
            while(true){

                System.out.println("enter id");
                int id=Integer.parseInt(input.nextLine());

                System.out.println("enter name");
                String name=input.nextLine();

                System.out.println("enter age");
                int age=Integer.parseInt(input.nextLine());

                System.out.println("enter gender");
                String gender=input.nextLine();

                ps.setInt(1,id);
                ps.setString(2,name);
                ps.setInt(3,age);
                ps.setString(4,gender);
                ps.executeUpdate();

                System.out.println("commit/rollback? ");
                String answer=input.nextLine();

                if(answer.equals("commit")){
                    connection.commit();
                }
                if(answer.equals("rollback")){
                    connection.rollback();
                }


                System.out.println("Want to add more records y/n");
                String ans=input.nextLine();
                if(ans.equals("n")){
                    break;
                }

            }
            connection.commit();
            System.out.println("record successfully saved");
        }catch(Exception e){System.out.println(e);}
    }
}
