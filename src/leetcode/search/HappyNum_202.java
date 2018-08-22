package leetcode.search;

import java.util.HashSet;

/**
 * Created by cdx0312
 * 2018/4/4
 */
public class HappyNum_202 {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        int sum = 0;
        while (n != 1) {
            set.add(n);
            while (n != 0) {
                sum += (n % 10) * (n % 10);
                n = n / 10;
            }
            n = sum;
            sum = 0;
            if (set.contains(n))
                return false;
        }
        return true;
    }
}
