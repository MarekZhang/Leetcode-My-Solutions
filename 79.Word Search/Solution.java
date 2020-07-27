/**
 * 79. Word Search
Medium

3971

192

Add to List

Share
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.
 

Constraints:

board and word consists only of lowercase and uppercase English letters.
1 <= board.length <= 200
1 <= board[i].length <= 200
1 <= word.length <= 10^3
 */

class Solution {
    private boolean[][] visited;
    private int[][] offset = new int[][]{{0,-1},{-1,0},{0,1},{1,0}};
    private int width;
    private int len;


    public boolean exist(char[][] board, String word) {

        width = board.length;
        len = board[0].length;
        visited = new boolean[width][len];
        
        for(int i = 0; i < width; i++)
            for(int j = 0; j < len; j++){
                if(searchWord(board, 0, word, i, j))
                    return true;
            }

        return false;
    }

    private boolean searchWord(char[][] board, int index, String word, int xStart, int yStart){
        if(index == word.length() - 1)
            return board[xStart][yStart] == word.charAt(index);

        if(word.charAt(index) == board[xStart][yStart]){
            visited[xStart][yStart] = true;
            for(int i = 0; i < 4; i++){
                int newX = xStart + offset[i][0];
                int newY = yStart + offset[i][1];
                if(inBoard(newX, newY) && !visited[newX][newY])
                    if(searchWord(board, index+1, word, newX, newY))
                        return true;
            }
            visited[xStart][yStart] = false;
        }

        return false;
    }

    private boolean inBoard(int x, int y){
        if(x >= 0 && y >= 0 && x < len && y < width)
            return true;

        return false;
    }
}