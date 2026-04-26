class Solution {
    public int pivotIndex(int[] nums) {
        int pivot = 0;
        while(pivot<nums.length){
            if(LeftSum(nums, pivot)!=RightSum(nums, pivot)){
                pivot++;
            }else{
                return pivot;
            }
        }
        return -1;
    }
    public static int LeftSum(int[] nums, int pivot){
        int sum = 0;
        for(int i=0;i<pivot;i++){
            sum = sum + nums[i];
        }
        return sum;
    }
    public static int RightSum(int[] nums, int pivot){
        int sum = 0;
        for(int i=nums.length-1;i>pivot;i--){
            sum = sum + nums[i];
        }
        return sum;
    }
}