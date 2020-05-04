import java.util.*;

class Solution {
    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> temptSet = new HashSet<>();

        for(int nums: nums1){
            temptSet.add(nums);
        }

        Set<Integer> temptResult = new HashSet<>();

        for(int nums: nums2){
            if(temptSet.contains(nums))
                temptResult.add(nums);
        }

        int[] Result = new int[temptResult.size()];
        int index = 0;
        for(int nums : temptResult)
            Result[index++] = nums;

        return Result;
    }

    public static void main(String args[]){
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};

        int[] result = intersection(nums1, nums2);

        for(int nums: result)
            System.out.println(nums);
    }
}