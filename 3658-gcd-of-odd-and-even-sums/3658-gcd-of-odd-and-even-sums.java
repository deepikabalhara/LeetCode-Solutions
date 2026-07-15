class Solution {
    public int gcdOfOddEvenSums(int n) {
        int sumofeven = n*n;
        int sumofodd=n*(n+1);
    
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