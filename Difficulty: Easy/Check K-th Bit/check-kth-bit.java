class CheckBit {
    static boolean checkKthBit(int n, int k) {
        // code here
        
        String res = "";
        while(n > 0){
            res = (n % 2) + res;
            n = n/2;
        }
        if(k >= res.length()){
            return false;
        }
        int count = 0;
        for(int i = res.length() - 1; i >= 0; i--){
            if(count == k){
                if(res.charAt(i) == '1'){
                    return true;
                }
            }
            count++;
        }
        return false;
    }
}