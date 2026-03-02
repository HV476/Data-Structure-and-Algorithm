// User function Template for Java

class Solution {
    public int countCoordinates(int[][] mat) {
        // code here
        int n = mat.length;
        int m = mat[0].length;
        
        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];
        
        for(int i = 0; i < n; i++){
            bfs(i , 0 , mat , pacific);
            bfs(i , m-1 , mat , atlantic);
        }
        for(int i = 0; i < m; i++){
            bfs(0 , i , mat , pacific);
            bfs(n-1 , i , mat , atlantic);
        }
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(pacific[i][j] && atlantic[i][j]){
                    count++;
                }
            }
        }
        return count;
    }
    public void bfs(int sr , int sc , int[][] mat , boolean[][] isVisited){
        int[] dr = {-1 , 0 , 1 , 0};
        int[] dc = {0 , 1 , 0 , -1};  
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr , sc});
        isVisited[sr][sc] = true;
        
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            int prev = mat[r][c];
            
            for(int i = 0; i < 4; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                
                if(nr >= 0 && nc >= 0 && nr < mat.length && nc < mat[0].length && mat[nr][nc] >= prev && !isVisited[nr][nc]){
                    isVisited[nr][nc] = true;
                    q.add(new int[]{nr , nc});
                }
            }
        }
    } 
}


















