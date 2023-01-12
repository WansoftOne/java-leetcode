package mx.wansoft;

/**
 * Given a string columnTitle that represents the column title as appears in an
 * Excel sheet, return its corresponding column number.
 * 
 * For example:
 * 
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 * 
 *  
 * 
 * Example 1:
 * 
 * Input: columnTitle = "A"
 * Output: 1
 * 
 * Example 2:
 * 
 * Input: columnTitle = "AB"
 * Output: 28
 * 
 * Example 3:
 * 
 * Input: columnTitle = "ZY"
 * Output: 701
 * 
 *  
 * 
 * Constraints:
 * 
 * 1 <= columnTitle.length <= 7
 * columnTitle consists only of uppercase English letters.
 * columnTitle is in the range ["A", "FXSHRXW"].
 * 
 * 
 */
public class ExcelSheetColumnNumber {
    class Solution {
        public int titleToNumber(String columnTitle) {
            int columntNumber = 0;
            for (int i=0; i < columnTitle.length(); i++) {
                int d = columnTitle.charAt(i) - 'A' + 1;
                columntNumber = (columntNumber * 26) + d;
            }
            return columntNumber;
        }
    }
}
