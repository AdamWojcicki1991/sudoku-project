package com.sudoku.engine;

import java.util.ArrayList;
import java.util.List;

public class SudokuRow {
    private static int row = -1;
    private List<SudokuElement> columns = new ArrayList<>();

    public SudokuRow() {
        for (int i = 0; i < 9; i++) {
            columns.add(new SudokuElement());
        }
    }

    public List<SudokuElement> getColumns() {
        return columns;
    }

    @Override
    public String toString() {
        row++;
        if (row == 0) {
            return "|----------+----------+---------|]\n, " + columns + "\n";
        } else if (row == 3 || row == 6) {
            return "[|----------+----------+---------|]\n, " + columns + "\n";
        } else if (row == 8) {
            row = -1;
            return columns + "\n, [|----------+----------+---------|";
        }
        return columns + "\n";
    }
}
