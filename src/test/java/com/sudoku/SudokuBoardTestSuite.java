package com.sudoku;

import com.sudoku.engine.SudokuBoard;
import com.sudoku.engine.SudokuSolver;
import com.sudoku.model.SudokuResult;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static com.sudoku.UI.UserInterface.printSudokuBoard;
import static com.sudoku.model.SudokuResult.SOLVED;
import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
        assertEquals(-1, number);
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

    @Test
    public void shouldValidatePlacedNumber() {
        //GIVEN
        SudokuBoard sudokuBoard = new SudokuBoard();
        sudokuBoard.setNumber(3, 3, 9);
        //WHEN
        boolean isValidNumberPlacedInSameBox = sudokuBoard.isValidNumberPlaced(4, 5, 9);
        boolean isValidNumberPlacedInSameRow = sudokuBoard.isValidNumberPlaced(0, 3, 9);
        boolean isValidNumberPlacedInSameColumn = sudokuBoard.isValidNumberPlaced(3, 6, 9);
        boolean isValidNumberPlacedInOtherBoxRowColumn = sudokuBoard.isValidNumberPlaced(2, 2, 9);
        boolean isValidNumberPlaced = sudokuBoard.isValidNumberPlaced(4, 3, 8);
        //THEN
        assertFalse(isValidNumberPlacedInSameBox);
        assertFalse(isValidNumberPlacedInSameRow);
        assertFalse(isValidNumberPlacedInSameColumn);
        assertTrue(isValidNumberPlacedInOtherBoxRowColumn);
        assertTrue(isValidNumberPlaced);
    }

    @Test
    public void shouldValidatedEmptyCell() {
        //GIVEN
        SudokuBoard sudokuBoard = new SudokuBoard();
        sudokuBoard.setNumber(3, 3, 9);
        //WHEN
        boolean cellEmpty = sudokuBoard.isCellEmpty(0, 0);
        boolean cellWithNumber = sudokuBoard.isCellEmpty(3, 3);
        //THEN
        assertTrue(cellEmpty);
        assertFalse(cellWithNumber);
    }

    @Test
    public void shouldResolveSudoku() {
        //GIVEN
        SudokuBoard sudokuBoard = new SudokuBoard();
        sudokuBoard.setNumber(1, 0, 3);
        sudokuBoard.setNumber(3, 0, 2);
        sudokuBoard.setNumber(5, 0, 6);
        sudokuBoard.setNumber(6, 0, 7);
        sudokuBoard.setNumber(7, 0, 8);
        sudokuBoard.setNumber(2, 1, 2);
        sudokuBoard.setNumber(5, 1, 8);
        sudokuBoard.setNumber(8, 1, 4);
        sudokuBoard.setNumber(8, 2, 5);
        sudokuBoard.setNumber(0, 3, 3);
        sudokuBoard.setNumber(2, 3, 1);
        sudokuBoard.setNumber(5, 3, 5);
        sudokuBoard.setNumber(6, 3, 8);
        sudokuBoard.setNumber(3, 4, 7);
        sudokuBoard.setNumber(5, 4, 4);
        sudokuBoard.setNumber(2, 5, 6);
        sudokuBoard.setNumber(3, 5, 3);
        sudokuBoard.setNumber(6, 5, 9);
        sudokuBoard.setNumber(8, 5, 7);
        sudokuBoard.setNumber(0, 6, 8);
        sudokuBoard.setNumber(0, 7, 7);
        sudokuBoard.setNumber(3, 7, 1);
        sudokuBoard.setNumber(6, 7, 4);
        sudokuBoard.setNumber(1, 8, 9);
        sudokuBoard.setNumber(2, 8, 5);
        sudokuBoard.setNumber(3, 8, 8);
        sudokuBoard.setNumber(5, 8, 3);
        sudokuBoard.setNumber(7, 8, 7);
        printSudokuBoard(sudokuBoard);
        SudokuSolver sudokuSolver = new SudokuSolver();
        //WHEN
        SudokuResult sudokuResult = sudokuSolver.resolveSudoku(sudokuBoard);
        //THEN
        assertEquals(SOLVED, sudokuResult);
    }
}
