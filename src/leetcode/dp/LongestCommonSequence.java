package leetcode.dp;

/**
 * Created by cdx0312
 * 2018/4/12
 * 最长公共子序列
 */
public class LongestCommonSequence {

    //递归
    public int longest(String s1, String s2) {
        if (s1.length() == 0 || s2.length() == 0)
            return 0;
        return longest(s1, s2, s1.length()-1, s2.length()-1);
    }

    private int longest(String s1, String s2, int m, int n) {

        if (m < 0 || n < 0)
            return 0;
        if (s1.charAt(m) == s2.charAt(n))
            return 1 + longest(s1,s2,m-1,n-1);
        else
            return Math.max(longest(s1,s2,m-1, n), longest(s1,s2,m,n-1));
    }

    public static void main(String[] args) {
        LongestCommonSequence LCS = new LongestCommonSequence();
        String s1 = "abcd";
        String s2 = "abcdefg";
        System.out.println(LCS.longest(s1,s2));
        System.out.println(LCS.longest2(s1,s2));
    }

    //DP
    public int longest2(String s1, String s2) {
        if (s1.length() == 0 || s2.length() == 0)
            return 0;
        int len1 = s1.length();
        int len2 = s2.length();
        int[][] dp = new int[len1+1][len2+1];
        for (int i = 0; i <= len1; i++)
            dp[i][0] = 0;
        for (int i = 0; i <= len2; i++)
            dp[0][i] = 0;
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[len1][len2];
    }
}
