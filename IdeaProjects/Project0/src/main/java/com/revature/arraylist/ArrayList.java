package com.revature.arraylist;

import java.util.Arrays;

//Lifted from Stack Overflow
//https://stackoverflow.com/questions/35880131/creating-an-array-list-from-scratch
public class ArrayList <T extends Object> {

    private static int initialCapacity = 5;
    private static int currentSize;
    private Object[] myArrayList = {}, temp = {};

    private static int currentIndex = 0;

    public ArrayList() {
        myArrayList = new Object[initialCapacity];
    }

    public ArrayList(int size) { //creates custom sized Array of Objects
        myArrayList = new Object[size];
    }

    public void addElement(Object entry) {
        //add element directy
        myArrayList[currentIndex] = entry;
        currentSize = myArrayList.length;
        currentIndex++;
        if (currentIndex == currentSize) {
            DoubleArray(currentSize);
        }
    }

    private void DoubleArray(int currentSize) {
        temp = myArrayList.clone();
        myArrayList = new ArrayList[2 * currentSize];  //myObject pointer big size data structure

//         myObject = temp.clone(); //probably I can do this here as well. Need to check this
        System.arraycopy(temp, 0, myArrayList, 0, currentSize);

    }

}
