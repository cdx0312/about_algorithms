package leetcode.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by cdx0312
 * 2018/4/11
 */
public class NQueens_51 {
    private List<List<String>> res = new LinkedList<>();
    boolean[] col, dia1, dia2;
    public List<List<String>> solveNQueens(int n) {
        res.clear();
        List<Integer> row = new LinkedList<>();
        col = new boolean[n];
        dia1 = new boolean[2*n - 1];
        dia2 = new boolean[2*n - 1];
        putQueen(n, 0, row);
        return res;
    }

    /**
     *
     * @param n n皇后问题
     * @param index 第index行
     * @param row 数组，row[0]=i表示第0行第i列放皇后
     */
    private void putQueen(int n, int index, List<Integer> row) {
        if (index == n) {
            res.add(generateBoard(n, row));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!col[i] && !dia1[index + i] && !dia2[index-i+n-1]) {
                row.add(i);
                col[i] = true;
                dia1[index + i] = true;
                dia2[index-i+n-1] = true;
                putQueen(n, index + 1, row);
                col[i] = false;
                dia1[index + i] = false;
                dia2[index-i+n-1] = false;
                row.remove(row.size() -1);
            }
        }
    }

    private List<String> generateBoard(int n, List<Integer> row) {
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j ++) {
                if (j == row.get(i)) {
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }
            board.add(sb.toString());
        }
        return board;
    }

    public static void main(String[] args) {
        NQueens_51 queen = new NQueens_51();
        queen.solveNQueens(8);
        System.out.println(queen.res);
    }
}
