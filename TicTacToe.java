import java.util.Scanner;

class TicTacToe {
    public static void printBoard(char[][] board) {
        int n = board.length;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                System.out.print("[" + board[row][col] + "]");
            }
            System.out.println();
        }
    }

    public static boolean haveWon(char[][] board, char player) {
        int n = board.length;
        for (int row = 0; row < n; row++) {
            if (board[row][0] == player && board[row][1] == player && board[row][2] == player) {
                return true;
            }
        }
        for (int col = 0; col < n; col++) {
            if (board[0][col] == player && board[1][col] == player && board[2][col] == player) {
                return true;
            }
        }
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }
        return false;
    }

    public static boolean isBoardFull(char[][] board) {
        int n = board.length;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (board[row][col] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = new char[3][3];
        int n = board.length;

        // Initialize the board with spaces
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                board[row][col] = ' ';
            }
        }

        char player = 'X';
        boolean gameOver = false;

        Scanner scanner = new Scanner(System.in);

        while (!gameOver) {
            System.out.println();
            printBoard(board);
            System.out.println();
            System.out.println("Player "+player+" turn");
            System.out.print("Enter row and column (1-3): ");
            int row = scanner.nextInt() - 1; 
            int col = scanner.nextInt() - 1; 

            if (row >= 0 && row < n && col >= 0 && col < n && board[row][col] == ' ') {
                board[row][col] = player;
                if (haveWon(board, player)) {
                    System.out.println("Player " + player + " has won!");
                    printBoard(board);
                    gameOver = true;
                } else if (isBoardFull(board)) {       
                    System.out.println("The game is a draw!");
                    printBoard(board);
                    gameOver = true;
                } else {
                    player = (player == 'X') ? 'O' : 'X';
                }
            } else {
                System.out.println("Invalid move. Try again!");
            }
        }
        scanner.close();
    }
}
