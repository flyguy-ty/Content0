package com.revature.dao;

import com.revature.arraylist.ArrayList;
import com.revature.driver.Driver;
import com.revature.util.ConnectionUtil;
import com.revature.model.Content;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.Random;


public class ContentDAO {

    static Connection conn;
    public static final Logger log = Logger.getLogger(ContentDAO.class);

    public ContentDAO(){
        conn = ConnectionUtil.getConnection();
    }

    public ArrayList getContent() {
        return null;
    }



        //User mood and free time input
    public static Content MoodandTime(String mood, int timelength) throws SQLException {
        ArrayList myContent = new ArrayList();

//        System.out.println("test3");
        PreparedStatement statement = conn.prepareStatement("Select title, timelength From Content Where mood = ?" +
                " AND timelength <= ?");


        int parameterIndex = 0;
        statement.setString(++parameterIndex, mood);
        statement.setInt(++parameterIndex, timelength);

        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
//            System.out.println("test6");

            Content nextThing = new Content(rs.getString("title"), rs.getInt("timelength"));
//            System.out.println("test6");
            myContent.addElement(nextThing);
        }
        rs.close();

//        System.out.println("test5");
        Random rand = new Random();
        int upper = myContent.getLength();
        int int_random = 0;
        if (upper <= 0) {
            Driver.log.info("No matches");
            System.out.println("Sorry, I got nothing :/ \n");
//                    System.out.println("Wanna try again?");
        } else {
            Driver.log.info(upper);
            int_random = rand.nextInt(upper);
            Driver.log.info(int_random);
//            System.out.println(content.getElement(int_random));
            Driver.log.info("Recommendation: " + myContent.getElement(int_random));
        }

//        System.out.println("test4");

        return myContent.getElement(int_random);
    }

    public static void Adder(String title, String mood, int timelength) throws SQLException {
        ArrayList myContent = new ArrayList();

        Statement statement = conn.createStatement();

        PreparedStatement insert = conn.prepareStatement("insert into content (title, mood, timelength) values(?,?,?)");
        int parameterIndex = 0;
        insert.setString(++parameterIndex, title);
        insert.setString(++parameterIndex,mood);
        insert.setInt(++parameterIndex, timelength);

        insert.executeUpdate();
        ContentDAO.log.info(title + " added to content");
        System.out.println("Thanks for the new content!");
    }
}



