package mx.wansoft.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Given an array of strings strs, group the anagrams together. You can return
 * the answer in any order.
 * 
 * An Anagram is a word or phrase formed by rearranging the letters of a
 * different word or phrase, typically using all the original letters exactly
 * once.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * 
 * Example 2:
 * 
 * Input: strs = [""]
 * Output: [[""]]
 * 
 * Example 3:
 * 
 * Input: strs = ["a"]
 * Output: [["a"]]
 * 
 * 
 * 
 * Constraints:
 * 
 * 1 <= strs.length <= 104
 * 0 <= strs[i].length <= 100
 * strs[i] consists of lowercase English letters.
 * 
 * 
 */
public class GroupAnagrams {
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> memo = new HashMap<>();
            for (String str : strs) {
                char[] charArray = str.toCharArray();
                Arrays.sort(charArray);
                String key =  new String(charArray);
                if (memo.containsKey(key)) {
                    memo.get(key).add(str);
                } else {
                    List<String> items = new ArrayList<>();
                    items.add(str);
                    memo.put(key, items);
                }
            }

            return new ArrayList<>(memo.values());
        }
    }
}
