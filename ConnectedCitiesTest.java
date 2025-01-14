import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

public class ConnectedCitiesTest {
    @Test
    void testAreConnected() throws IOException {
        ConnectedCities cc = new ConnectedCities();
        cc.loadCities("test_cities.txt"); // Create a test file with appropriate test data

        assertTrue(cc.areConnected("London", "Bristol"));
        assertFalse(cc.areConnected("London", "Nottingham"));
        assertTrue(cc.areConnected("Southampton", "Birmingham"));
        assertFalse(cc.areConnected("Leicester", "Plymouth"));
    }
}