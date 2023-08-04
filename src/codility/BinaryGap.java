package codility;

public class BinaryGap {
    private int lowbit(int num){
        return num & (-num);
    
    }
    public int Solution(int num){
        if(num == lowbit(num)) return 0;
        String s = Integer.toBinaryString(num);
        int left = 0;
        int ans = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '1'){
                ans = Math.max(ans, i - left - 1 );
                left = i;
            }
        }

        return ans;
    }
}
