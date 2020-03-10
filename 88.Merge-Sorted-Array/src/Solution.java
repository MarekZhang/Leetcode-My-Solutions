/*
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:

The number of elements initialized in nums1 and nums2 are m and n respectively.
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
Example:

Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6]
 */
import java.util.*;
//same as merge Sort
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n == 0)
            return;
        if(m == 0){
            for(int i = 0; i < nums1.length; i++)
                nums1[i] = nums2[i];
            return;
        }
            
        //if the smallest value in nums2 is greater than the biggest value in nums1
        for(int i = m; i < m + n;i++)
                nums1[i] = nums2[i-m];
        if(nums1[m-1] < nums2[0])
            return;
        else{
            int i = 0;
            int j = m;
            int[] tempt = Arrays.copyOfRange(nums1, 0, n+m);
            for(int k = 0; k < m + n; k++){
                if(i > m -1){
                    nums1[k] = tempt[j];
                    j++;    
                }
                else if( j > m + n -1){
                    nums1[k] = tempt[i];
                    i++;
                }
                else if(tempt[i] < tempt[j]){
                    nums1[k] = tempt[i];
                    i++;
                }else{
                    nums1[k] = tempt[j];
                    j++;
                }
            }
        }
    }
}