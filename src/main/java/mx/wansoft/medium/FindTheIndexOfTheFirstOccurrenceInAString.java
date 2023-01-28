package mx.wansoft.medium;

/**
 * Given two strings needle and haystack, return the index of the first
 * occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: haystack = "sadbutsad", needle = "sad"
 * Output: 0
 * Explanation: "sad" occurs at index 0 and 6.
 * The first occurrence is at index 0, so we return 0.
 * 
 * Example 2:
 * 
 * Input: haystack = "leetcode", needle = "leeto"
 * Output: -1
 * Explanation: "leeto" did not occur in "leetcode", so we return -1.
 * 
 * 
 * 
 * Constraints:
 * 
 * 1 <= haystack.length, needle.length <= 104
 * haystack and needle consist of only lowercase English characters.
 * 
 * 
 */
public class FindTheIndexOfTheFirstOccurrenceInAString {
    static class Solution {
        public int strStr(String haystack, String needle) {

            for (int i=0; i < haystack.length(); i++) {
                if (haystack.charAt(i) == needle.charAt(0)) {
                    if (haystack.length() - i < needle.length()) return -1;
                    boolean exist = true;
                    for (int j=1; j < needle.length(); j++) {
                        if (haystack.charAt(i+j) != needle.charAt(j)) {
                            exist = false;
                            break;
                        }
                    }
                    if (exist) {
                        return i;
                    }
                }
            }
            return -1;
        }

        public static void main(String[] args) {
            Solution s = new Solution();
            int r = s.strStr("a", "a");
            System.out.println(r);
        }
    }
}
