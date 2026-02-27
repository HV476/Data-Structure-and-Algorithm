class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        for(int i = 0; i < m; i++){
            if(board[i][0] == 'O'){
                bfs(i , 0 , board , m , n);
            }
            if(board[i][n-1] == 'O'){
                bfs(i , n - 1 , board , m , n);
            }
        }
        for(int j = 0 ; j < n; j++){
            if(board[0][j] == 'O'){
                bfs(0 , j , board , m , n);
            }
            if(board[m-1][j] == 'O'){
                bfs(m - 1 , j , board , m , n);
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
               if(board[i][j] == 'H'){
                board[i][j] = 'O';
               }else if(board[i][j] == 'O'){
                board[i][j] = 'X';
               }
            }
        }
    }
    public void bfs(int sr , int sc , char[][] board , int m , int n){
        int[] dr = {-1 , 0 , 1 , 0};
        int[] dc = {0 , 1 , 0 , -1};

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr , sc});
        board[sr][sc] = 'H';

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];

            for(int i = 0; i < 4; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(nr >= 0 && nc >= 0 && nr < m && nc < n && board[nr][nc] == 'O'){
                    board[nr][nc] = 'H';
                    q.add(new int[]{nr , nc});
                }
            }
        }
    }
}