package com.sudoku.strategy;

import com.sudoku.model.PromptType;

public interface Strategy {
    int enterDataIntoCell(PromptType promptType);
}
