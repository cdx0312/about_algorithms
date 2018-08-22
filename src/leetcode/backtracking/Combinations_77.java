package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cdx0312
 * 2018/4/10
 */
public class Combinations_77 {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        if (n <= 0 || k <= 0 || k > n)
            return res;
        combine(n, k, 1, new ArrayList<>());
        return res;
    }

    /**
     * 求解C(n,k),
     * @param n
     * @param k
     * @param start
     * @param list
     */
    private void combine(int n, int k, int start, List<Integer> list) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <= n- (k - list.size()) + 1; i++) {
            list.add(i);
            combine(n, k, i + 1, list);
            list.remove(list.size() - 1);
        }
    }
}
