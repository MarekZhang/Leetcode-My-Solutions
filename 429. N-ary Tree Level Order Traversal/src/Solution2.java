class Solution {
    //time complexity O(N) | space complexity O(H) -- stack space
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, 0, res);
        return res;
    }
    
    private void dfs(Node node, int level, List<List<Integer>> res){
        if(node == null)
            return;
        if(level == res.size())
            res.add(new ArrayList<>());
        res.get(level).add(node.val);
        for(Node child : node.children)
            dfs(child, level + 1, res);
    }
}