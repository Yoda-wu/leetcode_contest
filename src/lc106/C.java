package lc106;

import java.util.Arrays;

public class C {
    final int MOD = 1000000007;

    public int sumDistance(int[] nums, String s, int d) {
        char[] ch = s.toCharArray();
        int[] step = getStep(nums.length, d, ch);
        for (int i = 0; i < nums.length; i++) {
            nums[i] += step[i];
        }
        long ans = 0;
        
        Arrays.sort(nums);
        long[] sum = new long[nums.length + 1];
        sum[0] = 0;
        for(int i = 1; i <= nums.length; i++){
            sum[i] = (sum[i-1] + nums[i-1]) % MOD ;
        }
        
        for(int i = nums.length; i  >= 1; i--){
            ans = (ans + ((long)i * nums[i-1]) % MOD - (sum[i]) % MOD + MOD) % MOD;
        }
        
        return (int)ans;
    }
    private int[] getStep(int n, int d ,char[] dir ){
        int[] step = new int[n];
        step[0] = 1;
        for(int i = 0; i < step.length; i++){
            step[i] = dir[i] == 'R' ? 1*d :  (-1)*d;
        }
        return step;
    }
}
