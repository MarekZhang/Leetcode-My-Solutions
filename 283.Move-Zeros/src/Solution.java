
public class Solution{

    public static void moveZeroes(int[] nums) {
        int i = 0;
        int k = 0;
        for(; i < nums.length; i++){
            if(nums[i] != 0){
                nums[k] = nums[i];
                k ++;
            }
        }
        for(int m = k; m < nums.length; m++){
            nums[m] = 0;
        }
    } 

    // public static void moveZeroes(int[] nums){
    //     int k = 0;
    //     for(int i =0; i < nums.length; i++){
    //         if(nums[i] != 0)
    //             swap(nums, i, k++);
    //     }
    // }

    // private static void swap(int[] arr, int i, int j){
    //     int tempt = arr[i];
    //     arr[i] = arr[j];
    //     arr[j] = tempt;
    // }

    public static void main(String args[]){
        int[] arr = {0, 1, 0, 3, 12};
        moveZeroes(arr);
        for(int i: arr){
            System.out.print(i + ", ");
        }

    }
}
