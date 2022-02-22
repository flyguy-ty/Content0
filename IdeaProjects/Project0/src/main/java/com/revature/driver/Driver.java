package com.revature.driver;

import com.revature.model.Content;
import com.revature.util.ConnectionUtil;
import com.revature.dao.contentDAO;
import com.revature.arraylist.ArrayList;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.Random;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

//The app is called Contento
public final class Driver {
//    Establish connection
    public static Connection conn = ConnectionUtil.getConnection();
//    Initialize logger
    public static final Logger log = Logger.getLogger(Driver.class);

    public static void main(String[] args) throws SQLException {

        conn.setAutoCommit(true);

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

        //Opening interface
        Scanner sc = new Scanner(System.in);
        String path = null;
        boolean loop = true;
        System.out.println("Hello! I am Content0!");
        System.out.println("How may I help you?");
        while (true) {

            System.out.println("[R] Recommend some content " + "\n"
                    + "[A] Add something to the database" + "\n" + "[Q] Quit program");
            path = sc.nextLine();
            System.out.println(path);
            if (path.equals("r")|path.equals("R")) {
                ArrayList content = contentdao.MoodandTime();
                Random rand = new Random();
                int upper = content.getLength();
                if (upper <= 0){
                    System.out.println("Sorry, I got nothing :/ \n");
//                    System.out.println("Wanna try again?");
                }else {
                    Driver.log.info(upper);
                    int int_random = rand.nextInt(upper);
                    System.out.println(int_random);
                    System.out.println(content.getElement(int_random));
                    break;
                }
            } else if (path.equals("a")|path.equals("A")){
                contentdao.Adder();
                System.out.println("What would you like to do next?");;
            }  else if (path.equals("q")|path.equals("Q")) {
                System.out.println("See ya!");;
                break;
            }
            else {
                System.out.println("Invalid Key");
            }
        }


    }
}