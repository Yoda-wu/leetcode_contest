package lc107;

/**
 * 给你三个整数 x ，y 和 z 。
 *  这三个整数表示你有 x 个 "AA" 字符串，y 个 "BB" 字符串，和 z 个 "AB" 字符串。你需要选择这些字符串中的部分字符串（可以全部选择也可以一个都不选择），将它们按顺序连接得到一个新的字符串。新字符串不能包含子字符串 "AAA" 或者 "BBB" 。
 * 请你返回新字符串的最大可能长度。
 * 子字符串 是一个字符串中一段连续 非空 的字符序列。
 */
public class B {
    int[][][][] memo;
    public int longestString(int x, int y, int z) {
        int res = 0;
        memo = new int[x+1][y+1][z+1][3];
        
        res =  Math.max(dfs(x,y,z,0), dfs(x, y, z, 1));
        return res;
    }
    /**
     * AA后面只能接BB
     * BB后面可以接AA或者AB
     * AB后面可以接AA或者BB
     * @param x AA剩余的数量
     * @param y BB剩余的数量
     * @param z AB剩余的数量
     * @param k 0表示上一个字符AA，1表示BB，2表示AB
     */
    private int dfs(int x ,int y, int z ,int k){
        if(memo[x][y][z][k] != 0){
            return memo[x][y][z][k];
        }
        if (k == 0) {
            if(y > 0){
                return dfs(x,y-1,z,1) + 2;
            }
            return 0;
        }
        int r1 = 0, r2 = 0;
        if(x > 0 ){
            r1 = dfs(x-1,y,z,0) + 2;
        }
        if( z > 0){
            r2 = dfs(x,y, z-1, 2) + 2;
        }
        return memo[x][y][z][k] = Math.max(r1, r2);
    }
}
