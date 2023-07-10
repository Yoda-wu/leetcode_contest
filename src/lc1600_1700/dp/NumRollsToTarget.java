package lc1600_1700.dp;

public class NumRollsToTarget {

    int MOD = (int) 1e9 + 7;

    public int numRollsToTarget(int n, int m, int t) {
        int[][] dp = new int[n + 1][t + 1]; // 前i个骰子，和为j的方案数
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) { // 枚举物品组
            for (int j = 0; j <= t; j++) { // 枚举背包容量
                for (int k = 1; k <= m; k++) { // 枚举决策
                    if (j >= k) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][j - k]) % MOD;
                    }

                }
            }
        }
        return dp[n][t];
    }

}
