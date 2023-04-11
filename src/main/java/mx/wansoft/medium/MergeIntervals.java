package mx.wansoft.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * Given an array of intervals where intervals[i] = [starti, endi], merge all
 * overlapping intervals, and return an array of the non-overlapping intervals
 * that cover all the intervals in the input.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
 * 
 * Example 2:
 * 
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 * 
 * 
 * 
 * Constraints:
 * 
 * 1 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 104
 * 
 * 
 */
public class MergeIntervals {
    public static void main(String[] args) {
        int[][] input = new int[][] {
            new int[] {1,3},
            new int[] {2,6},
            new int[] {8,10},
            new int[] {15,18}
        };
        Solution s = new Solution();
        final int[][] result = s.merge(input);
        Arrays.stream(result).forEach(interval -> {
            System.out.println(Arrays.toString(interval));
        });
    }
    static class Solution {
        public int[][] merge(int[][] intervals) {
            Integer[] starList = new Integer[10000];
            Integer[] endList = new Integer[10000];
            
            for (int[] interval: intervals) {
                starList[interval[0]] = interval[0];
                endList[interval[1]] = interval[1];
            }
            

            List<int[]> mergedIntervals = new ArrayList<>();
            int[] interval = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
            for (int i=0; i < 10000; i++) {
                Integer start = starList[i], end = endList[i];
                if (start != null) {
                    // we should try to set start
                    if (start < interval[0]) {
                        interval[0] = start;
                    } else if (start > interval[1] && interval[0] > 0 && interval[1] > 0) {
                        mergedIntervals.add(interval);
                        interval = new int[] {start, Integer.MAX_VALUE};
                    } 
                }
                if (end != null) {
                    // We should try to set end
                    interval[1] = end;
                }
            }

            if (interval[0] > -1 && interval[1] > -1) {
                mergedIntervals.add(interval);
            }
            return mergedIntervals.toArray(new int[][] {});
            
            // List<int[]> mergedIntervals = new ArrayList<>();
            // Queue<Integer> startValues = new LinkedList<>(Arrays.stream(starList).filter(v -> v > 0).boxed().collect(Collectors.toList()));
            // Queue<Integer> endValues = new LinkedList<>(Arrays.stream(endList).filter(v -> v > 0).boxed().collect(Collectors.toList()));

            // int[] interval = new int[] {0, 0};
            // while(!endValues.isEmpty()) {
            //     int start = startValues.remove();
            //     int end = endValues.remove();
            //     if (start > interval[1]) {
            //         if (interval[0] != 0 && interval[1] != 0) {
            //             mergedIntervals.add(interval);
            //         }
            //         interval = new int[] {start, end};
            //     } else {
            //         interval[1] = end;
            //     }
            // }

            // if (interval[0] != 0 && interval[1] != 0) {
            //     mergedIntervals.add(interval);
            // }
            
            // return mergedIntervals.toArray(new int[][] {});

            // mergedIntervals.add(intervals[0]);
            // for (int i=1; i<intervals.length; i++) {
            //     int[] last = mergedIntervals.get(mergedIntervals.size() - 1);
            //     int[] interval = intervals[i];
            //     if (last[1] < interval[0]) {
            //         mergedIntervals.add(interval);
            //     } else if (interval[0] == last[1]) {
            //         last[1] = interval[1];
            //     } else {
            //         last[0] = Math.min(interval[0], last[0]);
            //         last[1] = Math.max(interval[1], last[1]);
            //     }
            // }
        }
    }
}
