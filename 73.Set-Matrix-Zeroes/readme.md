# 73. Set Matrix Zeroes

![73%20Set%20Matrix%20Zeroes%20ef36ffe9eba340abb0dcb0b642dbe61e/Untitled.png](73%20Set%20Matrix%20Zeroes%20ef36ffe9eba340abb0dcb0b642dbe61e/Untitled.png)

### Solution

- In place: use the first column and first row to store the information which row should be set as zero

```java
class Solution{
  // time complexity O(MN) || space complexity O(1)
  public void setZeroes(int[][] matrix){
    int row = matrix.length, col = matrix[0].length;
    boolean row0, col0;
    row0 = col0 = false;
    for(int i = 0; i < col; i++){
      if(matrix[0][i] == 0) row0 = true;
    }
    for(int i = 0; i < row; i++){
      if(matrix[i][0] == 0) col0 = true;
    }
		//which columns and rows should be zero
    for(int i = 1; i < row; i++){
      for(int j = 1; j < col; j++){
        if(matrix[i][j] == 0){
          matrix[0][j] = 0;
          matrix[i][0] = 0;
        }
      }
    }
		//set zero
    for(int i = 1; i < row; i++){
      for(int j = 1; j < col; j++){
        if(matrix[0][j] == 0 || matrix[i][0] == 0)
          matrix[i][j] = 0;
      }
    }
    if(row0){
      for(int i = 0; i < col; i++)
        matrix[0][i] = 0;
    }
    if(col0){
      for(int i = 0; i < row; i++)
        matrix[i][0] = 0;
    }

  }
}
```