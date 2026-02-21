class Solution {
    public int diagonalSum(int[][] mat) {
        ArrayList<Integer> pd = new ArrayList<>();
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[i].length; j++){
                if(i == j || i+j == mat.length-1){
                    pd.add(mat[i][j]);
                }
            }
        }
        int sum = 0;
        for(int i = 0; i < pd.size(); i++){
            sum += pd.get(i);
        }
        return sum;
    }
}