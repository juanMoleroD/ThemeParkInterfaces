package stalls;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import javax.swing.text.View;

import static org.junit.Assert.*;

public class TobaccoStallTest {

    TobaccoStall tobaccoStall;

    @Before
    public void setUp() throws Exception {
        tobaccoStall = new TobaccoStall("Jacks Drum", 5, "Jack Jarvis", ParkingSpot.B1);
    }

    @Test
    public void hasName() {
        assertEquals("Jacks Drum", tobaccoStall.getName());
    }

    @Test
    public void hasOwner() {
        assertEquals("Jack Jarvis", tobaccoStall.getOwnerName());
    }

    @Test
    public void hasParkingSpot() {
        assertEquals(ParkingSpot.B1, tobaccoStall.getParkingSpot());
    }

    @Test
    public void onlyAllows18AndOver() {
        Visitor visitor = new Visitor(17, 1.7, 100);
        assertFalse(tobaccoStall.isAllowedTo(visitor));
        visitor = new Visitor(18, 1.7, 100);
        assertTrue(tobaccoStall.isAllowedTo(visitor));
        visitor = new Visitor(20, 1.7, 100);
        assertTrue(tobaccoStall.isAllowedTo(visitor));
    }
}
