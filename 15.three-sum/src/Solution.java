// Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

// Note:

// The solution set must not contain duplicate triplets.

// Example:

// Given array nums = [-1, 0, 1, 2, -1, -4],

// A solution set is:
// [
//   [-1, 0, 1],
//   [-1, -1, 2]
// ]

import java.util.*;
import java.util.Arrays;

class Solution {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resultList = new LinkedList<>();
        Arrays.sort((nums));
        Set<Integer> set = new TreeSet<>();
        Map<Integer, Integer> intFreq = new HashMap<>();

        for( int i = 0; i < nums.length; i++){
            int count = intFreq.getOrDefault(nums[i], 0);
            intFreq.put(nums[i], count + 1);
            set.add(nums[i]);
        }

        if(intFreq.containsKey(0) && intFreq.get(0) >= 3){
            resultList.add(Arrays.asList(0,0,0));
        }
            

        int[] nums2 = new int[set.size()];
        int index = 0;
        for(int i: set)
            nums2[index++] = i;

        for( int i = 0; i < nums2.length; i++){
            int currentInt = nums2[i];
            for( int j = i + 1; j < nums2.length; j++){
                if(currentInt + 2 * nums2[j] == 0 && intFreq.get(nums2[j]) >= 2){
                    resultList.add(Arrays.asList(currentInt, nums2[j], nums2[j]));
                }else if( currentInt * 2 + nums2[j] == 0 && intFreq.get(currentInt) >= 2){
                    resultList.add(Arrays.asList(currentInt, currentInt, nums2[j]));
                }else{
                    int complement = 0 - currentInt - nums2[j];
                    if(intFreq.containsKey(complement) && complement > nums2[j]){
                        resultList.add(Arrays.asList(currentInt,nums2[j], complement));
                    }
                }
            }
        }
        return resultList;
    }

    public static void main(String[] args){
        int[] nums = {-1, 0, 1, 2, -1, -4};
        threeSum(nums);
    }   
}