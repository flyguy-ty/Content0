import com.revature.util.ConnectionUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ConnectionUtilTest {

    @Test
    public void ConnectedtoDB(){
        Connection conn;
        conn = ConnectionUtil.getConnection();
        assertTrue(!conn.equals(null));
    }
}
