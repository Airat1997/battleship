import java.util.Scanner;

public class ComputerPlayer extends Player {
    public ComputerPlayer(String name) {
        super(name);
    }

    @Override
    public void takeTurn(Player opponent, Scanner scanner) {
        System.out.println("Ваше поле:");
        getBoard().printBoard();
        System.out.println("Поле противника:");
        opponent.getBoard().printOpponentBoard();

        int row, col;
        do {
            row = (int) (Math.random() * 10);
            col = (int) (Math.random() * 10);
        } while (opponent.getBoard().shoot(row, col));

        System.out.println("Компьютер стреляет в " + row + ", " + col);

        if (opponent.getBoard().shoot(row, col)) {
            System.out.println("Попадание!");
            for (Ship ship : opponent.ships) {
                if (opponent.getBoard().isShipSunk(ship)) {
                    System.out.println("Корабль потоплен!");
                }
            }
        } else {
            System.out.println("Промах!");
        }
    }
}