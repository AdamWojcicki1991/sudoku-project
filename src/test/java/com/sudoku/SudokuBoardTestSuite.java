package com.sudoku;

import com.sudoku.engine.SudokuBoard;
import com.sudoku.engine.SudokuSolver;
import com.sudoku.model.SudokuResult;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static com.sudoku.DataFixture.*;
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
    public void shouldValidateDuplicateNumbersInBoxOfSudokuBoard() {
        //GIVEN
        SudokuBoard sudokuBoard = new SudokuBoard();
        sudokuBoard.setValue(1, 3, 9);
        sudokuBoard.setValue(2, 4, 9);
        printSudokuBoard(sudokuBoard);
        //WHEN
        boolean isSudokuBoardValid = sudokuBoard.isSudokuBoardValid(sudokuBoard);
        //THEN
        assertFalse(isSudokuBoardValid);
    }

    @Test
    public void shouldValidateDuplicateNumbersInRowOfSudokuBoard() {
        //GIVEN
        SudokuBoard sudokuBoard = new SudokuBoard();
        sudokuBoard.setValue(1, 4, 9);
        sudokuBoard.setValue(7, 4, 9);
        printSudokuBoard(sudokuBoard);
        //WHEN
        boolean isSudokuBoardValid = sudokuBoard.isSudokuBoardValid(sudokuBoard);
        //THEN
        assertFalse(isSudokuBoardValid);
    }

    @Test
    public void shouldValidateDuplicateNumbersInColumnOfSudokuBoard() {
        //GIVEN
        SudokuBoard sudokuBoard = new SudokuBoard();
        sudokuBoard.setValue(4, 0, 9);
        sudokuBoard.setValue(4, 4, 9);
        printSudokuBoard(sudokuBoard);
        //WHEN
        boolean isSudokuBoardValid = sudokuBoard.isSudokuBoardValid(sudokuBoard);
        //THEN
        assertFalse(isSudokuBoardValid);
    }

    @Test
    public void shouldValidateSudokuBoardWithoutAnyDuplicates() {
        //GIVEN
        SudokuBoard sudokuBoard = createSimpleSudokuBoard();
        printSudokuBoard(sudokuBoard);
        //WHEN
        boolean isSudokuBoardValid = sudokuBoard.isSudokuBoardValid(sudokuBoard);
        //THEN
        assertTrue(isSudokuBoardValid);
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
        shallowClonedSudokuBoard = sudokuBoard.shallowCopy();
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
        deepClonedSudokuBoard = sudokuBoard.deepCopy();
        //WHEN
        deepClonedSudokuBoard.setValue(1, 1, 1);
        //THEN
        System.out.println(sudokuBoard);
        System.out.println(deepClonedSudokuBoard);
        assertEquals(0, sudokuBoard.getValue(1, 1));
        assertEquals(1, deepClonedSudokuBoard.getValue(1, 1));
    }

    @Test
    public void shouldNotResolveInvalidSudokuBoard() {
        //GIVEN
        SudokuBoard sudokuBoard = createInvalidSudokuBord();
        SudokuSolver sudokuSolver = new SudokuSolver();
        printSudokuBoard(sudokuBoard);
        //WHEN
        SudokuResult sudokuResult = sudokuSolver.resolveSudoku(sudokuBoard);
        printSudokuBoard(sudokuSolver.getResolvedSudoku());
        //THEN
        assertEquals(UNSOLVED, sudokuResult);
    }

    @Test
    public void shouldResolveSimpleSudokuWithoutUsingRecursion() {
        //GIVEN
        SudokuBoard sudokuBoard = createSimpleSudokuBoard();
        SudokuSolver sudokuSolver = new SudokuSolver();
        printSudokuBoard(sudokuBoard);
        //WHEN
        SudokuResult sudokuResult = sudokuSolver.resolveSudoku(sudokuBoard);
        printSudokuBoard(sudokuSolver.getResolvedSudoku());
        //THEN
        assertEquals(SOLVED, sudokuResult);
    }

    @Test
    public void shouldResolveSudokuUsingRecursionMediumDifficulty() {
        //GIVEN
        SudokuBoard sudokuBoard = createSudokuBordThatAlgorithmWillSolveUsingRecursionMediumDifficulty();
        SudokuSolver sudokuSolver = new SudokuSolver();
        printSudokuBoard(sudokuBoard);
        //WHEN
        SudokuResult sudokuResult = sudokuSolver.resolveSudoku(sudokuBoard);
        printSudokuBoard(sudokuSolver.getResolvedSudoku());
        //THEN
        assertEquals(SOLVED, sudokuResult);
    }

    @Test
    public void shouldResolveSudokuUsingRecursionHardDifficulty() {
        //GIVEN
        SudokuBoard sudokuBoard = createSudokuBordThatAlgorithmWillSolveUsingRecursionHardDifficulty();
        SudokuSolver sudokuSolver = new SudokuSolver();
        printSudokuBoard(sudokuBoard);
        //WHEN
        SudokuResult sudokuResult = sudokuSolver.resolveSudoku(sudokuBoard);
        printSudokuBoard(sudokuSolver.getResolvedSudoku());
        //THEN
        assertEquals(SOLVED, sudokuResult);
    }
}
