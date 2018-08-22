package leetcode.search;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Created by cdx0312
 * 2018/4/4
 */
public class WordPattern_290 {
    public boolean wordPattern(String pattern, String str) {
        if (pattern == null || str == null)
            return false;
        HashMap<Object, Integer> map = new HashMap<>();
        char[] chars = pattern.toCharArray();
        String[] strings = str.split(" ");
        if (chars.length != strings.length)
            return false;
        for (int i = 0; i < chars.length; i++) {
            if (!Objects.equals(map.put(chars[i], i), map.put(strings[i], i)))
                return false;
        }
        return true;
    }

    public boolean wordPattern1(String pattern, String str) {
        char[] chars = pattern.toCharArray();
        String[] strings = str.split(" ");
        String[] pat = new String[26];
        if (chars.length != strings.length)
            return false;
        Set<String> set = new HashSet<>();

        for (int i = 0; i < chars.length; i++) {
            if (pat[chars[i]-'a'] == null) {
                pat[chars[i]-'a'] = strings[i];
                if (set.contains(strings[i]))
                    return false;
                else
                    set.add(strings[i]);
            } else {
                if (!strings[i].equals(pat[chars[i]-'a']))
                    return false;
            }
        }
        return true;
    }
}
