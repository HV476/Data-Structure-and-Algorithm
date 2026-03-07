// User function Template for Java
class Solution {
    static String onesComplement(String S, int N) {
        // code here
        StringBuilder sb = new StringBuilder(S);
        for(int i = 0; i < sb.length(); i++){
            if(sb.charAt(i) == '0'){
                sb.setCharAt(i , '1');
            }else{
                sb.setCharAt(i , '0');
            }
        }
        return sb.toString();
    }
}