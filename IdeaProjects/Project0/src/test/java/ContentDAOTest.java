import com.revature.dao.ContentDAO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ContentDAOTest {

    @BeforeEach
    public void setup(){
        ContentDAO dao = new ContentDAO();
    }

    @Test
    public void GetRecommendation() throws SQLException {
        String mood = "Happy";
        int timelength = 180;
        ContentDAO.MoodandTime(mood, timelength);
    }

    @Test
    public void AddRecommendation() throws SQLException {
        String title = "Mars Attacks";
        String mood = "Whacky";
        int timelength = 120;
        ContentDAO.Adder(title, mood, timelength);
    }
}
