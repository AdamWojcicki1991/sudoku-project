package com.sudoku;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class SudokuTestSuite {
    private static int testCounter;

    @BeforeClass
    public static void beforeAllTests() {
        System.out.println("Start tests.");
    }

    @AfterClass
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @Before
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Test
    public void shouldReadNumberFromBoard() {
        //GIVEN
        Sudoku sudoku = new Sudoku();
        //WHEN
        int number = sudoku.getNumber(3, 3);
        //THEN
//        assertEquals(0, number);
    }

    @Test
    public void shouldPlaceNumberOnBoard() {
        //GIVEN
        Sudoku sudoku = new Sudoku();
        //WHEN
        sudoku.setNumber(3, 3, 9);
        //THEN
    }

    @Test
    public void shouldReadWhatWasPlaced() {
        //GIVEN
        Sudoku sudoku = new Sudoku();
        sudoku.setNumber(3, 3, 9);
        //WHEN
        int number = sudoku.getNumber(3, 3);
        //THEN
        assertEquals(9, number);
    }
}
