package leetcode.search;

import java.util.*;

/**
 * Created by cdx0312
 * 2018/4/4
 */
public class SortCharactersByFrequency_451 {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c))
                map.put(c, map.get(c) + 1);
            else
                map.put(c, 1);
        }
        List<Character> [] bucket = new List[s.length() + 1];
        for (char key : map.keySet()) {
            int freq = map.get(key);
            if (bucket[freq] == null)
                bucket[freq] = new ArrayList<>();
            bucket[freq].add(key);
        }
        StringBuilder sb = new StringBuilder();
        for (int j = bucket.length - 1; j >= 0; j--) {
            if (bucket[j] != null) {
                for (char ch : bucket[j]) {
                    for (int i = 0; i < map.get(ch); i++)
                        sb.append(ch);
                }
            }
        }
        return sb.toString();
    }
}
