package com.sudoku.UI.controller;

import com.sudoku.engine.SudokuBoard;
import com.sudoku.model.PromptType;

import static com.sudoku.UI.UserInterface.*;
import static com.sudoku.model.PromptType.CONFIRM;
import static com.sudoku.model.PromptType.NAME;

public class SudokuUserController implements UserController {
    @Override
    public String enterData(PromptType promptType) {
        if (promptType == NAME) printMainMenu();
        printPrompt(promptType);
        return SCANNER.next();
    }

    @Override
    public boolean confirmGameResult() {
        boolean errorConfirmed = false;
        char keyboardCharacter = ' ';
        while (!errorConfirmed) {
            printShortMenu();
            printConfirmation();
            keyboardCharacter = SCANNER.next().charAt(0);
            if (keyboardCharacter == 'y' || keyboardCharacter == 'n') {
                errorConfirmed = true;
            } else {
                printErrorMessage();
            }
        }
        return keyboardCharacter == 'y';
    }

    @Override
    public SudokuBoard putValuesOnSudokuBoard() {
        String confirm = "";
        SudokuBoard sudokuBoard = new SudokuBoard();
        while (!confirm.equals("sudoku")) {
            SCANNER.nextLine();
            sudokuBoard.setValue(UserDialogs.getCellValue());
            printSudokuBoard(sudokuBoard);
            confirm = enterData(CONFIRM).toLowerCase();
            if (confirm.equals("x")) {
                sudokuBoard.setForceExit(true);
                break;
            }
        }
        return sudokuBoard;
    }
}
