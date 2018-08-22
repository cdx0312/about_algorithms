package leetcode.dp;

/**
 * Created by cdx0312
 * 2018/4/12
 */
public class CoinChange_322 {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0)
            return 0;
        int n = amount + 1;
        for (int coin : coins) {
            int curr = 0;
            if (amount >= coin) {
                int next = coinChange(coins, amount - coin);
                if (next >= 0)
                    curr = 1 + next;
            }
            if (curr > 0)
                n = Math.min(n, curr);
        }
        return n == amount + 1 ? -1 : n;
    }

    public int coinChange1(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 0; i < dp.length; i++)
            dp[i] = amount + 1;
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i)
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        System.out.println(new CoinChange_322().coinChange1(new int[]{2}, 3));
    }

}
