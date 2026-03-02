class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        ArrayList<Integer> res = new ArrayList<>();

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    int a = bfs1(i , j , grid);
                    res.add(a);
                }
            }
        }if(res.isEmpty()){
            return 0;
        }
        int max = Collections.max(res);
        return max;
    }
     public int bfs1(int sr , int sc , int[][] grid){
        int[] dr = {-1 , 0 , 1 , 0};
        int[] dc = {0 , 1 , 0 , -1};

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr , sc});
        grid[sr][sc] = -1;
        int count = 1;

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];

            for(int i = 0; i < 4; i++){
                int nr = r + dr[i];
                int  nc = c + dc[i];

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