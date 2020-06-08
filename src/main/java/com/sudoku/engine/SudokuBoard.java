package com.sudoku.engine;

import java.util.ArrayList;
import java.util.List;

import static com.sudoku.engine.SudokuElement.EMPTY;

public class SudokuBoard {
    private List<SudokuRow> rows = new ArrayList<>();

    public SudokuBoard() {
        for (int i = 0; i < 9; i++) {
            rows.add(new SudokuRow());
        }
    }

    public int getNumber(int columnNumber, int rowNumber) {
        return rows.get(rowNumber).getColumns().get(columnNumber).getValue();
    }

    public void setNumber(int columnNumber, int rowNumber, int value) {
        rows.get(rowNumber).getColumns().get(columnNumber).setValue(value);
    }

    public List<Integer> getPossibles(int columnNumber, int rowNumber) {
        return rows.get(rowNumber).getColumns().get(columnNumber).getPossibles();
    }

    public boolean isCellEmpty(int columnNumber, int rowNumber) {
        return rows.get(rowNumber).getColumns().get(columnNumber).getValue() == EMPTY;
    }

    public boolean isValidNumberPlaced(int columnNumber, int rowNumber, int value) {
        return isValidNumberPlacedInRow(columnNumber, rowNumber, value) &&
                isValidNumberPlacedInColumn(columnNumber, rowNumber, value) &&
                isValidNumberPlacedInBox(columnNumber, rowNumber, value);
    }

    private boolean isValidNumberPlacedInRow(int columnNumber, int rowNumber, int value) {
        for (int i = 0; i < 9; i++) {
            if (rows.get(rowNumber).getColumns().get(i).getValue() == value && columnNumber != i) return false;
        }
        return true;
    }

    private boolean isValidNumberPlacedInColumn(int columnNumber, int rowNumber, int value) {
        for (int i = 0; i < 9; i++) {
            if (rows.get(i).getColumns().get(columnNumber).getValue() == value && rowNumber != i) return false;
        }
        return true;
    }

    private boolean isValidNumberPlacedInBox(int columnNumber, int rowNumber, int value) {
        int boxRow = rowNumber / 3;
        int boxColumn = columnNumber / 3;

        for (int i = boxColumn * 3; i < boxColumn * 3 + 3; i++) {
            for (int j = boxRow * 3; j < boxRow * 3 + 3; j++) {
                if (rows.get(i).getColumns().get(j).getValue() == value && rowNumber != i && columnNumber != j)
                    return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "  " + rows + "\n";
    }
}
