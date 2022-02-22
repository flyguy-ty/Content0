import com.revature.arraylist.ArrayList;
import com.revature.model.Content;
import com.revature.util.ConnectionUtil;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArrayListTest {

    @BeforeAll
    public static void setup(){

    }

    @Test
    public void ContainsAddedContent() {
        ArrayList list = new ArrayList();
        Content nextThing = new Content("title");
        String title = nextThing.toString();
        list.addElement(title);
        assertTrue(list.contains(title));
    }

    @Test
    public void GetElementTest() {

    }

}
