# 784. Letter Case Permutation

![784%20Letter%20Case%20Permutation%20107e090ef7b0433191f9edffcb37ee77/Untitled.png](784%20Letter%20Case%20Permutation%20107e090ef7b0433191f9edffcb37ee77/Untitled.png)

### Solution

- time complexity O(2^N) N equals to the number of characters

```java
class Solution {
  public List<String> letterCasePermutation(String S) {
    List<String> res = new ArrayList<>();
    permutate(S, "", 0, res);

    return res;
  }

  private void permutate(String s, String str, int idx, List<String> res){
    if(idx == s.length()){
      res.add(str);
      return;
    }
    char c = s.charAt(idx);
    if(Character.isLetter(c)){
      permutate(s, str + Character.toLowerCase(c), idx + 1, res);
      permutate(s, str + Character.toUpperCase(c), idx + 1, res);
    }else{ // is digit
      str += c;
      permutate(s, str, idx + 1, res);
    }
  }
}
```