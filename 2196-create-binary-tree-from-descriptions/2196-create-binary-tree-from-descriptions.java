/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        Set<Integer> childrenSet = new HashSet<>();
        Map<Integer,int[]> childrenHashMap = new HashMap<>();

        for(int[] desc : descriptions){
            int parent = desc[0];
            int child = desc[1];
            boolean isleft = desc[2]==1;

            childrenHashMap.putIfAbsent(parent , new int[]{-1,-1});
            childrenSet.add(child);

            if(isleft){
                childrenHashMap.get(parent)[0]=child;
            }else{
                childrenHashMap.get(parent)[1] = child;
            }
        }
        int headnodeval = 0;
        for(int parent : childrenHashMap.keySet()){
            if(!childrenSet.contains(parent)){
                headnodeval = parent;
                break;
            }
        }
        return constructTree(headnodeval , childrenHashMap);
    }
        private TreeNode constructTree(int curNodeVal , Map<Integer , int[]> childrenHashMap){
            TreeNode newNode = new TreeNode(curNodeVal);
            if(childrenHashMap.containsKey(curNodeVal)){
                int[] children = childrenHashMap.get(curNodeVal);
                if(children[0]!= -1){
                    newNode.left = constructTree(children[0] , childrenHashMap);
                }
                if(children[1] != -1){
                    newNode.right = constructTree(children[1] , childrenHashMap);
                }
            }
            return newNode;

    }
}