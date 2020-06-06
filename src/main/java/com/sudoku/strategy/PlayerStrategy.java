package com.sudoku.strategy;

import com.sudoku.UI.controller.UserController;
import com.sudoku.model.PromptType;

import static com.sudoku.model.PromptType.VALUE;

public final class PlayerStrategy implements Strategy {
    private final UserController userController;

    public PlayerStrategy(final UserController userController) {
        this.userController = userController;
    }

    @Override
    public int enterDataIntoCell(PromptType promptType) {
        switch (userController.enterValidCharacter(promptType)) {
            case '1':
                return (promptType == VALUE) ? 1 : 0;
            case '2':
                return (promptType == VALUE) ? 2 : 1;
            case '3':
                return (promptType == VALUE) ? 3 : 2;
            case '4':
                return (promptType == VALUE) ? 4 : 3;
            case '5':
                return (promptType == VALUE) ? 5 : 4;
            case '6':
                return (promptType == VALUE) ? 6 : 5;
            case '7':
                return (promptType == VALUE) ? 7 : 6;
            case '8':
                return (promptType == VALUE) ? 8 : 7;
            case '9':
                return (promptType == VALUE) ? 9 : 8;
            default:
                return (promptType == VALUE) ? -1 : 0;
        }
    }
}
