/* 215. Kth Largest Element in an Array
Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

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
        if(nums.length == 1)
            return nums[0];
        int l = 0;
        int r = nums.length - 1;
        int p = partition(nums, l, r);
        int N = nums.length;

        while( p != N - k){
            if( p < N - k)
                l = p + 1;
            else if( p > N - k)
                r = p - 1;
            p = partition(nums, l, r);
        }

        return nums[p];
    }

    public static int partition(int[] nums, int l, int r){
        int v = nums[l];
        int i = l + 1;
        int j = r;
        while(true){
            while(i <= r && nums[i] < v)
                i++;
            while(j > l && nums[j] > v)
                j--;
            if( i >= j)
                break;
            swap(nums, i++, j--);    
        }
        swap(nums, l, j);//j已经-1了 此时就是partition应该返回的位置

        return j;

    }

    public static void swap(int[] nums, int i, int j){
        int tempt = nums[i];
        nums[i] =nums[j];
        nums[j] = tempt;
    }
    public static void main(String[] args){
        int[] nums = {3,2,1,5,6,4,1,1};
        int k = 7;
        int num = findKthLargest(nums, k);
        System.out.println(num);
    }


}