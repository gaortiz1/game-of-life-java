package com.github.jkratz55.gameoflife;

public class Grid {

    private static int DEFAULT_WIDTH = 8;
    private static int DEFAULT_HEIGHT = 7;

    private int[][] grid;

    /**
     * Constructor that creates a random state
     */
    public Grid() {
        grid = new int[DEFAULT_WIDTH][DEFAULT_HEIGHT];
        for (int i=0; i<DEFAULT_WIDTH; i++) {
            for (int j=0; j<DEFAULT_HEIGHT; j++) {
                grid[i][j] = (int) Math.round(Math.random());
            }
        }
    }

    /**
     * Constructor allowing for initial state to be passed in.
     *
     * @param grid Two dimensional array of state to start with
     * @throws IllegalArgumentException
     */
    public Grid(int[][] grid) {
        if (isJagged(grid)) {
            throw new IllegalArgumentException("Arrays passed in cannot be jagged");
        }
        this.grid = grid;
    }

    /**
     * Returns the current generation
     *
     * @return Returns two dimensional array representing current state
     */
    public int[][] currentGeneration() {

        return this.grid;
    }

    /**
     * Returns the next generation
     *
     * @return Returns two dimensional array representing next state
     */
    public int[][] nextGeneration() {

        int[][] futureGeneration = new int[grid.length][grid[0].length];
        int rows = grid.length;
        int columns = grid[0].length;

        // iterate through two dimensional array
        for (int i=0; i<rows; i++) {
            for(int j=0; j<columns; j++) {

                // count of living neighbors
                int liveCount = 0;

                // calculate how many living
                for (int x=-1; x<=1; x++) {
                    for (int y = -1; y <= 1; y++) {
                        // check for boundary conditions
                        if (i + x < 0 || i + x > (rows - 1) || y + j < 0 || y + j > (columns - 1)) {
                            continue;
                        }
                        liveCount += grid[i + x][y + j];
                    }
                }

                // remove since we may have counted ourselves
                liveCount -= grid[i][j];

                /**
                 * Cell is lonely with less than two live neighbors and dies
                 */
                if ((grid[i][j] == 1) && (liveCount < 2)) {
                    futureGeneration[i][j] = 0;
                }

                /**
                 * Cell is overcrowded and dies
                 */
                else if ((grid[i][j] == 1) && liveCount > 3) {
                    futureGeneration[i][j] = 0;
                }

                /**
                 * Cell is dead but 3 lives neighbors causes it to be born
                 */
                else if (grid[i][j] == 0 && liveCount == 3) {
                    futureGeneration[i][j] = 1;
                }

                /**
                 * Nothing changes so copy that state
                 */
                else {
                    futureGeneration[i][j] = grid[i][j];
                }
            }
        }

        return futureGeneration;
    }

    /**
     * Determines if array is jagged.
     *
     * @param array Array to test if jagged
     * @return True if jagged, otherwise false
     */
    private boolean isJagged(int[][] array) {
        boolean isJagged = false;

        if (array != null) {
            Integer length = null;
            for (int i=0; i<array.length; i++) {
                if(length == null) {
                    length = array[i].length;
                }
                else if (length.equals(array[i].length)) {
                    continue;
                }
                else {
                    isJagged = true;
                    break;
                }
            }
        }

        return isJagged;
    }
}
