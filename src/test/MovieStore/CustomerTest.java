package MovieStore;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerTest {

    private Customer underTest;

    @Before
    public void setUp() {
        underTest = new Customer("Max Mustermann");
    }

    @Test
    public void testGetName(){
        assertEquals("Max Mustermann", underTest.getName());
    }

    @Test
    public void testStatementWithoutRental(){
        String result = "Rental Record for " + underTest.getName() + "\n";
        result += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";
        result += "Amount owed is " + 0.0 + "\n";
        result += "You earned " + 0 + " frequent renter points";

        assertEquals(result, underTest.statement());
    }

    @Test
    public void testStatementWithRentalForRegularMovie(){
        Rental mockRental = new Rental(new Movie("MovieTitle", 0), 3);
        underTest.addRental(mockRental);

        String result = "Rental Record for " + underTest.getName() + "\n";
        result += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";
        result += "\t" + "MovieTitle" + "\t" + "\t" + 3 + "\t" + 3.5 + "\n";
        result += "Amount owed is " + 3.5 + "\n";
        result += "You earned " + 1 + " frequent renter points";

        assertEquals(result, underTest.statement());
    }

    @Test
    public void testStatementWithRentalForNewReleaseMovie(){
        Rental mockRental = new Rental(new Movie("MovieTitle", 1), 3);
        underTest.addRental(mockRental);

        String result = "Rental Record for " + underTest.getName() + "\n";
        result += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";
        result += "\t" + "MovieTitle" + "\t" + "\t" + 3 + "\t" + 9.0 + "\n";
        result += "Amount owed is " + 9.0 + "\n";
        result += "You earned " + 2 + " frequent renter points";

        assertEquals(result, underTest.statement());
    }

    @Test
    public void testStatementWithRentalForChildrenMovie(){
        Rental mockRental = new Rental(new Movie("MovieTitle", 2), 3);
        underTest.addRental(mockRental);

        String result = "Rental Record for " + underTest.getName() + "\n";
        result += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";
        result += "\t" + "MovieTitle" + "\t" + "\t" + 3 + "\t" + 1.5 + "\n";
        result += "Amount owed is " + 1.5 + "\n";
        result += "You earned " + 1 + " frequent renter points";

        assertEquals(result, underTest.statement());
    }

}
