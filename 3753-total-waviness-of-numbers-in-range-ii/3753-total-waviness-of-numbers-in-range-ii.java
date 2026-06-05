class Solution {
    static class Pair{
        long count ; 
        long sum;

        Pair(long c , long s)
        {
            count =c;
            sum = s;

        }
    }
    String digits;
    Pair[][][][] memo; //memoization table
    boolean[][][][] vis;  //visited states

    private Pair dfs(int pos , int prev2 , int prev1 , int started , int tight){
        if(pos==digits.length()){
            return new Pair(1,0);  //count =1 , sum=0
        }
        if(tight==0 && vis[pos][prev2+1][prev1+1][started]){
            return memo[pos][prev2+1][prev1+1][started];  // if we are not in a tight state and this has been already solved then return memoized result

        }
        int limit = (tight==1) ? digits.charAt(pos)-'0' :9;  //digits.charAt(pos)-'0' converting the digit in actual integer
        long totalcount =0;
        long totalsum=0;

        for(int d=0 ; d<=limit ; d++){
            int nexttight = (tight==1 && d==limit) ? 1:0;
        if(started==0 && d==0){
            Pair child = dfs(pos+1 , -1 , -1 ,0 ,nexttight);
            totalcount +=child.count;
            totalsum+=child.sum;
        }else{
            int add =0;
            if(prev2!=-1){
                if((prev1>prev2 && prev1 >d)||(prev1<prev2 && prev1<d)){
                    add=1;
                }
            }
            int np2;
            int np1;
            if(started==0){
                np2=-1;
                np1=d;
            }
            else{
                np2=prev1;
                np1=d;
            }
            Pair child = dfs(pos+1 , np2 , np1 , 1 ,nexttight);
            totalcount += child.count;
            totalsum += child.sum + add*child.count;





        }
    }
    Pair ans = new Pair(totalcount , totalsum);
    if(tight ==0){
        vis[pos][prev2+1][prev1+1][started]=true;
        memo[pos][prev2+1][prev1+1][started]=ans;
    }
    return ans;
}
private long solve(long n){
    if(n<=0)
        return 0;
    digits =String.valueOf(n);
    int len = digits.length();

    memo = new Pair[len+1][11][11][2];
    vis=new boolean[len+1][11][11][2];

    return dfs(0,-1,-1,0,1).sum;
    
}



    public long totalWaviness(long num1, long num2) {
        return solve(num2)-solve(num1-1);
    }
}