package mx.wansoft.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,2,3,6,9,8,7,4,5]
 * 
 * Example 2:
 * 
 * Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 * 
 * 
 * 
 * Constraints:
 * 
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 * 
 */
public class SpiralMatrix {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Integer> result = s.spiralOrder(new int[][]{
            new int[] {1,2,3},
            new int[] {4,5,6},
            new int[] {7,8,9}
        });
        System.out.println(Objects.toString(result));
    }

    static class Solution {
        List<Integer> ans = new ArrayList<>();

        public List<Integer> spiralOrder(int[][] matrix) {

            int[] i = new int[]{0, matrix.length - 1};
            int[] j = new int[]{0, matrix[0].length - 1};
            int[] position = new int[]{0, 0};
            walkThrough("RIGHT", position, i, j, matrix);
            ans.add(matrix[position[0]][position[1]]);
            return ans;
        }
        
        public void walkThrough(String direction, int[] position, int[] i, int[] j, int[][] matrix) {
            if("RIGHT".equals(direction)) {
                if (position[1] < j[1]) {
                    ans.add(matrix[position[0]][position[1]]);
                    position[1] += 1;
                    walkThrough(direction, position, i, j, matrix);
                } else if (position[0] < i[1]) {
                    i[0] += 1;
                    walkThrough("DOWN", position, i, j, matrix);
                }
            } else if ("DOWN".equals(direction)) {
                if (position[0] < i[1]) {
                    ans.add(matrix[position[0]][position[1]]);
                    position[0] += 1;
                    walkThrough(direction, position, i, j, matrix);
                } else if (position[1] > j[0]) {
                    j[1] -= 1;
                    walkThrough("LEFT", position, i, j, matrix);
                }
            } else if ("LEFT".equals(direction)) {
                if (position[1] > j[0]) {
                    ans.add(matrix[position[0]][position[1]]);
                    position[1] -= 1;
                    walkThrough(direction, position, i, j, matrix);
                } else if (position[0] > i[0]) {
                    i[1] -= 1;
                    walkThrough("UP", position, i, j, matrix);
                }
            } else if ("UP".equals(direction)) {
                if (position[0] > i[0]) {
                    ans.add(matrix[position[0]][position[1]]);
                    position[0] -= 1;
                    walkThrough(direction, position, i, j, matrix);
                } else if (position[1] < j[1]) {
                    j[0] += 1;
                    walkThrough("RIGHT", position, i, j, matrix);
                }
            }
            
        }
    }
}
