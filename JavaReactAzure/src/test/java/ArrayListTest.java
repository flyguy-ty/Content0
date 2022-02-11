
import arraylists.ArrayList;
import org.junit.gen5.api.BeforeEach;
import org.junit.gen5.api.Test;
import org.junit.jupiter.api.BeforeAll;

public class ArrayListTest {
    /*
    I would like you all to write some automated testing methods
    in junit
    using:
    @Test
    some form of assertion
    (assertTrue, assertEquals)
    As well as continuing to work on your Arraylist implementations
    (make them generic if you like, it might help you
    on your projects)
     */
    @BeforeAll
    public void initialSetup(){

    }

    @BeforeEach
    void setup(){

    }

    @Test
    public void ContainsOneElement(){
        ArrayList newList = new ArrayList();
        String[] theList;
        theList = newList.addElement("Joe Rogan");
        newList.contains("Joe Rogan", theList);
    }

    @Test
    public void IdenticalLists(){
        ArrayList newList = new ArrayList();
        String[] theList;
        String[] otherList = {"Joe Rogan", "Andrew Schulz", "Aakash Singh"};
        theList = newList.addElement("Joe Rogan");
        theList = newList.addElement("Andrew Schulz");
        theList = newList.addElement("Aakash Singh");
        newList.sameList(theList, otherList);
    }


}