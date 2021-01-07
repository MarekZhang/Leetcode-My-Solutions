class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid;        
        while(left <= right){
            mid = left + (right - left) / 2;
            if(nums[mid] >=  target) right = mid - 1;
            else left = mid + 1; 
        }
        if(left == nums.length || nums[left] != target) return new int[]{-1, -1}; 
        int pos = left;
        while(pos < nums.length && nums[pos] == nums[left]) pos++;

        return new int[]{left, pos - 1};
    }
}