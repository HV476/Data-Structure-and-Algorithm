// User function Template for Java

class Solution {

    int numberOfEnclaves(int[][] grid) {

        // Your code here
        int n = grid.length;
        int m = grid[0].length;
        
        for(int i = 0; i < m; i++){
            if(grid[0][i] == 1){
                bfs(0 , i , grid);
            }
            if(grid[n-1][i] == 1){
                bfs(n-1 , i , grid);
            }
        }
        for(int i = 0; i < n; i++){
            if(grid[i][0] == 1){
                bfs(i , 0 , grid);
            }
            if(grid[i][m-1] == 1){
                bfs(i , m-1 , grid);
            }
        }
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    count++;
                }
            }
        }
        return count;
    }
    public void bfs(int sr , int sc , int[][] grid){
        int[] dr = {-1 , 0 , 1 , 0};
        int[] dc = {0 , 1 , 0 , -1};
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr , sc});
        grid[sr][sc] = -1;
        
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            
            for(int i = 0; i < 4; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                
                if(nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length && grid[nr][nc] == 1){
                    grid[nr][nc] = -1;
                    q.add(new int[]{nr , nc});
                }
            }
        }
    }
}


















