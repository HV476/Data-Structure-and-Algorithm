class Solution {
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++){
            int from = edges[i][0];
            int to = edges[i][1];
            adj.get(from).add(to);
            adj.get(to).add(from);
        }
        
        
        boolean[] isVis = new boolean[V];
        for(int i = 0; i < V; i++){
            if(isVis[i] == false){
                if(bfs(i , isVis , adj)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean bfs(int src , boolean[] isVis , ArrayList<ArrayList<Integer>> adj){
        Queue<int[]> q = new LinkedList<>();
        q.add
        (new int[]{src , -1});
        isVis[src] = true;
        
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int node = curr[0];
            int parent = curr[1];
            for(int i = 0; i < adj.get(node).size(); i++){
                int neigh = adj.get(node).get(i);
                if(isVis[neigh] == false){
                    isVis[neigh] = true;
                    q.add(new int[]{neigh , node});
                }
                else if(neigh != parent){
                    return true;
                }
            }
        }
        return false;
    }
}








