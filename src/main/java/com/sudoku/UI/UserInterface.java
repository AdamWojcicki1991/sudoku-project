package com.sudoku.UI;

import com.sudoku.engine.SudokuBoard;

import java.util.Scanner;

public interface UserInterface {
    Scanner SCANNER = new Scanner(System.in);

    void printMainMenu();

    void printShortMenu();

    void printConfirmation();

    void printErrorMessage();

    void printSudokuBoard(SudokuBoard sudokuBoard);

    void printValidCharacters();

    void printThanksForGame(String playerName);

    String enterUserName();

    SudokuBoard putValuesOnSudokuBoard(SudokuBoard sudokuBoard);

    char enterValidCharacter();

    boolean confirmNewGame();
}
