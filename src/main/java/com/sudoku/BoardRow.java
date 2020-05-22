package com.sudoku;

import java.util.ArrayList;
import java.util.List;

public class BoardRow {
    private List<SudokuElement> cols = new ArrayList<>();

    public BoardRow() {
        for (int n = 0; n < 9; n++) {
            cols.add(new SudokuElement());
        }
    }

    public List<SudokuElement> getCols() {
        return cols;
    }
}
