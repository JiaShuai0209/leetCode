//数组之间元素的复制
class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int rows = nums.length;
        int cols = nums[0].length;
        int res[][] = new int[r][c];
        if(r*c != rows*cols)
            return nums;
        int x = 0,y = 0;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                    res[x][y] = nums[i][j];
                    y++;
                    if(y == c){
                        x++;
                        y = 0;//之前忘记重置
                    }                        
                }
            }  
        return res;
    }
}
