package com.revature.dao;

import com.revature.arraylist.ArrayList;
import com.revature.util.ConnectionUtil;
import com.revature.model.Content;

import java.sql.*;
import java.util.Scanner;


public class contentDAO {

    static Connection conn;

    public contentDAO(){
        conn = ConnectionUtil.getConnection();
    }

    public ArrayList getContent() {
        return null;
    }



        //User mood and free time input
    public static ArrayList MoodandTime() throws SQLException {
        ArrayList myContent = new ArrayList();
        String mood= null;
        int timelength = 0;

        PreparedStatement statement = conn.prepareStatement("Select title From Content Where mood = ?" +
                " AND timelength <= ?" );

        Scanner sc = new Scanner(System.in);
        while (mood == null & timelength == 0) {
            System.out.println("What is your current mood?");
            mood = sc.nextLine();
            System.out.println("How much time do you have?");
            timelength = Integer.parseInt(sc.nextLine());
            System.out.println("Your input: " + mood + ',' + timelength);
        }


        int parameterIndex = 0;
        statement.setString(++parameterIndex, mood);
        statement.setInt(++parameterIndex, timelength);

        ResultSet rs = statement.executeQuery();


        while(rs.next()){
            Content nextThing = new Content(rs.getString("title"));
//            System.out.println(nextThing.toString());
            myContent.addElement(nextThing.toString());
        }
        rs.close();
        return myContent;
    }

    public void Adder() throws SQLException {
        ArrayList myContent = new ArrayList();

        String title = null;
        String mood = null;
        int timelength = 0;
        Scanner sc = new Scanner(System.in);

        Statement statement = conn.createStatement();

        while (title == null & mood == null & timelength == 0) {
            System.out.println("What is the title?");
            title = sc.nextLine();
            System.out.println("Describe the mood in one word");
            mood = sc.nextLine();
            System.out.println("How long is it?");
            timelength = sc.nextInt();
        }

        PreparedStatement insert = conn.prepareStatement("insert into content (title, mood, timelength) values(?,?,?)");
        int parameterIndex = 0;
        insert.setString(++parameterIndex, title);
        insert.setString(++parameterIndex,mood);
        insert.setInt(++parameterIndex, timelength);

        insert.executeUpdate();
    }
}



