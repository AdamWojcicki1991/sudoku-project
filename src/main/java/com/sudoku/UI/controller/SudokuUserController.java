package com.sudoku.UI.controller;

import com.sudoku.engine.SudokuBoard;
import com.sudoku.model.PromptType;
import com.sudoku.strategy.Strategy;

import static com.sudoku.UI.UserInterface.*;
import static com.sudoku.model.PromptType.*;

public class SudokuUserController implements UserController {
    @Override
    public String enterData(PromptType promptType) {
        if (promptType == NAME) printMainMenu();
        printPrompt(promptType);
        return SCANNER.next();
    }

    @Override
    public char enterValidCharacter(PromptType promptType) {
        boolean errorConfirmed = false;
        char keyboardCharacter = ' ';
        while (!errorConfirmed) {
            printValidCharacters();
            printPrompt(promptType);
            keyboardCharacter = SCANNER.next().charAt(0);
            if (isValidCharacter(keyboardCharacter)) {
                errorConfirmed = true;
            } else {
                printErrorMessage();
            }
        }
        return keyboardCharacter;
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
    public SudokuBoard putValuesOnSudokuBoard(Strategy strategy) {
        String confirm = "";
        SudokuBoard sudokuBoard = new SudokuBoard();
        while (!confirm.equals("sudoku")) {
            sudokuBoard.setNumber(
                    strategy.enterDataIntoCell(COLUMN),
                    strategy.enterDataIntoCell(ROW),
                    strategy.enterDataIntoCell(VALUE));
            printSudokuBoard(sudokuBoard);
            confirm = enterData(CONFIRM).toLowerCase();
        }
        return sudokuBoard;
    }

    private boolean isValidCharacter(char keyboardCharacter) {
        return keyboardCharacter == '1' || keyboardCharacter == '2' || keyboardCharacter == '3' ||
                keyboardCharacter == '4' || keyboardCharacter == '5' || keyboardCharacter == '6' ||
                keyboardCharacter == '7' || keyboardCharacter == '8' || keyboardCharacter == '9';
    }
}
