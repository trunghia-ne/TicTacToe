package model;

/**
 * A class for the model of a TicTacToe board
 *
 * @author Trung Nghia
 */
public class GameLogic {
    private final char[][] board;
    private final int size;

    public GameLogic(char[][] board, int size) {
        this.board = board;
        this.size = size;
    }

    public char findWinner() {
        // kiểm tra chiều ngang
        char winner;
        for (int row = 0; row < size; row++) {
            winner = board[row][0];
            for (int col = 0; col < size; col++) {
                if (board[row][col] != winner) {
                    winner = '\0';
                    break;
                }
            }
            if (winner != '\0')
                return winner;
        }
        // kiểm tra ngành dọc
        for (int col = 0; col < size; col++) {
            winner = board[0][col];
            for (int row = 0; row < size; row++) {
                if (board[row][col] != winner) {
                    winner = '\0';
                    break;
                }
            }
            if (winner != '\0')
                return winner;
        }
        // kiểm tra đường chéo trái sang phải
        winner = board[0][0];
        for (int row = 0; row < size; row++) {
            if (board[row][row] != winner) {
                winner = '\0';
                break;
            }
        }
        if (winner != '\0')
            return winner;
        // kiểm tra đường chéo từ phải sang trái
        winner = board[0][size - 1];
        for (int row = 0; row < size; row++) {
            if (board[row][(size - 1) - row] != winner) {
                winner = '\0';
                break;
            }
        }
        if (winner != '\0') {
            return winner;
        }

        return '\0';
    }

    public boolean isTiedGame() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (board[row][col] == '\0')
                    return false;
            }
        }
        return true;
    }
}