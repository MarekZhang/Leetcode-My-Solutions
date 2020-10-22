## leetcode 91. Decode Ways
A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given a non-empty string containing only digits, determine the total number of ways to decode it.

The answer is guaranteed to fit in a 32-bit integer.

 

Example 1:

Input: s = "12"
Output: 2
Explanation: It could be decoded as "AB" (1 2) or "L" (12).
Example 2:

Input: s = "226"
Output: 3
Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
Example 3:

Input: s = "0"
Output: 0
Explanation: There is no character that is mapped to a number starting with '0'. We cannot ignore a zero when we face it while decoding. So, each '0' should be part of "10" --> 'J' or "20" --> 'T'.
Example 4:

Input: s = "1"
Output: 1
 

Constraints:

1 <= s.length <= 100
s contains only digits and may contain leading zero(s).

### Solution
- 使用dynamic programming，考虑当前位的数字str.charAt(i)与i-1位的数字是否能够组成一个介于(10, 26]之间的数值，如果可以的话，当前位的结果应该是memo[i-1] + memo[i-2] (不是memo[i-1] + 1)
- 由于可能需要取memo[i-2]的值，需要一个memo[0]的offset,且 i 对应的值为从1开始的序列值
- 这道题的edge cases全部与0有关
    - “0123” 结果应该是0，所以对于memo[0]的取值要观察首位是否为0
    - “2310” memo[4]的值应该等于memo[2]的值
    - “2301” 结果应该是0，因为0不能mapping到任何字母上,30也不能
    - "23001" 结果应该为0
- 所以我们应该以当前digit得到的数值是否为0，进而分别考虑memo[i]的取值

```java
class Solution {
    //time complexity O(N) || space complexity O(N)
    public int numDecodings(String s) {
        int N = s.length();
        if(s == null || N == 0)
            return 0;
        int[] memo = new int[N + 1];
        // consider if the first character is zero
        memo[0] = s.charAt(0) == '0' ? 0 : 1;
        memo[1] = memo[0];
        for(int i = 2; i <= N; i++){
            String digit1 = s.substring(i - 1, i);
            //two digits number
            String digit2 = s.substring(i - 2, i);
            int val1 = Integer.valueOf(digit1);
            int val2 = Integer.valueOf(digit2);
            if(val1 != 0){
                if(val2 > 10 && val2 <=26)
                    memo[i] = memo[i - 1] + memo[i - 2];
                else
                    memo[i] = memo[i - 1];
            }else{
                //the most significant bit cannot be zero; the value of two bit digits cannot be greater than 20
                if(val2 > 20 || val2 == 0)
                    return 0;
                else
                    memo[i] = memo[i - 2];
            }
        }
        
        return memo[N];
    }
}
```
