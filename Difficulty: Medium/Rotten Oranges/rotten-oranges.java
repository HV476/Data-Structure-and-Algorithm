class Solution {
    public int orangesRot(int[][] mat) {
        // code here
        int m = mat.length;
        int n = mat[0].length;
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        boolean[][] visited = new boolean[m][n];
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 2){
                    q.add(new int[]{i , j});
                }
                if(mat[i][j] == 1){
                    fresh++;
                }
            }
        }
        return bfs(q , mat , fresh , visited);
    }
    public int bfs(Queue<int[]> q , int[][] mat , int fresh , boolean[][] visited){
        int[] dr = {-1 , 0 , 1 , 0};
        int[] dc = {0 , 1, 0 , -1};
        
        int min = 0;
        
        while(!q.isEmpty()){
            int size = q.size();
            boolean rotted = false;
            
            for(int i = 0; i < size; i++){
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];
                visited[r][c] = true;
                
                for(int j = 0; j < 4; j++){
                    int nr = r + dr[j];
                    int nc = c + dc[j];
                    
                    if(nr >= 0 && nc >= 0 && nr < mat.length && nc < mat[0].length && mat[nr][nc] == 1 && !visited[nr][nc]){
                        visited[nr][nc] = true;
                        q.add(new int[]{nr , nc});
                        fresh--;
                        rotted = true;
                    }
                }
            }
            if(rotted){
                min++;
            }
        }
        if(fresh == 0){
            return min ;
        }else{
            return -1;
        }
    }
    
}













