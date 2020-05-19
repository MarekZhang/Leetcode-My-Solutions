//Sorting with two pointers 
//Time complexity O(nlogn) -- sorting   O(n^2)--two pointers


import java.util.*;

public class Solution{
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];
        int div = result - target;
        

        for(int i = 0; i < nums.length - 2;i++){
            int diff = target - nums[i];
            int l = i + 1;
            int r = nums.length - 1;

            while( l < r){
                if(nums[l] + nums[r] == diff){
                    result = nums[i] + nums[l] + nums[r];
                    return result;
                }else if(Math.abs(nums[l] + nums[r] - diff) < Math.abs(div)){
                    result = nums[i] + nums[l] + nums[r];
                    div = result - target;
                }
                
                if(nums[l] + nums[r] > diff)
                    r--;
                else
                    l++;
            }
        }

        return result;
    }

    public static void main(String args[]){
        int[] nums = {0, 2, 1, -3};
        int target = 1;
        System.out.println();
        System.out.println(threeSumClosest(nums, 1));
    }

}