class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length==0 ){
            return "";
        }
        String pref = strs[0];
        for(String str : strs)
        {
            while(!str.startsWith(pref)){
                pref=pref.substring(0,pref.length()-1);
            }
        }
        return pref;
    }
}