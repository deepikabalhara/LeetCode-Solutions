class Solution {
    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        int[] arr = new int[n];

        //transform array
        for(int i = 0;  i<n;i++)
        {
            arr[i] = (nums[i]==target)? 1:-1;
        }


        //compute prefix sum
        long[] prefix = new long[n+1];
        for(int i =0 ; i<n;i++){
           prefix[i+1] = prefix[i] +arr[i];
        }
        

        //coordinate compression(prefix sums can be -ve/large)
        long[] sorted = prefix.clone();
        Arrays.sort(sorted);
        Map<Long , Integer> comp = new HashMap<>();
        int idx =1;
        for(long val :sorted){
            if(!comp.containsKey(val)){
                comp.put(val,idx++);
            }
        }

        //fenwick tree
        FenwickTree bit = new FenwickTree(idx+2);
        long result=0;

        for(long val: prefix){
            int pos = comp.get(val);
            //count how many previous prefix sums are strictly smaller
            result += bit.query(pos-1);
            //add current prefix sum to BIT
            bit.update(pos,1);
        }
        return result;
    }

    //fenwick tree implementation
    static class FenwickTree{
        long[] tree;
        int n ;
        FenwickTree(int n){
            this.n=n;
            tree= new long[n+1];
        }

        void update(int i , long delta){
            while(i<=n){
                tree[i] += delta;
                i+=i & -i;
            }
        }
        long query(int i ){
            long sum=0;
            while(i>0){
                sum+= tree[i];
                 i-= i&-i;
            }
            return sum;
        }
    }
}