package org.example.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Configuration {
    private final static String url = "jdbc:postgresql://localhost:5432/java8";
    private final static  String user = "postgres";
    private final static  String password = "postgres";
    public static Connection getConnection(){
        Connection connection = null;
        try{
            connection = DriverManager.getConnection(url,user,password);
            System.out.println("Connected");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return connection;
    }
}
