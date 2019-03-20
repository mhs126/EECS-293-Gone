package Test;

import gone.Color;
import gone.CoordinatePair;
import gone.Pebble;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PebbleTest {

    Pebble p = new Pebble(Color.WHITE, new CoordinatePair(3,3));
    Pebble p1 = new Pebble(Color.BLACK, new CoordinatePair(1,3));

    Pebble pn1 = new Pebble(Color.BLACK, new CoordinatePair(2,2));
    Pebble pn2 = new Pebble(Color.BLACK, new CoordinatePair(3,2));
    Pebble pn3 = new Pebble(Color.BLACK, new CoordinatePair(1,2));
    Pebble pn4 = new Pebble(Color.BLACK, new CoordinatePair(2,3));
    Pebble pn5 = new Pebble(Color.BLACK, new CoordinatePair(2,1));

    /*
    Tests the changeColorToWhite method of class Pebble
    AssertEquals the Color white and the actual color of a Pebble
    Two Cases: Pebble starts white
               Pebble starts black
    Testing Type: Structured Basis
     */
    @Test
    public void changeColorToWhite() {
        //Pebble starts White
        p.changeColorToWhite();
        assertEquals(Color.WHITE, p.getColor());

        //Pebble starts black
        p1.changeColorToWhite();
        assertEquals(Color.WHITE, p1.getColor());
    }

    /*
    Tests the getNeighborsLocations from the Pebble Class
    AssertEquals the expected list of locations with the actual list
    Testing Type: Structured Basis
     */
    @Test
    public void getNeighborsLocations() {
        List<CoordinatePair> neighborList = new ArrayList<>();
        neighborList.add(pn2.getPair());
        neighborList.add(pn3.getPair());
        neighborList.add(pn4.getPair());
        neighborList.add(pn5.getPair());
        assertEquals(neighborList, pn1.getNeighborsLocations());
    }

    @Test
    public void getColor() {
    }

    @Test
    public void getPair() {
    }
}