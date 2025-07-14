import com.sun.nio.sctp.MessageInfo;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char[][] game = {
                {'1','2','3'},
                {'4','5','6'},
                {'7','8','9'}
        };

        int counter = 1;
        Scanner sc = new Scanner(System.in);
        printGame(game);

        while (true) {
            char player;
            if (counter % 2 == 1) {
                player = 'X';
            } else {
                player = 'O';
            }

            System.out.println("Player " + player + ", what is your next move?");
            char move = sc.next().charAt(0);
            boolean moveDone = false;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (game[i][j] == move) {
                        game[i][j] = player;
                        moveDone = true;
                    }
                }
            }

            if (!moveDone) {
                System.out.println("Invalid move. Try again.");
                continue;
            }

            printGame(game);

            if (checkWinner(game, player)) {
                System.out.println("🎉 Congratulations, Player " + player + " won the game!");
                break;
            }

            if (counter == 9) {
                System.out.println("It's a draw! No winner.");
                break;
            }

            counter++;
        }
    }

    public static void printGame(char[][] game) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(" " + game[i][j] + " ");
                if (j < 2) {
                    System.out.print("|");
                }
            }
            System.out.println();
        }
    }

    public static boolean checkWinner(char[][] g, char p) {
        if (g[0][0] == p && g[0][1] == p && g[0][2] == p) return true;
        if (g[1][0] == p && g[1][1] == p && g[1][2] == p) return true;
        if (g[2][0] == p && g[2][1] == p && g[2][2] == p) return true;

        if (g[0][0] == p && g[1][0] == p && g[2][0] == p) return true;
        if (g[0][1] == p && g[1][1] == p && g[2][1] == p) return true;
        if (g[0][2] == p && g[1][2] == p && g[2][2] == p) return true;

        if (g[0][0] == p && g[1][1] == p && g[2][2] == p) return true;
        if (g[0][2] == p && g[1][1] == p && g[2][0] == p) return true;

        return false;
    }
}
