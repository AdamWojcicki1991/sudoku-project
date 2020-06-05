package com.sudoku.engine;

import com.sudoku.UI.UserInterface;
import com.sudoku.model.GameResult;
import com.sudoku.model.SudokuDefinition;
import com.sudoku.model.SudokuResult;

import static com.sudoku.model.GameResult.END_GAME;
import static com.sudoku.model.GameResult.NEXT_GAME;
import static com.sudoku.model.SudokuResult.UNSOLVED;

public final class SudokuGame {
    private final UserInterface userInterface;
    private SudokuDefinition sudokuDefinition;

    public SudokuGame(final UserInterface userInterface) {
        this.userInterface = userInterface;
    }

    public GameResult start() {
        userInterface.printMainMenu();
        sudokuDefinition = createSudokuDefinition();
        SudokuResult sudokuResult = UNSOLVED;
        while (sudokuResult == UNSOLVED) {
            sudokuResult = new SudokuSolver().solve(sudokuDefinition);
        }
        userInterface.printSudokuBoard(sudokuDefinition.getSudokuBoard());
        return resolveSudoku();
    }

    private GameResult resolveSudoku() {
        return (userInterface.confirmNewGame()) ? NEXT_GAME : END_GAME;
    }

    private SudokuDefinition createSudokuDefinition() {
        String userName = userInterface.enterUserName();
        SudokuBoard sudokuBoardWithValues = userInterface.putValuesOnSudokuBoard(new SudokuBoard());
        return new SudokuDefinition(userName, sudokuBoardWithValues);
    }

    public String getPlayerName() {
        return sudokuDefinition.getUserName();
    }
}
