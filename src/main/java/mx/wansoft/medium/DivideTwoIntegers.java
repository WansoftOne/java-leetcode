package mx.wansoft.medium;

import javax.lang.model.element.Element;
import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

/**
 * Given two integers dividend and divisor, divide two integers without using
 * multiplication, division, and mod operator.
 * 
 * The integer division should truncate toward zero, which means losing its
 * fractional part. For example, 8.345 would be truncated to 8, and -2.7335
 * would be truncated to -2.
 * 
 * Return the quotient after dividing dividend by divisor.
 * 
 * Note: Assume we are dealing with an environment that could only store
 * integers within the 32-bit signed integer range: [−231, 231 − 1]. For this
 * problem, if the quotient is strictly greater than 231 - 1, then return 231 -
 * 1, and if the quotient is strictly less than -231, then return -231.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: dividend = 10, divisor = 3
 * Output: 3
 * Explanation: 10/3 = 3.33333.. which is truncated to 3.
 * 
 * Example 2:
 * 
 * Input: dividend = 7, divisor = -3
 * Output: -2
 * Explanation: 7/-3 = -2.33333.. which is truncated to -2.
 * 
 * 
 * 
 * Constraints:
 * 
 * -231 <= dividend, divisor <= 231 - 1
 * divisor != 0
 * 
 * 
 */
public class DivideTwoIntegers {
    static class Solution {
        public int divide(int dividend, int divisor) {
            char s = dividend < 0 == divisor < 0 ? '+' : '-';
            Long longDivisor = Math.abs(Long.valueOf(divisor));
            Long longDividend = Math.abs(Long.valueOf(dividend));
            if (longDivisor > longDividend) return 0;
            
            String dividendStr = Long.toString(longDividend);
            String temp = "0";
            String ansStr = "0";
            for (int i=0; i < dividendStr.length(); i++) {
                Long n = Long.parseLong("" + Integer.parseInt(temp) + (dividendStr.charAt(i) - 48));
                if ( n >= longDivisor) {
                    temp = "0";
                    int tempAns = 0;
                    while (n - longDivisor >=  0) {
                        tempAns++;
                        n -= longDivisor;
                    }
                    temp += n;
                    ansStr += tempAns;
                } else {
                    ansStr += 0;
                    temp = Long.toString(n);
                }
            }
            ansStr = s + ansStr;
            Long ans = Long.parseLong(ansStr);
            if (ans > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (ans < Integer.MIN_VALUE) return Integer.MIN_VALUE; 

            return ans.intValue();
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int r = s.divide(-2147483648, -1017100424);
        System.out.println(r);
    }
}
