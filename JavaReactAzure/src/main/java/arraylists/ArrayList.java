package arraylists;
import java.util.Arrays;

public class ArrayList{

// Initialize array
    String[] comedians = new String[1];
// Constructor that creates an initial array of some size;
    public ArrayList(){
        //Don't think nothing needs to be here
    }
//    The current amount of somethings;
//    int amount = comedians.length;

// Get method that returns the something of a given index;
    String getElement(int i) {

        if (i > 0) {
            return comedians[i];
        }else{
            System.out.println("Index out of bounds");
            return null;
        }

    }

//    Contains method
    public void contains(String comedian, String[] list){

        int not = 0;
        for (int i = 0; i<list.length; i++){
            if (list[i].equals(comedian)){
                System.out.println("Comedian " + comedian + " is on the list.");
                not = -1;
                break;
            }
        }
        if (not != -1){
            System.out.println("Comedian " + comedian + " is NOT on the list.");
        }
    }

//    Add method
    int current = 0;
//    add method takes an array and a new element passed from main and returns a new array that includes the new element
    public String[] addElement(String comedian){

        if (current+1 > comedians.length){
            String[] newArrayList = new String[comedians.length+1];

            for (int i = 0; i < comedians.length; i++){
                newArrayList[i] = comedians[i];
            }
            comedians = newArrayList;
            comedians[current] = comedian;
            current++;
        }else {
            comedians[current] = comedian;
            current++;
        }

        System.out.println("Comedian " + comedian + " added to the list");
        System.out.println(Arrays.toString(comedians));
        return comedians;

    }

    public String[] addElement(String comedian, int index){
//        System.out.println(comedians.length);
        if (index+1 > comedians.length){
            String[] newArrayList = new String[index+1];
            for (int i = 0; i < comedians.length; i++){
                newArrayList[i] = comedians[i];
            }
            comedians = newArrayList;
            comedians[index] = comedian;
            current = index;
        }else {
            if (comedians[index] != null){

                String[] newArrayList = new String[current+1];
                for (int i=0; i < index; i++){
                    newArrayList[i] = comedians[i];
                }
                newArrayList[index] = comedian;
                for (int i=index+1; i<current+1; i++){
                    newArrayList[i] = comedians[i-1];
                }
                comedians = newArrayList;
                current++;
            }else{
                comedians[index] = comedian;
            }
        }
        System.out.println("Comedian " + comedian + " added to the list");
        System.out.println(Arrays.toString(comedians));
        return comedians;

    }
    public boolean sameList(String[] list1, String[] list2){
        if (list1.length != list2.length){
            System.out.println("Not the same list");
            return false;
        }
        for (int i = 0; i < list1.length; i++){
            if (!list1[i].equals(list2[i])){
                System.out.println("Not the same list");
                return false;
            } else{
                continue;
            }
        }
        System.out.println("It's the same list");
        return true;
    }
}

