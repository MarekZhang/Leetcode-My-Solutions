class Solution {
    public int[] sortedSquares(int[] nums) {
        int N = nums.length;
        int idx = 1;
        int tempt = Math.abs(nums[0]);
        while(idx < N){
            if(nums[idx] >= tempt)  
                break;
            idx++; 
        } 

        int[] aux = Arrays.copyOfRange(nums, 0, idx);
        int i, j, k;
        i = 0;
        j = aux.length - 1;
        k = idx - 1;
        while(i <= j){
            if(Math.abs(aux[i]) < Math.abs(aux[j]))
                nums[k--] = aux[j--]; 
            else
                nums[k--] = aux[i++];
        }

        for(int m = 0; m < nums.length; m++)
            nums[m] = nums[m] * nums[m];

        return nums;
    }
}