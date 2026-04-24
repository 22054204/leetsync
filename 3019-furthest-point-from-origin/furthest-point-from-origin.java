class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int L = 0;
        int R = 0;
        int space = 0;
        for(int i=0;i<moves.length();i++){
            char c = moves.charAt(i);
            if(c=='L'){
                L++;
            }else if(c=='R'){
                R++;
            }else{
                space++;
            }
        }
        return Math.abs(L-R)+space;
    }
}