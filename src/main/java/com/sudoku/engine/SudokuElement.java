package com.sudoku.engine;

import java.util.ArrayList;
import java.util.List;

import static com.sudoku.engine.SudokuBoard.SIZE;

public class SudokuElement {
    private static int element = -1;
    static final int EMPTY = 0;
    private int value = EMPTY;
    private List<Integer> possibles = new ArrayList<>();

    public SudokuElement() {
        for (int i = 1; i <= SIZE; i++) {
            possibles.add(i);
        }
    }

    public List<Integer> getPossibles() {
        return possibles;
    }

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
            return (value != EMPTY) ? "| " + value : "| " + " ";
        } else if (element == 8 || element == 17 || element == 26 || element == 35 ||
                element == 44 || element == 53 || element == 62 || element == 71) {
            return (value != EMPTY) ? value + " |" : " " + " |";
        } else if (element == 80) {
            element = -1;
            return (value != EMPTY) ? value + " |" : " " + " |";
        }
        return (value != EMPTY) ? value + "" : " ";
    }
}
