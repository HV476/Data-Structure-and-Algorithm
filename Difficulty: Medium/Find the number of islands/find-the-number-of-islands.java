class Solution {
    public int countIslands(char[][] grid) {
        // Code here
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 'L'){
                    bfs(i , j , grid , n , m);
                    count++;
                }
            }
        }
        return count;
    }
    public void bfs(int sr , int sc , char[][] grid , int n , int m){
        int[] dr = {-1 , -1 , -1 , 0 , 0 , 1 , 1, 1};
        int[] dc = {-1 , 0 , 1 , -1 , 1 , -1 , 0 , 1};
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr , sc});
        grid[sr][sc] = 'A';
        
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            
            for(int i = 0; i < 8; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                
                if(nr >= 0 && nc >= 0 && nr < n && nc < m && grid[nr][nc] == 'L'){
                    grid[nr][nc] = 'A';
                    q.add(new int[]{nr , nc});
                }
            }
            
        }
    }
}











