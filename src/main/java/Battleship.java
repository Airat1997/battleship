import java.util.Scanner;

public class Battleship {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Player humanPlayer = new Player("Игрок");
        ComputerPlayer computerPlayer = new ComputerPlayer("Компьютер");

        humanPlayer.placeShips();
        computerPlayer.placeShips();

        boolean gameOver = false;
        Player currentPlayer = humanPlayer;
        Player opponent = computerPlayer;

        while (!gameOver) {
            System.out.println(currentPlayer.getName() + ", ваш ход:");
            currentPlayer.takeTurn(opponent, scanner);

            if (opponent.allShipsSunk()) {
                System.out.println(currentPlayer.getName() + " победил!");
                gameOver = true;
            }

            // Меняем игроков местами
            Player temp = currentPlayer;
            currentPlayer = opponent;
            opponent = temp;
        }

        scanner.close();
    }
}