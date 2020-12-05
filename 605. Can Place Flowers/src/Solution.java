class Solution {
    //time complexity O(N) | space complexity O(N)
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int N = flowerbed.length;
        int[] paddingFlowerbed = new int[N + 2];
        paddingFlowerbed[0] = 0;
        paddingFlowerbed[N + 1] = 0;
        for(int i = 0; i < N; i++)
            paddingFlowerbed[i + 1] = flowerbed[i];
        int i = 1;
        int count = 0;
        while(i < N + 1){
            if(paddingFlowerbed[i] == 0 
               && paddingFlowerbed[i - 1] == 0 
               && paddingFlowerbed[i + 1] == 0){
                count++;
                i+=2;
                continue;
            }
            i++;
        }
        
        return count >= n;
    }
}