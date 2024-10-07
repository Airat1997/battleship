import java.util.Scanner;

public class ComputerPlayer extends Player {
    public ComputerPlayer(String name) {
        super(name);
    }

    @Override
    public void takeTurn(Player opponent, Scanner scanner) {
        System.out.println("Ваше поле:");
        board.printBoard();
        System.out.println("Поле противника:");
        opponent.board.printBoard();

        int row, col;
        do {
            row = (int) (Math.random() * 10);
            col = (int) (Math.random() * 10);
        } while (opponent.board.shoot(row, col));

        System.out.println("Компьютер стреляет в " + row + ", " + col);

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
}