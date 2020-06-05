package com.sudoku.engine;

import com.sudoku.UI.UserInterface;
import com.sudoku.model.GameResult;

import static com.sudoku.model.GameResult.NEXT_GAME;

public final class SudokuRunner {
    private final UserInterface userInterface;

    public SudokuRunner(final UserInterface userInterface) {
        this.userInterface = userInterface;
    }

    public void run() {
        SudokuGame sudokuGame = new SudokuGame(userInterface);
        GameResult gameResult = NEXT_GAME;
        while (gameResult == NEXT_GAME) {
            gameResult = new SudokuGame(userInterface).start();
        }
        userInterface.printThanksForGame(sudokuGame.getPlayerName());
    }
}
