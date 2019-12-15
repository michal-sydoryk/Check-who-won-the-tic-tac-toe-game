package com.epam.app;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String filePath= args[0];
        char[][] board = getBoardFromFile(filePath);
        if(checkRowsForWin(board, 'X') || checkColumnsForWin(board, 'X') || checkCrossForWin(board, 'X')){
            System.out.println("X");
        }
        else if (checkRowsForWin(board, 'O') || checkColumnsForWin(board, 'O') || checkCrossForWin(board, 'O')){
            System.out.println("O");
        }
        else {
            System.out.println("DRAW");
        }
    }

    static char[][] getBoardFromFile(String filePath){
        Path path = Paths.get(filePath);
        char[][] board = new char[3][3];
        try {
            Scanner scanner = new Scanner(path);
            int r = 0;
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                for(int c=0; c<3 ;c++){
                    board[r][c] = line.charAt(c);

                }
                r++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return board;
    }

    static boolean checkRowsForWin(char[][] board, char sign){
        for(int c=0; c<3; c++) {
            if (board[c][0] == sign && board[c][1] == sign && board[c][1] == sign) return true;
        }
        return false;
    }

    static boolean checkColumnsForWin(char[][] board, char sign){
        for(int r=0; r<3; r++) {
            if (board[0][r] == sign && board[1][r] == sign && board[2][r] == sign) return true;
        }
        return false;
    }

    static boolean checkCrossForWin(char[][] board, char sign){
        if (board[0][0] == sign && board[1][1] == sign && board[2][2] == sign) return true;
        if (board[0][2] == sign && board[1][1] == sign && board[2][0] == sign) return true;
        return false;
    }
}
