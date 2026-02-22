class Solution {
    public int[][] transpose(int[][] matrix) {
        int[][] res = new int[matrix[0].length][matrix.length];
        if(matrix.length == 1 && matrix[0].length == 1){
            return matrix;
        }
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                res[j][i] = matrix[i][j];
            }
        }
        return res;
    }
}