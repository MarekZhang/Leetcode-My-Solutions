/*Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note: You are not suppose to use the library's sort function for this problem.

Example:

Input: [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
*/


public class Solution{

    public static void  sortColors(int[] nums) {
        //arr[0...zero] = 0  arr[zero+1...two-1] = 1  arr[two...l] = 2
        int zero = -1;
        int two = nums.length; // out of the bound of array
        
        for(int i = 0; i < two;){//no additional i++ needed in the for loop
            if(nums[i] == 1)
                i++;
            else if(nums[i] == 2){
                swap(nums,i ,--two);
            }else{//nums[i] == 0
                swap(nums, ++zero, i++);
            }
        }        
    }
    
    public static void swap(int[] arr, int i, int j){
        int tempt = arr[i];
        arr[i] = arr[j];
        arr[j] = tempt;
    }

    public static void main(String args[]){
        int[] arr = {2, 0, 2, 1, 1, 0};
        sortColors(arr);

        for( int i: arr){
            System.out.print( i + ", ");
        }
    }
}