package mx.wansoft;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

/**
 * Given the root of a binary tree, return the inorder traversal of its nodes'
 * values.
 * 
 *  1
 *   \
 *    2
 *   /
 *  3     
 * 
 * Example 1:
 * 
 * Input: root = [1,null,2,3]
 * Output: [1,3,2]
 * 
 * Example 2:
 * 
 * Input: root = []
 * Output: []
 * 
 * Example 3:
 * 
 * Input: root = [1]
 * Output: [1]
 * 
 *  
 * 
 * Constraints:
 * 
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 * 
 *  
 */
public class BinaryTreeInorderTransversal {
    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2, node3, null);
        TreeNode node1 = new TreeNode(1, null, node2);
        
        var s = new Solution();
        var r = s.inorderTraversal(node1);
        System.out.println(Objects.toString(r));
    }

    //Definition for a binary tree node.
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
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> answer = new ArrayList<>();
            TreeNode pre;
            while (root != null) {
                if (root.left == null) {
                    answer.add(root.val);
                    root = root.right; // move to next right node
                } else { // has a left subtree
                    pre = root.left;
                    while (pre.right != null) { // find rightmost
                        pre = pre.right;
                    }
                    pre.right = root; // put cur after the pre node
                    TreeNode temp = root; // store cur node
                    root = root.left; // move cur to the top of the new tree
                    temp.left = null; // original cur left be null, avoid infinite loops
                }
            }

            // Deque<TreeNode> stack = new LinkedList<>();
            // while (root != null || !stack.isEmpty()) {
            //     while (root != null) {
            //         stack.add(root);
            //         root = root.left;
            //     }
            //     root = stack.removeLast();
            //     answer.add(root.val);
            //     root = root.right;
            // }
            return answer;
        }
    }
}
