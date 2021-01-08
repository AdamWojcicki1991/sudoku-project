package com.sudoku;

import com.sudoku.engine.SudokuBoard;

public class DataFixture {
    static SudokuBoard createInvalidSudokuBord() {
        SudokuBoard sudokuBoard = new SudokuBoard();
        sudokuBoard.setValue(8, 1, 4);
        sudokuBoard.setValue(7, 1, 4);
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
        return sudokuBoard;
    }

    static SudokuBoard createSimpleSudokuBoard() {
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
        return sudokuBoard;
    }

    static SudokuBoard createSudokuBordThatAlgorithmWillSolveUsingRecursionMediumDifficulty() {
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
        return sudokuBoard;
    }

    static SudokuBoard createSudokuBordThatAlgorithmWillSolveUsingRecursionHardDifficulty() {
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
        return sudokuBoard;
    }
}
