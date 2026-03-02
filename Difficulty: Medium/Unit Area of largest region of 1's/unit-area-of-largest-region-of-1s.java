class Solution {
    // Function to find unit area of the largest region of 1s.
    public int findMaxArea(int[][] grid) {
        // Code here
        int n = grid.length;
        int m = grid[0].length;
        int maxArea = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    int area = bfs(i , j , grid);
                    maxArea = Math.max(area , maxArea);
                }
            }
        }
        return maxArea;
    }
    public int bfs(int sr , int sc , int[][] grid){
        int[] dr = {-1 , -1 , -1 , 0 , 0 , 1 , 1 , 1};
        int[] dc = {-1 , 0 , 1 , -1 , 1 , -1 , 0 , 1};
        int count = 0;
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr , sc});
        grid[sr][sc] = -1;
        
        while(!q.isEmpty()){
            int[] curr = q.poll();
            count++;
            int r = curr[0];
            int c = curr[1];
            
            for(int i = 0; i < 8; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                
                if(nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length && grid[nr][nc] == 1){
                    grid[nr][nc] = -1;
                    q.add(new int[]{nr , nc});
                }
            }
            
        }
        return count;
    }
}













