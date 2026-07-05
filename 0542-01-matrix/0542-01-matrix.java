class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        Queue<int[]> q = new LinkedList<>();
        int[][] res = new int[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 0){
                    q.add(new int[]{i , j});
                }else{
                    res[i][j] = -1;
                }
            }
        }
        bfs(mat , q , res);
        return res;
    }
    public void bfs(int[][] mat , Queue<int[]> q , int[][] res){
        int[] dr = {-1 , 0 , 1 , 0};
        int[] dc = {0 , 1 , 0 , -1};

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];

            for(int i = 0; i < 4; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(nr >= 0 && nc >= 0 && nr < mat.length && nc < mat[0].length && res[nr][nc] == -1){
                    res[nr][nc] = res[r][c] + 1;
                    q.add(new int[]{nr , nc});
                }
            } 
        }
    }
}