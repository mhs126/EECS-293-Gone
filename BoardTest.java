package Test;

import gone.Board;
import gone.Color;
import gone.Pebble;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    Pebble p = new Pebble(3,3, Color.WHITE);
    Pebble p1 = new Pebble(1,3, Color.BLACK);
    Pebble p2 = new Pebble(2,3, Color.BLACK);
    Pebble p3 = new Pebble(3,2, Color.BLACK);
    Pebble p4 = new Pebble(3,1, Color.BLACK);
    Pebble p5 = new Pebble(2,2, Color.WHITE);
    Pebble p6 = new Pebble(1,1, Color.BLACK);
    List<Pebble> testList = new ArrayList<>();

    Pebble pp = new Pebble(1,1, Color.WHITE);
    Pebble pp1 = new Pebble(1,2, Color.BLACK);
    Pebble pp2 = new Pebble(2,2, Color.BLACK);
    Pebble pp3 = new Pebble(2,3, Color.BLACK);
    Pebble pp4 = new Pebble(3,3, Color.BLACK);
    Pebble pp5 = new Pebble(3,4, Color.BLACK);
    Pebble pp6 = new Pebble(4,4, Color.BLACK);
    List<Pebble> testList2 = new ArrayList<>();

    /*
    Tests the sortByColor method of class Board
    AssertEquals the expected list of white pebbles and the actual list
     */
    @org.junit.jupiter.api.Test
    void sortByColor() {
        this.makeList();
        Board testBoard = new Board(5,5, testList);
        List<Pebble> list = new ArrayList<>();
        list.add(p);
        list.add(p5);
        assertEquals(list,testBoard.getWhiteList());
    }
    /*
       Tests the changeBlackPebbles method of class board
       checks two cases
       asserEquals the expected number of steps and the actual number
    */
    @org.junit.jupiter.api.Test
    void changeBlackPebbles() {
        this.makeList();
        Board testBoard = new Board(5,5,testList);
        Board testBoard2 = new Board(5,5,testList2);
        assertEquals(2, testBoard.changeBlackPebblesRecursively(0,0));
        assertEquals(6, testBoard2.changeBlackPebblesRecursively(0,0));
    }

    /*
    Tests the gameResult method of class Board
    Checks two cases
    asserEquals the expected string and the actual string
     */
    @org.junit.jupiter.api.Test
    void gameResult() {
        this.makeList();
        Board testBoard = new Board(3,3,testList);
        Board testBoard2 = new Board(5,5,testList2);
        assertEquals("It took 2 steps to change the pebbles and there are 1 black pebbles left",
                testBoard.gameResult());
        assertEquals("It took 6 steps to change the pebbles and there are 0 black pebbles left",
                testBoard2.gameResult());
    }

    public void makeList(){
        testList.add(p);
        testList.add(p1);
        testList.add(p2);
        testList.add(p3);
        testList.add(p4);
        testList.add(p5);
        testList.add(p6);

        testList2.add(pp);
        testList2.add(pp1);
        testList2.add(pp2);
        testList2.add(pp3);
        testList2.add(pp4);
        testList2.add(pp5);
        testList2.add(pp6);
    }

}