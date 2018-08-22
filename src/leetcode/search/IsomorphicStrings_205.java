package leetcode.search;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by cdx0312
 * 2018/4/4
 */
public class IsomorphicStrings_205 {
    public boolean isIsomorphic(String s, String t) {
        int[] num = new int[256];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < num.length; i++)
            num[i] = Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); i++) {
            int tmp = t.charAt(i);
            if (num[s.charAt(i)] == Integer.MAX_VALUE) {
                num[s.charAt(i)] = tmp;
                if (set.contains(tmp))
                    return false;
                else
                    set.add(tmp);
            } else {
                if (tmp != num[s.charAt(i)])
                    return false;
            }
        }
        return true;
    }
}
