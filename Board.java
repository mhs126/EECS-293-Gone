package gone;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {

    private int height;

    private int width;

    private Map<CoordinatePair, Pebble> blackMap = new HashMap<>();

    private List<Pebble> whiteList = new ArrayList<>();

    /*
     * @param: Height, Width, Pebble List
     * Constructor takes two ints and a
     * list of pebbles, which will indicate the width, height and board
     * configuration. Within the constructor the list of pebbles will be sorted
     * into the field variables of a white and black list
     */
    public Board(int height, int width, List<Pebble> pebbleList){
        this.height = height;
        this.width = width;
        this.sortByColor(pebbleList);
    }

    /*
     * @param: List of pebbles
     * sortPebblesByColor() accepts a list of pebbles and sorts the pebbles into their appropriate field variable
     * list, returns nothing.
     */
    public void sortByColor(List<Pebble> p){
        for (Pebble pebble : p){
            if(pebble.getColor() == Color.BLACK){
                blackMap.put(pebble.getPair(), pebble);
            }
            else{
                whiteList.add(pebble);
            }
        }
    }

    /* @param: counter, index
     * @return: counter
     * replaceWhiteAdjacentPebbles() Takes an integer of iterations and starting index as inputs, identifies
     * where the white pebbles neighbors are, and looks for the neighbors in the blackmap to remove
     * and add to the white pebble list
     * called recursively with steps incremented by one and the current index
     * Run Time: n^2*m where n is number of white Pebbles and m is number of black Pebbles
     */
    public int changeBlackPebblesRecursively(int steps, int index) {
        List<Pebble> changedPebbles = new ArrayList<>();
        int x;
        for (x = index; x < whiteList.size(); x++) {
            for (CoordinatePair pair : whiteList.get(x).getNeighborsLocations()) {
                Pebble p = blackMap.get(pair);
                if (p != null) {
                    blackMap.remove(pair);
                    p.changeColorToWhite();
                    changedPebbles.add(p);
                }
                //else we do nothing
            }
        }
        if(changedPebbles.isEmpty()) {
            return steps;
        }
        else{
            whiteList.addAll(changedPebbles);
            return this.changeBlackPebblesRecursively(steps + 1, x);
        }
    }

    /*
     * @return a string stating the amount of turns took and the number of black pebbles remaining
     */
    public String gameResult(){
        return "It took " + this.changeBlackPebblesRecursively(0, 0) + " steps to change the pebbles " +
                "and there are " + blackMap.size() + " black pebbles left";
    }

    public List<Pebble> getWhiteList(){
        return whiteList;
    }

    public Map<CoordinatePair, Pebble> getBlackMap() {
        return blackMap;
    }

    public static void main(String[] args){
        Pebble p = new Pebble(Color.WHITE, new CoordinatePair(3,3));
        Pebble p1 = new Pebble(Color.BLACK, new CoordinatePair(1,3));
        Pebble p2 = new Pebble(Color.BLACK, new CoordinatePair(2,3));
        Pebble p3 = new Pebble(Color.BLACK, new CoordinatePair(3,2));
        Pebble p4 = new Pebble(Color.BLACK, new CoordinatePair(3,1));
        Pebble p5 = new Pebble(Color.WHITE, new CoordinatePair(2,2));
        Pebble p6 = new Pebble(Color.BLACK, new CoordinatePair(1,1));

        Pebble pp = new Pebble(Color.WHITE, new CoordinatePair(1,1));
        Pebble pp1 = new Pebble(Color.BLACK, new CoordinatePair(1,2));
        Pebble pp2 = new Pebble( Color.BLACK, new CoordinatePair(2,2));
        Pebble pp3 = new Pebble( Color.BLACK, new CoordinatePair(2,3));
        Pebble pp4 = new Pebble( Color.BLACK, new CoordinatePair(3,3));
        Pebble pp5 = new Pebble(Color.BLACK, new CoordinatePair(3,4));
        Pebble pp6 = new Pebble(Color.BLACK, new CoordinatePair(4,4));

        List<Pebble> testList2 = new ArrayList<>();
        testList2.add(pp);
        testList2.add(pp1);
        testList2.add(pp2);
        testList2.add(pp3);
        testList2.add(pp4);
        testList2.add(pp5);
        testList2.add(pp6);

        List<Pebble> list = new ArrayList<>();
        list.add(p);
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        list.add(p5);
        list.add(p6);
        Board b = new Board(6,6,list);
        Board b2 = new Board(5,5,testList2);
        System.out.println(b.gameResult());
        System.out.println(b2.gameResult());
    }

    /*
    changeBlackPebbles algorithm runtime: (n^2 * m)
        n = number of white pebbles
        m = number of black pebbles
        The first run through of this method has a run time of 4n because a list of 4 is run through
        for every Pebble white pebble but since the 4 is negligible, we ignore it
        The extra n*m comes from the recursion, it is the worst case number of recursive calls
    changeBlackPebbles algorithm correctness:
        The algorithm will find and change the black neighbors from the initial index till the end of the array
        Any pebbles changed are added onto the end of the list of white pebbles
        The algorithm is called again starting from the point it left off
        Based on step one, all black pebbles will be correctly changed
     */

}