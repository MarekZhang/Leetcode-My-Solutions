class Solution {
    public int findKthPositive(int[] arr, int k) {
        int N = arr.length; 
        int offset = arr[N - 1] - N;
        if(offset < k) return arr[N - 1] + offset - k;

        int pos = binarySearch(arr, k);

        return arr[mid] - (arr[mid] - mid - 1 - k + 1);
    }

    private int binarySearch(int[] arr, int k) {
        int left, right, mid;
        right = arr.length - 1;
        left = 0;
        while(left <= right){
            mid = left + (right - left) / 2;
            int offset = arr[mid] - mid - 1;
            if(offse < k) left = mid + 1;
            else if(offset > k) right = mid;
            else return mid;
        }
        return mid;
    }
}