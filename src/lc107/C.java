package lc107;

import java.util.Arrays;

public class C {
    public int minimizeConcatenatedLength(String[] words) {
        int n = words.length;
        int[][][] f = new int[n][26][26]; // 前i个字符，开头是j，结尾是k的最小长度
        for(int i = 0; i < n; i++){
            for(int j = 0; j < 26; j++){
                Arrays.fill(f[i][j], Integer.MAX_VALUE/ 2);
            }
        }
        String w = words[0];
        f[0][w.charAt(0) - 'a'][w.charAt(w.length() - 1) - 'a'] =  w.length();
        for(int i = 1; i < n; i++){
            w = words[i];
            int wl = w.charAt(0) - 'a';
            int wr = w.charAt(w.length() - 1) - 'a';
            int len = w.length();
            for(int j = 0; j < 26; j++){ // first  
                for(int k = 0; k < 26; k++){ // tail 
                    if(wl == k) { // join(str_i-1, w)
                        f[i][j][wr] = Math.min(f[i][j][wr], f[i-1][j][k] + len - 1);
                    } else {
                        f[i][j][wr] = Math.min(f[i][j][wr], f[i-1][j][k] + len);
                    }
                    if(wr == j )  {// join(w, str_i-1)
                        f[i][wl][k] = Math.min(f[i][wl][k], f[i-1][j][k] + len - 1);
                    }else {
                        f[i][wl][k] = Math.min(f[i][wl][k], f[i-1][j][k] + len);
                    }
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < 26; i++){
            for(int j = 0 ; j < 26; j++){
                ans = Math.min(ans, f[n-1][i][j]);
            }
        }
        return ans;
    }
}
