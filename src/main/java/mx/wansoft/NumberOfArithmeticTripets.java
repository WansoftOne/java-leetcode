package mx.wansoft;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 
    You are given a 0-indexed, strictly increasing integer array nums and a positive integer diff. A triplet (i, j, k) is an arithmetic triplet if the following conditions are met:

    i < j < k,
    nums[j] - nums[i] == diff, and
    nums[k] - nums[j] == diff.
    Return the number of unique arithmetic triplets.

    Input: nums = [0,1,4,6,7,10], diff = 3
    Output: 2
    Explanation:
    (1, 2, 4) is an arithmetic triplet because both 7 - 4 == 3 and 4 - 1 == 3.
    (2, 4, 5) is an arithmetic triplet because both 10 - 7 == 3 and 7 - 4 == 3. 

    Input: nums = [4,5,6,7,8,9], diff = 2
    Output: 2
    Explanation:
    (0, 2, 4) is an arithmetic triplet because both 8 - 6 == 2 and 6 - 4 == 2.
    (1, 3, 5) is an arithmetic triplet because both 9 - 7 == 2 and 7 - 5 == 2.

    */
public class NumberOfArithmeticTripets {
    class Solution {
        public int arithmeticTriplets(int[] nums, int diff) {
            int triplets = 0;
            Set<Integer> values = new HashSet<Integer>(
                Arrays.stream(nums).boxed().collect(Collectors.toList())
            );

            System.out.println(Objects.toString(values));

            for (int num : nums) {
                int j = num + 3;
                int k = j + 3;
                if (values.contains(j) && values.contains(k)) {
                    triplets++;
                }
            }

            return triplets;
        }
    }
}
