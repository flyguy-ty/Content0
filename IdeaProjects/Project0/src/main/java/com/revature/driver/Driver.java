package com.revature.driver;

import com.revature.model.Content;
import com.revature.util.ConnectionUtil;
import com.revature.dao.ContentDAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

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


        ContentDAO contentdao = new ContentDAO();

        //Opening interface
        Scanner sc1 = new Scanner(System.in);
        String path = null;

        System.out.println("Hello! I am Content0!");
        System.out.println("How may I help you?");

        while (true) {
            System.out.println("[R] Recommend some content " + "\n"
                    + "[A] Add something to the database" + "\n" + "[Q] Quit program" + "\n");
            path = sc1.nextLine();
//            System.out.println(path);

            if (path.equals("r")|path.equals("R")) {
                String mood= null;
                int timelength = 0;
                Scanner sc2 = new Scanner(System.in);
                while (mood == null & timelength == 0) {
                    System.out.println("What is your current mood?");
                    mood = sc2.nextLine();
                    System.out.println("How much time do you have (in minutes)?");
                    timelength = Integer.parseInt(sc2.nextLine());
                    System.out.println("Your input: " + mood + ", " + timelength);
                }
                try {
//                    System.out.println("test1");
                    Content content = contentdao.MoodandTime(mood, timelength);
//                    System.out.println("test2"`);
                    //Print the content here or something
                    if (content == null){
                        //System.out.println("null");
                        continue;
                    }else {
                        System.out.println(content.toString());
                        break;
                    }
                }catch (SQLException e){}
            } else if (path.equals("a")|path.equals("A")){
                String title = null;
                String mood = null;
                int timelength = 0;
                Scanner sc3 = new Scanner(System.in);
                while (title == null & mood == null & timelength == 0) {
                    System.out.println("What is the title?");
                    title = sc3.nextLine();
                    System.out.println("Describe the mood in one word");
                    mood = sc3.nextLine();
                    System.out.println("How long is it?");
                    timelength = sc3.nextInt();
                }
                try {
                    contentdao.Adder(title, mood, timelength);
                    System.out.println("What would you like to do next?");
                }catch (SQLException e){}


            }  else if (path.equals("q")|path.equals("Q")) {
                System.out.println("See ya!");
                Driver.log.info("Quitting Program");
                break;
            }
            else {
                Driver.log.info("bad entry");
                System.out.println("Invalid Key");
            }
        }
    }
}