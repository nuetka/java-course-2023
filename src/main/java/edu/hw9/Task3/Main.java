package edu.hw9.Task3;

public class Main {
    public static void main(String[] args) {
        char[][] maze = {
            {'S', '.', '.', '#', '.', '#', '#'},
            {'#', '#', '.', '#', '.', '#', '#'},
            {'#', '.', '.', '.', '.', '.', '#'},
            {'#', '#', '#', '#', '#', '.', '#'},
            {'#', '#', '#', '#', '#', '.', 'E'}
        };

        MazeSolver mazeSolver = new MazeSolver(maze);
        boolean isPathFound = mazeSolver.solve();

        if (isPathFound) {
            System.out.println("Path found!");
            for (char[] row : maze) {
                for (char cell : row) {
                    System.out.print(cell + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("No path found.");
        }
    }
}
