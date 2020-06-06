package com.sudoku.engine;

import com.sudoku.UI.controller.UserController;
import com.sudoku.model.GameResult;
import com.sudoku.strategy.PlayerStrategy;
import com.sudoku.strategy.Strategy;

import static com.sudoku.UI.UserInterface.printThanksForGame;
import static com.sudoku.model.GameResult.NEXT;

public final class SudokuRunner {
    private final UserController userController;
    private final Strategy strategy;

    public SudokuRunner(final UserController userController) {
        this.userController = userController;
        this.strategy = new PlayerStrategy(userController);
    }

    public void run() {
        SudokuGame sudokuGame = new SudokuGame(userController, strategy);
        GameResult gameResult = sudokuGame.start();
        while (gameResult == NEXT) {
            gameResult = new SudokuGame(userController, strategy).start();
        }
        printThanksForGame(sudokuGame.getSudokuDefinition().getUserName());
    }
}
