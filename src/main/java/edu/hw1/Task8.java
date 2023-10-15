package edu.hw1;

public class Task8 {
    public static boolean knightBoardCapture(int[][] board) {
        int[][] moves = { {-2, -1}, {-1, -2}, {1, -2}, {2, -1}, {2, 1}, {1, 2}, {-1, 2}, {-2, 1} };

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 1) {
                    for (int[] move : moves) {
                        int newRow = i + move[0];
                        int newCol = j + move[1];
                        if (isValidMove(newRow, newCol) && board[newRow][newCol] == 1) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }

    private static boolean isValidMove(int row, int col) {
        return row >= 0 && row < 8 && col >= 0 && col < 8;
    }
}
