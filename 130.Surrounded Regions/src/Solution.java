/**
 * 130. Surrounded Regions
Medium

1859

670

Add to List

Share
Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

Example:

X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
Explanation:

Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.
 */

class Solution {
    private boolean[][] visited;
    private int m,n;
    private int[][] posOffset = {{1,0},{0,1},{-1,0},{0,-1}};

    public void solve(char[][] board) {
        m = board.length;
        if(m==0 || m == 1)
            return;
        n = board[0].length;
        List<Pair<Integer,Integer>> coordinates = new ArrayList<>();
        visited = new boolean[m][n];

        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++){
                coordinates.clear();
                if(!visited[i][j]&&board[i][j]=='O')
                    if(bfs(board, i, j, coordinates)){
                        for(int k = 0; k < coordinates.size(); k++)
                            board[coordinates.get(k).getKey()][coordinates.get(k).getValue()] = 'X';
                    }
            }

        return;
    }

    private boolean bfs(char[][]board, int x, int y, List<Pair<Integer, Integer>> coordinates){
        boolean res = true;
        LinkedList<Pair<Integer,Integer>> queue = new LinkedList<>();
        visited[x][y] = true;
        queue.addLast(new Pair<Integer,Integer>(x, y));

        coordinates.add(new Pair<Integer,Integer>(x, y));

        while(!queue.isEmpty()){
            Pair<Integer,Integer> pair = queue.removeFirst();
            int coordinateX = pair.getKey();
            int coordinateY = pair.getValue();

            for(int i = 0; i < 4; i++){
                int newX = coordinateX + posOffset[i][0];
                int newY = coordinateY + posOffset[i][1];

                if(!inBoard(newX, newY))
                    res = false;
                else if(board[newX][newY]=='O'&&!visited[newX][newY]){
                    visited[newX][newY] = true;
                    coordinates.add(new Pair(newX, newY));
                    queue.addLast(new Pair(newX, newY));
                }
            }

        }

        return res;
    }

    private boolean inBoard(int x, int y){
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}