import java.util.*;

class Solution {
    public static int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> temptMap = new HashMap<>();
        for(int nums: nums1){
            int count = temptMap.getOrDefault(nums, 0);
            temptMap.put(nums, count+1);
        }

        List<Integer> result = new ArrayList<>();
        for(int nums:nums2){
            if(temptMap.containsKey(nums) && temptMap.get(nums) > 0){
                result.add(nums);
                int count = temptMap.get(nums);
                temptMap.put(nums, count-1);
            }
        }
        int index = 0;
        int[] finalResult = new int[result.size()];
        for(Integer nums: result){
            finalResult[index ++] = nums;
        }

        return finalResult;
    }

    public static void main(String args[]){
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        int[] result = intersect(nums1, nums2);

        for(int nums: result){
            System.out.println(nums);
        }
    }
}