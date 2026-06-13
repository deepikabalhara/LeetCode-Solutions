class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int min =Integer.MAX_VALUE;
        //int max =Integer.MIN_VALUE;
        //int minidx=-1;
        int maxprofit=0;
        for(int num : prices)
        {
            min = Math.min(min , num);
            maxprofit = Math.max(num-min , maxprofit);
        }
        return maxprofit;
    }
}