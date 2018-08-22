package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cdx0312
 * 2018/4/10
 */
public class PalindromePartitioning_131 {
    private List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {
        List<String> list = new ArrayList<>();
        partition(list, s, 0, "");
        return res;
    }

    private void partition(List<String> list, String s, int pos, String sub) {
        if (pos == s.length()) {
            if (sub.equals(""))
                res.add(new ArrayList<>(list));
            return;
        }
        String tmp = sub + s.charAt(pos);
        if (isPalindrome(tmp)) {
            list.add(tmp);
            partition(list, s, pos + 1, "");
            list.remove(list.size() - 1);
        }
        partition(list, s, pos + 1, tmp);
    }

    private boolean isPalindrome(String s) {
        for (int i = 0; i < s.length()/2; i += 1) {
            if (s.charAt(i) != s.charAt(s.length()-1-i))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aab";
        System.out.println(new PalindromePartitioning_131().partition(s));
    }
}
