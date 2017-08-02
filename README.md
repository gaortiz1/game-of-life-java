# Game of Life Java
Conway’s Game Of Life implementation in Java

## Summary

A simple console implemenation of Conway's Game of Life. The application takes an initial state or generates a random initial state, then proceeds to calculate the next state.

### Basic Rules

1. Any live cell with fewer than two live neighbours dies (referred to as underpopulation or exposure[1]).
2. Any live cell with more than three live neighbours dies (referred to as overpopulation or overcrowding).
3. Any live cell with two or three live neighbours lives, unchanged, to the next generation.
4. Any dead cell with exactly three live neighbours will come to life.
