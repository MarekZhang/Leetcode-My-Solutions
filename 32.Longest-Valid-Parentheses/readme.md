# 32. Longest Valid Parentheses

![Untitled](32%20Longest%20Valid%20Parentheses%206cc67da1ef034c4986782d85cbaf85e9/Untitled.png)

### Caveats

- invalid char could be ‘(’ or ‘)’ e.g. two consecutive ((
- find the indices of those invalid parentheses, and calculate the max length of valid substrings
    
    ![Untitled](32%20Longest%20Valid%20Parentheses%206cc67da1ef034c4986782d85cbaf85e9/Untitled%201.png)
    

```java
class Solution {
    public int longestValidParentheses(String s) {
        int len = s.length();
        if(len == 0) return 0;
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < len; i++) {
            char c = s.charAt(i);
            // store the indices of invalid parenthese
            if(c == ')') {
                if(stack.isEmpty() || s.charAt(stack.peek()) != '(')
                    stack.push(i);
                else 
                    stack.pop();
            }else {
                stack.push(i);
            }
        }
        
        if(stack.isEmpty()) return len;
        
        int start = 0;
        int end = len;
        int res = 0;
        
        while(!stack.isEmpty()){
            start = stack.pop();
            res = Math.max(res, end - start - 1);
            end = start;
        }
        
        res = Math.max(res, end);
     
        return res;
    }
}
```