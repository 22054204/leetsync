class Solution {
    public long[] distance(int[] nums) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(nums[i])){
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(nums[i], list);
            }else{
                map.get(nums[i]).add(i);
            }
        }
        long[] result = new long[nums.length];  
        for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()){
            List<Integer> l1 = entry.getValue();
            int n = l1.size();
            if(n == 1){
                result[l1.get(0)] = 0;
                continue;
            }
            long totalSum = 0;
            for(int i = 0; i < n; i++){
                totalSum += l1.get(i);
            }
            long prefixSum = 0;
            for(int i = 0; i < n; i++){
                long current = l1.get(i);
                long left = (long)i * current - prefixSum;
                long right = (totalSum - prefixSum - current) - (long)(n - i - 1) * current;
                result[l1.get(i)] = left + right;
                prefixSum += current;
            }
        }
        return result;
    }
}