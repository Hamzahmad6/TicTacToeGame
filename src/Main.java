import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        char[][] board = {
                {'1','2','3'},
                {'4','5','6'},
                {'7','8','9'}
        };

        Scanner sc = new Scanner(System.in);
        int moveCount = 0;
        char currentPlayer;

        printBoard(board);

        while (true) {
            currentPlayer = (moveCount % 2 == 0) ? 'X' : 'O';
            System.out.print("Player " + currentPlayer + ", enter your move (1-9): ");

            String input = sc.next();
            if (input.length() != 1 || !Character.isDigit(input.charAt(0))) {
                System.out.println("❌ Invalid input. Please enter a number from 1 to 9.");
                continue;
            }

            char move = input.charAt(0);
            if (!makeMove(board, move, currentPlayer)) {
                System.out.println("❌ Invalid move. That cell is already taken or does not exist.");
                continue;
            }

            moveCount++;
            printBoard(board);

            if (checkWinner(board, currentPlayer)) {
                System.out.println("🎉 Congratulations! Player " + currentPlayer + " wins!");
                break;
            }

            if (moveCount == 9) {
                System.out.println("🤝 It's a draw!");
                break;
            }
        }

        sc.close();
    }

    // Prints the game board
    public static void printBoard(char[][] board) {
        System.out.println();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(" " + board[i][j] + " ");
                if (j < 2) System.out.print("|");
            }
            System.out.println();
            if (i < 2) System.out.println("---+---+---");
        }
        System.out.println();
    }

    // Makes a move if valid and returns true, else returns false
    public static boolean makeMove(char[][] board, char move, char player) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == move) {
                    board[i][j] = player;
                    return true;
                }
            }
        }
        return false;
    }

    // Checks all winning conditions
    public static boolean checkWinner(char[][] b, char p) {
        // Rows, columns, and diagonals
        return (b[0][0] == p && b[0][1] == p && b[0][2] == p) ||
               (b[1][0] == p && b[1][1] == p && b[1][2] == p) ||
               (b[2][0] == p && b[2][1] == p && b[2][2] == p) ||
               (b[0][0] == p && b[1][0] == p && b[2][0] == p) ||
               (b[0][1] == p && b[1][1] == p && b[2][1] == p) ||
               (b[0][2] == p && b[1][2] == p && b[2][2] == p) ||
               (b[0][0] == p && b[1][1] == p && b[2][2] == p) ||
               (b[0][2] == p && b[1][1] == p && b[2][0] == p);
    }
}
