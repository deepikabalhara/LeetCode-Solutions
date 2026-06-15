class Solution {
    public int lengthOfLastWord(String s) {
        // String[] words = s.split(" ");

        // String last = words[words.length-1];
        // return last.length();

        int len = s.length()-1, count =0;
        while(len>=0 && s.charAt(len)==' ')
        {
            len--;
        }
        while(len>=0 && (s.charAt(len) != ' '))
        {
            len--;
            count++;
        }
        return count;
    }
}