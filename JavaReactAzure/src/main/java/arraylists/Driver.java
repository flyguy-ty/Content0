package arraylists;
import java.util.Arrays;

public class Driver {

    public static void main(String[] args){
        ArrayList newList = new ArrayList();
        String[] theList;
        theList = newList.addElement("Joe Rogan");
//        theList = newList.addElement("Andrew Schulz");
//        theList = newList.addElement("Shane Gillis");

        theList = newList.addElement("Aakash Singh", 2);
        theList = newList.addElement("Tom Segura", 1);


        //System.out.println(theList[1]);
        String[] otherList = {"Joe Rogan", "Andrew Schulz", "Aakash Singh"};
        //newList.sameList(theList, otherList);



        newList.contains("Joe Rogan", theList);
    }
}
