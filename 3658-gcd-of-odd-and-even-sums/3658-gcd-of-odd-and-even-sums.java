class Solution {
    public int gcdOfOddEvenSums(int n) {
        int sumofeven =0;
        int sumofodd=0;
        for(int i=1 ; i<=n;i++){
           sumofodd += 2*i-1;
           sumofeven += 2*i;
        }
        return gcd(sumofodd , sumofeven);

    }
    private int gcd(int a , int b){
        while(b!=0){
            int t = a%b;
            a=b;
            b=t;
        }
        return a;
    }
}