package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.*;

public class PlaygroundTest {
    Playground playground;

    @Before
    public void setUp() throws Exception {
        playground = new Playground("Fun Zone", 7);
    }

    @Test
    public void hasName() {
        assertEquals("Fun Zone", playground.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(7, playground.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, playground.getVisitCount());
    }

    @Test
    public void onlyAllowsUnder15() {
        Visitor visitor = new Visitor(14, 1.5, 100);
        assertTrue(playground.isAllowedTo(visitor));
        visitor = new Visitor(16, 1.5, 100);
        assertFalse(playground.isAllowedTo(visitor));
        visitor = new Visitor(15, 1.3, 100);
        assertTrue(playground.isAllowedTo(visitor));

    }
}
