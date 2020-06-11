package com.sudoku;

import com.sudoku.UI.controller.SudokuUserController;
import com.sudoku.engine.SudokuRunner;

public final class SudokuApplication {
    public static void main(String[] args) {
        try {
            new SudokuRunner(new SudokuUserController()).run();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
