package lc1600_1700.dp;

public class MumPartition {
    
    public int minimumPartition(String s, int k) {
        int res = 1;
        int n = s.length();
        long pre = 0;

        for(int i = 0, j = 0; i < n; i++){
            int v = s.charAt(i) - '0';
            if(v > k )return -1;
            pre = pre * 10 + v;
            if(pre > k){
                res++;
                pre = v;
            }
        }
        return res;
    }
}
