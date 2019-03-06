
import java.util.ArrayList;
import java.util.List;

public class Pebble {

	private Color color;

	private int xLocation;

	private int yLocation;

	/*
	 * INPUT: INT, INT, COLOR 
	 * OUTPUT:NONE
	 * Constructor takes two int inputs and a color to
	 * set them as the x and y location as well as the color.
	 */

	public Pebble(int xLocation, int yLocation, Color color) {
		this.color = color;
		this.xLocation = xLocation;
		this.yLocation = yLocation;
	}

	/*
	 * INPUT:NONE
	 * OUTPUT:NONE
	 * changeColorToWhite() method will change the color of the pebble to white.
	 */
	public void changeColorToWhite() {
		this.color = Color.WHITE;
	}

	/*
	 * INPUT:NONE
	 * OUTPUT: neighborList
	 * isNeighbor() Accepts a Pebble and checks if this Pebble is a neighbor of the input Pebble.
	 */
	public List<String> getNeighborsLocations() {
		List<String> neighborList = new ArrayList<>();
		neighborList.add(this.xLocation + 1 + ", " + yLocation);
		neighborList.add(this.xLocation - 1 + ", " + yLocation);
		neighborList.add(this.xLocation + ", " + (yLocation - 1));
		neighborList.add(this.xLocation + ", " + (yLocation + 1));
		return neighborList;
	}
	
	public Color getColor() {
		return this.color;
	}
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * toString() method will create a string joining the pebble's locations
	 */
	public String toString() {
		return xLocation + ", " + yLocation;
	}

}
