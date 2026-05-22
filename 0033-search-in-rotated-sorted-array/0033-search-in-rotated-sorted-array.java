class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int left =0 , right = n-1;
        while(left<=right)
        {
            int mid = (left+right)>>1;
            if(nums[mid]>nums[n-1])
            {
                left = mid+1;
            }
            else
            {
                right = mid-1;
            }

        }
        int answer = binarySearch(nums , target ,0 , left-1);
        if(answer!= -1)
        {
            return answer;
        }
        return binarySearch(nums , target , right+1 , n-1);
    }
        private int binarySearch(int nums[] , int target , int left , int right)
        {
            while(left<=right)
            {
                int mid = (left + right )>>1;
                if(nums[mid]==target)
                {
                    return mid;
                }
                else if(nums[mid]<target)
                {
                    left = mid+1;
                }
                else
                {
                    right = mid -1;
                }

            }
            return -1;
        }
}