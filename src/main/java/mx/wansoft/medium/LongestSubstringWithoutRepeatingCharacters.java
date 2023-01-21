package mx.wansoft.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a string s, find the length of the longest
 * substring
 * without repeating characters.
 * 
 *  
 * 
 * Example 1:
 * 
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * 
 * Example 2:
 * 
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * 
 * Example 3:
 * 
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a
 * substring.
 * 
 *  
 * 
 * Constraints:
 * 
 * 0 <= s.length <= 5 * 104
 * s consists of English letters, digits, symbols and spaces.
 * 
 * 
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution s = new Solution();
        int r = s.lengthOfLongestSubstring("abba");
    }
    static class Solution {
        public int lengthOfLongestSubstring(String s) {
            int n = s.length(), ans = 0;
            Map<Character, Integer> map = new HashMap<>();;
            for (int i=0, j=0; j < n; j++) {
                if (map.containsKey(s.charAt(j))) {
                    // check the what is index of s.charAt(j) and we add 1 
                    // because we want the position next to it
                    i = Math.max(map.get(s.charAt(j)) + 1, i);
                }
                ans = Math.max(ans, j - i + 1);
                map.put(s.charAt(j), j);
            }
            return ans;
        }
    }
}
