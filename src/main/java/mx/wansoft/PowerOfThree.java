package mx.wansoft;

/**
 * Given an integer n, return true if it is a power of three. Otherwise, return
 * false.
 * 
 * An integer n is a power of three, if there exists an integer x such that n ==
 * 3x.
 * 
 *  
 * 
 * Example 1:
 * 
 * Input: n = 27
 * Output: true
 * Explanation: 27 = 33
 * 
 * Example 2:
 * 
 * Input: n = 0
 * Output: false
 * Explanation: There is no x where 3x = 0.
 * 
 * Example 3:
 * 
 * Input: n = -1
 * Output: false
 * Explanation: There is no x where 3x = (-1).
 * 
 *  
 * 
 * Constraints:
 * 
 * -231 <= n <= 231 - 1
 * 
 *  
 * Follow up: Could you solve it without loops/recursion?
 */
public class PowerOfThree {
    class Solution {
        public boolean isPowerOfThree(int n) {
            // To prevent
            // java.lang.ArithmeticException: / by zero and
            // negative n
            if (n <= 0)
                return false;
            /* The maximum power of 3 value that
               integer can hold is 1162261467 ( 3^19 ) .*/
            return 1162261467 % n == 0;
        }
    }
}
