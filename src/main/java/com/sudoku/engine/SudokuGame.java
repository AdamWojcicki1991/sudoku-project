package com.sudoku.engine;

import com.sudoku.UI.controller.UserController;
import com.sudoku.model.GameResult;
import com.sudoku.model.SudokuDefinition;
import com.sudoku.model.SudokuResult;
import com.sudoku.strategy.Strategy;

import static com.sudoku.UI.UserInterface.printSolvedSudokuBoard;
import static com.sudoku.UI.UserInterface.printUnsolvedSudokuBoard;
import static com.sudoku.model.GameResult.END;
import static com.sudoku.model.GameResult.NEXT;
import static com.sudoku.model.PromptType.NAME;
import static com.sudoku.model.SudokuResult.SOLVED;

public final class SudokuGame {
    private final UserController userController;
    private final Strategy strategy;
    private SudokuDefinition sudokuDefinition;

    public SudokuGame(final UserController userController, final Strategy strategy) {
        this.userController = userController;
        this.strategy = strategy;
        this.sudokuDefinition = new SudokuDefinition(userController.enterData(NAME), new SudokuBoard());
    }

    public GameResult start() {
        sudokuDefinition = fillSudokuBoard(sudokuDefinition);
        SudokuResult sudokuResult = new SudokuSolver().resolveSudoku(sudokuDefinition.getSudokuBoard());
        if (sudokuResult == SOLVED) {
            printSolvedSudokuBoard(sudokuDefinition.getSudokuBoard());
        } else {
            printUnsolvedSudokuBoard(sudokuDefinition.getSudokuBoard());
        }
        return (userController.confirmGameResult()) ? NEXT : END;
    }

    public SudokuDefinition getSudokuDefinition() {
        return sudokuDefinition;
    }

    private SudokuDefinition fillSudokuBoard(SudokuDefinition sudokuDefinition) {
        SudokuBoard sudokuBoardWithValues = userController.putValuesOnSudokuBoard(strategy);
        return new SudokuDefinition(sudokuDefinition.getUserName(), sudokuBoardWithValues);
    }
}
