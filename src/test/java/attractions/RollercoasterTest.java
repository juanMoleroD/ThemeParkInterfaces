package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.*;

public class RollercoasterTest {

    RollerCoaster rollerCoaster;
    Visitor visitor;

    @Before
    public void setUp() {
        rollerCoaster = new RollerCoaster("Blue Ridge", 10);
    }

    @Test
    public void hasName() {
        assertEquals("Blue Ridge", rollerCoaster.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(10, rollerCoaster.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, rollerCoaster.getVisitCount());
    }

    @Test
    public void onlyVisitorsOver145cmAndOver18CanRide() {
        visitor = new Visitor(20, 1.50, 100.00);
        assertTrue(rollerCoaster.isAllowedTo(visitor));
        visitor = new Visitor(11, 1.50, 100);
        assertFalse(rollerCoaster.isAllowedTo(visitor));
        visitor = new Visitor(20, 1.4, 100);
        assertFalse(rollerCoaster.isAllowedTo(visitor));
    }

    @Test
    public void chargesDoubleToTallPeople() {
        visitor = new Visitor(20, 201, 100);
        assertEquals(16.8, rollerCoaster.priceFor(visitor), 0.0);
        visitor = new Visitor(20, 1.99, 100);
        assertEquals(8.4, rollerCoaster.priceFor(visitor), 0.0);
    }
}
