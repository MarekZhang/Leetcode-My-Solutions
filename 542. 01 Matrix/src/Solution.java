/**
 * 542. 01 Matrix
Medium

1791

114

Add to List

Share
Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.

The distance between two adjacent cells is 1.

 

Example 1:

Input:
[[0,0,0],
 [0,1,0],
 [0,0,0]]

Output:
[[0,0,0],
 [0,1,0],
 [0,0,0]]
Example 2:

Input:
[[0,0,0],
 [0,1,0],
 [1,1,1]]

Output:
[[0,0,0],
 [0,1,0],
 [1,2,1]]
 

Note:

The number of elements of the given matrix will not exceed 10,000.
There are at least one 0 in the given matrix.
The cells are adjacent in only four directions: up, down, left and right.
 */

class Solution {
    int[][] dist;
    int[][] posOffset = {{1,0},{0,1},{-1,0},{0,-1}};
    int m, n;

    public int[][] updateMatrix(int[][] matrix) {
        m = matrix.length;
        if(m == 0)
            return dist;
        n = matrix[0].length;
        dist = new int[m][n];
        for(int i = 0; i < m; i++)
            Arrays.fill(dist[i], Integer.MAX_VALUE);

        LinkedList<Pair<Integer, Integer>> queue = new LinkedList<>();
        //add all 0 position into the queue and set the dist value as 0
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0){
                    dist[i][j] = 0;
                    queue.addLast(new Pair<Integer, Integer>(i, j));
                }
            }

        while(!queue.isEmpty()){
            Pair<Integer, Integer> pos = queue.removeFirst();
            int posX = pos.getKey();
            int posY = pos.getValue();
            for(int i = 0; i < 4; i++){
                int newX = posX + posOffset[i][0];
                int newY = posY + posOffset[i][1];
                if(inBoard(newX, newY) && dist[newX][newY] > dist[posX][posY] + 1){
                    dist[newX][newY] = dist[posX][posY] + 1;
                    queue.addLast(new Pair<Integer, Integer>(newX, newY));
                }
            }
        }

        return dist;
    }
    private boolean inBoard(int x, int y){
        return x >= 0 && x < m && y >=0 && y < n; 
    }

}