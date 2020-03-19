/*Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

Example 1:

Input: [3,2,1,5,6,4] and k = 2
Output: 5
Example 2:

Input: [3,2,3,1,2,4,5,5,6] and k = 4
Output: 4
Note:
You may assume k is always valid, 1 ≤ k ≤ array's length.
*/

public class Solution{
    public static int findKthLargest(int[] nums, int k) {
        
        int l = 0;
        int r = nums.length - 1;
        int p = 0;
        while( true){
            if (l == r)
                return nums[l];
            int i = l + 1;
            int j = r;
            while(true){
                int v = nums[l];
                while(nums[i] < v && i < r)
                    i++;
                while(nums[j] > v && j > l)
                    j--;
                if(i >= j)
                    break;
                swap(nums, i++, j--);
            }
            swap(nums, l, j);
            p = j + 1; //count from zero

            if(p == k)
                return nums[p];
            else if( p < k)
                l = p + 1;
            else 
                r = p -1;  
        } 

    }

    public static void swap(int[] nums, int i, int j){
        int tempt = nums[i];
        nums[i] =nums[j];
        nums[j] = tempt;
    }
    public static void main(String[] args){
        int[] nums = {3,2,1,5,6,4};
        int k = 6;
        int num = findKthLargest(nums, k);
        System.out.println(num);
    }


}