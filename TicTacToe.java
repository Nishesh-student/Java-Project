package Project.TicTacToe;

import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        char[][] board = new char[3][3];
        for(int row = 0;row< board.length;row++)
        {
            for (int col = 0; col<board[row].length  ; col++) {
                board[row][col] = ' ';
            }
        }
        boolean gameOver = false;
        char player = 'X';
        int row,col;
        Scanner sc = new Scanner(System.in);
        while(!gameOver){
            printBoard(board);
            System.out.println("Player "+player+" enter");
            row = sc.nextInt();
            col = sc.nextInt();
            if(board[row][col]==' '){
                board[row][col] = player;
                gameOver = hasWon(board,player);
                if (gameOver){
                    printBoard(board);
                    System.out.println("Player "+player+" has Won");
                }
                else{
                    if (player=='X'){
                        player = 'O';
                    }
                    else{
                        player = 'X';
                    }

                }
            }
            else{
                System.out.println("Invalid coordinates");
            }
        }
    }
    private static void printBoard(char[][] board){
        for(int row = 0;row< board.length;row++)
        {
            for (int col = 0; col<board[row].length  ; col++) {
                System.out.print("|"+board[row][col]+"|");
            }
            System.out.println();
        }

    }
    private static boolean hasWon(char[][] board ,char player){
        //check for row
        for (int row = 0; row < board.length; row++) {
            if (board[row][0]==player && board[row][1]==player && board[row][2]==player){
                return true;
            }
        }

        //check for col
        for (int col = 0; col < board.length; col++) {
            if(board[0][col] == player && board[1][col] == player && board[2][col] == player){
                return true;
            }
        }

        //check for diagonal
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player){
            return true;
        }

        if(board[2][0] == player && board[1][1] == player && board[0][1] == player){
            return true;
        }

        return false;
    }

}
