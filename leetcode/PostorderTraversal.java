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
class PostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        List<Integer> postorderList = postorderTraversalInner(root, list);
        return postorderList;
    }
    
    public List<Integer> postorderTraversalInner(TreeNode root, List<Integer> list) {
        if(root == null) return list;
        postorderTraversalInner(root.left, list);
        postorderTraversalInner(root.right, list);
        list.add(root.val);
        return list;
    }
}