package lc1600_1700.dp;

public class MapAnalysis {
    
    // 两次动态规划，从左上到右下
    // f(x,y) = 0 if grid[x][y] == 1
    // f(x,y) = min(f(x-1,y), f(x,y-1)) + 1 if grid[x][y] == 0
    public int maxDistance(int[][] grid){
        int n = grid.length;
        final int INF = 1000000;
        int[][] f = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++) {
                f[i][j] = grid[i][j] == 1 ? 0 : INF;
            }
        }
        for(int i = 0; i < n ;i++){
            for(int j=  0; j < n; j++){
                if(grid[i][j] == 1) continue;
                if(i - 1 >= 0 ) f[i][j] = Math.min(f[i][j], f[i-1][j] + 1);
                if(j - 1 >= 0 ) f[i][j] = Math.min(f[i][j], f[i][j-1] + 1);
            }
        }

        for(int i = n -1;  i>= 0; i --){
            for(int j = n-1;j >= 0; j--){
                if(grid[i][j] == 1) continue;
                if(i + 1 < n ) f[i][j] = Math.min(f[i][j], f[i+1][j] + 1);
                if(j + 1 < n ) f[i][j] = Math.min(f[i][j], f[i][j+1] + 1);
            }
        }
        int ans = -1;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1) continue;
                ans = Math.max(ans, f[i][j]);
            }
        }
        
        return ans == INF ? -1 :ans ;
    }
}
