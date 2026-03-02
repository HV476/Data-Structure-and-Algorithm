// User function Template for Java

class Solution {
    public int closedIslands(int[][] matrix, int N, int M) {
        // Code here
        for(int i = 0; i < N; i++){
            if(matrix[i][0] == 1){
                bfs(i , 0 , matrix);
            }
            if(matrix[i][M-1] == 1){
                bfs(i , M-1 , matrix);
            }
        }
        for(int i = 0; i < M; i++){
            if(matrix[0][i] == 1){
                bfs(0 , i , matrix);
            }
            if(matrix[N-1][i] == 1){
                bfs(N-1 , i , matrix);
            }
        }
        int count = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(matrix[i][j] == 1){
                    bfs(i , j , matrix);
                    count++;
                }
            }
        }
        return count;
    }
    public void bfs(int sr , int sc , int[][] matrix){
        int[] dr = {-1 , 0 , 1 , 0};
        int[] dc = {0 , 1 , 0 , -1};
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr , sc});
        matrix[sr][sc] = -1;
        
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            
            for(int i = 0; i < 4; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                
                if(nr >= 0 && nc >= 0 && nr < matrix.length && nc < matrix[0].length && matrix[nr][nc] == 1){
                    matrix[nr][nc] = -1;
                    q.add(new int[]{nr , nc});
                }
            }
        }
    }
}













