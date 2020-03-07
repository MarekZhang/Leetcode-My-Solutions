// Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length.

// Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

// Example 1:

// Given nums = [1,1,1,2,2,3],

// Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.

// It doesn't matter what you leave beyond the returned length.


/**Solution:
Create three index: i: retrival the whole array; 
                    index:position of storing values; 
                    newIndex:position of next un-duplicate value
*/
public class Solution{
    public static int removeDuplicates(int[] nums) {
        int i = 0;
        int index = 0;
        int newIndex = 0;
        while( i < nums.length){
            newIndex = findIndex(nums, i);
            if( newIndex - i == 1){
                nums[index++] = nums[i];
            }else{
                nums[index++] = nums[i];
                nums[index++] = nums[i+1];
            }
            i = newIndex;
        }

        return index;
    }

    private static int findIndex(int[] arr, int i){
        while(i < arr.length - 1 && arr[i] == arr[i + 1]){
            i++;
        }
        return i + 1;
    }

    public static void main(String args[]){
        int[] nums = {0,0,1,1,1,1,2,3,3,4,4,4, 5,5,6,7,7,7,7};
        int p = removeDuplicates(nums);
        System.out.println(p);
        for(int i = 0; i < p; i++){
            System.out.print(nums[i] + ",");
        }
    }
}