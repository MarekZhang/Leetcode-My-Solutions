public class Solution{
    public static int removeDuplicates(int[] nums) {
        int index = 0;
        for(int i = 0; i < nums.length; i++){
            nums[index++] = nums[i];
            nums[index++] = nums[i+1];
            while(i < nums.length - 1 && nums[i] == nums[i + 1])
                i++;
        }
        return index;
    }

    public static void main(String args[]){
        int[] nums = {0,0,1,1,1,1,2,3,3,4,4,4};
        int p = removeDuplicates(nums);
        System.out.println(p);
        for(int i = 0; i < p; i++){
            System.out.print(nums[i] + ",");
        }
    }
}