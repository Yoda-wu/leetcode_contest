package lc1600_1700.dp;

/**
 * 前缀和理解：
 *  如果位置i的前缀和为偶数，如果下标j满足j<i的位置的前缀和为奇数，那么[i,j]这个区间的和为奇数，这个j的数目是odd
 *  如果位置i的前缀和为奇数，如果下标j满足j<i的位置的前缀和为偶数，那么[i,j]这个区间的和为奇数，这个j的数目是even
 * 线性DP理解：dp[i][0], dp[i][1] 表示前i个数中，奇数子数组和的个数，偶数子数组和的个数
 *  如果arr[i]为偶数，那么dp[i][0] = dp[i-1][0], dp[i][1] = dp[i-1][1]+1 奇偶奇， 偶偶偶
 *  如果arr[i]为奇数，那么dp[i][0] = dp[i-1][1]+1, dp[i][1] = dp[i-1][0] 奇奇偶， 偶奇奇
 *  由于只需要前一个状态，所以可以优化为两个变量odd, even
 */
public class NumOfSubarraysOdd {
    static final int MOD = (int)1e9+7;
    public int numOfSubarrays(int[] arr) {
        int n = arr.length;
        int odd = 0 ,even = 1;
        int res = 0;
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += arr[i];
            if(sum % 2 == 0){
                res = (res + odd) % MOD;
                even++;
            }else{
                res = (res + even) % MOD;
                odd++;
            }
        }


        return res;
    }
}
