class Solution {
    public void fill(char[][] grid) {
        // Code here
        int m = grid.length;
        int n = grid[0].length;
        
        for(int i = 0; i < m; i++){
            if(grid[i][0] == 'O'){
                bfs(i , 0 , grid , m , n);
            }
            if(grid[i][n-1] == 'O'){
                bfs(i , n-1 , grid , m , n);
            }
        }
        for(int j = 0; j < n; j++){
            if(grid[0][j] == 'O'){
                bfs(0 , j , grid , m , n);
            }
            if(grid[m-1][j] == 'O'){
                bfs(m-1 , j , grid , m , n);
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 'T'){
                    grid[i][j] = 'O';
                }
                else if(grid[i][j] == 'O'){
                    grid[i][j] = 'X';
                }
            }
        }
    }
    public void bfs(int sr , int sc , char[][] grid , int m , int n){
        if(grid[sr][sc] == 'X'){
            return;
        }
        int[] dr = {-1 , 0 , 1 , 0};
        int[] dc = {0 , 1 , 0 , -1};
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr , sc});
        grid[sr][sc] = 'T';
        
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            
            for(int i = 0; i < 4; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                
                if(nr >= 0 && nc >= 0 && nr < m && nc < n && grid[nr][nc] == 'O'){
                    grid[nr][nc] = 'T';
                    q.add(new int[]{nr , nc});
                }
            }
        }
    }
}
