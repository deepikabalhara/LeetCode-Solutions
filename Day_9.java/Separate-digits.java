class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> list= new ArrayList<>();
        for(int num:nums){
            String s=String.valueOf(num);
            for(char ch:s.toCharArray()){
                list.add(ch-'0');
            }
        }
        int[] res = new int[list.size()];

        for(int i=0;i<list.size();i++){
            res[i]=list.get(i);
        }
        return res;
    }
}

//approach: array/simulation
//complexity:O(NlogM)
