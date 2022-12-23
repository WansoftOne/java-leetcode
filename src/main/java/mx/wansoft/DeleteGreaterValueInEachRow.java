package mx.wansoft;

import java.util.Arrays;

public class DeleteGreaterValueInEachRow {
    class Solution {
        public int deleteGreatestValue(int[][] grid) { 
            for (int i=0; i < grid.length; i++) {
                Arrays.sort(grid[i]);
            }

            int answer = 0;
            if (grid.length > 0) {
                for (int column=0; column < grid[0].length; column++) {
                    int max = Integer.MIN_VALUE;
                    for (int row=0; row < grid.length; row++) {
                        if (grid[row][column] > max) {
                            max = grid[row][column];
                        }
                    }
                    answer += max;
                }
            }
            
            return answer;
        }
    }
}
