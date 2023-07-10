package lc1600_1700.dp;

public class PushDominoes {
    public String pushDominoes(String dominoes) {
        char[] s = dominoes.toCharArray();
        int n = s.length, i = 0;
        char left = 'L';
        while(i < n ){
            int j = i;
            while(j < n && s[j] == '.') {
                j++;
            }
            char right = j < n ? s[j] : 'R';
            if(left == right ) {// L......L
                                // R......R
                while(i < j ){
                    s[i++] = right;
                }    
            }   else if( left == 'R' && right == 'L') {
                // R......L 中间靠
                int k = j - 1;
                while(i < k){
                    s[i++] = 'R';
                    s[k--] = 'L';
                }
                // L......R 无变化
            }
            left = right;
            i = j + 1;
        }
        return new String(s);
    }
}
