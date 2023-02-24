package mx.wansoft.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be
 * validated according to the following rules:
 * 
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9
 * without repetition.
 * 
 * Note:
 * 
 * A Sudoku board (partially filled) could be valid but is not necessarily
 * solvable.
 * Only the filled cells need to be validated according to the mentioned rules.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: board =
 * [['5','3','.','.','7','.','.','.','.']
 * ,['6','.','.','1','9','5','.','.','.']
 * ,['.','9','8','.','.','.','.','6','.']
 * ,['8','.','.','.','6','.','.','.','3']
 * ,['4','.','.','8','.','3','.','.','1']
 * ,['7','.','.','.','2','.','.','.','6']
 * ,['.','6','.','.','.','.','2','8','.']
 * ,['.','.','.','4','1','9','.','.','5']
 * ,['.','.','.','.','8','.','.','7','9']]
 * Output: true
 * 
 * Example 2:
 * 
 * Input: board =
 * [['8','3','.','.','7','.','.','.','.']
 * ,['6','.','.','1','9','5','.','.','.']
 * ,['.','9','8','.','.','.','.','6','.']
 * ,['8','.','.','.','6','.','.','.','3']
 * ,['4','.','.','8','.','3','.','.','1']
 * ,['7','.','.','.','2','.','.','.','6']
 * ,['.','6','.','.','.','.','2','8','.']
 * ,['.','.','.','4','1','9','.','.','5']
 * ,['.','.','.','.','8','.','.','7','9']]
 * Output: false
 * Explanation: Same as Example 1, except with the 5 in the top left corner
 * being modified to 8. Since there are two 8's in the top left 3x3 sub-box, it
 * is invalid.
 * 
 * 
 * 
 * Constraints:
 * 
 * board.length == 9
 * board[i].length == 9
 * board[i][j] is a digit 1-9 or '.'.
 * 
 * 
 */
public class ValidSudoku {
    static class Solution {
        public boolean isValidSudoku(char[][] board) {
            for (int i=0; i < 9; i++) {
                for (int j=0; j < 9; j++) {
                    if (board[i][j] != '.') {
                        if (!isAxisValid(i, j, board)) {
                            return false;
                        }
                        if (!isValidSqure(i, j, board)) {
                            return false;
                        }
                    }
                }
            }
            return true;
        }

        public boolean isAxisValid(int xIndex, int yIndex, char[][]board) {
            Set<Character> chars = new HashSet<>();
            for (int i=0; i < 9; i++) {
                char item = board[xIndex][i];
                if( item != '.' && !chars.contains(item)) {
                    chars.add(item);
                } else {
                    return false;
                }
            }
            chars.clear();
            for (int i=0; i < 9; i++) {
                char item = board[i][yIndex];
                if( item != '.' && !chars.contains(item)) {
                    chars.add(item);
                } else {
                    return false;
                }
            }

            return true;
        }

        public boolean isValidSqure(int i, int j, char[][] board) {
            int[] xRange = getSquareRange(i);
            int[] yRange = getSquareRange(j);
            Set<Character> chars = new HashSet<>();
            for (int x= xRange[0]; i <= xRange[1]; i++) {
                for (int y = yRange[0]; y <= yRange[1]; y++) {
                    char item = board[x][y];
                    if( item != '.' && !chars.contains(item)) {
                        chars.add(item);
                    } else {
                        return false;
                    }
                }
            }
            return true;
        }

        public int[] getSquareRange(int index) {
            int[] square1 = new int[]{0, 2}, square2 = new int[]{3, 5}, square3 = new int[]{6, 8};
            if (index < 3) {
                return square1;
            } else if (index < 6) {
                return square2;
            } else {
                return square3;
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        boolean r = s.isValidSudoku(new char[][] {
            new char[]{'8','3','.','.','7','.','.','.','.'},
            new char[]{'6','.','.','1','9','5','.','.','.'},
            new char[]{'.','9','8','.','.','.','.','6','.'},
            new char[]{'8','.','.','.','6','.','.','.','3'},
            new char[]{'4','.','.','8','.','3','.','.','1'},
            new char[]{'7','.','.','.','2','.','.','.','6'},
            new char[]{'.','6','.','.','.','.','2','8','.'},
            new char[]{'.','.','.','4','1','9','.','.','5'},
            new char[]{'.','.','.','.','8','.','.','7','9'}
        });
        System.out.println(r);
    }
}
