package com.sudoku.UI;

import com.sudoku.engine.SudokuBoard;
import com.sudoku.model.PromptType;

public interface UserInterface {
    static void printMainMenu() {
        System.out.println("######################################################  WELCOME IN SUDOKU SOLVER ########################################################");
        System.out.println("Key 1 - 9 - Use it to put valid number in Sudoku cell");
        System.out.println("Sign ' ,' - In Sudoku board means that this cell is empty and you can put a value from keyboard to this cell");
        System.out.println("#########################################################################################################################################\n");
    }

    static void printShortMenu() {
        System.out.println("\n########################################################### SHORT GAME MENU #############################################################");
        System.out.println("Key y - START NEW GAME");
        System.out.println("Key n - EXIT GAME");
        System.out.println("#########################################################################################################################################\n");
    }

    static void printSolvedSudokuBoard(SudokuBoard sudokuBoard) {
        System.out.println("############################################################ SOLVED SUDOKU ##############################################################\n");
        System.out.println(sudokuBoard.toString());
        System.out.println("#########################################################################################################################################\n");
    }

    static void printUnsolvedSudokuBoard(SudokuBoard sudokuBoard) {
        System.out.println("########################################################### UNSOLVED SUDOKU #############################################################\n");
        System.out.println(sudokuBoard.toString());
        System.out.println("#########################################################################################################################################\n");
    }

    static void printSudokuBoard(SudokuBoard sudokuBoard) {
        System.out.println(sudokuBoard.toString());
    }

    static void printPrompt(PromptType promptType) {
        switch (promptType) {
            case ROW:
                System.out.println("Type ROW number: ");
                break;
            case COLUMN:
                System.out.println("Type COLUMN number: ");
                break;
            case VALUE:
                System.out.println("Type VALUE you want to put to the cell: ");
                break;
            case NAME:
                System.out.println("Type player name and press ENTER: ");
                break;
            case CONFIRM:
                System.out.println("Type 'sudoku' to solve SUDOKU or type something else to continue filling SUDOKU and press ENTER: ");
                break;
        }
    }

    static void printConfirmation() {
        System.out.println("Are you sure You want to END current GAME and start NEW GAME ? - type 'y' to confirm or 'n' to EXIT GAME\n");
    }

    static void printValidCharacters() {
        System.out.println("Type a valid character '1' - '9' and press ENTER: ");
    }

    static void printErrorMessage() {
        System.err.println("You put invalid symbol. Please try again !");
    }

    static void printThanksForGame(String playerName) {
        System.out.println("Thanks for playing " + playerName + " it was a great experience !");
    }
}
