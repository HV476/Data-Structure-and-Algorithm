class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = num.length - 1; i >= 0; i--){
            num[i] = num[i] + k;
            k = num[i] / 10;
            res.add(num[i] % 10);
        }
        if(k != 0){
            while(k > 0){
                res.add(k % 10);
                k /= 10;
            }
        }
        Collections.reverse(res);
        return res;
    }
}