class Solution {
    public boolean validDigit(int n, int x) {
        List<Integer> list = new ArrayList<>();
        if(n==0){
            return false;
        }
        while(n>0){
            list.add(n%10);
            n = n/10;
        }
        if(list.get(list.size()-1)==x){
            return false;
        }
        if(list.contains(x)){
            return true;
        }
        return false;
    }
}