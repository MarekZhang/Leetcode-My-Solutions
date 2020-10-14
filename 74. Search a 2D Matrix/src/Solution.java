/**
 * 74. Search a 2D Matrix
Medium

2234

168

Add to List

Share
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
 

Example 1:


Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 3
Output: true
Example 2:


Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 13
Output: false
Example 3:

Input: matrix = [], target = 0
Output: false
 

Constraints:

m == matrix.length
n == matrix[i].length
0 <= m, n <= 100
-104 <= matrix[i][j], target <= 104
 */

class Solution {
    //time complexity O(logm * logn) || space complexity O(1)
    public boolean searchMatrix(int[][] matrix, int target) {
        //traverse vertically find the proper subarray
        if(matrix.length == 0 || matrix[0].length == 0)
            return false;
        int row = matrix.length;
        int col = matrix[0].length;
        int start = 0;
        int end = row * col - 1;
        int mid = 0;
        while(start <= end){
            mid = start + (end - start) / 2;
            if(matrix[mid/col][mid%row] == target)
                return true;
            else if(matrix[mid/col][mid%row] > target)
                end = mid - 1;
            else
                start = mid + 1;
        }

        return false;
    }
}