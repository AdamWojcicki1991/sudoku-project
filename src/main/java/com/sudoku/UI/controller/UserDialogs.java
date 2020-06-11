package com.sudoku.UI.controller;

import com.sudoku.model.Coords;

import static com.sudoku.UI.UserInterface.printErrorMessage;
import static com.sudoku.UI.UserInterface.printValidCharacters;
import static com.sudoku.UI.controller.UserController.SCANNER;

public class UserDialogs {
    public static Coords getCellValue() {
        while (true) {
            printValidCharacters();
            String s = SCANNER.nextLine();
            try {
                int row = Integer.parseInt(s.substring(0, 1));
                int col = Integer.parseInt(s.substring(1, 2));
                int value = Integer.parseInt(s.substring(2, 3));
                if (row <= 8 && col <= 8 && (value >= 1 || value == 0) && s.length() == 3) {
                    return new Coords(row, col, value);
                } else {
                    printErrorMessage();
                }
            } catch (Exception e) {
                printErrorMessage();
            }
        }
    }
}
