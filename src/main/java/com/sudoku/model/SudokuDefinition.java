package com.sudoku.model;

import com.sudoku.engine.SudokuBoard;

public final class SudokuDefinition {
    private final String userName;
    private final SudokuBoard sudokuBoard;

    public SudokuDefinition(final String userName, final SudokuBoard sudokuBoard) {
        this.userName = userName;
        this.sudokuBoard = sudokuBoard;
    }

    public String getUserName() {
        return userName;
    }

    public SudokuBoard getSudokuBoard() {
        return sudokuBoard;
    }
}
