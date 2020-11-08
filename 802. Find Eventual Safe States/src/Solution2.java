class Solution {
    enum State{UNKNOWN, VISITING, UNSAFE, SAFE}
    //time complexity O(E + V) || space complexity O(V)
    public List<Integer> eventualSafeNodes(int[][] graph) {
        State[] state = new State[graph.length];
        Arrays.fill(state, State.UNKNOWN);
        List<Integer> res = new ArrayList<Integer>();
        
        for(int i = 0; i < graph.length; i++)
            if(state[i] == State.UNKNOWN)
                dfs(i, graph, state);
        
        for(int i = 0; i < state.length; i++)
            if(state[i] == State.SAFE)
                res.add(i);
        
        return res;
    }
    
    private State dfs(int vertex, int[][] graph, State[] state){
        if(state[vertex] == State.VISITING){
            state[vertex] = State.UNSAFE;
            return State.UNSAFE;
        }
        //UNSAFE OR SAFE
        if(state[vertex] != State.UNKNOWN)
            return state[vertex];
        
        state[vertex] = State.VISITING;
        for(int vex : graph[vertex]){
            if(dfs(vex, graph, state) == State.UNSAFE){
                state[vex] = State.UNSAFE;
                return state[vex];
            }
        }
        state[vertex] = State.SAFE;
            
        return state[vertex];
    }
}