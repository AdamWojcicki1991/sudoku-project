package com.sudoku.engine;

import com.sudoku.UI.controller.UserController;
import com.sudoku.model.GameResult;
import com.sudoku.model.SudokuDefinition;

import static com.sudoku.UI.UserInterface.printSolvedSudokuBoard;
import static com.sudoku.UI.UserInterface.printUnsolvedSudokuBoard;
import static com.sudoku.model.GameResult.END;
import static com.sudoku.model.GameResult.NEXT;
import static com.sudoku.model.PromptType.NAME;
import static com.sudoku.model.SudokuResult.SOLVED;

public final class SudokuGame {
    private final UserController userController;
    private SudokuDefinition sudokuDefinition;

    public SudokuGame(final UserController userController) {
        this.userController = userController;
        this.sudokuDefinition = new SudokuDefinition(userController.enterData(NAME), new SudokuBoard());
    }

    public GameResult start() throws CloneNotSupportedException {
        sudokuDefinition = fillSudokuBoard(sudokuDefinition);
        SudokuSolver sudokuSolver = new SudokuSolver();
        if (sudokuSolver.resolveSudoku(sudokuDefinition.getSudokuBoard()) == SOLVED) {
            printSolvedSudokuBoard(sudokuSolver.getResolvedSudoku());
        } else {
            printUnsolvedSudokuBoard(sudokuSolver.getResolvedSudoku());
        }
        return (userController.confirmGameResult()) ? NEXT : END;
    }

    public SudokuDefinition getSudokuDefinition() {
        return sudokuDefinition;
    }

    private SudokuDefinition fillSudokuBoard(SudokuDefinition sudokuDefinition) {
        SudokuBoard sudokuBoardWithValues = userController.putValuesOnSudokuBoard();
        return new SudokuDefinition(sudokuDefinition.getUserName(), sudokuBoardWithValues);
    }
}
