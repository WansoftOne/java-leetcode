package mx.wansoft;

/**
 * You are climbing a staircase. It takes n steps to reach the top.
 * 
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can
 * you climb to the top?
 * 
 *  
 * 
 * Example 1:
 * 
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * 
 * Example 2:
 * 
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 * 
 *  
 * 
 * Constraints:
 * 
 * 1 <= n <= 45
 * 
 * 
 */
public class ClimbingStairs {

    static class Solution {
        public int climbStairs(int n) {
            // Solving the problem starting at the default case
            /**
             * Example:
             *          _
             *        _|1 - base case alwais should be 1 
             *      _|1
             *    _|2
             *  _|3
             * |5 
             * 
             */
            int one = 1, two = 1;
            for (int i=0; i < n -1; i++) {
                int temp = one;
                one = one + two;
                two = temp;
            }

            return one;
        }
    }
}
