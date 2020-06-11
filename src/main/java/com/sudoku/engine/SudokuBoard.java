package com.sudoku.engine;

import com.sudoku.model.Coords;

import java.util.ArrayList;
import java.util.List;

import static com.sudoku.engine.SudokuElement.EMPTY;

public class SudokuBoard extends Prototype {
    static int SIZE = 9;
    private List<SudokuRow> rows = new ArrayList<>();

    public SudokuBoard() {
        for (int i = 0; i < 9; i++) {
            rows.add(new SudokuRow());
        }
    }

    public int getValue(int columnNumber, int rowNumber) {
        return rows.get(rowNumber).getColumns().get(columnNumber).getValue();
    }

    public void setValue(int columnNumber, int rowNumber, int value) {
        rows.get(rowNumber).getColumns().get(columnNumber).setValue(value);
    }

    public void setValue(Coords coords) {
        rows.get(coords.getRow()).getColumns().get(coords.getCol()).setValue(coords.getValue());
    }

    public List<Integer> getPossibles(int columnNumber, int rowNumber) {
        return rows.get(rowNumber).getColumns().get(columnNumber).getPossibles();
    }

    public boolean isCellEmpty(int columnNumber, int rowNumber) {
        return rows.get(rowNumber).getColumns().get(columnNumber).getValue() == EMPTY;
    }

    public SudokuBoard shallowCopy() throws CloneNotSupportedException {
        return (SudokuBoard) super.clone();
    }

    public SudokuBoard deepCopy() throws CloneNotSupportedException {
        SudokuBoard clonedSudokuBoard = shallowCopy();
        SudokuBoard deepClonedSudokuBoard = new SudokuBoard();
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                int value = clonedSudokuBoard.getValue(col, row);
                deepClonedSudokuBoard.setValue(col, row, value);
            }
        }
        return deepClonedSudokuBoard;
    }

    @Override
    public String toString() {
        return "  " + rows + "\n";
    }

    public boolean canPlacedValue(int columnNumber, int rowNumber, int value) {
        return !isNumberPlacedInRow(rowNumber, value) &&
                !isNumberPlacedInColumn(columnNumber, value) &&
                !isNumberPlacedInBox(columnNumber, rowNumber, value);
    }

    private boolean isNumberPlacedInRow(int rowNumber, int value) {
        for (int i = 0; i < SIZE; i++) {
            if (rows.get(rowNumber).getColumns().get(i).getValue() == value) return true;
        }
        return false;
    }

    private boolean isNumberPlacedInColumn(int columnNumber, int value) {
        for (int i = 0; i < SIZE; i++) {
            if (rows.get(i).getColumns().get(columnNumber).getValue() == value) return true;
        }
        return false;
    }

    private boolean isNumberPlacedInBox(int columnNumber, int rowNumber, int value) {
        int boxRow = rowNumber / 3;
        int boxColumn = columnNumber / 3;

        for (int i = boxColumn * 3; i < boxColumn * 3 + 3; i++) {
            for (int j = boxRow * 3; j < boxRow * 3 + 3; j++) {
                if (rows.get(i).getColumns().get(j).getValue() == value)
                    return true;
            }
        }
        return false;
    }
}
