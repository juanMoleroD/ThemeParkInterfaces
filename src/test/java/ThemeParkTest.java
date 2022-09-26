import attractions.Dodgems;
import attractions.RollerCoaster;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import people.Visitor;
import stalls.ParkingSpot;
import stalls.TobaccoStall;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ThemeParkTest {
    Dodgems dodgems;
    RollerCoaster rollerCoaster;
    Visitor visitor;
    ThemePark themePark;


    @BeforeEach
    void setUp() {
        rollerCoaster = new RollerCoaster("The Roller coaster", 5);
        dodgems = new Dodgems("The Dodgems", 4);
        themePark = new ThemePark();
        visitor = new Visitor(17, 1.7, 100);

    }

    @Test
    void canCountAttractions() {
        themePark.addReviewedItem(rollerCoaster);
        assertEquals(1, themePark.getAllReviewed());
    }

    @Test
    void canUpdateVisitorVisitCount() {
        themePark.visit(visitor, rollerCoaster);
        assertEquals(1, visitor.getVisitedCount());
    }

    @Test
    void canUpdateVisitCountOnAttraction() {
        themePark.visit(visitor, rollerCoaster);
        assertEquals(1, rollerCoaster.getVisitCount());
    }

    @Test
    void canGetAllReviewedAndTheirReviews() {
        themePark.addReviewedItem(rollerCoaster);
        themePark.addReviewedItem(dodgems);
        assertEquals(5, themePark.getReviews().get("The Roller coaster"));
        assertEquals(4, themePark.getReviews().get("The Dodgems"));
    }

    @Test
    void canGetAllAvailableForVisitor() {
        TobaccoStall tobaccoStall = new TobaccoStall("Tobacco", 4, "Jack", ParkingSpot.A1);
        themePark.addReviewedItem(rollerCoaster);
        themePark.addReviewedItem(dodgems);
        themePark.addReviewedItem(tobaccoStall);
        
        assertEquals(rollerCoaster, themePark.getAllowedFor(visitor).get(0));
        assertEquals(2, themePark.getAllowedFor(visitor).size());
    }
}