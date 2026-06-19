class Solution {
    public int largestAltitude(int[] gain) {
        int n = gain.length;
        int sum=0;
        int mx = Integer.MIN_VALUE;
        int[] ans = new int[n+1];
        for(int i =0 ; i<=n;i++){
            if(i==0)
            {
                ans[i]=0;
            }
            else{
                sum+=gain[i-1];
                ans[i]=sum;
            }
        }
        for(int i =0 ; i<=n;i++)
        {
            mx = Math.max(mx ,ans[i]);
        }
        return mx;
    }
}