package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cdx0312
 * 2018/4/10
 */
public class RestoreIpAddress_93 {

    private List<String> res = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        int len = s.length();
        for (int i = 1; i < 4 && i < len - 2; i++) {
            for (int j = i + 1; j < i + 4 && j < len - 1; j++) {
                for (int k = j + 1; k < j + 4 && k < len; k++) {
                    String s1 = s.substring(0,i);
                    String s2 = s.substring(i,j);
                    String s3 = s.substring(j,k);
                    String s4 = s.substring(k,len);
                    if (isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)){
                        StringBuilder sb = new StringBuilder();
                        sb.append(s1).append(".").append(s2).append(".").append(s3)
                                .append(".").append(s4);
                        res.add(sb.toString());
                    }
                }
            }
        }
        return res;
    }

    private boolean isValid(String s) {
        return s.length() <= 3 && s.length() != 0 && (s.charAt(0) != '0' || s.length() <= 1) && Integer.parseInt(s) <= 255;
    }

    public List<String> restoreIpAddresses1(String s) {
        dfs(new StringBuilder(), 0, s, 0, 0);
        return res;
    }

    /**
     * DFS方法，回溯法应用
     * @param sb 拼接的字符串
     * @param pos 字符串的下标
     * @param s 输入的字符串
     * @param num 组成的数字
     * @param dot 点的个数
     */
    private void dfs(StringBuilder sb, int pos, String s, int num, int dot) {
        //终止条件，当检查晚最后一个元素时，如果点为3个，将字符串添加到res中
        if (pos == s.length()) {
            if (dot == 3)
                res.add(sb.toString());
            return;
        }
        //pos时，检查将其添加到当前数字中是否小于255，小于说明可以添加，则将其添加过去，遍历下一位
        if (num * 10 + s.charAt(pos)-'0' <= 255) {
            if (pos == 0 || num != 0) {
                sb.append(s.charAt(pos));
                dfs(sb, pos + 1, s,num * 10 + s.charAt(pos)-'0', dot);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        //不管pos能否添加，都不添加，而直接加点，迭代下一位
        if (dot < 3 && pos > 0){
            sb.append(".");
            sb.append(s.charAt(pos));
            dfs(sb,pos + 1, s, s.charAt(pos) - '0', dot + 1);
            sb.deleteCharAt(sb.length() - 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
