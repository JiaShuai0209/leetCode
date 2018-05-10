//第9行，比较当前计数与历史计数，并将大的赋值给max
public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int j = 0;
        
        for (int i = 0; i < nums.length; i++) {
            
            if (nums[i] == 1)
                max = Math.max(++j, max);
            else
                j = 0;
            
        }
        
        return max;
        
    }
    
    //提交代码
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0,temp = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1){
                temp++;
            }
            else{
                if(res < temp)
                    res = temp;
                temp = 0;
            }           
        }
        if(nums[nums.length - 1] != 0){
            if(temp > res)
                res = temp;
        }
        return res;        
    }
}
