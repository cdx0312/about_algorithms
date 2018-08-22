package leetcode.backtracking;

/**
 * Created by cdx0312
 * 2018/4/11
 */
public class Sudoku_Solver_37 {
    public void solveSudoku(char[][] board) {
        doSolve(board, 0, 0);
    }

    private boolean doSolve(char[][] board, int row, int col) {
        for (int i = row; i < 9; i++, col = 0) {
            for (int j = col; j < 9; j++) {
                if (board[i][j] != '.')
                    continue;
                for (char c = '1'; c <= '9'; c++) {
                    if (isValid(board, i, j, c)) {
                        board[i][j] = c;
                        if (doSolve(board, i, j + 1))
                            return true;
                        board[i][j] = '.';
                    }
                }
                return false;
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char num) {
        int blkrow = row / 3 * 3, blkcol = col / 3 * 3;
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num || board[row][i] == num || board[blkrow + i / 3][blkcol + i % 3] == num)
                return false;
        }
        return true;
    }
}
