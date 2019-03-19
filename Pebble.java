package gone;

import gone.Color;

import java.util.ArrayList;
import java.util.List;

public class Pebble {

    private Color color;

    private int xLocation;

    private int yLocation;

    private CoordinatePair pair;

    /*
     * @param: xlocation, ylocation and color of pebble
     * Constructor takes two int inputs and a color to
     * set them as the x and y location as well as the color.
     */

    public Pebble(int xLocation, int yLocation, Color color, CoordinatePair pair) {
        this.color = color;
        this.xLocation = xLocation;
        this.yLocation = yLocation;
        this.pair = pair;
    }

    /*
     * changeColorToWhite() method will change the color of the pebble to white.
     */
    public void changeColorToWhite() {
        this.color = Color.WHITE;
    }

    /*
     * @return list of neighbor locations
     * isNeighbor() Accepts a Pebble and checks if this Pebble is a neighbor of the input Pebble.
     */
    public List<CoordinatePair> getNeighborsLocations() {
        List<CoordinatePair> neighborList = new ArrayList<>();
        neighborList.add(new CoordinatePair(pair.getxLocation()+1, pair.getyLocation()));
        neighborList.add(new CoordinatePair(pair.getxLocation()-1, pair.getyLocation()));
        neighborList.add(new CoordinatePair(pair.getxLocation(), pair.getyLocation()+1));
        neighborList.add(new CoordinatePair(pair.getxLocation(), pair.getyLocation()-1));
        return neighborList;
    }

    public Color getColor() {
        return this.color;
    }
    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     * @return string of location
     * toString() method will create a string joining the pebble's locations
     */
    public String toString() {
        return xLocation + ", " + yLocation;
    }

    public CoordinatePair getPair(){ return pair;}

}