package mx.wansoft;

import java.util.Arrays;

/**
 * 
    Given an array of positive integers arr, return the sum of all possible odd-length subarrays of arr.

    A subarray is a contiguous subsequence of the array.

    Input: arr = [1,4,2,5,3]
    Output: 58
    Explanation: The odd-length subarrays of arr and their sums are:
    [1] = 1
    [4] = 4
    [2] = 2
    [5] = 5
    [3] = 3
    [1,4,2] = 7
    [4,2,5] = 11
    [2,5,3] = 10
    [1,4,2,5,3] = 15
    If we add all these together we get 1 + 4 + 2 + 5 + 3 + 7 + 11 + 10 + 15 = 58

    Input: arr = [1,2]
    Output: 3
    Explanation: There are only 2 subarrays of odd length, [1] and [2]. Their sum is 3.

    Input: arr = [10,11,12]
    Output: 66

 */
public class SumOfAllOddLengthSubarrays {
    class Solution {
        public int sumOddLengthSubarrays(int[] arr) {
            int sum = Arrays.stream(arr).sum();
            for (int i=2; i < arr.length; i += 2) {
                sum += sum(arr, 0, i);
            }
            
            return sum;
        }

        public int sum(int[] arr, int startIndex, int endIndex) {
            int[] subArray = Arrays.copyOfRange(arr, startIndex, endIndex);
            int result = Arrays.stream(subArray).sum();   
            if (endIndex == arr.length -1) {
                return result;
            }

            return result + sum(arr, startIndex + 1, endIndex + 1);
        }
    }
}
