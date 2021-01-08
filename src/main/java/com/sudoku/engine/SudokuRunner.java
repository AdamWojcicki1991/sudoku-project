package com.sudoku.engine;

import com.sudoku.UI.controller.UserController;
import com.sudoku.model.GameResult;

import static com.sudoku.UI.UserInterface.printThanksForGame;
import static com.sudoku.model.GameResult.NEXT;

public final class SudokuRunner {
    private final UserController userController;

    public SudokuRunner(final UserController userController) {
        this.userController = userController;
    }

    public void run() {
        SudokuGame sudokuGame = new SudokuGame(userController);
        GameResult gameResult = sudokuGame.start();

        while (gameResult == NEXT) {
            gameResult = new SudokuGame(userController).start();
        }
        printThanksForGame(sudokuGame.getSudokuDefinition().getUserName());
    }
}
