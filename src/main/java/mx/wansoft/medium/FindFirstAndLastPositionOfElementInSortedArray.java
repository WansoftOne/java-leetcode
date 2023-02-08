package mx.wansoft.medium;

import java.util.Arrays;

/**
 * Given an array of integers nums sorted in non-decreasing order, find the
 * starting and ending position of a given target value.
 * 
 * If target is not found in the array, return [-1, -1].
 * 
 * You must write an algorithm with O(log n) runtime complexity.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * 
 * Example 2:
 * 
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 * 
 * Example 3:
 * 
 * Input: nums = [], target = 0
 * Output: [-1,-1]
 * 
 * 
 * 
 * Constraints:
 * 
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * nums is a non-decreasing array.
 * -109 <= target <= 109
 * 
 * 
 */
public class FindFirstAndLastPositionOfElementInSortedArray {
    static class Solution {
        public int[] searchRange(int[] nums, int target) {
            int[] ans = new int[]{-1, -1};
            int left = 0, right = nums.length -1;

            while(left <= right) {
                int middle = (left + right) / 2;
                if (target == nums[middle]) {
                    ans[0] = middle;
                    if (middle -1 >= 0 && target == nums[middle - 1]) {
                        right = middle -1;
                    } else {
                        break;
                    }
                } else if (target > nums[middle]) {
                    left = middle + 1;
                } else if (target < nums[middle]) {
                    right = middle -1;
                }
            }

            left = 0;
            right =  nums.length -1;
            while(left <= right) {
                int middle = (left + right) / 2;
                if (target == nums[middle]) {
                    if (middle + 1 <= nums.length - 1 && target == nums[middle + 1]) {
                        left = middle + 1;
                    } else {
                        ans[1] = middle;
                        break;
                    }
                } else if (target > nums[middle]) {
                    left = middle + 1;
                } else if (target < nums[middle]) {
                    right = middle -1;
                }
            }
            return ans;
        } 
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] r = s.searchRange(new int[]{5,7,7,8,8,10}, 6);
        System.out.println(Arrays.toString(r));
    }
}
