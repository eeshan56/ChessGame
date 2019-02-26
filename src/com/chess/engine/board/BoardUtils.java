package com.chess.engine.board;

public class BoardUtils {

    public static boolean[] FIRST_COLUMN = initColumn(0);
    public static boolean[] SECOND_COLUMN = initColumn(1);
    public static boolean[] SEVENTH_COLUMN = initColumn(6);
    public static boolean[] EIGHTH_COLUMN = initColumn(7);

    public static final int NUM_TILES = 64;
    public static final int NUM_TILES_PER_ROW = 8;

    public static final boolean[] SECOND_ROW = null;
    public static final boolean[] SEVENTH_ROW = null;

    private static boolean[] initColumn(int columnNumber) {

        final boolean column[] = new boolean [NUM_TILES];

        do {

            column[columnNumber] = true;
            columnNumber += NUM_TILES_PER_ROW;

        }while (columnNumber < NUM_TILES);

        return column;
    }

    private BoardUtils() {
        throw new RuntimeException("You cannot instantiate me!");
    }

    public static boolean isValidTileCoordinate(int candidateDestinationCoordinate) {

        return candidateDestinationCoordinate >= 0 && candidateDestinationCoordinate < NUM_TILES;
    }

}