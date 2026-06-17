class Solution {
    public ArrayList<ArrayList<Integer>> getComponents(int V, int[][] edges) {
        // code here
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
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        boolean[] isVisited = new boolean[V];
        for(int i = 0; i < V; i++){
            if(isVisited[i] == false){
                res.add(bfs(i , isVisited , adj));
            }
        }
        return res;
    }
    public ArrayList<Integer> bfs(int src , boolean[] isVisited , ArrayList<ArrayList<Integer>> adj){
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        isVisited[src] = true;
        ArrayList<Integer> res1 = new ArrayList<>();
        
        while(!q.isEmpty()){
            int curr = q.poll();
            res1.add(curr);
            
            for(int i = 0; i < adj.get(curr).size(); i++){
                int neigh = adj.get(curr).get(i);
                if(isVisited[neigh] == false){
                    isVisited[neigh] = true;
                    
                    q.add(neigh);
                }
            }
        }
        return res1;
    }
}

















