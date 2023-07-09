package lc1600_1700.dp;

public class MinFlipsMonoIncr {
    public int minFlipsMonoIncr(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        int[] ones = new int[n + 1];
        for (int i = 0; i < n; i++) {
            ones[i + 1] = ones[i] + (s.charAt(i) == '1' ? 1 : 0);
        }
        for (int i = 1; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1] + (s.charAt(i - 1) == '1' ? 0 : 1), ones[i - 1]);
        }
        return dp[n];
    }
}