package com.revature.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
    private static Connection conn;
    private ConnectionUtil(){

    }

    public static Connection getConnection(){
        try {
            FileInputStream propertiesInput = new FileInputStream("/Users/truperti/Documents/Revature/sql.properties");
            Properties props = new Properties();
            props.load(propertiesInput);

            String url = (String) props.get("url");

            String username = (String) props.get("username");

            String password = (String) props.get("password");

//            System.out.println(password);
//            System.out.println(url);
//            System.out.println(username);

            if (conn == null) {
                try {
                    conn = DriverManager.getConnection(url, username, password);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return conn;
    }

}