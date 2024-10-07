import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {
    private String name;
    public Board board;
    public List<Ship> ships;

    public Player(String name) {
        this.name = name;
        this.board = new Board();
        this.ships = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void placeShips() {
        int[] shipLengths = {4, 3, 3, 2, 2, 2, 1, 1, 1, 1};
        for (int length : shipLengths) {
            placeShip(length);
        }
    }

    private void placeShip(int length) {
        boolean placed = false;
        while (!placed) {
            int row = (int) (Math.random() * 10);
            int col = (int) (Math.random() * 10);
            boolean isVertical = Math.random() < 0.5;
            Ship ship = new Ship(row, col, length, isVertical);
            if (board.isValidPlacement(ship)) {
                board.placeShip(ship);
                ships.add(ship);
                placed = true;
            }
        }
    }

    public void takeTurn(Player opponent, Scanner scanner) {
        System.out.println("Ваше поле:");
        board.printBoard();
        System.out.println("Поле противника:");
        opponent.board.printBoard();

        System.out.print("Введите координаты выстрела (строка столбец): ");
        int row = scanner.nextInt();
        int col = scanner.nextInt();

        if (opponent.board.shoot(row, col)) {
            System.out.println("Попадание!");
            for (Ship ship : opponent.ships) {
                if (opponent.board.isShipSunk(ship)) {
                    System.out.println("Корабль потоплен!");
                }
            }
        } else {
            System.out.println("Промах!");
        }
    }

    public boolean allShipsSunk() {
        for (Ship ship : ships) {
            if (!board.isShipSunk(ship)) {
                return false;
            }
        }
        return true;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }
}