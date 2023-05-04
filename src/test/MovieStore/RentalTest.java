package MovieStore;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class RentalTest {
    private Rental underTest;
    private Movie mockMovie;

    @Before
    public void setup() {
        mockMovie = new Movie("TestTitle", 0);
        underTest = new Rental(mockMovie, 1);
    }

    @Test
    public void testGetDaysRented() {
        assertEquals(1, underTest.getDaysRented());
    }

    @Test
    public void testGetMovie(){
        assertEquals(mockMovie, underTest.getMovie());
    }
}
