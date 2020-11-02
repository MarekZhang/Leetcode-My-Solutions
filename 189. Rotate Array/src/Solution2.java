class Solution {
    //time complexity O(N) || space complexity O(1)
    public void rotate(int[] nums, int k) {
        int N = nums.length;
        if(N == 1 || k == 0)
            return;
        reverseArr(nums, 0, N - 1);
        k %= N;
        reverseArr(nums, 0, k - 1);
        reverseArr(nums, k, N - 1);
    }
    
    private void reverseArr(int[] arr, int start, int end){
        while(start < end){
            int tempt = arr[start];
            arr[start++] = arr[end];
            arr[end--] = tempt;
        }
    }
    
}