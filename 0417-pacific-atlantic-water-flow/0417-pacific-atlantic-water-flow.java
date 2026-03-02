class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        for(int i = 0; i < m; i++){
            bfs(i , 0 , heights , pacific);
            bfs(i , n-1 , heights ,atlantic);
        }
        for(int j = 0; j < n; j++){
            bfs(0 , j , heights , pacific);
            bfs(m-1 , j , heights , atlantic);
        }
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(pacific[i][j] && atlantic[i][j]){
                    res.add(Arrays.asList(i , j));
                }
            }
        }
        return res;
    }
    public void bfs(int sr , int sc , int[][] heights , boolean[][] isVisited ){
        int[] dr = {-1 , 0 , 1 , 0};
        int[] dc = {0, 1 , 0 , -1};

        Queue<int[]> q  = new LinkedList<>();
        if(isVisited[sr][sc]) return;

        q.add(new int[]{sr , sc});
        isVisited[sr][sc] = true; 

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            int prev = heights[r][c];

            for(int i = 0; i < 4; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(nr >= 0 && nc >= 0 && nr < heights.length && nc < heights[0].length && heights[nr][nc] >= prev &&!isVisited[nr][nc]){
                    isVisited[nr][nc] = true;
                    q.add(new int[]{nr , nc});
                }
            }
        }
    }
}