package com.revature.driver;

import com.revature.model.Content;
import com.revature.util.ConnectionUtil;
import com.revature.dao.contentDAO;
import com.revature.arraylist.ArrayList;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

//The app is called Contento
public final class Driver {
    public static Connection conn = ConnectionUtil.getConnection();
    public static void main(String[] args) throws SQLException {

        conn.setAutoCommit(false);

        /*
        conn.setAutoCommit(false);
        conn.commit();
        why not autocommit?
        let's say we're inserting an artist followed by all their paintings
        to the DB -
        but for some reason our program / computer crashes halfway through inserting the
        paintings:
        it becomes difficult for us to know how information we're missing or has been lost
        this is a case where we need atomicity:
        either all transactions are completed, or all transactions fail
         */

        contentDAO contentdao = new contentDAO();


        try {
            Content someContent = contentdao.getAllContent();
                System.out.println(someContent);
        }catch(SQLException e){
            e.printStackTrace();
        }




    }
}