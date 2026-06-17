class Solution {
    public String longestPalindrome(String s) {
        if(s.length() <= 1){
            return s;
        }

        String maxstr = s.substring(0 , 1);

        for(int i = 0; i < s.length(); i++){
            String even = expandFromCenter(s , i , i+1);
            String odd = expandFromCenter(s , i , i);

            if(odd.length() > maxstr.length()){
                maxstr = odd;
            }
            if(even.length() > maxstr.length()){
                maxstr = even;
            }
        }
        return maxstr;
    }
    private String expandFromCenter(String s , int left , int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return s.substring(left+1 , right);
    }
}