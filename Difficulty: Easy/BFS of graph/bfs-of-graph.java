class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        boolean[] isVisited = new boolean[adj.size()];
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        
        q.add(0);
        isVisited[0] = true;
        
        while(!q.isEmpty()){
             int curr = q.poll();
             res.add(curr);
             for(int i = 0; i < adj.get(curr).size(); i++){
                 int neigh = adj.get(curr).get(i);
                 if(isVisited[neigh] == false){
                     q.add(neigh);
                     isVisited[neigh] = true;
                 }
             }
        }
        return res;
       
    }
}