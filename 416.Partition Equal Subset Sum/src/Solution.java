/**
 * 416. Partition Equal Subset Sum
Medium

2896

73

Add to List

Share
Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.

Note:

Each of the array element will not exceed 100.
The array size will not exceed 200.
 

Example 1:

Input: [1, 5, 11, 5]

Output: true

Explanation: The array can be partitioned as [1, 5, 5] and [11].
 

Example 2:

Input: [1, 2, 3, 5]

Output: false

Explanation: The array cannot be partitioned into equal sum subsets.
 */

class Solution {
    private int[][] memo;
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++)
            sum += nums[i];

        if(sum % 2 != 0)
            return false;
        //-1 代表未计算，0代表可以填充，1代表不可以填充
        memo = new int[nums.length][sum / 2 + 1];
        for(int i = 0; i < nums.length; i++)
            Arrays.fill(memo[i], -1);
        
        return knapSack(nums.length - 1, sum / 2, nums);
        
    }

    private boolean knapSack(int index, int capacity, int[] nums){
        if(capacity == 0)
            return true;
        if(index < 0 || capacity < 0)
            return false;
        if(memo[index][capacity] != -1)
            return memo[index][capacity] == 0;
        memo[index][capacity] = knapSack(index - 1, capacity, nums) || knapSack(index - 1, capacity - nums[index], nums) ? 0 : 1;
        //[0..index]是否能够正好填充一个容量为sum的背包
        return memo[index][capacity] == 0;

    }
}