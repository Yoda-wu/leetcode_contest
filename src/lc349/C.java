package lc349;

public class C{
    public long minCost(int[] nums, int x) {
        long res = Long.MAX_VALUE;
        int n = nums.length;
        long[] sum = new long[n];
        for(int i =0; i <n; i++){
            sum[i] = (long) i*x;
        }
        for(int i = 0 ;i < n ;i++){
            int mn = nums[i];
            for(int j = i ; j < n + i; j++){
                mn = Math.min(mn, nums[j % n]);
                sum[j-i] += mn;
            }
        }
        for(var s  : sum) res = Math.min(s, res);

        return res;
    }
}