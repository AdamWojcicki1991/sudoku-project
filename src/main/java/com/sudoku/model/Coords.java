package com.sudoku.model;

public final class Coords {
    private final int row;
    private final int col;
    private int value;

    public Coords(final int row, final int col, int value) {
        this.row = row;
        this.col = col;
        this.value = value;
    }

    public Coords(final int row, final int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public int getValue() {
        return value;
    }
}
