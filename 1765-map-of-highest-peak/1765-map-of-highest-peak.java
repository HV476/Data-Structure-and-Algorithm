class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length;
        int n = isWater[0].length;
        Queue<int[]> q = new LinkedList<>();
        int[][] res = new int[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(isWater[i][j] == 1){
                    q.offer(new int[]{i , j});
                    res[i][j] = 0;
                }else{
                    res[i][j] = -1;
                }
            }
        }
        return bfs(q , isWater , res);
    }
    public int[][] bfs(Queue<int[]> q , int[][] isWater , int[][] res){
        int[] dr = {-1 , 0 , 1 , 0};
        int[] dc = {0 , 1 , 0 , -1};

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];

            for(int i = 0; i < 4; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(nr >= 0 && nc >= 0 && nr < isWater.length && nc < isWater[0].length && res[nr][nc] == -1){
                    res[nr][nc] = res[r][c] + 1;
                    q.offer(new int[]{nr , nc});
                }
            }
        }
        return res;
    }
}