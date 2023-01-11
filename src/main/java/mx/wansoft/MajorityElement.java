package mx.wansoft;

import java.security.KeyStore.Entry;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array nums of size n, return the majority element.
 * 
 * The majority element is the element that appears more than ⌊n / 2⌋ times. You
 * may assume that the majority element always exists in the array.
 * 
 *  
 * 
 * Example 1:
 * 
 * Input: nums = [3,2,3]
 * Output: 3
 * 
 * Example 2:
 * 
 * Input: nums = [2,2,1,1,1,2,2]
 * Output: 2
 * 
 *  
 * 
 * Constraints:
 * 
 * n == nums.length
 * 1 <= n <= 5 * 104
 * -109 <= nums[i] <= 109
 * 
 *  
 * Follow-up: Could you solve the problem in linear time and in O(1) space?
 */
public class MajorityElement {
    class Solution {
        public int majorityElement(int[] nums) {
            Map<Integer, Integer> data = new HashMap<>();
            for (int num : nums) {
                if (data.containsKey(num)) {
                    data.put(num, data.get(num) + 1);
                } else {
                    data.put(num, 1);
                }
            }

            int majority = Integer.MIN_VALUE, times= Integer.MIN_VALUE;
            for (var entry : data.entrySet()) {
                if (entry.getValue() > times) {
                    majority = entry.getKey();
                }
            }
            return majority;
        }
    }
}
