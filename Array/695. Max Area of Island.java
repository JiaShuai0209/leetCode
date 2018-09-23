//对于类似这样的题，访问过的元素需要进行记录。

//错误方法
class Solution {
    int res = 0,tmp = 0;
    public int maxAreaOfIsland(int[][] grid,int i,int j) {
        return area(grid,0,0);
    }
    public int area(int[][] grid,int i, int j){
        int[][] count = new int[grid.length][grid[0].length];
        
                if(count[i][j] == 0)
                    if(grid[i][j] == 1)
                        tmp++;
                if(i - 1 >= 0)
                    area(grid,i - 1,j);
                if(i + 1 <= grid.length-1)
                    area(grid,i + 1,j);
                if(j - 1 >= 0)
                    area(grid,i,j - 1);
                if(j + 1 <= grid[0].length)
                    area(grid,i,j + 1);
                    
                if(tmp > res)
                    res=tmp;
                tmp = 0; 
                count[i][j] = 1;
      
        return res;
    }
}

//正确解法
class Solution {
    int[][] grid;
    boolean[][] seen;

    public int area(int r, int c) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length ||
                seen[r][c] || grid[r][c] == 0)
            return 0;
        seen[r][c] = true;
        return (1 + area(r+1, c) + area(r-1, c)
                  + area(r, c-1) + area(r, c+1));
    }

    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        seen = new boolean[grid.length][grid[0].length];
        int ans = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                ans = Math.max(ans, area(r, c));
            }
        }
        return ans;
    }
}
