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
            if (head == null) return true;

            // Find the end of first half and reverse second half.
            ListNode firstHalfEnd = endOfFirstHalf(head);
            ListNode secondHalfStart = reverseList(firstHalfEnd.next);
    
            // Check whether or not there is a palindrome.
            ListNode p1 = head;
            ListNode p2 = secondHalfStart;
            boolean result = true;
            while (result && p2 != null) {
                if (p1.val != p2.val) result = false;
                p1 = p1.next;
                p2 = p2.next;
            }        
    
            // Restore the list and return the result.
            firstHalfEnd.next = reverseList(secondHalfStart);
            return result;

            
            // Another approach
            // ListNode reverse = null;
            // ListNode slow = head;
            // ListNode fast = head;
            // while (fast != null && fast.next != null) {
            //     ListNode temp = reverse;
            //     reverse = slow;

            //     slow = slow.next;
            //     fast = fast.next.next;
                
            //     reverse.next = temp;
            // }

            // if (fast != null) {
            //     slow = slow.next;
            // }

            // while (reverse != null) {
            //     if (reverse.val != slow.val) return false;
            //     reverse = reverse.next;
            //     slow = slow.next;
            // }
            // return true;



            // StringBuilder content = new StringBuilder();
            // while (head != null) {
            //     content.append(head.val);
            //     head = head.next;
            // }
            
            // return content.toString().equals(content.reverse().toString());
        }

            // Taken from https://leetcode.com/problems/reverse-linked-list/solution/
        private ListNode reverseList(ListNode head) {
            ListNode prev = null;
            ListNode curr = head;
            while (curr != null) {
                ListNode nextTemp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextTemp;
            }
            return prev;
        }

        private ListNode endOfFirstHalf(ListNode head) {
            ListNode fast = head;
            ListNode slow = head;
            while (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            return slow;
        }
    }
}
