class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for(int i = 0; i < m; i++){
            if(grid[i][0] == 1){
                bfs(i , 0 , grid);
            }
            if(grid[i][n-1] == 1){
                bfs(i , n-1 , grid);
            }
        }
        for(int j = 0; j < n; j++){
            if(grid[0][j] == 1){
                bfs(0 , j , grid);
            }
            if(grid[m-1][j] == 1){
                bfs(m-1 , j , grid);
            }
        }
        int ans = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    ans++;
                }
            }
        }
        return ans;
    }
    public int bfs(int sr , int sc , int[][] grid){
        int[] dr = {-1 , 0 , 1 , 0};
        int[] dc = {0 , 1 , 0 , -1};

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr , sc});
        grid[sr][sc] = -1;
        int count = 0;

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
                    count++;
                } 
            }
        }
        return count;
    }
}