# 48. Rotate Image

![48%20Rotate%20Image%2017d801722a2e409881b2afbc448ed6ab/Untitled.png](48%20Rotate%20Image%2017d801722a2e409881b2afbc448ed6ab/Untitled.png)

![48%20Rotate%20Image%2017d801722a2e409881b2afbc448ed6ab/Untitled%201.png](48%20Rotate%20Image%2017d801722a2e409881b2afbc448ed6ab/Untitled%201.png)

### Solution

- 有两种方法，第一种以anti-clockwise的方向`matrix[i][j] = matrix[N - j][i];` 交换三次，元素就都在正确位置了，但是这种方法如果答OA很容易出错
- 第二种方法现按照reverse diagonal方向swap元素，再以middle row为轴做swap
- follow up: reverse in anti-clock direction by 90 degree: 1) swap around digonal; 2)swap around the middle row

    ![48%20Rotate%20Image%2017d801722a2e409881b2afbc448ed6ab/IMG_ACDA38122142-1.jpeg](48%20Rotate%20Image%2017d801722a2e409881b2afbc448ed6ab/IMG_ACDA38122142-1.jpeg)

    ```java
    class Solution {
    		//time complexity O(N^2) || space complexity O(1)
        public void rotate(int[][] matrix) {
            int N = matrix.length - 1;
            //swap around the reverse diagonal
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N - i; j++)
                    swap(matrix, i, j, N - j, N - i);
            }
            //swap around the middle row
            for(int i = 0; i < (N + 1) / 2; i++)
                for(int j = 0; j <= N; j++)
                    swap(matrix, i, j, N - i, j);
        }

        private void swap(int[][] matrix, int i, int j, int x, int y) {
            int tempt = matrix[i][j];
            matrix[i][j] = matrix[x][y];
            matrix[x][y] = tempt;
        }
    }
    ```

    ```java
    class Solution {
      //time complexity O(N^2) || space O(1)
      public void rotate(int[][] matrix) {
        int N = matrix.length - 1;
        int start = 0, bound = N - 1, y = 0;
        while(start <= bound){
          for(int x = start; x <= bound; x++){
            //anti clockwise swap (x,y) with (N - y, x) three times
            int count = 3;
            int i = x, j = y;
            while(--count >= 0){
              int tempt = matrix[i][j];
              matrix[i][j] = matrix[N - j][i];
              matrix[N - j][i] = tempt;
              int temptI = i;
              i = N - j;
              j = temptI;
            }
          }
          start ++;
          bound --;
          y++;
        }
      }
    }
    ```
    ```java
    class Solution{
       public void rotate(int[][] matrix){
         // swap around the diagonal
         int N = matrix.length;
         for(int i = 0; i < N; i++){
           for(int j = 0; j < i; j++){
             swap(matrix, i, j, j, i);
           }
         }

         // swap around the middle row
         for(int i = 0; i < N / 2; i++){
           for(int j = 0; j < N; j++){
             swap(matrix, i, j, N - 1 - i, j);
           }
         }

       }

       private void swap(int[][] matrix, int i, int j, int x, int y){
         int tempt = matrix[i][j];
         matrix[i][j] = matrix[x][y];
         matrix[x][y] = tempt;
       }
    }     
    ```
