# 841. Keys and Rooms

![841%20Keys%20and%20Rooms%20a99d9b60d5854f63840119e7f80c562e/Untitled.png](841%20Keys%20and%20Rooms%20a99d9b60d5854f63840119e7f80c562e/Untitled.png)

### Solution

- dfs

```java
class Solution {
    //time complexity O(E + V) | space complexity O(V) stack space
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int N = rooms.size();
        boolean[] visited = new boolean[N];
        
        dfs(rooms, 0, visited);
        
        for(int i = 0; i < visited.length; i++)
            if(!visited[i]) return false;
        
        return true;
    }
    
    private void dfs(List<List<Integer>> rooms, int room, boolean[] visited){
        visited[room] = true;
        
        for(Integer rm : rooms.get(room))
            if(!visited[rm])
                dfs(rooms, rm, visited);
    }
}
```

- bfs

```java

class Solution {
		//bfs time complexity O(E+V) || space complexity O(E + V)
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if(rooms.size() == 1)
            return true;
        boolean[] visited = new boolean[rooms.size()];
        LinkedList<Integer> queue = new LinkedList<>();
        visited[0] = true;
        queue.addLast(0);
        while(!queue.isEmpty()){
            Integer room = queue.poll();
            for(int key : rooms.get(room)){
                if(!visited[key]){
                    visited[key] = true;
                    queue.addLast(key);
                }
            }
        }
        for(boolean b : visited)
            if(b == false)
                return false;
        
        return true;
    }
}
```