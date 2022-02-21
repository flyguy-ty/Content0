package com.revature.dao;

import com.revature.arraylist.ArrayList;
import com.revature.util.ConnectionUtil;
import com.revature.model.Content;

import java.sql.*;
import java.util.Scanner;


public class contentDAO {

    static Connection conn;

    public contentDAO(){
        conn = ConnectionUtil.getConnection();;
    }

    public ArrayList<Content> getContent() {
        return null;
    }

    public static Content getAllContent() throws SQLException {
        Content myContent = null;

        String mood= null;
        int timelength = 0;
        Scanner sc = new Scanner(System.in);
        while (mood == null & timelength == 0) {
            System.out.println("What is your current mood?");
            mood = sc.nextLine();
            System.out.println("How much time do you have?");
            timelength = Integer.parseInt(sc.nextLine());
            System.out.println("Your input: " + mood + ',' + timelength);
        }

        PreparedStatement statement = conn.prepareStatement("Select title From Content Where mood = ?" +
                                                                " AND timelength < ?" );
        int parameterIndex = 0;
        statement.setString(++parameterIndex, mood);
        statement.setInt(++parameterIndex, timelength);

        ResultSet rs = statement.executeQuery();


        while(rs.next()){
            myContent = new Content(
                    rs.getString("title"));
        }
        rs.close();
        return myContent;
    }

}



