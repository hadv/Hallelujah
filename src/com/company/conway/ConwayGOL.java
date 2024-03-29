package com.company.conway;

import java.util.HashMap;
import java.util.Map;

/**
 * Outline: Conway's Game Of Life
 * <p>
 *     The universe of the Game of Life is an infinite two-dimensional orthogonal grid of square cells,
 *     each of which is in one of two possible states, alive or dead.
 *     Every cell interacts with its eight neighbours, which are the cells
 *     that are horizontally, vertically, or diagonally adjacent.
 *     At each step in time, the following transitions occur:
 * <ol>
 *     <li>Any live cell with fewer than two live neighbours dies, as if caused by under-population.
 *     <li>Any live cell with two or three live neighbours lives on to the next generation.
 *     <li>Any live cell with more than three live neighbours dies, as if by over-population.
 *     <li>Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
 * </ol>
 * <p>
 *     The initial pattern constitutes the seed of the system.
 *     The first generation is created by applying the above rules simultaneously
 *     to every cell in the seed-births and deaths occur simultaneously,
 *     and the discrete moment at which this happens is sometimes called a tick
 *     (in other words, each generation is a pure function of the preceding one).
 *     The rules continue to be applied repeatedly to create further generations.
 *
 * @author Dang Viet Ha (dvietha@gmail.com)
 */
public class ConwayGOL {
    /**
     * Running Game Of Life demo with some seed pattern.
     *
     * @param args input arguments for the program
     */
    public static void main(String[] args) {
        // Glider
        final byte gliderSeed[][] = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0},
                {0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        // Initialize the Game Of Life with a given seed
        ConwayGameOfLife life = new ConwayGameOfLife(gliderSeed);

        while (true) {
            // Print out the current state of the system
            System.out.println(life.toString());

            // Transition to the next generation by applying the rule
            life.evolve();

            // Do nothing but delay program some seconds to see the result of each step time.
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

/**
 *
 */
class ConwayGameOfLife {
    // Storing state of the current generation system
    private Map<Point, Byte> currentGeneration;

    // The constant 1 value to present the live cell
    private static final byte LIVE_CELL_VAL = 1;

    // Eight neighbours
    private static final byte[][] NEIGHBOUR_CELL = {
            {-1, -1}, // NW
            {-1,  0}, // N
            {-1,  1}, // NE
            { 0, -1}, // W
            { 0,  1}, // E
            { 1, -1}, // SW
            { 1,  0}, // S
            { 1,  1}  // SE
    };

    private int horizontal;

    private int vertical;

    /**
     * Initialize the current state of the system with a given seed.
     *
     * @param seedOfTheSystem seed of the system
     * @throws UnsupportedOperationException throw {@link UnsupportedOperationException}
     * if the input {@code null} value for {@code seedOfTheSystem}
     */
    public ConwayGameOfLife(final byte[][] seedOfTheSystem) {
        if (seedOfTheSystem == null || seedOfTheSystem.length == 0) {
            throw new UnsupportedOperationException();
        }

        initSystemState(seedOfTheSystem);
    }

    /**
     * <p>Transition to the next generation by applying the Conway's Game Of Life rule.
     * <ol>
     *     <li>Any live cell with fewer than two live neighbours dies, as if caused by under-population.
     *     <li>Any live cell with two or three live neighbours lives on to the next generation.
     *     <li>Any live cell with more than three live neighbours dies, as if by overcrowding.
     *     <li>Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
     * </ol>
     */
    public void evolve() {
        Map<Point, Byte> tempGeneration = new HashMap<Point, Byte>();
        // At each step time, looping all live cells in the current generation to evolve
        for (Point p : currentGeneration.keySet()) {
            byte liveCellNeighbours = countLiveNeighbourCells(p);

            // Any live cell with fewer than two live neighbours dies, as if caused by under-population.
            // Any live cell with more than three live neighbours dies, as if by overcrowding.
            if (liveCellNeighbours < 2 || liveCellNeighbours > 3)
                tempGeneration.remove(p);
            else // Any live cell with two or three live neighbours lives on to the next generation.
                tempGeneration.put(p, LIVE_CELL_VAL);

            // Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
            for (byte[] n : NEIGHBOUR_CELL) {
                Point pt = p.move(n);
                if (currentGeneration.get(pt) == null) {
                    if (countLiveNeighbourCells(pt) == 3) {
                        tempGeneration.put(pt, LIVE_CELL_VAL);
                    }
                }
            }
        }
        // Swap the next generation to the current generation for the next step time
        currentGeneration = tempGeneration;
    }

    /**
     * Count the live cell neighbours to given cell.
     *
     * @param point The position of the cell
     * @return The total number of live cell neighbours to the given position cell
     */
    private byte countLiveNeighbourCells(final Point point) {

        byte count = 0;

        for (byte[] n : NEIGHBOUR_CELL) {
            if (currentGeneration.get(point.move(n)) != null) {
                count++;
            }
        }
        return count;
    }

    /**
     * Set the current state of the system from given seed.
     *
     * @param seed seed of the system
     */
    private void initSystemState(final byte[][] seed) {
        vertical = seed.length;
        if (vertical < 1) {
            throw new IllegalArgumentException();
        }

        horizontal = seed[0].length;
        if (horizontal < 1) {
            throw new IllegalArgumentException();
        }

        currentGeneration = new HashMap<Point, Byte>();
        for (int i = 0; i < vertical; i++) {
            for (int j = 0; j < horizontal; j++) {
                if (seed[i][j] == 1) {
                    currentGeneration.put(new Point(i, j), LIVE_CELL_VAL);
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < vertical; i++) {
            for (int j = 0; j < horizontal; j++) {
                Point p = new Point(i, j);
                if (currentGeneration.get(p) != null) {
                    // Present the live cell by black square character
                    builder.append("◾");
                } else {
                    // Present the dead cell by white square character
                    builder.append("◽");
                }
            }
            builder.append("\n");
        }
        return builder.toString();
    }
}

/**
 *
 */
class Point {
    private int x;

    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point move(final byte[] step) {
        return new Point(x + step[0], y + step[1]);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point point = (Point) o;

        if (x != point.x) return false;
        if (y != point.y) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}
