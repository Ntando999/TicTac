package tictac;
import java.util.Scanner;

public class TicTac {
    public static void main(String[] args) {
        int[][] board = new int[3][3];
        int player = 1;
        Scanner scanner = new Scanner(System.in);

        while (true) {printBoard(board);
            System.out.println("Player " + player + ", enter row and column (0, 1, 2):");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (!isValidMove(board, row, col)) {
                System.out.println("Try again.");
                continue;
       }
            board[row][col] = player;

            if (checkWin(board, player)) {printBoard(board);
        System.out.println("Player " + player + " wins!");
                break;
            }

            if (isBoardFull(board)) {printBoard(board);
                System.out.println("It's a draw!");
                break;
            }

            player = 3 - player;
        }

        scanner.close();
    }

    static void printBoard(int[][] board) {
        for (int[] row : board) {
            for (int cell : row) { 
                System.out.print(cell == 0 ? "_ " : (cell == 1 ? "X " : "O "));
  }
            System.out.println();
        }
}

    static boolean isValidMove(int[][] board, int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == 0;
    }

    static boolean checkWin(int[][] board, int player) {
        int[] winCon = new int[8];
        for (int i = 0; i < 3; i++) {
            winCon[i] = board[i][0] + board[i][1] + board[i][2];
            winCon[i + 3] = board[0][i] + board[1][i] + board[2][i];
        }
        winCon[6] = board[0][0] + board[1][1] + board[2][2];
        winCon[7] = board[0][2] + board[1][1] + board[2][0];
        int winSum = player * 3;
        for (int sum : winCon) {
            if (sum == winSum) return true;
        }
        return false;
    }

    static boolean isBoardFull(int[][] board) {
        for (int[] row : board) {
            for (int cell : row) {
                if (cell == 0) return false;
            }
        }
        return true;
}
}

