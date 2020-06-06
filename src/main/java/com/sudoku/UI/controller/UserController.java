package com.sudoku.UI.controller;

import com.sudoku.engine.SudokuBoard;
import com.sudoku.model.PromptType;
import com.sudoku.strategy.Strategy;

import java.util.Scanner;

public interface UserController {
    Scanner SCANNER = new Scanner(System.in);

    String enterData(PromptType promptType);

    char enterValidCharacter(PromptType promptType);

    boolean confirmGameResult();

    SudokuBoard putValuesOnSudokuBoard(Strategy strategy);
}
