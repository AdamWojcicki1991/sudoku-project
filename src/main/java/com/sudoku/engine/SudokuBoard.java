package com.sudoku.engine;

import java.util.ArrayList;
import java.util.List;

public class SudokuBoard {
    private List<SudokuRow> rows = new ArrayList<>();

    public SudokuBoard() {
        for (int i = 0; i < 9; i++) {
            rows.add(new SudokuRow());
        }
    }

    public int getNumber(int x, int y) {
        return rows.get(y).getColumns().get(x).getValue();
    }

    public void setNumber(int x, int y, int value) {
        rows.get(y).getColumns().get(x).setValue(value);
    }

    @Override
    public String toString() {
        return "SudokuBoard{" +
                "rows=" + rows +
                '}';
    }
}
