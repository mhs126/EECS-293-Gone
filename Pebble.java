package gone;

import java.util.ArrayList;
import java.util.List;

public class Pebble {

    private Color color;

    private int xLocation;

    private int yLocation;

    public Pebble(int xLocation, int yLocation, Color color){
        this.color = color;
        this.xLocation = xLocation;
        this.yLocation = yLocation;
    }

    public void changeColorToWhite(){
        this.color = Color.WHITE;
    }


    public List<String> getNeighborsLocations(){
        List<String> neighborList = new ArrayList<>();
        neighborList.add(this.xLocation+1 + ", " + yLocation);
        neighborList.add(this.xLocation-1 + ", " + yLocation);
        neighborList.add(this.xLocation + ", " + (yLocation-1));
        neighborList.add(this.xLocation + ", " + (yLocation+1));
        return neighborList;
    }


    public Color getColor(){
        return this.color;
    }

    public String toString(){
        return xLocation + ", " + yLocation;
    }


}
