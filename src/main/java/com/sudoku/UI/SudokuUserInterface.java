package com.sudoku.UI;

import com.sudoku.engine.SudokuBoard;

public class SudokuUserInterface implements UserInterface {
    @Override
    public void printMainMenu() {
        System.out.println("############################################################### GAME MENU ###############################################################");
        System.out.println("WELCOME IN SUDOKU SOLVER");
        System.out.println("Key 1 - 9 -> Use it to put valid number in Sudoku cell");
        System.out.println("Key x -----> Choose between START NEW GAME or EXIT GAME");
        System.out.println("As first you must put [ROW number] and [COLUMN number] of Sudoku cell you want to fill and at last put a [VALUE number]");
        System.out.println("Correct syntax for example should look 1,1,2 (You put [Value 2] in the cell position [First ROW] [First COLUMN])");
        System.out.println("#########################################################################################################################################\n");
    }

    @Override
    public void printShortMenu() {
        System.out.println("\n############################################################ SHORT GAME MENU ############################################################");
        System.out.println("Key y - START NEW GAME");
        System.out.println("Key n - EXIT GAME");
        System.out.println("#########################################################################################################################################\n");
    }

    @Override
    public void printConfirmation() {
        System.out.println("Are you sure You want to END current GAME and start NEW GAME ? - type 'y' to START NEW GAME or 'n' to EXIT GAME\n");
    }

    @Override
    public void printErrorMessage() {
        System.err.println("You put invalid symbol. Please try again !");
    }

    @Override
    public void printSudokuBoard(SudokuBoard sudokuBoard) {
        System.out.println(sudokuBoard.toString());
    }

    @Override
    public void printValidCharacters() {
        System.out.println("Type a valid character '1' - '9' or 'x' - Choose between NEW GAME or EXIT and press ENTER: ");
    }

    @Override
    public void printThanksForGame(String playerName) {
        System.out.println("Thanks for playing " + playerName + " it was a great experience !");
    }

    @Override
    public String enterUserName() {
        System.out.println("Type player name and press ENTER: ");
        return SCANNER.next();
    }

    @Override
    public char enterValidCharacter() {
        boolean errorConfirmed = false;
        char keyboardCharacter = ' ';
        while (!errorConfirmed) {
            printValidCharacters();
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
    public SudokuBoard putValuesOnSudokuBoard(SudokuBoard sudokuBoard) {
        printSudokuBoard(sudokuBoard);
        return null;
    }

    @Override
    public boolean confirmNewGame() {
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

    private boolean isValidCharacter(char keyboardCharacter) {
        return keyboardCharacter == '1' || keyboardCharacter == '2' ||
                keyboardCharacter == '3' || keyboardCharacter == '4' ||
                keyboardCharacter == '5' || keyboardCharacter == '6' ||
                keyboardCharacter == '7' || keyboardCharacter == '8' ||
                keyboardCharacter == '9' || keyboardCharacter == 'x';
    }
}
