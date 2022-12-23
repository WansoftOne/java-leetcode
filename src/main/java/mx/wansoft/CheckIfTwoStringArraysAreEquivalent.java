package mx.wansoft;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 
    Given two string arrays word1 and word2, return true if the two arrays represent the same string, and false otherwise.
    A string is represented by an array if the array elements concatenated in order forms the string.
 
    Example 1:

    Input: word1 = ["ab", "c"], word2 = ["a", "bc"]
    Output: true
    Explanation:
    word1 represents string "ab" + "c" -> "abc"
    word2 represents string "a" + "bc" -> "abc"
    The strings are the same, so return true.

    Example 2:

    Input: word1 = ["a", "cb"], word2 = ["ab", "c"]
    Output: false

    Example 3:

    Input: word1  = ["abc", "d", "defg"], word2 = ["abcddefg"]
    Output: true


 * 
 */
public class CheckIfTwoStringArraysAreEquivalent {
    class Solution {
        public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
            int maxLength = (word1.length > word2.length) ? word1.length : word2.length;
            String str1 = "", str2 = "";
            for (int i=0; i < maxLength; i++) {
                if (i < word1.length) {
                    str1 += word1[i];
                }
                if (i < word2.length) {
                    str2 += word2[i];
                }

                if (str1.length() >= str2.length() && !str1.startsWith(str2)) {
                    return false;
                }
            }

            return str1.equals(str2);
        }
    }
}
