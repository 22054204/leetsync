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
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<moves.length();i++){
            char c = moves.charAt(i);
            if(c=='L'){
                sb.append(c);
            }else if(c=='R'){
                sb.append(c);
            }else{
                if(L>=R){
                    sb.append('L');
                }else{
                    sb.append('R');
                }
            }
        }
        int left = 0;
        int right = 0;
        for(int i=0;i<sb.length();i++){
            char c = sb.charAt(i);
            if(c == 'L'){
                left++;
            }else{
                right++;
            }
        }
        return Math.abs(left-right);
    }
}