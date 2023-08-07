package codility;

public class DivideByThree {
    
    /**
     * 给你一个由 N 个数字组成的字符串 S，它代表一个数字。您最多可以将字符串中的一个数字改成其他任何数字。用这种方法可以得到多少个不同的能被 3 整除的数？

写一个函数：

class Solution { public int solution(String S); }

在给定长度为 N 的字符串 S 的情况下，返回一个整数，说明最多改变一位数就能得到多少个能被 3 整除的数。
     example S = 23 
     return 7
     */
    public int solution(String S){
        
        int cnt = 0;
        int sum = 0;
        char[] ss = S.toCharArray();
        for(int i = 0; i < ss.length; i++){
            sum += ss[i] - '0';
            
        }
        if((sum - '0') % 3 == 0)  {

            cnt++;
        }
        for(int i = 0; i < ss.length; i++){
            for(int j = 0; j <= 9; j++){
                int temp = sum;

                int c = ss[i] - '0';
                int diff = j - c;
                if(diff == 0) continue;
                temp += diff;
                if(temp % 3 == 0 ) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
