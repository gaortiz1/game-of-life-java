package com.github.jkratz55.gameoflife;

public class GameOfLife {

    public static void main(String[] args) {

        Grid grid = new Grid();
        int[][] currentGen = grid.currentGeneration();
        int[][] nextGen = grid.nextGeneration();
        System.out.println("Current Generation");
        printResults(currentGen);
        System.out.println("Next Generation");
        printResults(nextGen);
    }

    private static void printResults(int[][] results) {
        for (int i=0; i<results.length; i++) {
            for (int j=0; j<results[i].length; j++) {
                if (results[i][j] == 0) {
                    System.out.print(".");
                } else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }
}
