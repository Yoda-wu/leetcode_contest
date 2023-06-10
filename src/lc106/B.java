package lc106;

public class B {
    public int longestSemiRepetitiveSubstring(String s) {
        int max = 0;
        int res = 1;
        int cnt = 1;
        int nxt =0;
        for(int i = 1;i < s.length(); i++){
            if(s.charAt(i) != s.charAt(i-1)) cnt++;
            else if(res == 1 ){
                res--;
                cnt++;
                nxt = i;
            }else {
                max = Math.max(max, cnt);
                cnt = 1;
                res = 1;
                i = nxt;
            }
        }
        return Math.max(cnt, max);
    }
}
