package MovieStore;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MovieTest {

    private Movie underTest;

    @Before
    public void setup() {
        underTest = new Movie("TestTitle", 0);
    }

    @Test
    public void testGetTitle() {
        assertEquals("TestTitle", underTest.getTitle());
    }

    @Test
    public void testGetPriceCode() {
        assertEquals(0, underTest.getPriceCode());
    }
}
