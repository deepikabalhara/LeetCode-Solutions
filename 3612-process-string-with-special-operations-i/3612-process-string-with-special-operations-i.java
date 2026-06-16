class Solution {
    public String processStr(String s) {
        StringBuilder sb = new StringBuilder();

        for(int i =0 ; i<s.length();i++)
        {
            if((s.charAt(i)-'a'>=0) && (s.charAt(i)-'a'<=25) )
            {
                sb.append(s.charAt(i));
            }
            else if(s.charAt(i)=='#'){
                if(sb.length()>0){
                sb.append(sb);
                }
            }
            else if(s.charAt(i)=='*'){
                if(sb.length()>0){
                sb.deleteCharAt(sb.length()-1);
                }
            }
            else if(s.charAt(i)=='%'){
                sb.reverse();
            }

        }
        String str = sb.toString();
        return str;
    }
}