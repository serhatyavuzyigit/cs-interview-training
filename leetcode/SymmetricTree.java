/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        
        if(root == null){
            return true;
        }
        
        return innerMethod(root.left, root.right);
    }
    
    private boolean innerMethod(TreeNode root1, TreeNode root2){
        if(root1==null && root2==null){
            return true;
        } else if((root1==null && root2!= null) || (root1!=null && root2==null)){
            return false;
        } else {
            if(root1.val == root2.val){
                boolean b1 = innerMethod(root1.left, root2.right);
                boolean b2 = innerMethod(root1.right, root2.left);
                
                return b1&&b2;
            } else{
                return false;
            } 
            
        }
         
        
    }
}