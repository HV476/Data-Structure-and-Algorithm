class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] isVisited = new boolean[rooms.size()];
        q.add(0);
        isVisited[0] = true;

        while(!q.isEmpty()){
            int curr = q.poll();
            for(int i = 0; i < rooms.get(curr).size(); i++){
                int neigh = rooms.get(curr).get(i);
                if(isVisited[neigh] == false){
                    isVisited[neigh] = true;
                    q.add(neigh);
                }
            }
        }
        for(int i = 0; i < rooms.size(); i++){
            if(isVisited[i] == false){
                return false;
            }
        }
        return true;
    }
}