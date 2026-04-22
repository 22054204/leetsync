class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        return Optimal(nums1, nums2, nums3, nums4);
    }
    public int Optimal(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                map.put(nums1[i]+nums2[j], map.getOrDefault(nums1[i]+nums2[j], 0)+1);
            }
        }
        for(int k=0;k<nums3.length;k++){
            for(int l=0;l<nums4.length;l++){
                int sum = nums3[k]+nums4[l];
                int fourth = 0-sum;
                if(map.containsKey(fourth)){
                    ans = ans + map.get(fourth);
                }
            }
        }
        return ans;
    }
    //TLE
    public int Better(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int ans = 0;
        HashMap<Integer, Integer> map =  new HashMap<>();
        for(int i=0;i<nums4.length;i++){
            map.put(nums4[i], map.getOrDefault(nums4[i], 0) + 1);
        }
        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                for(int k=0;k<nums3.length;k++){
                    int sum = nums1[i] + nums2[j] + nums3[k];
                    int fourth = 0-sum;
                    if(map.containsKey(fourth)){
                        ans = ans + map.get(fourth);
                    }
                }
            }
        }
        return ans;
    }
    //TLE
    public int BruteForce(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int ans = 0;
        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                for(int k=0;k<nums3.length;k++){
                    for(int l=0;l<nums4.length;l++){
                        if(nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0){
                            ans++;
                        }
                    }
                }
            }
        }
        return ans;
    }
}