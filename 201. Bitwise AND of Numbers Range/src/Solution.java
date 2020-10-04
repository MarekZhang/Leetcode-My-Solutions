/**
 * 201. Bitwise AND of Numbers Range
Medium

1137

131

Add to List

Share
Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.

Example 1:

Input: [5,7]
Output: 4
Example 2:

Input: [0,1]
Output: 0
 */

class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int count = 0;
        while(m != 0){
            if(m == n)
                break;
            m >>= 1;
            n >>= 1;
            count ++;
        }

        return m << count;
    }
}