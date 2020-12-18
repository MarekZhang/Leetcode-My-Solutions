# 733. Flood Fill

![733%20Flood%20Fill%20de34c01cf7194fd194ea4b7a38294bc7/Untitled.png](733%20Flood%20Fill%20de34c01cf7194fd194ea4b7a38294bc7/Untitled.png)

### Solution

- edge case: the given `newColor`  is exactly the same as `image[sr][sc]`

```java
class Solution {
    int m, n;
    //time complexity O(MN) || space complexity O (MN)
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int pixVal = image[sr][sc];
        m = image.length;
        n = image[0].length;
        boolean[][] visited = new boolean[m][n];
        
        dfs(image, sr, sc, newColor, visited, pixVal);

        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int newColor, boolean[][] visited, int pixVal) {
        if(!inBoard(sr, sc) || visited[sr][sc] || image[sr][sc] != pixVal ) return;
        image[sr][sc] = newColor;
        visited[sr][sc] = true;
        dfs(image, sr - 1, sc, newColor, visited, pixVal);  
        dfs(image, sr + 1, sc, newColor, visited, pixVal);  
        dfs(image, sr, sc - 1, newColor, visited, pixVal);  
        dfs(image, sr, sc + 1, newColor, visited, pixVal);  
    }

    private boolean inBoard(int sr, int sc) { return sr >= 0 && sr < m && sc >=0 && sc < n; }
}
```