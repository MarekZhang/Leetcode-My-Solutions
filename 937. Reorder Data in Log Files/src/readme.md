## Leetcode 937. Reorder Data in Log Files
>You have an array of logs.  Each log is a space delimited string of words.
>
>For each log, the first word in each log is an alphanumeric identifier.  Then, either:
>
>Each word after the identifier will consist only of lowercase letters, or;
Each word after the identifier will consist only of digits.
We will call these two varieties of logs letter-logs and digit-logs.  It is guaranteed that each log has at least one word after its identifier.
>
>Reorder the logs so that all of the letter-logs come before any digit-log.  The letter-logs are ordered lexicographically ignoring identifier, with the identifier used in case of ties.  The digit-logs should be put in their original order.
>
>Return the final order of the logs.
>
>Example 1:
>
>Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
>Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
>
>Constraints:
>
>0 <= logs.length <= 100
>
>3 <= logs[i].length <= 100
>
>logs[i] is guaranteed to have an identifier, and a word after the identifier.

## Summary

- String 
    - split(String regex) 按照正则切分String为String[], <strong>并且会remove trailing empty string</strong>
    - split(String regex, int limit) 按照regex 最多match limit - 1次
    - compareTo(String str), 因为 String implement Comparable<String> time complexity O(N) N为Max(str1.length(), str2.length());

- Comparator<T>
    - @override public int compare(T t1, T t2);

- Character
    - Character.isDigit(char c) 判断c是否为0～9中的一员

- Arrays
    - Arrays.sort()底层是quickSort， space complexity O(NlogN) || time complexity O(logN) -- 递归调用使用的栈空间

```java
class Solution {
    //time complexity M * N * log(N) || space complexity O(M * logN);
    public String[] reorderLogFiles(String[] logs) {
        //divide logs into two arrays
        Comparator<String> comp = new Comparator<>(){
            @Override
            public int compare(String str1, String str2){
                //["dig1", "8 1 5 1"]
                String[] temptStr1 = str1.split(" ", 2);
                String[] temptStr2 = str2.split(" ", 2);
                
                boolean isDigit1 = Character.isDigit(temptStr1[1].charAt(0));
                boolean isDigit2 = Character.isDigit(temptStr2[1].charAt(0));
                
                if(!isDigit1 && !isDigit2){
                    int res = temptStr1[1].compareTo(temptStr2[1]);
                    if(res != 0)
                        return res;
                    else
                        return temptStr1[0].compareTo(temptStr2[0]);
                }else if(!isDigit1 && isDigit2)
                    return -1;
                else if(isDigit1 && !isDigit2)
                    return 1;
                else
                    return 0;
            }
        };
        Arrays.sort(logs, comp);
        
        return logs;
    }
}
```