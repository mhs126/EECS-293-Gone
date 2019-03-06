
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {

	private int height;

	private int width;

	private Map<String, Pebble> blackMap = new HashMap<>();

	private List<Pebble> whiteList = new ArrayList<>();

	/*
	 * @param: Height, Width, Pebble List
	 * Constructor takes two ints and a
	 * list of pebbles, which will indicate the width, height and board
	 * configuration. Within the constructor the list of pebbles will be sorted
	 * into the field variables of a white and black list
	 */
	public Board(int height, int width, List<Pebble> pebbleList) {
		this.height = height;
		this.width = width;
		this.sortByColor(pebbleList);
	}

	/*
	 * @param: List of pebbles 
	 * sortPebblesByColor() accepts a list of pebbles and sorts the pebbles into their appropriate field variable
	 * list, returns nothing.
	 */
	public void sortByColor(List<Pebble> p) {
		for (Pebble pebble : p) {
			if (pebble.getColor() == Color.BLACK) {
				blackMap.put(pebble.toString(), pebble);
			} else {
				whiteList.add(pebble);
			}
		}
	}

	/* @param: counter
	 * @return: counter
	 * replaceWhiteAdjacentPebbles() Takes an integer of iterations as input, identifies 
	 * where the white pebbles neighbors are, and looks for the neighbors in the blackmap to remove
	 * and add to the white pebble list
	 */
	public int changeBlackPebbles(int steps) {
		List<Pebble> changedPebbles = new ArrayList<>();
		for (Pebble pebble : whiteList) {
			for (String string : pebble.getNeighborsLocations()) {
				Pebble p = blackMap.get(string);
				if (p != null) {
					blackMap.remove(string);
					p.changeColorToWhite();
					changedPebbles.add(p);
				}
			}
		}
		if (changedPebbles.isEmpty()) {
			return steps;
		} else {
			whiteList.addAll(changedPebbles);
			return this.changeBlackPebbles(steps + 1);
		}
	}
	/*
	 * @return a string stating the amount of turns took and the number of black pebbles remaining
	 */
	public String gameResult() {
		return "It took " + this.changeBlackPebbles(0) + " steps to change the pebbles " + "and there are "
				+ blackMap.size() + " black pebbles left";
	}

	public static void main(String[] args) {
		Pebble p = new Pebble(1, 1, Color.WHITE);
		Pebble p1 = new Pebble(1, 2, Color.BLACK);
		Pebble p2 = new Pebble(1, 3, Color.BLACK);
		Pebble p3 = new Pebble(1, 0, Color.BLACK);
		Pebble p4 = new Pebble(2, 6, Color.BLACK);
		List<Pebble> list = new ArrayList<>();
		list.add(p);
		list.add(p1);
		list.add(p2);
		list.add(p3);
		list.add(p4);
		Board b = new Board(2, 2, list);
		System.out.println(b.gameResult());
	}

}
