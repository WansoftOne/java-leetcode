package mx.wansoft;

/**
 * Given a binary tree, determine if it is height-balanced.
 * https://www.geeksforgeeks.org/introduction-to-height-balanced-binary-tree/
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: root = [3,9,20,null,null,15,7]
 * Output: true
 * 
 * Example 2:
 * 
 * Input: root = [1,2,2,3,3,null,null,4,4]
 * Output: false
 * 
 * Example 3:
 * 
 * Input: root = []
 * Output: true
 * 
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the tree is in the range [0, 5000].
 * -104 <= Node.val <= 104
 * 
 * 
 */
public class BalancedBinaryTree {

    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static class Solution {
        public boolean isBalanced(TreeNode root) {
            if (root == null) return true;
            int leftHeight = getHeight(root.left);
            int rightHeight = getHeight(root.right);
            
            if (Math.abs(leftHeight - rightHeight) <= 1 
                    && isBalanced(root.left)
                    && isBalanced(root.right)) {
                    
                        return true;
                }

            return false;
        }

        public int getHeight(TreeNode root) {
            if (root == null) return 0;
            return 1 + Math.max(getHeight(root.left), getHeight(root.right));
        }
        
    }
}
