class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        // int n = words.length;
        // int m = weights.length;
        
        StringBuilder sb= new StringBuilder();
        //String result=null;
        for(String word : words)
        {
            
            // String str = words[i];
            int sum=0;
            //char ch[] = new char[str.length()];
            for(int i=0 ; i<word.length();i++)
            {
                char c = word.charAt(i);
                sum+=weights[c-'a'];
                
            }
            int mod = sum % 26;
            char ch = (char)('z'- mod);
            sb.append(ch);
        }
        return sb.toString();
        
    }
}