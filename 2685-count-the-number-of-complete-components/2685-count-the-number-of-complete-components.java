class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++){
            int from = edges[i][0];
            int to = edges[i][1];

            adj.get(from).add(to);
            adj.get(to).add(from);
        }
        boolean[] isVisited = new boolean[n];
        int count = 0;
        for(int i = 0; i < n; i++){
            if(isVisited[i] == false){
                if(bfs(i , isVisited , adj)){
                    count++;
                }
            }
        }
        return count;
    }
    public boolean bfs(int src , boolean[] isVisited , ArrayList<ArrayList<Integer>> adj){
        int nodecount = 0;
        int edgecount = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        isVisited[src] = true;

        while(!q.isEmpty()){
            int curr = q.poll();
            nodecount++;
            edgecount += adj.get(curr).size();

            for(int i = 0; i < adj.get(curr).size(); i++){
                int neigh = adj.get(curr).get(i);
                if(isVisited[neigh] == false){
                    isVisited[neigh] = true;
                    q.add(adj.get(curr).get(i));
                }
            }
        }
        edgecount = edgecount / 2;

        return edgecount == (nodecount * (nodecount - 1)) / 2; 
    }
}