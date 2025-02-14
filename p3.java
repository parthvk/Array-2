// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    public void gameOfLife(int[][] board) {

        // 0 -> 1 change it to 2
        // 1 -> 0 change it to 3

        int m = board.length;
        int n = board[0].length;

        // Traversing through the matrix and getting number of live cells
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Get live neighbors
                int l = live(board, i, j);

                // Changing the state of the cell based on neighboring cell
                if (board[i][j] == 1 && (l < 2 || l > 3)) {
                    board[i][j] = 3;
                }

                if (board[i][j] == 0 && l == 3) {
                    board[i][j] = 2;
                }
            }

        }

        // Changing temporary state to permanent state
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 1;
                }

                if (board[i][j] == 3) {
                    board[i][j] = 0;
                }
            }
        }
    }

    // Getting live cells around the current cell
    public int live(int[][] board, int i, int j) {

        // Direction array
        int[][] dir = new int[][] { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 },
                { 1, 1 } };

        int count = 0;

        // Traversing all the direction
        for (int m = 0; m < dir.length; m++) {
            int k = i + dir[m][0];
            int l = j + dir[m][1];

            // Removing edge cases
            if (k >= 0 && k < board.length && l >= 0 && l < board[0].length && (board[k][l] == 1 || board[k][l] == 3)) {
                count++;
            }
        }

        return count;

    }
}
