package com.sudoku.engine;

public class SudokuElement {
    private static final int EMPTY = -1;
    private int value = EMPTY;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
