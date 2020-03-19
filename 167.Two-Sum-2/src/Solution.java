/*
167. Two Sum II - Input array is sorted
Easy

1347

536

Add to List

Share
Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.

Note:

Your returned answers (both index1 and index2) are not zero-based.
You may assume that each input would have exactly one solution and you may not use the same element twice.
Example:

Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
*/

public class Solution{
    public static int[] twoSum(int[] numbers, int target) {
        assert(numbers.length >= 2);
        int[] result = new int[2];
        int i = 0;
        int j = numbers.length - 1;
        while( i < j ){
            if(numbers[i] + numbers[j] == target){
                result[0] = i + 1;
                result[1] = j + 1;
                return result; 
            }else if(numbers[i] + numbers[j] < target)
                i++;
            else // numbers[i] + numbers[j] > target
                j--;
        }
        throw new IllegalArgumentException("Unable to find target values");
    }

    public static void main(String[] args){
        int[] numbers = {2,7,11,15};
        int[] result = twoSum(numbers, 18);
        System.out.println("the length of result is: " + result.length);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }
}