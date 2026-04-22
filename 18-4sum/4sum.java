class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
       return Optimal(nums, target);
    }
    //This is Optimal Solution ... T.C = O(n^3) and S.C = O(1).
    public List<List<Integer>> Optimal(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
       for(int i=0;i<nums.length;i++){
        if(i>0 && nums[i]==nums[i-1]) continue;
        for(int j=i+1;j<nums.length;j++){
            if(j>i+1 && nums[j]==nums[j-1]) continue;
            int k = j+1;
            int l = nums.length-1;
            while(k<l){
                long sum = (long)nums[i]+nums[j]+nums[k]+nums[l];
                if(sum==target){
                    result.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                    k++;
                    l--;
                    while(k<l && nums[k]==nums[k-1]) k++;
                    while(k<l && nums[l]==nums[l+1]) l--;
                }
                else if(sum>target){
                    l--;
                }
                else if(sum<target){
                    k++;
                }
            }
        }
       }
       return result;
    }
    // This is Better Solution not optimal, because we did O(n³) which is nice but we take some extra space ... we definately solving it in constant space ... and that's the optimal solution.
    public List<List<Integer>> Better(int[] nums, int target) {
        Arrays.sort(nums); //O(nlogn)
        Set<List<Integer>> result = new HashSet<>();
        for(int i=0;i<nums.length;i++){ //O(n^3)
            for(int j=i+1;j<nums.length;j++){
                Set<Long> set = new HashSet<>();
                for(int k=j+1;k<nums.length;k++){
                    long fourth = target - ((long)nums[i]+nums[j]+nums[k]);
                    if(set.contains(fourth)){
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        list.add((int)fourth);
                        Collections.sort(list);
                        result.add(list);
                    }
                    set.add((long)nums[k]);
                }
            }
        }
        return new ArrayList(result);
    }

    //TLE
    public List<List<Integer>> BruteForce1(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                for(int k=j+1;k<nums.length;k++){
                    for(int l=k+1;l<nums.length;l++){
                        long sum = (long)nums[i] + nums[j] + nums[k] + nums[l];
                        if(sum == target){
                            List<Integer> list = new ArrayList<>();
                            list.add(nums[i]);
                            list.add(nums[j]);
                            list.add(nums[k]);
                            list.add(nums[l]);
                            if(!result.contains(list)){
                                result.add(list);
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
    //TLE 
    public List<List<Integer>> BruteForce2(int[] nums, int target) {
        Arrays.sort(nums);

        Set<List<Integer>> set = new HashSet<>();

        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                for(int k = j + 1; k < nums.length; k++){
                    for(int l = k + 1; l < nums.length; l++){

                        long sum = (long)nums[i] + nums[j] + nums[k] + nums[l];

                        if(sum == target){
                            List<Integer> list = new ArrayList<>();
                            list.add(nums[i]);
                            list.add(nums[j]);
                            list.add(nums[k]);
                            list.add(nums[l]);

                            set.add(list);
                        }
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }

    //SUBMITTED (Smart Solution :- because here you skip duplicates) but O(n^4) Very Slow 
    public List<List<Integer>> BruteForce3(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0; i < nums.length; i++){
            if(i > 0 && nums[i] == nums[i - 1]) continue;

            for(int j = i + 1; j < nums.length; j++){
                if(j > i + 1 && nums[j] == nums[j - 1]) continue;

                for(int k = j + 1; k < nums.length; k++){
                    if(k > j + 1 && nums[k] == nums[k - 1]) continue;

                    for(int l = k + 1; l < nums.length; l++){
                        if(l > k + 1 && nums[l] == nums[l - 1]) continue;

                        long sum = (long)nums[i] + nums[j] + nums[k] + nums[l];

                        if(sum == target){
                            List<Integer> list = new ArrayList<>();
                            list.add(nums[i]);
                            list.add(nums[j]);
                            list.add(nums[k]);
                            list.add(nums[l]);
                            result.add(list);
                        }
                    }
                }
            }
        }
        return result; 
    }
}