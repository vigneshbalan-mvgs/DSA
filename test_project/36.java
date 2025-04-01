import java.util.HashSet;

class Solution {

  // 1. Using HashSet - Simple and Clean
  public boolean isValidSudokuUsingHashSet(char[][] board) {
    HashSet<String> seen = new HashSet<>();
    
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        char num = board[i][j];
        if (num != '.') {
          // Formulate unique keys for row, column, and block
          if (!seen.add(num + " in row " + i) ||
              !seen.add(num + " in col " + j) ||
              !seen.add(num + " in block " + (i / 3) + "-" + (j / 3))) {
            return false; // If already exists, invalid Sudoku
          }
        }
      }
    }
    return true;
  }

  // 2. Using Boolean Arrays - Efficient for Constant Space
  public boolean isValidSudokuUsingBooleanArray(char[][] board) {
    boolean[][] rows = new boolean[9][9];
    boolean[][] cols = new boolean[9][9];
    boolean[][] blocks = new boolean[9][9];
    
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        if (board[i][j] != '.') {
          int num = board[i][j] - '1'; // Convert char to 0-8 index
          int blockIndex = (i / 3) * 3 + (j / 3);

          // Check if number already exists in row, column, or block
          if (rows[i][num] || cols[j][num] || blocks[blockIndex][num]) {
            return false;
          }

          // Mark number as seen
          rows[i][num] = true;
          cols[j][num] = true;
          blocks[blockIndex][num] = true;
        }
      }
    }
    return true;
  }

  // 3. Using Bit Manipulation - Memory Optimized
  public boolean isValidSudokuUsingBits(char[][] board) {
    int[] rows = new int[9];
    int[] cols = new int[9];
    int[] blocks = new int[9];
    
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        if (board[i][j] != '.') {
          int num = board[i][j] - '1';
          int bit = 1 << num; // Create bit mask
          int blockIndex = (i / 3) * 3 + (j / 3);

          // Check bit in row, column, or block
          if ((rows[i] & bit) != 0 || (cols[j] & bit) != 0 || (blocks[blockIndex] & bit) != 0) {
            return false;
          }

          // Set bit using bitwise OR
          rows[i] |= bit;
          cols[j] |= bit;
          blocks[blockIndex] |= bit;
        }
      }
    }
    return true;
  }

  // Main method to test all three approaches
  public static void main(String[] args) {
    char[][] board = {
      {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
      {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
      {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
      {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
      {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
      {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
      {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
      {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
      {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
    };

    Solution solution = new Solution();
    System.out.println("Using HashSet: " + (solution.isValidSudokuUsingHashSet(board) ? "Valid" : "Invalid"));
    System.out.println("Using Boolean Array: " + (solution.isValidSudokuUsingBooleanArray(board) ? "Valid" : "Invalid"));
    System.out.println("Using Bit Manipulation: " + (solution.isValidSudokuUsingBits(board) ? "Valid" : "Invalid"));
  }
}
