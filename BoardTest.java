package Test;

import gone.Board;
import gone.Color;
import gone.CoordinatePair;
import gone.Pebble;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTest {

        Pebble p = new Pebble(Color.WHITE, new CoordinatePair(3,3));
        Pebble p1 = new Pebble(Color.BLACK, new CoordinatePair(1,3));
        Pebble p2 = new Pebble(Color.BLACK, new CoordinatePair(2,3));
        Pebble p3 = new Pebble(Color.BLACK, new CoordinatePair(3,2));
        Pebble p4 = new Pebble(Color.BLACK, new CoordinatePair(3,1));
        Pebble p5 = new Pebble(Color.WHITE, new CoordinatePair(2,2));
        Pebble p6 = new Pebble(Color.BLACK, new CoordinatePair(1,1));
        Pebble p7 = new Pebble(Color.WHITE, new CoordinatePair(4,1));
        Pebble p8 = new Pebble(Color.WHITE, new CoordinatePair(4,2));
        Pebble p9 = new Pebble(Color.WHITE, new CoordinatePair(3,4));
        Pebble p10 = new Pebble(Color.WHITE, new CoordinatePair(5,1));

        Pebble pp = new Pebble(Color.WHITE, new CoordinatePair(1,1));
        Pebble pp1 = new Pebble(Color.BLACK, new CoordinatePair(1,2));
        Pebble pp2 = new Pebble(Color.BLACK, new CoordinatePair(2,2));
        Pebble pp3 = new Pebble(Color.BLACK, new CoordinatePair(2,3));
        Pebble pp4 = new Pebble(Color.BLACK, new CoordinatePair(3,3));
        Pebble pp5 = new Pebble(Color.BLACK, new CoordinatePair(3,4));
        Pebble pp6 = new Pebble(Color.BLACK, new CoordinatePair(4,4));

        List<Pebble> testList = new ArrayList<>();
        List<Pebble> testList2 = new ArrayList<>();
        List<Pebble> allWhiteList = new ArrayList<>();
        List<Pebble> allBlackList = new ArrayList<>();
        Map<CoordinatePair, Pebble> testBlackMap = new HashMap<>();
        List<Pebble> stressList2 = new ArrayList<>();
        List<Pebble> emptyList = new ArrayList<>();

        /*
        Tests the sortByColor method of class Board
        AssertEquals the expected list of white pebbles and the actual list
        AssertEquals the expected map of black pebbles with the actual map
        Four cases: Mix of black and white Pebbles
                    Only white Pebbles
                    Only Black Pebbles
                    No Pebbles
        Testing Type: Structured Basis, Good Data
         */
        @org.junit.Test
        public void sortByColor() {
            this.makeList();
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
        Testing Type: Structured Basis
         */
        @org.junit.Test
        public void getWhiteList() {
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
        Testing Type: Structured Basis
     */
        @org.junit.Test
        public void getBlackMap() {
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
        AssertEquals the expected number of steps and the actual number
        Four cases: Mix of black and white Pebbles
                    Only white Pebbles
                    Only Black Pebbles
                    No Pebbles
        Testing Type: Structured Basis, Good Data
        */
        @org.junit.Test
        public void changeBlackPebbles() {
            this.makeList();

            //Mix of black and white pebbles
            Board testBoard = new Board(5,5,testList);
            assertEquals(2, testBoard.changeBlackPebblesRecursively(0,0));

            //Only white Pebbles
            Board testBoard2 = new Board(5,5,allWhiteList);
            assertEquals(0, testBoard2.changeBlackPebblesRecursively(0, 0));

            //Only Black pebbles
            Board testBoard3 = new Board(5,5,allBlackList);
            assertEquals(0, testBoard3.changeBlackPebblesRecursively(0, 0));

            //No pebbles
            Board testBoard4 = new Board(5,5, emptyList);
            assertEquals(0, testBoard4.changeBlackPebblesRecursively(0, 0));
        }

        /*
        Tests the gameResult method of class Board
        assertEquals the expected string and the actual string
        Two Cases: Are Black Pebbles Left
                   No Black Pebbles Left
        Testing Type: Structured Basis, Good Data
         */
        @org.junit.Test
        public void gameResult() {
            this.makeList();

            //Black Pebbles remain
            Board testBoard = new Board(3,3,testList);
            assertEquals("It took 2 steps to change the pebbles and there are 1 black pebbles left",
                    testBoard.gameResult());

            //No black pebbles remain
            Board testBoard2 = new Board(5,5,testList2);
            assertEquals("It took 6 steps to change the pebbles and there are 0 black pebbles left",
                    testBoard2.gameResult());
        }
        /*
        stressTest inputs a large amount of data
        assertEquals rough maximum number of changes before a stack overflow
        Breaks at roughly 5000 changes
        Testing Type: Stress Test, Bad Data Test
        */

        @org.junit.Test
        public void stressTest(){
            this.makeList();
            Board testBoard5 = new Board(16384,16384, stressList2);
            assertEquals(4796, testBoard5.changeBlackPebblesRecursively(0,0));
        }

        /*
        Tests the Board class for null inputs
        Tests the sortByColor method called by the constructor from class Board
        Testing Type: Bad Data Test
         */
        @org.junit.Test(expected = NullPointerException.class)
        public void badDateTest(){
            Board testBoard = new Board(5,5,null);
        }

        //Makes the lists and maps that are tested
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

            stressList2.add(new Pebble(Color.WHITE, new CoordinatePair(1,1)));
            for(int y = 2; y < 2400; y++){
                stressList2.add(new Pebble(Color.BLACK, new CoordinatePair(y-1, y)));
                stressList2.add(new Pebble(Color.BLACK, new CoordinatePair(y, y)));
            }
        }

    }
