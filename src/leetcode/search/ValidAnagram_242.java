package leetcode.search;

import java.util.HashMap;

/**
 * Created by cdx0312
 * 2018/4/4
 */
public class ValidAnagram_242 {
    public boolean isAnagram(String s, String t) {
        if (s == null && t == null)
            return true;
        if (s == null || t == null)
            return false;
        if (s.length() != t.length())
            return false;
        HashMap<Character, Integer> sMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char s1 = s.charAt(i);
            char t1 = t.charAt(i);
            if (sMap.containsKey(s1))
                sMap.put(s1, sMap.get(s1)+1);
            else
                sMap.put(s1,1);
            if (sMap.containsKey(t1))
                sMap.put(t1, sMap.get(t1)-1);
            else
                sMap.put(t1, -1);
        }
        for (Character ch : sMap.keySet()) {
            if (sMap.get(ch) != 0)
                return false;
        }
        return true;
    }

    public boolean isAnagram1(String s, String t) {
        int[] chars = new int[26];
        for (char c : s.toCharArray()) {
            chars[c-'a']++;
        }
        for (char c : t.toCharArray()) {
            chars[c-'a']--;
        }

        for (int i : chars) {
            if (i != 0)
                return false;
        }
        return true;
    }
}
