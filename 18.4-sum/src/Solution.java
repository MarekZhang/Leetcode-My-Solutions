// 18. 4Sum
// Medium

// 1680

// 306

// Add to List

// Share
// Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

// Note:

// The solution set must not contain duplicate quadruplets.

// Example:

// Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.

// A solution set is:
// [
//   [-1,  0, 0, 1],
//   [-2, -1, 1, 2],
//   [-2,  0, 0, 2]
// ]

import java.util.*;


class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        //store the count of unique Integer values
        Map<Integer, Integer> intCount = new HashMap<>();
        Set<Integer> uniqueInt = new TreeSet<>();
        for(int i = 0; i < nums.length; i++){
            int count = intCount.getOrDefault(nums[i], 0);
            intCount.put(nums[i], count + 1);
            uniqueInt.add(nums[i]);
        }

        int fourSameInt = target / 4; //有余数也不会保存，所以要把四个数加起来再与target比较一下
        if(intCount.containsKey(fourSameInt) && intCount.get(fourSameInt) >= 4 && fourSameInt * 4 == target)
            result.add(Arrays.asList(fourSameInt, fourSameInt, fourSameInt, fourSameInt));


        List<Integer> uniqueList = new ArrayList<>(uniqueInt);

        for(int i = 0; i < uniqueList.size() - 1; i++){
            int currentInt = uniqueList.get(i);

            for(int j = i + 1; j < uniqueList.size(); j++){

                if(currentInt * 2 + uniqueList.get(j) * 2 == target && intCount.get(currentInt) >= 2 && intCount.get(uniqueList.get(j)) >= 2)
                    result.add(Arrays.asList(currentInt, currentInt, uniqueList.get(j), uniqueList.get(j)));

                if(currentInt + uniqueList.get(j) * 3 == target && intCount.get(uniqueList.get(j)) >= 3)
                    result.add(Arrays.asList(currentInt, uniqueList.get(j), uniqueList.get(j), uniqueList.get(j)));
                
                if(currentInt * 3 + uniqueList.get(j) == target && intCount.get(currentInt) >= 3)
                    result.add(Arrays.asList(currentInt, currentInt, currentInt, uniqueList.get(j)));
                
                for(int k = j+1; k < uniqueList.size(); k++){
                    if(currentInt + uniqueList.get(j) + uniqueList.get(k) * 2 == target && intCount.get(uniqueList.get(k)) >= 2)
                        result.add(Arrays.asList(currentInt, uniqueList.get(j), uniqueList.get(k), uniqueList.get(k)));
                    if(currentInt + uniqueList.get(j) * 2 + uniqueList.get(k) == target && intCount.get(uniqueList.get(j)) >= 2)
                        result.add(Arrays.asList(currentInt, uniqueList.get(j), uniqueList.get(j), uniqueList.get(k)));
                    if(currentInt * 2 + uniqueList.get(j) + uniqueList.get(k) == target && intCount.get(currentInt) >= 2)
                        result.add(Arrays.asList(currentInt,currentInt,uniqueList.get(j),uniqueList.get(k)));

                    int remainingValue = target - currentInt - uniqueList.get(j) - uniqueList.get(k);
                    if(intCount.containsKey(remainingValue) && remainingValue > uniqueList.get(k))
                        result.add(Arrays.asList(currentInt,uniqueList.get(j), uniqueList.get(k), remainingValue));
                }

            }

        }

        return result;
    }
}