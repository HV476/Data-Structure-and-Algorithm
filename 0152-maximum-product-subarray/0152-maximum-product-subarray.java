class Solution {
    public int maxProduct(int[] nums) {
        int prefix = 1;
        int suffix = 1;
        int max_prefix = Integer.MIN_VALUE;
        int max_suffix = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            if(prefix == 0){
                prefix = 1;
            }
            prefix *= nums[i];
            max_prefix = Math.max(prefix , max_prefix);
        }
        for(int i = nums.length - 1; i >= 0; i--){
            if(suffix == 0){
                suffix = 1;
            }
            suffix *= nums[i];
            max_suffix = Math.max(suffix , max_suffix);
        }
        return Math.max(max_prefix , max_suffix);
    }
}