class Solution {
    public int maxDistance(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    q.offer(new int[]{i, j});
                }
            }
        }

        if(q.isEmpty() || q.size() == m * n){
            return -1;
        }

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        int distance = -1;

        while(!q.isEmpty()){
            int size = q.size();
            distance++;

            for(int i = 0; i < size; i++){
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];

                for(int d = 0; d < 4; d++){
                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    if(nr >= 0 && nc >= 0 && nr < m && nc < n && grid[nr][nc] == 0){
                        grid[nr][nc] = 1;
                        q.offer(new int[]{nr, nc});
                    }
                }
            }
        }

        return distance;
    }
}