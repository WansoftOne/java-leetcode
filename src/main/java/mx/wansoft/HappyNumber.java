package mx.wansoft;

/**
 * Write an algorithm to determine if a number n is happy.
 * 
 * A happy number is a number defined by the following process:
 * 
 * Starting with any positive integer, replace the number by the sum of the
 * squares of its digits.
 * Repeat the process until the number equals 1 (where it will stay), or it
 * loops endlessly in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy.
 * 
 * Return true if n is a happy number, and false if not.
 * 
 *  
 * 
 * Example 1:
 * 
 * Input: n = 19
 * Output: true
 * Explanation:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 * 
 * Example 2:
 * 
 * Input: n = 2
 * Output: false
 * 
 *  
 * 
 * Constraints:
 * 
 * 1 <= n <= 231 - 1
 * 
 * 
 */
public class HappyNumber {
    class Solution {
        public int findNextNumber(int n) {
            int sum = 0;
            while (n > 0) {
                int d = n % 10;
                n = n / 10;
                sum += d * d;
            }
            return sum;
        }

        public boolean isHappy(int n) {
            // Set<Integer> memo = new HashSet<>();
            // while (n != 1 && !memo.contains(n)) {
            //     memo.add(n);
            //     n = findNextNumber(n);
            // }
            // return n == 1;

            // Floyd's Cycle-Finding Algorithm
            int slowRunner = n;
            int fastRunner = findNextNumber(n);
            while (n != 1 && slowRunner != fastRunner) {
                slowRunner = findNextNumber(slowRunner);
                fastRunner = findNextNumber(findNextNumber(fastRunner));
            }
            return fastRunner == 1;
        }
    }
}
