//方法一：
class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);//jdk8中自带排序算法
        int result = 0;
        for (int i = 0; i < nums.length; i += 2) {
            result += nums[i];
        }
        return result;
    }
}

//方法二：对每一个元素使用数组下标为元素值相关数值的数组来存储
public class Solution {
	public int arrayPairSum(int[] nums) {
		int[] exist = new int[20001];
		for (int i = 0; i < nums.length; i++) {
			exist[nums[i] + 10000]++;
		}
		int sum = 0;
		boolean odd = true;
		for (int i = 0; i < exist.length; i++) {
			while (exist[i] > 0) {
				if (odd) {
					sum += i - 10000;
				}
				odd = !odd;//隔一位sum加一次
				exist[i]--;
			}
		}
		return sum;
	}
	
}
