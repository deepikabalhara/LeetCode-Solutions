class Solution {
    public int totalWaviness(int num1, int num2) {
        int sum=0;
        for(int i = num1 ; i<= num2 ;i++)
        {
            String num = String.valueOf(i);
            if(num.length()<3)
            {
                continue;
            }
            boolean wavy = true;
            for(int j = 1; j<num.length()-1;j++)
            {
                char left = num.charAt(j-1);
                char curr = num.charAt(j);
                char right = num.charAt(j+1);

                boolean peak = curr > left && curr>right;
                boolean valley = curr < left && curr<right;

                if(peak || valley)
                {
                    sum++;
                }
            }
        }

        return sum;
    }
}