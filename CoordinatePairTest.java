package Test;

import gone.CoordinatePair;

import static org.junit.Assert.*;

public class CoordinatePairTest {

    CoordinatePair pair1 = new CoordinatePair(1,1);
    CoordinatePair pair2 = new CoordinatePair(1,1);
    CoordinatePair pair3 = new CoordinatePair(1,2);
    CoordinatePair pair4 = new CoordinatePair(2,1);

    /*
    Tests the equals method of the CoordinatePair class
    AssertEquals the expected return value and the actual of the equals method
    Three Cases: Pairs with same x and y locations
                 Pairs with same x but different y locations
                 Pairs with different x  but same y locations
    
     */
    @org.junit.Test
    public void equals() {
        assertEquals(true, pair1.equals(pair2));
        assertEquals(false, pair1.equals(pair3));
        assertEquals(false, pair1.equals(pair4));
    }

    @org.junit.Test
    public void hashCodeTest() {
    }

    @org.junit.Test
    public void getxLocation() {
    }

    @org.junit.Test
    public void getyLocation() {
    }
}