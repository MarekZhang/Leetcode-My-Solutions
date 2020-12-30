# 289. Game of Life

![289%20Game%20of%20Life%20393e223456cf482f821e906764dc7404/Untitled.png](289%20Game%20of%20Life%20393e223456cf482f821e906764dc7404/Untitled.png)

![289%20Game%20of%20Life%20393e223456cf482f821e906764dc7404/Untitled%201.png](289%20Game%20of%20Life%20393e223456cf482f821e906764dc7404/Untitled%201.png)

### Solution

- 对于board[i][j]周围的8个邻居的访问无法优化
- in-place 改变数组中的值使用bitwise operation, 使用2个bit分别代表current generation的状态(0或1), next generation的状态(0或1)。e.g. integer 2的bit level 为10，代表current generation为dead，next generation为live

```java
class Solution {
    private int m, n; 
    private int[][] offset = {{-1,0},{0,-1},{0,1},{1,0},{-1,-1},{1,-1},{1,1},{-1,1}}; 
    //time complexity O(M * N) || space complexity O(1)
    public void gameOfLife(int[][] board) {
        m = board.length;
        n = board[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                //use two bits representing two generations status: (nex)(cur) e.g. 10 means
                //current generation is dead and next generation is live
                int count = getNeighbors(i, j, board);
                if(board[i][j] == 1){
                    if(count < 2 || count > 3) board[i][j] = 1;
                    else if(count >= 2 && count <= 3) board[i][j] = 3;
                }else if(count == 3)//board[i][j] == 0
                    board[i][j] = 2;
                //other situation 00
            }
        }

        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++)  
                board[i][j] >>= 1;

    }

    private int getNeighbors(int i, int j, int[][] board){
        int count = 0;
        for(int k = 0; k < 8; k++){
            int newI = i + offset[k][0];
            int newJ = j + offset[k][1]; 
            if(inBoard(newI, newJ)) count += board[newI][newJ] & 1;
        }

        return count;
    }
 
    private boolean inBoard(int i, int j){ return i >= 0 && i < m && j >= 0 && j < n; }
}
```