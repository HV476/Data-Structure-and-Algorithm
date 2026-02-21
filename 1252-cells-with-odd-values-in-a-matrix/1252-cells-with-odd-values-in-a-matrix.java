class Solution {
    public int oddCells(int m, int n, int[][] indices) {
       int count = 0;
       int[][] matrix = new int[m][n];
       
    //    for(int i = 0; i < indices.length; i++){
        for(int[] idx : indices){
        int row = idx[0];
        int col = idx[1];
        for(int j = 0; j < n; j++){
            matrix[row][j]++;
        }
        for(int k = 0; k < m; k++){
            matrix[k][col]++;
        }
       }
       for(int i = 0; i < matrix.length; i++){
        for(int j = 0; j < matrix[i].length; j++){
            if(matrix[i][j] % 2 != 0){
                count++;
            }
        }
       }
       return count;
    }
}