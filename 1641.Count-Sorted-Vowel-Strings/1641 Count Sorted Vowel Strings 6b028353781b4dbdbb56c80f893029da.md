# 1641. Count Sorted Vowel Strings

![Untitled](1641%20Count%20Sorted%20Vowel%20Strings%206b028353781b4dbdbb56c80f893029da/Untitled.png)

![Untitled](1641%20Count%20Sorted%20Vowel%20Strings%206b028353781b4dbdbb56c80f893029da/Untitled%201.png)

- res[2][3] means we want to find all the combinations with [a,e,i] to build string with length 2
- it equals res[2][2] which means build string of length 2 with [a,e] + res[1][3] which means how many strings of length 1 we can add vowel i to its tail

```java
class Solution {
    //time complexity O(N) || space O(N)
    public int countVowelStrings(int n) {
        int[][] res = new int[n + 1][6];
        for(int i = 1; i <= 5; i++) res[0][i] = 1;
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= 5; j++){
                res[i][j] = res[i - 1][j] + res[i][j - 1];
            }
        }
        
        return res[n][5];
    }
}
```