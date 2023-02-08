package mx.wansoft.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * There is an integer array nums sorted in ascending order (with distinct
 * values).
 * 
 * Prior to being passed to your function, nums is possibly rotated at an
 * unknown pivot index k (1 <= k < nums.length) such that the resulting array is
 * [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]
 * (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3
 * and become [4,5,6,7,0,1,2].
 * 
 * Given the array nums after the possible rotation and an integer target,
 * return the index of target if it is in nums, or -1 if it is not in nums.
 * 
 * You must write an algorithm with O(log n) runtime complexity.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * 
 * Example 2:
 * 
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 * 
 * Example 3:
 * 
 * Input: nums = [1], target = 0
 * Output: -1
 * 
 */
public class SearchInRotatedSortedArray {
    static class Solution {
        public int search(int[] nums, int target) {
            // [4,5,6,7,0,1,2]
            // Binary Search approach
            int left = 0;
            int right = nums.length - 1;
            while(left <= right ) {
                int middle = (left + right) / 2;
                if (nums[middle] == target) return middle;
                
                if (nums[left] < nums[right]) {
                    // sorted
                    if (target <= nums[left] && target < nums[middle]) {
                        right = middle -1;
                    } else {
                        left = middle + 1;
                    }
                } else {
                    // unsorted
                    if (target <= nums[right]) {
                        // all the value from middle to right are less than right
                        left = middle +     1;
                    } else if (target >= nums[left]) {
                        // all the value from left to middle are greater than left    
                        right = middle -1;
                    } else {
                        return -1;
                    }
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        final List<String> l = new ArrayList<>();
        l.add("Magda");
        // l = new ArrayList<>();

        Solution s = new Solution();
        int r = s.search(new int[]{4,5,6,7,8,1,2,3}, 8);
        System.out.println(r);
    }
}
