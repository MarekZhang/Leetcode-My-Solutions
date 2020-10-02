/**
 * 338. Counting Bits
Medium

3084

178

Add to List

Share
Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.

Example 1:

Input: 2
Output: [0,1,1]
Example 2:

Input: 5
Output: [0,1,1,2,1,2]
Follow up:

It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
Space complexity should be O(n).
Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.
 */

class Solution {
    //time complexity O(n * sizeof(int)) || space complexity O (1)
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        if(num == 0)
            return res;

        for(int i = 1; i <= num; i++)
            res[i] = hammingWeight(i);

        return res;
    }

    private int hammingWeight(int n){
        int res = 0;
        while(n != 0){
            res = res + (n & 1);
            n = n >> 1;
        }
        return res;
    }
}