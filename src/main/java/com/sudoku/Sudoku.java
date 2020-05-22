package com.sudoku;

import java.util.ArrayList;
import java.util.List;

public class Sudoku {
    private List<BoardRow> rows = new ArrayList<>();

    public Sudoku() {
        for (int i = 0; i < 9; i++) {
            rows.add(new BoardRow());
        }
    }

    public int getNumber(int x, int y) {
        return rows.get(y).getCols().get(x).getValue();
    }

    public void setNumber(int x, int y, int value) {
        rows.get(y).getCols().get(x).setValue(value);
    }
}
