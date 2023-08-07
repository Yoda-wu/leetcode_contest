package codility;

public class BalanceSlice {
    
    public int solution(int[] A){
        
        int N = A.length;
        if(N <= 2 )return N;
        int cur = 2; 
        int max = 2;
        for(int i = 0; i < N ;i++){
            if(i >= 2 && A[i-1] == A[i] ) cur++;
            else cur=2;

            max = Math.max(max, cur);
        }
        return max;

    }
}
