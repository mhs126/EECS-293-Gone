package Test;

import gone.Board;
import gone.Color;
import gone.CoordinatePair;
import gone.Pebble;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTest {

        Pebble p = new Pebble(3,3, Color.WHITE, new CoordinatePair(3,3));
        Pebble p1 = new Pebble(1,3, Color.BLACK, new CoordinatePair(1,3));
        Pebble p2 = new Pebble(2,3, Color.BLACK, new CoordinatePair(2,3));
        Pebble p3 = new Pebble(3,2, Color.BLACK, new CoordinatePair(3,2));
        Pebble p4 = new Pebble(3,1, Color.BLACK, new CoordinatePair(3,1));
        Pebble p5 = new Pebble(2,2, Color.WHITE, new CoordinatePair(2,2));
        Pebble p6 = new Pebble(1,1, Color.BLACK, new CoordinatePair(1,1));
        Pebble p7 = new Pebble(1,1, Color.WHITE, new CoordinatePair(4,1));
        Pebble p8 = new Pebble(1,1, Color.WHITE, new CoordinatePair(4,2));
        Pebble p9 = new Pebble(1,1, Color.WHITE, new CoordinatePair(3,4));
        Pebble p10 = new Pebble(1,1, Color.WHITE, new CoordinatePair(5,1));

        Pebble pp = new Pebble(1,1, Color.WHITE, new CoordinatePair(1,1));
        Pebble pp1 = new Pebble(1,2, Color.BLACK, new CoordinatePair(1,2));
        Pebble pp2 = new Pebble(2,2, Color.BLACK, new CoordinatePair(2,2));
        Pebble pp3 = new Pebble(2,3, Color.BLACK, new CoordinatePair(2,3));
        Pebble pp4 = new Pebble(3,3, Color.BLACK, new CoordinatePair(3,3));
        Pebble pp5 = new Pebble(3,4, Color.BLACK, new CoordinatePair(3,4));
        Pebble pp6 = new Pebble(4,4, Color.BLACK, new CoordinatePair(4,4));

        List<Pebble> testList = new ArrayList<>();
        List<Pebble> testList2 = new ArrayList<>();
        List<Pebble> allWhiteList = new ArrayList<>();
        List<Pebble> allBlackList = new ArrayList<>();
        Map<CoordinatePair, Pebble> testBlackMap = new HashMap<>();

        /*
        Tests the sortByColor method of class Board
        AssertEquals the expected list of white pebbles and the actual list
        AssertEquals the expected map of black pebbles with the actual map
        Four cases: Mix of black and white Pebbles, Only white Pebbles, Only Black Pebbles and no Pebbles
         */
        @org.junit.Test
        void sortByColor() {
            this.makeList();
            List<Pebble> emptyList = new ArrayList<>();
            Map<CoordinatePair, Pebble> emptyMap = new HashMap<>();

            //Mix of black and  white Pebbles test
            Board testBoard = new Board(5,5, testList);
            assertEquals(allWhiteList,testBoard.getWhiteList());
            assertEquals(testBlackMap, testBoard.getBlackMap());

            //Only white Pebbles test
            Board testBoard2 = new Board(5,5, allWhiteList);
            assertEquals(allWhiteList,testBoard2.getWhiteList());
            assertEquals(emptyMap, testBoard2.getBlackMap());

            //Only Black Pebbles test
            Board testBoard3 = new Board(5,5, allBlackList);
            assertEquals(emptyList, testBoard3.getWhiteList());
            assertEquals(testBlackMap, testBoard3.getBlackMap());

            //No Pebbles test
            Board testBoard4 = new Board(5,5, emptyList);
            assertEquals(emptyList, testBoard4.getWhiteList());
            assertEquals(emptyMap, testBoard4.getBlackMap());
        }

        /*
        Tests the getWhiteList method of class Board
        AssertEquals the expected list of white pebbles with the actual list
         */
        @org.junit.Test
        void getWhiteList() {
            this.makeList();
            Board testBoard = new Board(5,5,testList);
            List<Pebble> list = new ArrayList<>();
            list.add(p);
            list.add(p5);
            list.add(p7);
            list.add(p8);
            list.add(p9);
            list.add(p10);
            assertEquals(list, testBoard.getWhiteList());
        }

        /*
        Tests the getBlackMap method of class Board
        AssertEquals the expected map of black pebbles with the actual map
     */
        @org.junit.Test
        void getBlackMap() {
            this.makeList();
            Board testBoard = new Board(5,5,testList);
            Map<CoordinatePair, Pebble> testMap = new HashMap<>();
            testMap.put(p1.getPair(), p1);
            testMap.put(p2.getPair(), p2);
            testMap.put(p3.getPair(), p3);
            testMap.put(p4.getPair(), p4);
            testMap.put(p6.getPair(), p6);
            assertEquals(testMap, testBoard.getBlackMap());
        }


        /*
           Tests the changeBlackPebbles method of class board
           checks two cases
           assertEquals the expected number of steps and the actual number
        */
        @org.junit.Test
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
        @org.junit.Test
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
            testList.add(p7);
            testList.add(p8);
            testList.add(p9);
            testList.add(p10);

            testList2.add(pp);
            testList2.add(pp1);
            testList2.add(pp2);
            testList2.add(pp3);
            testList2.add(pp4);
            testList2.add(pp5);
            testList2.add(pp6);

            allWhiteList.add(p);
            allWhiteList.add(p5);
            allWhiteList.add(p7);
            allWhiteList.add(p8);
            allWhiteList.add(p9);
            allWhiteList.add(p10);

            allBlackList.add(p1);
            allBlackList.add(p2);
            allBlackList.add(p3);
            allBlackList.add(p4);
            allBlackList.add(p6);

            testBlackMap.put(p1.getPair(), p1);
            testBlackMap.put(p2.getPair(), p2);
            testBlackMap.put(p3.getPair(), p3);
            testBlackMap.put(p4.getPair(), p4);
            testBlackMap.put(p6.getPair(), p6);
        }

    }
