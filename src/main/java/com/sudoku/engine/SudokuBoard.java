package com.sudoku.engine;

import com.sudoku.model.Coords;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.sudoku.engine.SudokuElement.EMPTY;

public class SudokuBoard extends Prototype {
    static int SIZE = 9;
    private boolean forceExit;
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

    public boolean isExitForced() {
        return forceExit;
    }

    public void setForceExit(boolean forceExit) {
        this.forceExit = forceExit;
    }

    public SudokuBoard shallowCopy() {
        SudokuBoard clone = null;
        try {
            clone = (SudokuBoard) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }

    public SudokuBoard deepCopy() {
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

    public boolean isSudokuBoardValid(SudokuBoard sudokuBoard) {
        Set<Integer> valuesInRow = new HashSet<>();
        Set<Integer> valuesInColumn = new HashSet<>();
        Set<Integer> valuesInBox = new HashSet<>();

        for (int row = 0; row < SIZE; row++) {
            for (int column = 0; column < SIZE; column++) {
                if (hasDuplicateNumberInLine(sudokuBoard, valuesInRow, row, column, column == SIZE - 1)) {
                    return false;
                }
                if (hasDuplicateNumberInLine(sudokuBoard, valuesInColumn, column, row, column == SIZE - 1)) {
                    return false;
                }
                if (hasDuplicateNumberInBox(sudokuBoard, valuesInBox, row, column)) {
                    return false;
                }
            }
        }
        return true;
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

        for (int col = boxColumn * 3; col < boxColumn * 3 + 3; col++) {
            for (int row = boxRow * 3; row < boxRow * 3 + 3; row++) {
                if (rows.get(row).getColumns().get(col).getValue() == value)
                    return true;
            }
        }
        return false;
    }

    private boolean hasDuplicateNumberInLine(SudokuBoard sudokuBoard, Set<Integer> valuesInSet, int x, int y, boolean isEndOfLine) {
        if (sudokuBoard.rows.get(x).getColumns().get(y).getValue() != 0) {
            if (!valuesInSet.add(sudokuBoard.rows.get(x).getColumns().get(y).getValue())) {
                return true;
            }
        }
        if (isEndOfLine) valuesInSet.clear();
        return false;
    }

    private boolean hasDuplicateNumberInBox(SudokuBoard sudokuBoard, Set<Integer> valuesInSet, int rowNumber, int columnNumber) {
        int boxRow = rowNumber / 3;
        int boxColumn = columnNumber / 3;

        for (int col = boxColumn * 3; col < boxColumn * 3 + 3; col++) {
            for (int row = boxRow * 3; row < boxRow * 3 + 3; row++) {
                if (sudokuBoard.rows.get(row).getColumns().get(col).getValue() != 0) {
                    if (!valuesInSet.add(sudokuBoard.rows.get(row).getColumns().get(col).getValue())) {
                        return true;
                    }
                }
            }
        }
        valuesInSet.clear();
        return false;
    }
}
