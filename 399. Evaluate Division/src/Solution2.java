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
            result[i] = (parent.containsKey(op1) && parent.containsKey(op2) && find(op1).equals(find(op2))) ? res.get(op1) / res.get(op2) : -1.0 ; 
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
    
        String p1 = parent.get(op1);
        String p2 = parent.get(op2);
        parent.put(p1, p2);
        res.put(p2, res.get(p2) * value / res.get(p1));
    }
    
}class Solution2 {
    
}
