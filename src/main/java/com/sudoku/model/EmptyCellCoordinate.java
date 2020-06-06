package com.sudoku.model;

public final class EmptyCellCoordinate {
    private final int rowNumber;
    private final int columnNumber;

    public EmptyCellCoordinate(final int rowNumber, final int columnNumber) {
        this.rowNumber = rowNumber;
        this.columnNumber = columnNumber;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public int getColumnNumber() {
        return columnNumber;
    }
}
