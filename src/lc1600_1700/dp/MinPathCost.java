package lc1600_1700.dp;
import java.util.Arrays;
public class MinPathCost {
    int[][] memo;
    public int minPathCost(int[][] grid, int[][] moveCost){
        int m = grid.length;
        int n  = grid[0].length;
        memo = new int[m][n];
        for(int i = 0; i < m ; i++){
            Arrays.fill(memo[i], -1);
        }
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < n ; i++){
            res = Math.min(res, helper(grid, moveCost, 0, i));
        }
        return res ;
    }
    private int helper(int[][] grid, int[][] moveCost, int i, int j) {
        int m  =  grid.length;
        int n  = grid[0].length;
        if(i < 0 || i >= m || j < 0 || j >= n ) return Integer.MAX_VALUE;
        if(memo[i][j] != -1){
            return memo[i][j];
        }
        if(i == m - 1){
            return memo[i][j] = grid[i][j];
        }
        int res = Integer.MAX_VALUE;
        for(int k = 0; k < n; k++){
           
            res = Math.min(res, helper(grid, moveCost, i+1, k) + moveCost[grid[i][j]][k]);
        }
        return memo[i][j] = res + grid[i][j];
    }
}
