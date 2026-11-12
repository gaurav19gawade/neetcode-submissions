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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> result = new ArrayList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                if (current != null) {
                    list.add(current.val);
                    if (current.left != null)
                        queue.offer(current.left);
                    if (current.right != null)
                        queue.offer(current.right);
                }
            }
            result.add(list);
        }
        return result;
    }
}
