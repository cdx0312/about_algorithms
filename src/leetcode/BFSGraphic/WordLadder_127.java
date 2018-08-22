package leetcode.BFSGraphic;

import java.util.*;

/**
 * Created by cdx0312
 * 2018/4/8
 */
public class WordLadder_127 {
    /*
        beginSet开始存放beginword，然后将经过一次变更字母之后可以编程的wordList中的字符串
        放入beginSet，直到出现变换成最终的字符串。
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList), qs = new HashSet<>(), qe = new HashSet<>(), vis = new HashSet<>();
        qs.add(beginWord);
        if (dict.contains(endWord))
            qe.add(endWord); // all transformed words must be in dict (including endWord)
        for (int len = 2; !qs.isEmpty(); len++) {
            Set<String> nq = new HashSet<>();
            for (String w : qs) {
                for (int j = 0; j < w.length(); j++) {
                    char[] ch = w.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == w.charAt(j))
                            continue; // beginWord and endWord not the same, so bypass itself
                        ch[j] = c;
                        String nb = String.valueOf(ch);
                        if (qe.contains(nb))
                            return len; // meet from two ends
                        if (dict.contains(nb) && vis.add(nb))
                            nq.add(nb); // not meet yet, vis is safe to use
                    }
                }
            }
            qs = (nq.size() < qe.size()) ? nq : qe; // switch to small one to traverse from other end
            qe = (qs == nq) ? qe : nq;
        }
        return 0;
    }
}
