class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        int[] sorted=nums.clone();
        Arrays.sort(sorted);
        //int left =0,right=n-1;
        for(int r =0 ; r<n ; r++)
        {
            int last = nums[n-1];
            for(int i = n-1 ; i>0 ; i--)
            {
                nums[i]=nums[i-1];
            }
            nums[0]=last;
            if(Arrays.equals(nums,sorted)){
                return true;
            }
        }
        return false;
        //Arrays.sort(nums);
    }
}