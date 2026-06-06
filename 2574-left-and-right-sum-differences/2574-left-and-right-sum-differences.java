class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length , leftsum=0 , rightsum=0;
        for(int num : nums) rightsum+=num;
        for(int i=0 ; i<n ; i++)
        {
            int val = nums[i];
            rightsum-=val;
            nums[i] = Math.abs(leftsum-rightsum);
            leftsum += val;
        }
        return nums;
    }
}