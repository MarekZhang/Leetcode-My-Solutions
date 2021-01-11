class Solution {
    //time O(N) || space O(N)
public void merge(int[] nums1, int m, int[] nums2, int n) {
    int M = nums1.length;
    int[] res = new int[M];
    int p1, p2, idx;
    p1 = p2 = idx = 0;
    
    while(idx < M){
        if(p1 == m) res[idx++] = nums2[p2++];
        else if(p2 == n) res[idx++] = nums1[p1++];
        else if(nums1[p1] > nums2[p2]) res[idx++] = nums2[p2++];
        else res[idx++] = nums1[p1++];
    }
    
    for(int i = 0; i < nums1.length; i++) nums1[i] = res[i];
}
}