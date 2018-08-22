package leetcode.BFSGraphic;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by cdx0312
 * 2018/4/8
 */
public class PerfectSquares_279 {
    public int numSquares(int n) {
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(n, 0));
        boolean[] visited = new boolean[n+1];
        visited[n] = true;
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int num = pair.num;
            int step = pair.step;
            if (num == 0)
                return step;
            for (int i = 1; num - i * i >= 0; i++) {
                if (!visited[num-i*i]) {
                    queue.offer(new Pair(num - i * i, step + 1));
                    visited[num - i * i] = true;
                }
            }
        }
        return n;
    }
    /**
     * num:当前数
     * step:n到num需要的步数
     */
    class Pair {
        int num;
        int step;
        public Pair(int num, int step) {
            this.num = num;
            this.step = step;
        }
    }
}
