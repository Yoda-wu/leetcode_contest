package lc349;

import java.security.cert.X509CRL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class C{
    public long minCost(int[] nums, int x) {
        long res = 0;
        int n = nums.length;
        long[] sum = new long[n+1];
        for(int i =1; i <= n; i++){
            sum[i] = i*x;
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