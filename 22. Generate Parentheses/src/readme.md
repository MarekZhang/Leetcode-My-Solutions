# 22. Generate Parentheses

![22%20Generate%20Parentheses%20d617449044e64ba19046702b0cd56eee/Untitled.png](22%20Generate%20Parentheses%20d617449044e64ba19046702b0cd56eee/Untitled.png)

### Solution

- dfs: 1)the first parenthesis should be "(";  2) we can only add ")" when the number of left parenthesis is greater than right parenthesis
- not sure about the time complexity(we have two options whether selecting left parenthesis or right)

```java
class Solution {
    private List<String> res;
    //dfs time O(2^(N)) | space O(N)
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<String>();
        //dfs; number of left parenthesis, number of right parenthesis, idx,         
        dfs(n - 1, n, "(");

        return res;
    }

    private void dfs(int leftNum, int rightNum, String str){
        if(leftNum == 0 && rightNum == 0){
            res.add(str);
            return;
        }

        if(leftNum == 0){
            dfs(leftNum, rightNum - 1, str + ")");
            return;
        }
        dfs(leftNum - 1, rightNum, str + "(");

        if(rightNum > leftNum)
            dfs(leftNum, rightNum - 1, str + ")");

    }
}
```