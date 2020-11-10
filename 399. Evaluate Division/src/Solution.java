/**
 * 399. Evaluate Division
Medium

2907

235

Add to List

Share
You are given an array of variable pairs equations and an array of real numbers values, where equations[i] = [Ai, Bi] and values[i] represent the equation Ai / Bi = values[i]. Each Ai or Bi is a string that represents a single variable.

You are also given some queries, where queries[j] = [Cj, Dj] represents the jth query where you must find the answer for Cj / Dj = ?.

Return the answers to all queries. If a single answer cannot be determined, return -1.0.

Note: The input is always valid. You may assume that evaluating the queries will not result in division by zero and that there is no contradiction.

 

Example 1:

Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
Explanation: 
Given: a / b = 2.0, b / c = 3.0
queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
return: [6.0, 0.5, -1.0, 1.0, -1.0 ]
Example 2:

Input: equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
Output: [3.75000,0.40000,5.00000,0.20000]
Example 3:

Input: equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
Output: [0.50000,2.00000,-1.00000,-1.00000]
 

Constraints:

1 <= equations.length <= 20
equations[i].length == 2
1 <= Ai.length, Bi.length <= 5
values.length == equations.length
0.0 < values[i] <= 20.0
1 <= queries.length <= 20
queries[i].length == 2
1 <= Cj.length, Dj.length <= 5
Ai, Bi, Cj, Dj consist of lower case English letters and digits.
 */

class Solution {
    private double[] res;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        //build directed graph  graph[a][b] = a / b;
        for(int i = 0; i < equations.size(); i++){
            String dividend = equations.get(i).get(0), divisor = equations.get(i).get(1);
            Map<String, Double> dividendMap = graph.computeIfAbsent(dividend, (map) -> new HashMap<>());
            dividendMap.put(divisor, values[i]);
            Map<String, Double> divisorMap = graph.computeIfAbsent(divisor, (map) -> new HashMap<>());
            divisorMap.put(dividend, 1 / values[i]);
        }
        
        res = new double[queries.size()];
        Set<String> visited = new HashSet<>();
        
        for(int i = 0; i < queries.size(); i++){
            String dividend = queries.get(i).get(0);
            String divisor = queries.get(i).get(1);
            if(!graph.containsKey(dividend) || !graph.containsKey(divisor))
                res[i] = -1.0;
            else if(dividend == divisor){
                res[i] = 1.0;
            }
            else{
                res[i] = dfs(dividend, divisor, graph, visited, 1.0);
            }
        }
        
        return res;
    }
    
    private double dfs(String dividend, String divisor, Map<String, Map<String, Double>> graph, Set<String> visited, double accProduct){
        
        visited.add(dividend);
        double res = -1.0;
        Map<String, Double> neighbors = graph.get(dividend);
        if(neighbors.containsKey(divisor))
            res = accProduct * neighbors.get(divisor);
        else{
            for(Map.Entry<String, Double> ent : graph.get(dividend).entrySet()){
                if(!visited.contains(ent.getKey())){
                    res =  dfs(ent.getKey(), divisor, graph, visited, accProduct * ent.getValue());
                    if(res != -1)    
                        break;
                }   
            }    
        }
        
        visited.remove(dividend);
        
        return res;
    }
}