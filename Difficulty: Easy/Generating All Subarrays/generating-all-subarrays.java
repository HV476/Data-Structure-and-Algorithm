class Solution {
    public List<List<Integer>> getSubArrays(int[] arr) {
        // code here
        List<List<Integer>> res = new ArrayList<>();
        int n = arr.length;
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                ArrayList<Integer> sub = new ArrayList<>();
                for(int k = i; k <= j; k++){
                    sub.add(arr[k]);
                }
                res.add(sub);
            }
        }
        return res;
    }
}