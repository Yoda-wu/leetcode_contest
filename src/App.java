import lc349.C;

public class App {
    public static void main(String[] args) throws Exception {
        int[] A = {1,2,3,4,1,5};
        int X = 5;
        int cnt = 0;
        int set = (1 << (X+1))  - 1;
        set = set ^ 1;
        System.out.println(Integer.toBinaryString(set));
        for(int i = 0; i < A.length; i++){
            System.out.println(cnt);
            if (((cnt >> A[i]) & 1 ) == 0 ){
                cnt |= 1 << A[i];
            }
            if( cnt == set   ) {
                System.out.println(Integer.toBinaryString(cnt));
                System.out.println(i);
            }
        }
        System.out.println( -1 );
    }

    int solution(int[] A, int X) {
        int N = A.length;
        if (N == 0) {
            return -1;
        }
        int l = 0;
        int r = N ;
        while (l < r) {
            int m = (l + r) / 2;
            if (A[m] > X) {
                r = m - 1;
            } else {
                l = m;
            }
        }
        if (A[l] == X) {
            return l;
        }
        return -1;
    }
    
}
