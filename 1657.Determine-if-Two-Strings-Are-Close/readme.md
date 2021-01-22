# 1657. Determine if Two Strings Are Close

![1657%20Determine%20if%20Two%20Strings%20Are%20Close%20ba56dacedac4461fb63fac148885186d/Untitled.png](1657%20Determine%20if%20Two%20Strings%20Are%20Close%20ba56dacedac4461fb63fac148885186d/Untitled.png)

![1657%20Determine%20if%20Two%20Strings%20Are%20Close%20ba56dacedac4461fb63fac148885186d/Untitled%201.png](1657%20Determine%20if%20Two%20Strings%20Are%20Close%20ba56dacedac4461fb63fac148885186d/Untitled%201.png)

### Solution

- two strings are close if they have same characters and the permutation of character counts

```java
class Solution {
    public boolean closeStrings(String word1, String word2) {
        int N1 = word1.length();        
        int N2 = word2.length();
        if(N1 != N2) return false;
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        for(int i = 0; i < N1; i++){
            cnt1[word1.charAt(i) - 'a']++; 
            cnt2[word2.charAt(i) - 'a']++; 
        }

        int[] pe1 = new int[26];
        int[] pe2 = new int[26];
        
        int idx = 0;
        for(int i = 0; i < 26; i++){
            if(cnt1[i] != 0 || cnt2[i] != 0){
                if(cnt1[i] == 0 || cnt2[i] == 0) return false;
                pe1[i] = cnt1[i];
                pe2[i] = cnt2[i];
                idx++;
            }
        }

        Arrays.sort(pe1);
        Arrays.sort(pe2);

        for(int i = 0; i < 26; i++)
            if(pe1[i] != pe2[i]) return false;

        return true;
    }
}
```