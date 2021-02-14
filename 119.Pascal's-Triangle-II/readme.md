# 119. Pascal's Triangle II

![119%20Pascal's%20Triangle%20II%208481823baae8491eb00773df79d346a1/Untitled.png](119%20Pascal's%20Triangle%20II%208481823baae8491eb00773df79d346a1/Untitled.png)

### Solution

- use two List

```java
class Solution {
  public List<Integer> getRow(int rowIndex) {
    if(rowIndex == 0){
      List<Integer> res = new ArrayList<>();
      res.add(1);
      return res;
    }
    List<Integer> list0 = new ArrayList<>();
    List<Integer> list1 = new ArrayList<>();
    list0.add(1);
    list0.add(1);
    for(int i = 2; i <= rowIndex; i++){
      if(i % 2 == 0){
        list1 = new ArrayList<>();
        generateRow(list0, list1);
      }else{
        list0 = new ArrayList<>();
        generateRow(list1, list0);
      }
    }
    return rowIndex % 2 == 0 ? list1 : list0;
  }

  private void generateRow(List<Integer> provider, List<Integer> consumer){
    int sz = provider.size();
    for(int j = 0; j <= sz; j++){
      if(j == 0 || j == sz) consumer.add(1);
      else consumer.add(provider.get(j - 1) + provider.get(j));
    }
  }
}
```