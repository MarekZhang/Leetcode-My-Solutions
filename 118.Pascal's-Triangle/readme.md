# 118. Pascal's Triangle

![118%20Pascal's%20Triangle%209ee9f98e42ca4b5cb8dad7a3e7f13909/Untitled.png](118%20Pascal's%20Triangle%209ee9f98e42ca4b5cb8dad7a3e7f13909/Untitled.png)

### Solution

```java
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < numRows; i++){
            res.add(new ArrayList<>());
            for(int j = 0; j <= i; j++){
                if(j == 0 || j == i){
                    res.get(i).add(1);
                }else{
                    int tempt = res.get(i - 1).get(j - 1) + res.get(i - 1).get(j);
                    res.get(i).add(tempt);
                }
            }
        }
        
        return res;
    }
}
```