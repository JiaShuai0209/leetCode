//对于类似这样的题，访问过的元素需要进行记录。

//错误方法
class Solution {
    int[][] grid;
    boolean[][] visit;
    
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        int tmp = 0;
        this.grid = grid;
        visit = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                //错误步骤，结果输出为0，因为area(i,j)跑了两遍，第二遍时答案为0
                if(res < area(i,j))
                    res = area(i,j);
            }
        }
        return res;
    }
    
    public int area(int r, int c){
        if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || visit[r][c] || grid[r][c] == 0)
            return 0;
        visit[r][c] = true;
        return (1 + area(r-1,c) + area(r+1,c) + area(r,c-1) + area(r,c+1));
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
