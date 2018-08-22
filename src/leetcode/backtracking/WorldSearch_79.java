package leetcode.backtracking;

/**
 * Created by cdx0312
 * 2018/4/10
 */
public class WorldSearch_79 {
    public boolean exist(char[][] board, String word) {
        boolean[][] flag = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++)
                if (seachWord(board, word, 0, i, j, flag))
                    return true;
        }
        return false;
    }

    private boolean seachWord(char[][] board, String word, int index, int x, int y, boolean[][] flag) {
        if (index == word.length() - 1)
            return board[x][y] == word.charAt(index);
        if (board[x][y] == word.charAt(index)) {
            flag[x][y] = true;
            if (x - 1 >= 0 && !flag[x-1][y] && seachWord(board, word, index+1,x-1, y, flag))
                return true;
            if (x + 1 < board.length && !flag[x+1][y] && seachWord(board, word, index + 1, x + 1, y, flag))
                return true;
            if (y-1 >= 0 && !flag[x][y-1] && seachWord(board, word, index + 1, x, y-1, flag))
                return true;
            if (y + 1 <board[0].length && !flag[x][y+1] && seachWord(board, word, index + 1, x, y+1, flag))
                return true;
            flag[x][y] = false;
        }
        return false;
    }
}
