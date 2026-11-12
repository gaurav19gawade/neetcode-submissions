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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null) return false;
        if(subRoot == null) return true;

        if(sameTree(root, subRoot)) return true;

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public boolean sameTree(TreeNode left, TreeNode right){
        if(left == null && right == null){
            return true;
        }

        if((left != null && right == null) || (left == null && right != null) ||(left.val != right.val)){
            return false;
        }

        return sameTree(left.left, right.left) && sameTree(left.right, right.right);
    }
}
