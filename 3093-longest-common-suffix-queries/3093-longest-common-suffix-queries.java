class TrieNode{
    TrieNode[] children = new TrieNode[26];
    int minLen = Integer.MAX_VALUE;  //for storing min len
    int idx = Integer.MAX_VALUE; //stores index of minlength string
    TrieNode(){
        for(int i = 0 ; i<26 ; i++){
            children[i]=null;        //no children is their in starting
        }
    }
}
class Trie
{
    TrieNode root = new TrieNode();//a root node which is ready to store children

    void insert(String s , int idx){
        int len = s.length();
        TrieNode node = root; //node is a pointer to point and currently its pointing towards root
        if(len<node.minLen){
            node.minLen =len;
            node.idx = idx;
        }
        for(char ch : s.toCharArray()){
            int c = ch-'a';
                if(node.children[c]==null){
                    node.children[c]=new TrieNode();
                }
                node = node.children[c];

                if(len<node.minLen){
                    node.minLen = len;
                    node.idx = idx;
                }
            
        }
    }
        int query(String s){
            TrieNode node = root;

            for(char ch : s.toCharArray()){
                int c = ch - 'a';
                if(node.children[c]!=null){
                    node = node.children[c];
                }
                else{
                    break;
                }
            }
            return node.idx;
        }
    


}
class Solution{
    public int[] stringIndices(String[] wordsCont , String[] wordsQ){
        Trie trie = new Trie();
        for(int i =0 ; i<wordsCont.length ; i++)
        {
            String reversed = new StringBuilder(wordsCont[i]).reverse().toString();
            trie.insert(reversed,i);
        }
        int[] res = new int[wordsQ.length];
        for(int i =0 ; i<wordsQ.length;i++)
        {
            String query = wordsQ[i];
            String reversed = new StringBuilder(query).reverse().toString();
            res[i] = trie.query(reversed);
        }
        return res;
    }
}