package com.sudoku.engine;

public class SudokuElement {
    static final int EMPTY = -1;
    private static int element = -1;
    private int value = EMPTY;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        element++;
        if (element % 3 == 0) {
            return (value != EMPTY) ? "| " + value : "| " + "*";
        } else if (element == 8 || element == 17 || element == 26 || element == 35 ||
                element == 44 || element == 53 || element == 62 || element == 71) {
            return (value != EMPTY) ? value + " |" : "*" + " |";
        } else if (element == 80) {
            element = -1;
            return (value != EMPTY) ? value + " |" : "*" + " |";
        }
        return (value != EMPTY) ? value + "" : "*";
    }
}
