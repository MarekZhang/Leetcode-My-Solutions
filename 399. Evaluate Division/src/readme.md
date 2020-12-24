# 399. Evaluate Division

![399%20Evaluate%20Division%2059d195fa9e054bb0aee1bfd25e48e9db/Untitled.png](399%20Evaluate%20Division%2059d195fa9e054bb0aee1bfd25e48e9db/Untitled.png)

### Solution

- 使用union find, 遍历整个equations将**除数**作为**被除数**的parent，并记录path weight, `find` 会更新被除数的parent为root node，并更新path weight

    ![399%20Evaluate%20Division%2059d195fa9e054bb0aee1bfd25e48e9db/Untitled%201.png](399%20Evaluate%20Division%2059d195fa9e054bb0aee1bfd25e48e9db/Untitled%201.png)

```java
public class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, String> parent = new HashMap<>();
        Map<String, Double> res = new HashMap<>();
        for(int i = 0; i < equations.size(); i++){
            String op1 = equations.get(i).get(0);
            String op2 = equations.get(i).get(1);
            double val = values[i];
            union(op1, op2, val, parent, res);
        }        
        double[] result = new double[queries.size()];
        for(int i = 0; i < queries.size(); i++){
            String op1 = queries.get(i).get(0);
            String op2 = queries.get(i).get(1);
            result[i] = (parent.containsKey(op1) && parent.containsKey(op2) && find(op1, parent, res).equals(find(op2, parent, res))) ? res.get(op1) / res.get(op2) : -1.0 ; 
        }

        return result;
    }

    //find parent
    public String find(String val, Map<String, String> parent, Map<String, Double> res){
        String p = parent.get(val);
        //if p is not the root node
        if(!val.equals(p)){
            String root = find(p, parent, res); 
            res.put(val, res.get(val) * res.get(p));
            parent.put(val, root);
        }

        return parent.get(val);
    }

    //union two values
    private void union(String op1, String op2, double value, Map<String, String> parent, Map<String, Double> res){
        parent.putIfAbsent(op1, op1);
        parent.putIfAbsent(op2, op2);
        res.putIfAbsent(op1, 1.0);
        res.putIfAbsent(op2, 1.0);

        String p1 = find(op1, parent, res);
        String p2 = find(op2, parent, res);
        parent.put(p1, p2);
        res.put(p1, res.get(op2) * value / res.get(op1));
    }
    
}
```