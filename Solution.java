class Solution {
    //time complexity O(N * M) || space complexity O(M * N)
    public int numBusesToDestination(int[][] routes, int S, int T) {
        boolean[] buses = new boolean[routes.length];        
        //stop : bus list
        Map<Integer, ArrayList<Integer>> graph = new HashMap<>();
        int count = 0; 
        for(int i = 0; i < routes.length; i++) {
            for(int j = 0; j < routes[i].length; j++){
                int stop = routes[i][j];
                graph.putIfAbsent(stop, new ArrayList<>());
                graph.get(stop).add(i);
                count++;
            }
        }
        boolean[] stops = new boolean[count];

        LinkedList<int[]> queue = new LinkedList<>();
        queue.addLast(new int[]{S, 0});
        //每次入队列当前stop所在bus的所有stop
        while(!queue.isEmpty()){
            int[] pair = queue.removeFirst();
            int s = pair[0];
            if(s == T) return pair[1];
            for(int bus : graph.get(s)){
                if(!buses[bus]){
                    buses[bus] = true;
                    for(int stop : routes[bus]){
                        if(!stops[stop]){
                            stops[stop] = true;
                            queue.addLast(new int[]{stop, pair[1] + 1});
                        }
                    }
                }
            }
        }

        return -1;
    }
}