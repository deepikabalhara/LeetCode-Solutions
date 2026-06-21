class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int count=0;
        Arrays.sort(costs);
        for(int num: costs){
            if(num<=coins){
                coins = coins- num;
                count++;
            }
            else{
                break;
            }
        }
        return count;
    }
}