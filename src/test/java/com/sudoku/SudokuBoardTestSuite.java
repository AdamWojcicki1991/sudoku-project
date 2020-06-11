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
    public void shouldReadValueFromBoard() {
        //GIVEN
        SudokuBoard sudokuBoard = new SudokuBoard();
        //WHEN
        int number = sudokuBoard.getValue(3, 3);
        //THEN
        assertEquals(0, number);
    }

    @Test
    public void shouldPlaceValueOnBoard() {
        //GIVEN
        SudokuBoard sudokuBoard = new SudokuBoard();
        //WHEN
        sudokuBoard.setValue(2, 4, 9);
        //THEN
        assertEquals(9, sudokuBoard.getValue(2, 4));
    }

    @Test
    public void shouldReadWhatWasPlaced() {
        //GIVEN
        SudokuBoard sudokuBoard = new SudokuBoard();
        sudokuBoard.setValue(2, 4, 9);
        //WHEN
        int number = sudokuBoard.getValue(2, 4);
        //THEN
        assertEquals(9, number);
    }

    @Test
    public void shouldValidatePlacedValue() {
        //GIVEN
        SudokuBoard sudokuBoard = new SudokuBoard();
        sudokuBoard.setValue(3, 3, 9);
        //WHEN
        boolean isValidNumberPlacedInSameBox = sudokuBoard.canPlacedValue(4, 5, 9);
        boolean isValidNumberPlacedInSameRow = sudokuBoard.canPlacedValue(0, 3, 9);
        boolean isValidNumberPlacedInSameColumn = sudokuBoard.canPlacedValue(3, 6, 9);
        boolean isValidNumberPlacedInOtherBoxRowColumn = sudokuBoard.canPlacedValue(2, 2, 9);
        boolean isValidNumberPlaced = sudokuBoard.canPlacedValue(4, 3, 8);
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
        sudokuBoard.setValue(3, 3, 9);
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
    public void shouldMakeShallowCopyOfSudokuBoard() {
        //GIVEN
        SudokuBoard sudokuBoard = new SudokuBoard();
        SudokuBoard shallowClonedSudokuBoard = null;
        try {
            shallowClonedSudokuBoard = sudokuBoard.shallowCopy();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        //WHEN
        shallowClonedSudokuBoard.setValue(1, 1, 1);
        //THEN
        System.out.println(sudokuBoard);
        System.out.println(shallowClonedSudokuBoard);
        assertEquals(1, sudokuBoard.getValue(1, 1));
        assertEquals(1, shallowClonedSudokuBoard.getValue(1, 1));
    }

    @Test
    public void shouldMakeDeepCopyOfSudokuBoard() {
        //GIVEN
        SudokuBoard sudokuBoard = new SudokuBoard();
        SudokuBoard deepClonedSudokuBoard = null;
        try {
            deepClonedSudokuBoard = sudokuBoard.deepCopy();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        //WHEN
        deepClonedSudokuBoard.setValue(1, 1, 1);
        //THEN
        System.out.println(sudokuBoard);
        System.out.println(deepClonedSudokuBoard);
        assertEquals(0, sudokuBoard.getValue(1, 1));
        assertEquals(1, deepClonedSudokuBoard.getValue(1, 1));
    }

    @Test
    public void shouldResolveSudoku() {
        //GIVEN
        SudokuBoard sudokuBoard = new SudokuBoard();
        sudokuBoard.setValue(0, 0, 2);
        sudokuBoard.setValue(1, 0, 6);
        sudokuBoard.setValue(3, 0, 5);
        sudokuBoard.setValue(6, 0, 3);
        sudokuBoard.setValue(8, 0, 1);
        sudokuBoard.setValue(1, 1, 7);
        sudokuBoard.setValue(4, 1, 6);
        sudokuBoard.setValue(6, 1, 9);
        sudokuBoard.setValue(1, 2, 4);
        sudokuBoard.setValue(2, 2, 5);
        sudokuBoard.setValue(4, 2, 1);
        sudokuBoard.setValue(8, 2, 8);
        sudokuBoard.setValue(2, 3, 6);
        sudokuBoard.setValue(3, 3, 8);
        sudokuBoard.setValue(5, 3, 1);
        sudokuBoard.setValue(7, 3, 3);
        sudokuBoard.setValue(8, 3, 9);
        sudokuBoard.setValue(0, 4, 7);
        sudokuBoard.setValue(1, 4, 3);
        sudokuBoard.setValue(7, 4, 1);
        sudokuBoard.setValue(8, 4, 4);
        sudokuBoard.setValue(0, 5, 9);
        sudokuBoard.setValue(1, 5, 1);
        sudokuBoard.setValue(3, 5, 7);
        sudokuBoard.setValue(5, 5, 5);
        sudokuBoard.setValue(6, 5, 2);
        sudokuBoard.setValue(0, 6, 6);
        sudokuBoard.setValue(4, 6, 9);
        sudokuBoard.setValue(6, 6, 4);
        sudokuBoard.setValue(7, 6, 5);
        sudokuBoard.setValue(2, 7, 2);
        sudokuBoard.setValue(4, 7, 5);
        sudokuBoard.setValue(7, 7, 6);
        sudokuBoard.setValue(0, 8, 4);
        sudokuBoard.setValue(2, 8, 3);
        sudokuBoard.setValue(5, 8, 6);
        sudokuBoard.setValue(7, 8, 9);
        sudokuBoard.setValue(8, 8, 7);
        SudokuSolver sudokuSolver = new SudokuSolver();
        SudokuResult sudokuResult = null;
        printSudokuBoard(sudokuBoard);
        //WHEN
        try {
            sudokuResult = sudokuSolver.resolveSudoku(sudokuBoard);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        printSudokuBoard(sudokuSolver.getResolvedSudoku());
        //THEN
        assertEquals(SOLVED, sudokuResult);
    }

    @Test
    public void shouldResolveSudokuUsingRecursion() {
        //GIVEN
        SudokuBoard sudokuBoard = new SudokuBoard();
        sudokuBoard.setValue(1, 0, 3);
        sudokuBoard.setValue(3, 0, 2);
        sudokuBoard.setValue(5, 0, 6);
        sudokuBoard.setValue(6, 0, 7);
        sudokuBoard.setValue(7, 0, 8);
        sudokuBoard.setValue(2, 1, 2);
        sudokuBoard.setValue(5, 1, 8);
        sudokuBoard.setValue(8, 1, 4);
        sudokuBoard.setValue(8, 2, 5);
        sudokuBoard.setValue(0, 3, 3);
        sudokuBoard.setValue(2, 3, 1);
        sudokuBoard.setValue(5, 3, 5);
        sudokuBoard.setValue(6, 3, 8);
        sudokuBoard.setValue(3, 4, 7);
        sudokuBoard.setValue(5, 4, 4);
        sudokuBoard.setValue(2, 5, 6);
        sudokuBoard.setValue(3, 5, 3);
        sudokuBoard.setValue(6, 5, 9);
        sudokuBoard.setValue(8, 5, 7);
        sudokuBoard.setValue(0, 6, 8);
        sudokuBoard.setValue(0, 7, 7);
        sudokuBoard.setValue(3, 7, 1);
        sudokuBoard.setValue(6, 7, 4);
        sudokuBoard.setValue(1, 8, 9);
        sudokuBoard.setValue(2, 8, 5);
        sudokuBoard.setValue(3, 8, 8);
        sudokuBoard.setValue(5, 8, 3);
        sudokuBoard.setValue(7, 8, 7);
        SudokuSolver sudokuSolver = new SudokuSolver();
        SudokuResult sudokuResult = null;
        printSudokuBoard(sudokuBoard);
        //WHEN
        try {
            sudokuResult = sudokuSolver.resolveSudoku(sudokuBoard);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        printSudokuBoard(sudokuSolver.getResolvedSudoku());
        //THEN
        assertEquals(SOLVED, sudokuResult);
    }

    @Test
    public void shouldResolveSudokuLevelHard() {
        //GIVEN
        SudokuBoard sudokuBoard = new SudokuBoard();
        sudokuBoard.setValue(0, 0, 3);
        sudokuBoard.setValue(2, 0, 4);
        sudokuBoard.setValue(4, 0, 2);
        sudokuBoard.setValue(2, 1, 1);
        sudokuBoard.setValue(4, 1, 9);
        sudokuBoard.setValue(5, 1, 4);
        sudokuBoard.setValue(8, 1, 7);
        sudokuBoard.setValue(0, 2, 9);
        sudokuBoard.setValue(3, 2, 5);
        sudokuBoard.setValue(5, 2, 7);
        sudokuBoard.setValue(0, 3, 7);
        sudokuBoard.setValue(1, 3, 5);
        sudokuBoard.setValue(4, 3, 1);
        sudokuBoard.setValue(5, 3, 3);
        sudokuBoard.setValue(0, 4, 1);
        sudokuBoard.setValue(2, 4, 2);
        sudokuBoard.setValue(5, 4, 8);
        sudokuBoard.setValue(6, 4, 3);
        sudokuBoard.setValue(5, 6, 5);
        sudokuBoard.setValue(6, 6, 4);
        sudokuBoard.setValue(3, 7, 1);
        sudokuBoard.setValue(8, 7, 9);
        sudokuBoard.setValue(0, 8, 2);
        sudokuBoard.setValue(1, 8, 3);
        sudokuBoard.setValue(3, 8, 4);
        sudokuBoard.setValue(6, 8, 7);
        SudokuSolver sudokuSolver = new SudokuSolver();
        SudokuResult sudokuResult = null;
        printSudokuBoard(sudokuBoard);
        //WHEN
        try {
            sudokuResult = sudokuSolver.resolveSudoku(sudokuBoard);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        printSudokuBoard(sudokuSolver.getResolvedSudoku());
        //THEN
        assertEquals(SOLVED, sudokuResult);
    }

    @Test
    public void shouldNotResolveSudoku() {
        //GIVEN
        SudokuBoard sudokuBoard = new SudokuBoard();
        sudokuBoard.setValue(8, 1, 4);
        sudokuBoard.setValue(8, 2, 5);
        sudokuBoard.setValue(0, 3, 3);
        sudokuBoard.setValue(2, 3, 1);
        sudokuBoard.setValue(5, 3, 5);
        sudokuBoard.setValue(6, 3, 8);
        sudokuBoard.setValue(3, 4, 7);
        sudokuBoard.setValue(5, 4, 4);
        sudokuBoard.setValue(2, 5, 6);
        sudokuBoard.setValue(3, 5, 3);
        sudokuBoard.setValue(6, 5, 9);
        sudokuBoard.setValue(8, 5, 7);
        sudokuBoard.setValue(0, 6, 8);
        sudokuBoard.setValue(0, 7, 7);
        sudokuBoard.setValue(3, 7, 1);
        sudokuBoard.setValue(6, 7, 4);
        sudokuBoard.setValue(1, 8, 9);
        sudokuBoard.setValue(2, 8, 5);
        sudokuBoard.setValue(3, 8, 8);
        sudokuBoard.setValue(5, 8, 3);
        sudokuBoard.setValue(7, 8, 7);
        SudokuSolver sudokuSolver = new SudokuSolver();
        SudokuResult sudokuResult = null;
        printSudokuBoard(sudokuBoard);
        //WHEN
        try {
            sudokuResult = sudokuSolver.resolveSudoku(sudokuBoard);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        printSudokuBoard(sudokuSolver.getResolvedSudoku());
        //THEN
        assertEquals(SOLVED, sudokuResult);
    }
}
