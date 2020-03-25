/*
11. Container With Most Water
Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.
Example:

Input: [1,8,6,2,5,4,8,3,7]
Output: 49
*/

public class Solution{
    public static int maxArea(int[] height) {
        if(height.length == 2)
            return height[0] < height[1] ? height[0] : height[1];

        int N = height.length - 1;
        int i = 0;
        int j = N;
        int water = (height[i] < height[j] ? height[i] : height[j]) * N;
        while(true){
            if(height[j] > height[i])
                i++;
            else
                j--;
            if(i >= j)
                break;

            int move_water = quantOfWater(height, i, j);
   
            water = move_water > water ? move_water : water;
        }
        return water;
    }

    private static int quantOfWater(int[] arr, int i, int j){
        int border = arr[i] < arr[j] ? arr[i]: arr[j];
        return border * ( j - i);
    }   

    public static void main(String args[]){
        int[] nums = {1,3,2,5,25,24,5};
        System.out.println(maxArea(nums));
    }
}
