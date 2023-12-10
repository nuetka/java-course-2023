package edu.hw9.Task3;

import lombok.extern.java.Log;

@Log
public class Main {

    private Main() {

    }

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
            log.info("Path found!\n");
            for (char[] row : maze) {
                for (char cell : row) {
                    log.info(cell + " \n");
                }
                log.info("\n");
            }
        } else {
            log.info("No path found.\n");
        }
    }
}
