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
    
}
