package mx.wansoft;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 * 
 * An input string is valid if:
 * 
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 * 
 *  
 * 
 * Example 1:
 * 
 * Input: s = "()"
 * Output: true
 * 
 * Example 2:
 * 
 * Input: s = "()[]{}"
 * Output: true
 * 
 * Example 3:
 * 
 * Input: s = "(]"
 * Output: false
 * 
 *  
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 104
 * s consists of parentheses only '()[]{}'.
 * 
 * 
 */
public class ValidParentheses {
    class Solution {
        public boolean isValid(String s) {
            Deque<Character> stack = new LinkedList<>();
            for (int i=0; i < s.length(); i++) {
                char c = s.charAt(i);
                switch(c) {
                    case '(':
                        stack.add(')');
                        break;
                    case '[':
                        stack.add(']');
                        break;
                    case '{':
                        stack.add('}');
                        break;
                    default:
                        if (stack.isEmpty() || !stack.removeLast().equals(c)) {
                            return false;
                        }
                        break;
                }
            }

            return stack.isEmpty();
        }
    }
}
