import java.util.Scanner;
public class TicTacToe {
        public static void main(String[] args) {
            char[][] board = new char[3][3];
            for (int row = 0; row < board.length; row++) {
                for (int col = 0; col < board[row].length; col++) {
                    board[row][col] = ' ';
                }
            }

            //concept
        /*
        - The player is either 'X' or 'O'
        -Now we need to think how we are going to take input
        - 'X' and 'O' need to play alternatively
        - this continues till the game doesn't end
        - The game ends when the characters in wither diagonal, row or col are same


        - so will basically have a 2-D array which is empty and have a variable lets say the current player

        */
            char player = 'X';
            boolean gameOver = false;
            Scanner scanner = new Scanner(System.in);

        //firstly need to print the board, so we know where to place the char


            while (!gameOver) {
                printBoard(board);
                System.out.print("Player " + player + " enter: ");
                int row = scanner.nextInt();
                int col = scanner.nextInt();
                System.out.println();

                if (board[row][col] == ' ') {
                    //we are checking where to put the variable and whether the place is already occupied
                    board[row][col] = player; //Placing X or O
                    gameOver = haveWon(board, player);
                    if (gameOver) {
                        System.out.println("Player " + player + " has won: ");
                    } else {
                        // if (player == 'X') {
                        // player = 'O';
                        // } else {
                        // player = 'X';
                        // }
                        player = (player == 'X') ? 'O' : 'X';
                    }
                } else {
                    System.out.println("Invalid move. Try again!");
                }
            }
            printBoard(board);
        }

        public static boolean haveWon(char[][] board, char player) {

            //How are we going to decide who has won?
        /*
        -You have to check the row, col and diagonal
        -So first we will check the rows for the same character
        - if not found then check the col
        - Lastly check the diagonal
         */

            // check the rows
            for (int row = 0; row < board.length; row++) {
                if (board[row][0] == player && board[row][1] == player && board[row][2] == player) {
                    //row keeps changing, but we are having it for every single col
                    return true;
                }
            }

            // check for col
            for (int col = 0; col < board[0].length; col++) {
                if (board[0][col] == player && board[1][col] == player && board[2][col] == player) {
                    return true;
                }
            }

            // diagonal
            if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
                return true;
            }

            if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
                return true;
            }
            return false;
        }

        public static void printBoard(char[][] board) {
            //Creating the board
            for (int row = 0; row < board.length; row++) {
                for (int col = 0; col < board[row].length; col++) {
                    System.out.print(board[row][col] + " | ");
                }
                System.out.println();
                // New line only after evey row is printed
            }
        }
    }

