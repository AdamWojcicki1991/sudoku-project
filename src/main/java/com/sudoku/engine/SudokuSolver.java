package com.sudoku.engine;

import com.sudoku.model.SudokuResult;

import java.util.List;
import java.util.stream.IntStream;

import static com.sudoku.model.SudokuResult.SOLVED;
import static com.sudoku.model.SudokuResult.UNSOLVED;

public class SudokuSolver {
    static final int SIZE = 9;

    public SudokuResult resolveSudoku(SudokuBoard sudokuBoard) {
        boolean changed = true;
        while (changed) {
            resolveStageOne(sudokuBoard);
            changed = resolveStageTwo(sudokuBoard);
        }
        return isSudokuSolvable(sudokuBoard);
    }

    private void resolveStageOne(SudokuBoard sudokuBoard) {
        for (int col = 0; col < SIZE; col++) {
            for (int row = 0; row < SIZE; row++) {
                if (sudokuBoard.isCellEmpty(col, row)) {
                    removeFromRow(sudokuBoard, sudokuBoard.getPossibles(col, row), row);
                    removeFromCol(sudokuBoard, sudokuBoard.getPossibles(col, row), col);
                    removeFromBox(sudokuBoard, sudokuBoard.getPossibles(col, row), col, row);
                }
            }
        }
    }

    private boolean resolveStageTwo(SudokuBoard sudokuBoard) {
        boolean changed = false;
        for (int col = 0; col < SIZE; col++) {
            for (int row = 0; row < SIZE; row++) {
                if (sudokuBoard.getPossibles(col, row).size() == 1 && sudokuBoard.isCellEmpty(col, row)) {
                    sudokuBoard.setNumber(col, row, sudokuBoard.getPossibles(col, row).get(0));
                    changed = true;
                }
            }
        }
        return changed;
    }

    private void removeFromBox(SudokuBoard sudokuBoard, List<Integer> possibles, int col, int row) {
        int boxX = col / 3;
        int boxY = row / 3;
        for (int dx = 0; dx < 3; dx++) {
            for (int dy = 0; dy < 3; dy++) {
                Integer value = sudokuBoard.getNumber(boxX * 3 + dx, boxY * 3 + dy);
                possibles.remove(value);
            }
        }
    }

    private void removeFromRow(SudokuBoard sudokuBoard, List<Integer> possibles, int row) {
        IntStream.range(0, SIZE)
                .mapToObj(n -> sudokuBoard.getNumber(n, row))
                .forEach(n -> possibles.remove(n));
    }

    private void removeFromCol(SudokuBoard sudokuBoard, List<Integer> possibles, int col) {
        IntStream.range(0, SIZE)
                .mapToObj(n -> sudokuBoard.getNumber(col, n))
                .forEach(n -> possibles.remove(n));
    }

    private SudokuResult isSudokuSolvable(SudokuBoard sudokuBoard) {
        for (int col = 0; col < SIZE; col++) {
            for (int row = 0; row < SIZE; row++) {
                if (sudokuBoard.isCellEmpty(col, row)) {
                    return UNSOLVED;
                }
            }
        }
        return SOLVED;
    }
}
