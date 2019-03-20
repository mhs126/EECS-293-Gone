package gone;

import java.util.HashMap;
import java.util.Map;

public class CoordinatePair {

    int xLocation;

    int yLocation;

    public CoordinatePair(int x, int y){
        this.xLocation = x;
        this.yLocation = y;
    }

    @Override
    public boolean equals(Object pair){
        if (this.yLocation == ((CoordinatePair)pair).yLocation && this.xLocation == ((CoordinatePair)pair).xLocation){
            return true;
        }
        return false;
    }

    @Override
    public int hashCode(){
        return this.xLocation*16384 + this.yLocation;
    }

    public int getxLocation() {
        return xLocation;
    }

    public int getyLocation() {
        return yLocation;
    }

    public static void main(String[] args){
        CoordinatePair c = new CoordinatePair(1,2);
        CoordinatePair c1 = new CoordinatePair(1,2);
        System.out.println(c.equals(c1));
        Map<CoordinatePair, Integer> map = new HashMap<>();
        map.put(c, 6);
        System.out.println(map.get(c1));
    }
}
