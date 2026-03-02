class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // code here
        int original = image[sr][sc];
        if(original == newColor){
            return image;
        }
        int[] dr = {-1 , 0 , 1 , 0};
        int[] dc = {0 , 1 , 0 , -1};
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr , sc});
        image[sr][sc] = newColor;
        
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            
            for(int i = 0; i < 4; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                
                if(nr >= 0 && nc >= 0 && nr < image.length && nc < image[0].length && image[nr][nc] == original){
                    image[nr][nc] = newColor;
                    q.add(new int[]{nr , nc});
                }
            }
        }
        return image;
    }
}