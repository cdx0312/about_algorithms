package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by cdx0312
 * 2018/4/10
 */
public class LetterCombinationsOfAPhoneNumber_17 {

    private static final String[] letterMap  =  {" ", "","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    private List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits == null || Objects.equals(digits, ""))
            return res;
        findCombation(digits, 0, "");
        return res;
    }

    private void findCombation(String digits, int index, String s) {
        if (index == digits.length()) {
            //保存s
            res.add(s);
            return;
        }
        char c = digits.charAt(index);
        String letters = letterMap[c - '0'];
        for (int i = 0; i < letters.length(); i++) {
            findCombation(digits, index + 1, s + letters.charAt(i));
        }
    }
}
