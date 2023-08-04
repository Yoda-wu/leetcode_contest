package codility;

public class UnPairElement {
    
    public int Solution(int[] A){
        int ans = 0;
        for(int i = 0; i < A.length; i++){
            ans ^= A[i];
        }
        return ans;
    }
}
