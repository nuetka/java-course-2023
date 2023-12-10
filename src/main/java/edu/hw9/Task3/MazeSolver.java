package edu.hw9.Task3;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

class MazeSolver {
    private final char[][] maze;
    private final int rows;
    private final int cols;

    MazeSolver(char[][] maze) {
        this.maze = maze;
        this.rows = maze.length;
        this.cols = maze[0].length;
    }

    public boolean solve() {
        ForkJoinPool pool = new ForkJoinPool();
        return pool.invoke(new MazeTask(0, 0));
    }

    private class MazeTask extends RecursiveTask<Boolean> {
        private final int row;
        private final int col;

        MazeTask(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        protected Boolean compute() {
            // Check if the current cell is outside the maze
            if (row < 0 || col < 0 || row >= rows || col >= cols) {
                return false;
            }

            // Check if the current cell is the exit
            if (maze[row][col] == 'E') {
                return true;
            }

            // Check if the current cell is a wall or already visited
            if (maze[row][col] == '#' || maze[row][col] == 'V') {
                return false;
            }

            // Mark the current cell as visited
            maze[row][col] = 'V';

            // Define the neighboring cells as tasks
            MazeTask upTask = new MazeTask(row - 1, col);
            MazeTask downTask = new MazeTask(row + 1, col);
            MazeTask leftTask = new MazeTask(row, col - 1);
            MazeTask rightTask = new MazeTask(row, col + 1);

            // Fork the tasks in parallel
            invokeAll(upTask, downTask, leftTask, rightTask);

            // Join the results of the tasks
            boolean result = upTask.join() || downTask.join() || leftTask.join() || rightTask.join();

            // If the result is true, mark the current cell as part of the solution path
            if (result) {
                maze[row][col] = 'X';
            }

            return result;
        }
    }
}
