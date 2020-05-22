package com.sudoku;

public class SudokuElement {
    public static final int EMPTY = -1;
    private int value = EMPTY;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
