import com.revature.arraylist.ArrayList;
import com.revature.model.Content;
import com.revature.util.ConnectionUtil;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArrayListTest {

    @BeforeAll
    public static void setup(){

    }

    @Test
    public void ContainsAddedContent() {
        ArrayList list = new ArrayList();
        Content nextThing = new Content("title", 30);
        String title = nextThing.toString();
        list.addElement(nextThing);
        assertTrue(list.contains(nextThing));
    }

    @Test
    public void GetElementTest() {
        Content e1 = new Content("Seinfeld", 30);
        Content e2 = new Content("Spongebob", 30);
        Content e3 = new Content("Breaking Bad", 50);

        ArrayList myContent = new ArrayList();
        myContent.addElement(e1);
        myContent.addElement(e2);
        myContent.addElement(e3);

        int upper = myContent.getLength();
        int int_random = 0;
        Random rand = new Random();
        int_random = rand.nextInt(upper);

        myContent.getElement(int_random);
    }

}
