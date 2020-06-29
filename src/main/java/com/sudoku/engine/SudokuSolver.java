package com.sudoku.engine;

import com.sudoku.model.Coords;
import com.sudoku.model.SudokuResult;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static com.sudoku.engine.SudokuBoard.SIZE;
import static com.sudoku.model.SudokuResult.SOLVED;
import static com.sudoku.model.SudokuResult.UNSOLVED;

public class SudokuSolver {
    private SudokuBoard resolvedSudoku;

    public SudokuResult resolveSudoku(SudokuBoard sudokuBoard) throws CloneNotSupportedException {
        boolean changed = true;
        while (changed) {
            resolveStageOne(sudokuBoard);
            changed = resolveStageTwo(sudokuBoard);
        }
        if (isSudokuSolved(sudokuBoard)) {
            resolvedSudoku = sudokuBoard;
            return SOLVED;
        } else {
            List<Coords> emptyCells = getUnsolvedCells(sudokuBoard);
            if (emptyCells.size() < 2) return UNSOLVED;
            for (Coords cell : emptyCells) {
                for (Integer value : sudokuBoard.getPossibles(cell.getCol(), cell.getRow())) {
                    SudokuBoard sudokuBoardCopy = sudokuBoard.deepCopy();
                    sudokuBoardCopy.setValue(cell.getCol(), cell.getRow(), value);
                    sudokuBoardCopy.getPossibles(cell.getCol(), cell.getRow()).remove(value);
                    if (resolveSudoku(sudokuBoardCopy) == SOLVED) return SOLVED;
                }
            }
            return UNSOLVED;
        }
    }

    public SudokuBoard getResolvedSudoku() {
        return resolvedSudoku;
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
                    if (sudokuBoard.canPlacedValue(col, row, sudokuBoard.getPossibles(col, row).get(0))) {
                        sudokuBoard.setValue(col, row, sudokuBoard.getPossibles(col, row).get(0));
                        changed = true;
                    }
                }
            }
        }
        return changed;
    }

    private void removeFromRow(SudokuBoard sudokuBoard, List<Integer> possibles, int row) {
        IntStream.range(0, SIZE)
                .mapToObj(n -> sudokuBoard.getValue(n, row))
                .forEach(n -> possibles.remove(n));
    }

    private void removeFromCol(SudokuBoard sudokuBoard, List<Integer> possibles, int col) {
        IntStream.range(0, SIZE)
                .mapToObj(n -> sudokuBoard.getValue(col, n))
                .forEach(n -> possibles.remove(n));
    }

    private void removeFromBox(SudokuBoard sudokuBoard, List<Integer> possibles, int col, int row) {
        int boxX = col / 3;
        int boxY = row / 3;
        for (int dx = 0; dx < 3; dx++) {
            for (int dy = 0; dy < 3; dy++) {
                Integer value = sudokuBoard.getValue(boxX * 3 + dx, boxY * 3 + dy);
                possibles.remove(value);
            }
        }
    }

    private boolean isSudokuSolved(SudokuBoard sudokuBoard) {
        for (int col = 0; col < SIZE; col++) {
            for (int row = 0; row < SIZE; row++) {
                if (sudokuBoard.isCellEmpty(col, row)) {
                    return false;
                }
            }
        }
        return true;
    }

    private List<Coords> getUnsolvedCells(SudokuBoard sudokuBoard) {
        List<Coords> coords = new ArrayList<>();
        for (int col = 0; col < SIZE; col++) {
            for (int row = 0; row < SIZE; row++) {
                if (sudokuBoard.isCellEmpty(col, row)) {
                    coords.add(new Coords(row, col));
                }
            }
        }
        return coords;
    }
}
