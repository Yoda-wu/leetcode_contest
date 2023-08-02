package lc1600_1700.hash;

public class SubarraysDivByK {
    public int subarraysDivByK(int[] nums, int k){
        int[] cnt = new int[k+1];
        cnt[0] = 1;
        int prefix = 0;
        int ans = 0;
        for(int i = 0; i < nums.length; i++){
            prefix += nums[i];
            int modules = (prefix  % k + k ) % k;
            int same = cnt[modules];
            ans += same;
            cnt[modules]++;
           
        }
        return ans;
    }
}
