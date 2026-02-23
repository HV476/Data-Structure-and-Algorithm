class Solution {
    public int maximumPopulation(int[][] logs) {
        int[] year = new int[101];
        for(int i = 0; i < logs.length; i++){
            int birth = logs[i][0] - 1950;
            int death = logs[i][1] - 1950;

            year[birth]++;
            year[death]--;
        }
        int maxp = 0;
        int currp = 0;
        int early_year = 1950;
        for(int  i = 0; i < year.length; i++){
            currp += year[i];
            if(currp > maxp){
                maxp = currp;
                early_year = 1950 + i;
            }
        }
        return early_year;
    }
}