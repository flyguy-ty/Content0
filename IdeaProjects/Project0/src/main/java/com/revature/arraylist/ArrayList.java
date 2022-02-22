package com.revature.arraylist;

import java.util.Arrays;
//Testarino
public class ArrayList{

    // Initialize array
    String[] things = new String[1];
    // Constructor that creates an initial array of some size;
    public ArrayList(){
        //Don't think nothing needs to be here
    }
//    The current amount of somethings;
//    int amount = things.length;

    // Get method that returns the something of a given index;

    public String getElement(int i) {

        if (i >= 0) {
            return things[i];
        }else{
            System.out.println("Index out of bounds");
            return null;
        }

    }

    //    Contains method
    public boolean contains(String thing){
        for (int i = 0; i<things.length; i++) {
            if (things[i].equals(thing)) {
                System.out.println("thing " + thing + " is on the list.");
                return true;
            }
            System.out.println("thing " + thing + " is NOT on the list.");
        }
        return false;
    }

    //    Add method
    int current = 0;
    //    add method takes an array and a new element passed from main and returns a new array that includes the new element
    public String[] addElement(String thing){

        if (current+1 > things.length){
            String[] newArrayList = new String[things.length+1];

            for (int i = 0; i < things.length; i++){
                newArrayList[i] = things[i];
            }
            things = newArrayList;
            things[current] = thing;
            current++;
        }else {
            things[current] = thing;
            current++;
        }

//        System.out.println("thing " + thing + " added to the list");
//        System.out.println(Arrays.toString(things));
        return things;

    }


    public int getLength(){
        return current;
    }
}

