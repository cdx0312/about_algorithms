package leetcode.search;

import java.util.HashMap;

/**
 * Created by cdx0312
 * 2018/4/5
 */
public class FourSumII_454 {
    //查找表中记录C,D中任意两个和的可能次数O(N^2)
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer, Integer> record = new HashMap<>();
        for (int aC : C) {
            for (int aD : D) {
                int tmp = aC + aD;
                if (record.containsKey(tmp)) {
                    record.put(tmp, record.get(tmp) + 1);
                } else {
                    record.put(tmp, 1);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int tmp = 0 - A[i] - B[j];
                if (record.containsKey(tmp)) {
                    count += record.get(tmp);
                }
            }
        }
        return count;
    }
}
