class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int i=0;
        int j =0;
        
        if(nums1[m-1]<nums2[0] || nums2[n-1]<nums1[0] ){
            return -1;
        }
        else
        {
            while(i<m && j<n)
            {
                if(nums1[i]==nums2[j])
                {
                    return nums1[i];
                }
                else if(nums1[i]<nums2[j]){
                    i++;
                }
                else{
                    j++;
                }

            }
        }

        return -1;
        // Set<Integer> set1 = new HashSet<>();
        // for(int i =0;i<m;i++)
        // {
        //     set1.add(nums1[i]);
        // }
        // Set<Integer> set2 = new HashSet<>();
        // for(int i =0;i<n;i++)
        // {
        //     set2.add(nums2[i]);
        // }
        // int min = Integer.MAX_VALUE;
        // for(int num:set1){
        //     if(set2.contains(num)){
        //         min=Math.min(min,num);
        //     }
        // }
        // if(min==Integer.MAX_VALUE)
        // {
        //     return -1;
        // }
        // else{
        //     return min;
        // }
    }
}