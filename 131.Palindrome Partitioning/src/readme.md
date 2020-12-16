# 131. Palindrome Partitioning

![131%20Palindrome%20Partitioning%20f4e5bf76e7af4329bc2c0c96197c8569/Screenshot_2020-12-16_at_19.02.15.png](131%20Palindrome%20Partitioning%20f4e5bf76e7af4329bc2c0c96197c8569/Screenshot_2020-12-16_at_19.02.15.png)

### Solution

- Back Tracking, 每一步分解字符串可以包含一个char, 两个char，.... N 个char(N ≤ str.leng())
- time complexity: 对于一个length为n的string，共有n-1个interval，对于每一个interval，我们可以选择partition it or not,这样共有$2^{N- 1}$ 种partition，所以时间复杂度为$O(2^N)$ ; isPalindrome()的操作time complexity 为$O(N)$, 所以算法的总时间复杂度为$O(N * 2 ^ N)$

![131%20Palindrome%20Partitioning%20f4e5bf76e7af4329bc2c0c96197c8569/IMG_1369BD292006-1.jpeg](131%20Palindrome%20Partitioning%20f4e5bf76e7af4329bc2c0c96197c8569/IMG_1369BD292006-1.jpeg)

```java
class Solution {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> partition(String s) {
        
        if(s == null || s.length() == 0) return res;
        
        LinkedList<String> list = new LinkedList<>();
        findPalindrome(s, 0, s.length() - 1, list);

        return res;
    }

    private void findPalindrome(String s, int start, int end, LinkedList<String> temptRes){
        if(start > end && !temptRes.isEmpty()){
            res.add(new ArrayList<String>(temptRes));
            return;
        }
            
        for(int i = start; i <= end; i++){
            if(isPalindrome(s, start, i)){
                temptRes.addLast(s.substring(start, i + 1));
                findPalindrome(s, i + 1, end, temptRes);
                temptRes.removeLast();
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end){
        if(start == end) return true;

        while(start < end){
            if(s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }
}
```