public class Board {
    private static final int SIZE = 10;
    private char[][] grid;

    public Board() {
        grid = new char[SIZE][SIZE];
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                grid[i][j] = '-';
            }
        }
    }

    public void placeShip(Ship ship) {
        for (int i = 0; i < ship.getLength(); i++) {
            if (ship.isVertical()) {
                grid[ship.getRow() + i][ship.getCol()] = 'S';
            } else {
                grid[ship.getRow()][ship.getCol() + i] = 'S';
            }
        }
    }

    public boolean isValidPlacement(Ship ship) {
        for (int i = 0; i < ship.getLength(); i++) {
            if (ship.isVertical()) {
                if (ship.getRow() + i >= SIZE || grid[ship.getRow() + i][ship.getCol()] != '-') {
                    return false;
                }
            } else {
                if (ship.getCol() + i >= SIZE || grid[ship.getRow()][ship.getCol() + i] != '-') {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean shoot(int row, int col) {
        if (grid[row][col] == 'S') {
            grid[row][col] = 'X';
            return true;
        } else if (grid[row][col] == '-') {
            grid[row][col] = 'O';
        }
        return false;
    }

    public boolean isShipSunk(Ship ship) {
        for (int i = 0; i < ship.getLength(); i++) {
            if (ship.isVertical()) {
                if (grid[ship.getRow() + i][ship.getCol()] != 'X') {
                    return false;
                }
            } else {
                if (grid[ship.getRow()][ship.getCol() + i] != 'X') {
                    return false;
                }
            }
        }
        return true;
    }

    public void printBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}