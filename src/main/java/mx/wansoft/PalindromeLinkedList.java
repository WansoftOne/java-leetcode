package mx.wansoft;

/**
 * Given the head of a singly linked list, return true if it is a
 * palindrome
 * or false otherwise.
 * 
 *  
 * 
 * Example 1:
 * 
 * Input: head = [1,2,2,1]
 * Output: true
 * 
 * Example 2:
 * 
 * Input: head = [1,2]
 * Output: false
 * 
 *  
 * 
 * Constraints:
 * 
 * The number of nodes in the list is in the range [1, 105].
 * 0 <= Node.val <= 9
 * 
 *  
 * Follow up: Could you do it in O(n) time and O(1) space?
 */
public class PalindromeLinkedList {
    
    //Definition for singly-linked list.
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    
    class Solution {
        public boolean isPalindrome(ListNode head) {
            ListNode reverse = null;
            ListNode slow = head;
            ListNode fast = head;
            while (fast != null && fast.next != null) {
                ListNode temp = reverse;
                reverse = slow;

                slow = slow.next;
                fast = fast.next.next;
                
                reverse.next = temp;
            }

            if (fast != null) {
                slow = slow.next;
            }

            while (reverse != null) {
                if (reverse.val != slow.val) return false;
                reverse = reverse.next;
                slow = slow.next;
            }
            return true;
            // StringBuilder content = new StringBuilder();
            // while (head != null) {
            //     content.append(head.val);
            //     head = head.next;
            // }
            
            // return content.toString().equals(content.reverse().toString());
        }
    }
}
