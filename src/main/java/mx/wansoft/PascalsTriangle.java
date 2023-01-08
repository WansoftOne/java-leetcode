package mx.wansoft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 * 
 * In Pascal's triangle, each number is the sum of the two numbers directly
 * above it as shown:
 * 
 *     1
 *    1 1
 *   1 2 1
 *  1 3 3 1  
 * 1 4 6 4 1 
 * 
 * Example 1:
 * 
 * Input: numRows = 5
 * Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 * 
 * Example 2:
 * 
 * Input: numRows = 1
 * Output: [[1]]
 * 
 *  
 * 
 * Constraints:
 * 
 * 1 <= numRows <= 30
 * 
 * 
 */
public class PascalsTriangle {
    class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> answer = new ArrayList<>();
            answer.add(Arrays.asList(1));
            if (numRows == 1) return answer;
            answer.add(Arrays.asList(1,1));
            if (numRows == 2) return answer;
            
            for (int n=3; n <= numRows; n++) {
                List<Integer> numbers = new ArrayList<>();              
                for (int i=0; i < n; i++) {
                    if (i > 0 && i < n - 1) {
                        List<Integer> above = answer.get(n - 2);
                        numbers.add(above.get(i) + above.get(i -1));
                    } else {
                        numbers.add(1);
                    }
                }
                answer.add(numbers);
            }
            return answer;
        }
    }
}
