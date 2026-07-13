class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> list = new ArrayList<>();

        int lowdigits = String.valueOf(low).length();
        int highdigits = String.valueOf(high).length();

        for(int len = lowdigits ; len<=highdigits ; len++){
            for(int start =1 ; start<= 10-len ;start++){
                int num =0;
                for(int i =0 ; i<len;i++){
                    num = num * 10 +(start+i);
                }
                if(num >=low && num <=high){
                    list.add(num);
                }
            }
        }
        return list;

    //     for(int i = low ; i<=high ;i++){
    //         String str = String.valueOf(i);
    //         boolean isSequential = true;

    //         for(int j =0 ; j<str.length()-1; j++){
    //             if(str.charAt(j+1) != str.charAt(j)+1){
    //                 isSequential = false;
    //                 break;
    //             }
    //         }
    //         if(isSequential){
    //             list.add(i);
    //         }
    //     }
    //    return list;
    }
}