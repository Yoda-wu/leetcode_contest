package lc349;

import java.security.cert.X509CRL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class C{
    public long minCost(int[] nums, int x) {
        long cost = Arrays.stream(nums).sum();
        int min = Arrays.stream(nums).min().getAsInt();
        int max = Arrays.stream(nums).max().getAsInt(); 
       
        int cnt = 0;
        int n = nums.length;
        int left = n;
        int right = 0;
        if( x > max){return cost ;}
        long init = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] == min){
                left = Math.min(left, i);
                right = Math.max(right, i);
                init += min;
            }
        }
        System.out.println(init);
        int maxMove = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] != min && nums[i] > x ){
                int tmp = i;
                int move = 0;
                while(nums[tmp] != min ){
                    tmp++;
                    move++;
                    if(tmp == n){
                        tmp = 0;
                    }
                    
                }
                maxMove = Math.max(maxMove, move);
            }
        }
        long res = Integer.MAX_VALUE ;
        for(int i = 1; i <= maxMove; i++){
            long temp = init;
            for(int j = 0; j < n; j++){
                if(nums[j] != min){
                    int idx = j;
                    idx = ( idx + i )% n;
                    if(idx == n){
                        idx = 0;
                    }
                    int c = nums[idx];
                    temp  += c;
                    System.out.println(temp);
                }
            }
            // System.out.println();
            temp += x*(i);
            // System.out.println(temp + "cost" + cost);
            // System.out.println(temp);
            
            res = Math.min(temp, Math.min(res,cost));
            // System.out.println(res + "cost" + cost);
        }
        // System.out.println(maxMove);
        // res = res + (long)maxMove * (x + min);
        // System.out.println(res);
        return res;
    }
}