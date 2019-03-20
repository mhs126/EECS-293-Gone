package Test;

import gone.CoordinatePair;

import static org.junit.Assert.*;

public class CoordinatePairTest {

    CoordinatePair pair1 = new CoordinatePair(1,1);
    CoordinatePair pair2 = new CoordinatePair(1,1);
    CoordinatePair pair3 = new CoordinatePair(1,2);
    CoordinatePair pair4 = new CoordinatePair(2,1);
    CoordinatePair pair5 = new CoordinatePair(0,1);
    CoordinatePair pair6 = new CoordinatePair(-20000, 1);
    CoordinatePair pair7 = new CoordinatePair(100000, 1);
    CoordinatePair pair8 = new CoordinatePair(16385, 1);
    CoordinatePair pair9 = new CoordinatePair(16384, 16385);
    CoordinatePair pair10 = new CoordinatePair(-16384, -16385);

    /*
    Tests the equals method of the CoordinatePair class
    AssertEquals the expected return value and the actual of the equals method
    Three Cases: Pairs with same x and y locations
                 Pairs with same x but different y locations
                 Pairs with different x  but same y locations
    Testing Type: Structured Basis
    
     */
    @org.junit.Test
    public void equals() {
        //Pairs with same locations
        assertEquals(true, pair1.equals(pair2));

        //Pairs with different x-locations
        assertEquals(false, pair1.equals(pair3));

        //Pairs with different y-locations
        assertEquals(false, pair1.equals(pair4));
    }

    /*
    Tests ths hashCode method of the CoordinatePair class
    AssertEquals the expected integer value and the hachCode method called on a CoordinatePair
    Seven Cases: Ordinary CoordinatePair location
                X-location of 0
                X-location < 0
                X-location very large
                Coordinate pair values greater than 16384 that lead to the same hash value
                Large Positive Values
                Large Negative Values
    Testing Type: Boundary and Compound Boundary testing
     */
    @org.junit.Test
    public void hashCodeTest() {
        //Ordinary Pair
        assertEquals(16385, pair1.hashCode());

        //X = 0
        assertEquals(1, pair5.hashCode());

        //X < 0
        assertEquals(-163840000*2 + 1, pair6.hashCode());

        //X is large
        assertEquals(1638400000 + 1, pair7.hashCode());

        //Two pairs with the same hash code
        assertEquals(pair8.hashCode(), pair9.hashCode());

        //Two large coordinate values
        assertEquals(268451841, pair9.hashCode());

        //Testing two large negative coordinate values
        assertEquals(-268451841, pair10.hashCode());
    }

    /*
    Tests the getxLocation method in class CoordinatePair
    AssertEquals the expected x-location and the actual location
    Testing Type: Structured Basis
     */
    @org.junit.Test
    public void getxLocation() {
        assertEquals(1, pair1.getxLocation());
    }

    /*
    Tests the getyLocation method in class CoordinatePair
    AssertEquals the expected y-location and the actual location
    Testing Type: Structured Basis
     */
    @org.junit.Test
    public void getyLocation() {
        assertEquals(1, pair1.getyLocation());
    }


}