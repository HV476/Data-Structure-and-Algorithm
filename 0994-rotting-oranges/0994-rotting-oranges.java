class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0;
        Queue<int[]> q = new LinkedList<>();


        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 2){
                    q.offer(new int[]{i , j});
                }
                if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }
        int res = bfs(grid , q , fresh);
        return res;
    }
    public int bfs( int[][] grid , Queue<int[]> q , int fresh){
        int[] dr = {-1 , 0 , 1 , 0};
        int[] dc = {0 , 1 , 0 , -1};
        int countmin = 0;

        while(!q.isEmpty()){
            int size = q.size();
            boolean rotted = false;

            for(int j = 0; j < size; j++){
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];

                for(int i = 0; i < 4; i++){
                    int nr = r + dr[i];
                    int nc = c + dc[i];

                    if(nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length && grid[nr][nc] == 1){
                        grid[nr][nc] = 2;
                        fresh--;
                        q.add(new int[]{nr , nc});
                        rotted = true;

                    }
                }
            }
            if(rotted == true){
                countmin++;
            }
        }
        if(fresh == 0){
            return countmin;
        }else{
            return -1;
        }
    }
}