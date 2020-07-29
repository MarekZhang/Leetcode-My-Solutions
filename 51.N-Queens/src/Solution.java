/**
 * 51. N-Queens
Hard

1943

73

Add to List

Share
The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.



Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

Example:

Input: 4
Output: [
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.
 */

class Solution {
    boolean[] column, dia1, dia2;
    List<List<String>> res;


    public List<List<String>> solveNQueens(int n) {
        column = new boolean[n];
        dia1 = new boolean[2*n-1];
        dia2 = new boolean[2*n-1];
        res = new ArrayList<>();
        
        putQueen(n, 0, new LinkedList<Integer>());

        return res;
    }

    //find a proper position for the index th row
    private void putQueen(int n, int index, LinkedList<Integer> pos){
        if(pos.size() == n){
            addResult(pos, n);
            return;
        }

        for(int i = 0; i < n; i++){
            if(!column[i] && !dia1[i+index] && !dia2[index-i+n-1]){
                column[i] = true;
                dia1[i + index] = true;
                dia2[index - i + n -1] = true;
                pos.addLast(i);
                putQueen(n, index + 1, pos);
                pos.removeLast();
                column[i] = false;
                dia1[i + index] = false;
                dia2[index - i + n -1] = false;
            }
        }
    }

    private void addResult(LinkedList<Integer> row, int n){
        assert row.size() == n;

        ArrayList<String> board = new ArrayList<String>();
        for(int i = 0 ; i < n ; i ++){
            char[] charArray = new char[n];
            Arrays.fill(charArray, '.');
            charArray[row.get(i)] = 'Q';
            board.add(new String(charArray));
        }
        res.add(board);
    }

}