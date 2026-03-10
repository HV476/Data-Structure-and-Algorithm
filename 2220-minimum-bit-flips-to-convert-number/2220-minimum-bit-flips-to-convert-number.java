class Solution {
    public int minBitFlips(int start, int goal) {
        String s1 = Integer.toBinaryString(start);
        String s2 = Integer.toBinaryString(goal);

        int count = 0;
        int xor = start ^ goal;
        while(xor > 0){
            count += xor & 1;
            xor /= 2;
        }
        return count;
    }
}