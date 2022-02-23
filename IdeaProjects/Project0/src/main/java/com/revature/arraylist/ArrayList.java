package com.revature.arraylist;

import com.revature.model.Content;

//Testarino
public class ArrayList{

    // Initialize array
    Content[] things = new Content[1];
    // Constructor that creates an initial array of some size;
    public ArrayList(){
        //Don't think nothing needs to be here
    }
//    The current amount of somethings;
//    int amount = things.length;

    // Get method that returns the something of a given index;

    public Content getElement(int i) {

        if (i >= 0) {
            return things[i];
        }else{
            System.out.println("Index out of bounds");
            return null;
        }

    }

    //    Contains method
    public boolean contains(String title){
        for (int i = 0; i<things.length; i++) {
            if (things[i].getTitle().equals(title)) {
//                System.out.println("thing " + title + " is on the list.");
                return true;
            }
            System.out.println("title: " + title + ", things[i].getTitle(): "+ things[i].getTitle());
        }
        return false;
    }

    //    Add method
    int current = 0;
    //    add method takes an array and a new element passed from main and returns a new array that includes the new element
    public Content[] addElement(Content thing){

        if (current+1 > things.length){
            Content[] newArrayList = new Content[things.length+1];

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
//        System.out.println(Arrays.toContent(things));
        return things;

    }


    public int getLength(){
        return current;
    }
}

