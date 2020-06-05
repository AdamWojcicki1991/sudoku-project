package com.sudoku;

import com.sudoku.engine.SudokuBoard;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class SudokuBoardTestSuite {
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
        SudokuBoard sudokuBoard = new SudokuBoard();
        //WHEN
        int number = sudokuBoard.getNumber(3, 3);
        //THEN
//        assertEquals(0, number);
    }

    @Test
    public void shouldPlaceNumberOnBoard() {
        //GIVEN
        SudokuBoard sudokuBoard = new SudokuBoard();
        //WHEN
        sudokuBoard.setNumber(3, 3, 9);
        //THEN
        assertEquals(9, sudokuBoard.getNumber(3, 3));
    }

    @Test
    public void shouldReadWhatWasPlaced() {
        //GIVEN
        SudokuBoard sudokuBoard = new SudokuBoard();
        sudokuBoard.setNumber(3, 3, 9);
        //WHEN
        int number = sudokuBoard.getNumber(3, 3);
        //THEN
        assertEquals(9, number);
    }
}
