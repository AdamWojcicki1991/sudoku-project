package com.sudoku;

import com.sudoku.engine.SudokuBoard;
import com.sudoku.engine.SudokuSolver;
import com.sudoku.model.SudokuResult;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static com.sudoku.UI.UserInterface.printSudokuBoard;
import static com.sudoku.model.SudokuResult.SOLVED;
import static com.sudoku.model.SudokuResult.UNSOLVED;
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
        sudokuBoard.setNumber(2, 4, 9);
        //THEN
        assertEquals(9, sudokuBoard.getNumber(2, 4));
    }

    @Test
    public void shouldReadWhatWasPlaced() {
        //GIVEN
        SudokuBoard sudokuBoard = new SudokuBoard();
        sudokuBoard.setNumber(2, 4, 9);
        //WHEN
        int number = sudokuBoard.getNumber(2, 4);
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
    public void shouldGetPossibleValuesOfSudokuElement() {
        //GIVEN
        SudokuBoard sudokuBoard = new SudokuBoard();
        //WHEN
        List<Integer> possibles = sudokuBoard.getPossibles(3, 3);
        //THEN
        assertEquals(9, possibles.size());
    }

    @Test
    public void shouldResolveSudoku() {
        //GIVEN
        SudokuBoard sudokuBoard = new SudokuBoard();
        sudokuBoard.setNumber(0, 0, 2);
        sudokuBoard.setNumber(1, 0, 6);
        sudokuBoard.setNumber(3, 0, 5);
        sudokuBoard.setNumber(6, 0, 3);
        sudokuBoard.setNumber(8, 0, 1);
        sudokuBoard.setNumber(1, 1, 7);
        sudokuBoard.setNumber(4, 1, 6);
        sudokuBoard.setNumber(6, 1, 9);
        sudokuBoard.setNumber(1, 2, 4);
        sudokuBoard.setNumber(2, 2, 5);
        sudokuBoard.setNumber(4, 2, 1);
        sudokuBoard.setNumber(8, 2, 8);
        sudokuBoard.setNumber(2, 3, 6);
        sudokuBoard.setNumber(3, 3, 8);
        sudokuBoard.setNumber(5, 3, 1);
        sudokuBoard.setNumber(7, 3, 3);
        sudokuBoard.setNumber(8, 3, 9);
        sudokuBoard.setNumber(0, 4, 7);
        sudokuBoard.setNumber(1, 4, 3);
        sudokuBoard.setNumber(7, 4, 1);
        sudokuBoard.setNumber(8, 4, 4);
        sudokuBoard.setNumber(0, 5, 9);
        sudokuBoard.setNumber(1, 5, 1);
        sudokuBoard.setNumber(3, 5, 7);
        sudokuBoard.setNumber(5, 5, 5);
        sudokuBoard.setNumber(6, 5, 2);
        sudokuBoard.setNumber(0, 6, 6);
        sudokuBoard.setNumber(4, 6, 9);
        sudokuBoard.setNumber(6, 6, 4);
        sudokuBoard.setNumber(7, 6, 5);
        sudokuBoard.setNumber(2, 7, 2);
        sudokuBoard.setNumber(4, 7, 5);
        sudokuBoard.setNumber(7, 7, 6);
        sudokuBoard.setNumber(0, 8, 4);
        sudokuBoard.setNumber(2, 8, 3);
        sudokuBoard.setNumber(5, 8, 6);
        sudokuBoard.setNumber(7, 8, 9);
        sudokuBoard.setNumber(8, 8, 7);
        printSudokuBoard(sudokuBoard);
        SudokuSolver sudokuSolver = new SudokuSolver();
        //WHEN
        SudokuResult sudokuResult = sudokuSolver.resolveSudoku(sudokuBoard);
        printSudokuBoard(sudokuBoard);
        //THEN
        assertEquals(SOLVED, sudokuResult);
    }

    @Test
    public void shouldNotResolveSudoku() {
        //GIVEN
        SudokuBoard sudokuBoard = new SudokuBoard();
        sudokuBoard.setNumber(0, 0, 2);
        printSudokuBoard(sudokuBoard);
        SudokuSolver sudokuSolver = new SudokuSolver();
        //WHEN
        SudokuResult sudokuResult = sudokuSolver.resolveSudoku(sudokuBoard);
        printSudokuBoard(sudokuBoard);
        //THEN
        assertEquals(UNSOLVED, sudokuResult);
    }
}
