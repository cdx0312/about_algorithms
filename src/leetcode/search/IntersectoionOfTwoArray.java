package leetcode.search;

import java.util.HashSet;

/**
 * Created by cdx0312
 * 2018/4/4
 */
public class IntersectoionOfTwoArray {
    public int[] intersection(int[] num1, int[] num2) {
        HashSet<Integer> record = new HashSet<>();
        HashSet<Integer> result = new HashSet<>();

        for (int aNum1 : num1) {
            record.add(aNum1);
        }

        for (int aNum1 : num2) {
            if (record.contains(aNum1))
                result.add(aNum1);
        }

        int[] resultA = new int[result.size()];

        int j = 0;
        for (int i : result) {
            resultA[j++] = i;
        }
        return resultA;
    }
}
