package mx.wansoft.medium;

/**
 * Given a signed 32-bit integer x, return x with its digits reversed. If
 * reversing x causes the value to go outside the signed 32-bit integer range
 * [-231, 231 - 1], then return 0.
 * 
 * Assume the environment does not allow you to store 64-bit integers (signed or
 * unsigned).
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: x = 123
 * Output: 321
 * 
 * Example 2:
 * 
 * Input: x = -123
 * Output: -321
 * 
 * Example 3:
 * 
 * Input: x = 120
 * Output: 21
 * 
 * 
 * 
 * Constraints:
 * 
 * -231 <= x <= 231 - 1
 * 
 * 
 */
public class ReverseInteger {
    class Solution {
        public int reverse(int x) {
            Long rev = 0L;
            while(x != 0) {
                // pop the last digit of the number
                int pop = x % 10;
                x /= 10;
                // add the poped digit to the reversed number
                rev = rev * 10 + pop;
                if (rev > Math.pow(2, 31) || rev < Math.pow(-2, 31)) {
                    return 0;
                }
            }
            return rev.intValue();
        }
    }
}
