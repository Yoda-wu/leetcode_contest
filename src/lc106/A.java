package lc106;

import java.util.Arrays;

public class A {
    public boolean isFascinating(int n) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(n));
        sb.append(String.valueOf(2*n));
        sb.append(String.valueOf(3*n));
        return check(sb.toString());
    }
    private boolean check(String w){
        char[] ch = w.toCharArray();
        Arrays.sort(ch);
        for(int i = 0; i < ch.length; i++){
            if(ch[i]-'0' != i+1) return false;
        }
        return true;
        
    }
}
