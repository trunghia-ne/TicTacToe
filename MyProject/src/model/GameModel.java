package model;

/**
 * A class for the model of a TicTacToe board
 *
 * @author Trung Nghia
 */
public class GameModel implements MyModel {
    private final char[][] board;
    private final int size;
    private char turn;
    private final GameLogic gameLogic;

    public GameModel(int size) {
        this(size, 'X');
    }

    public GameModel(int size, char startingTurn) {
        this.size = size;
        this.board = new char[size][size];
        this.turn = startingTurn;
        this.gameLogic = new GameLogic(board, size);
    }

    public boolean doMove(int row, int col) {
        if (board[row][col] == '\0') {
            board[row][col] = turn;
            turn = (turn == 'X' ? 'O' : 'X');
            return true;
        }
        return false;
    }

    public char findWinner() {
        return gameLogic.findWinner();
    }

    public boolean isTiedGame() {
        return gameLogic.isTiedGame();
    }

    public char getTurn() {
        return this.turn;
    }

    public void resetGame() {
        // 1. Đặt lại tất cả các ô trên bàn cờ về trạng thái trống ('\0')
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = '\0';
            }
        }
        // 2. Đặt lại lượt chơi về 'X'
        turn = 'X';
    }

    // kiểm tra trạng thái của bàn cờ
    public boolean isEmptyCell(int row, int col) {
        return board[row][col] == '\0';
    }

    public void undoMove(int row, int col) {
        board[row][col] = '\0'; // Đặt ô đã đánh lại thành trống
        turn = (turn == 'X') ? 'O' : 'X'; // Đổi lại lượt chơi
    }

    public boolean isBoardFull() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (board[row][col] == '\0') { // Nếu có ô trống
                    return false; // Bàn cờ chưa đầy
                }
            }
        }
        return true; // Tất cả các ô đã được đánh dấu, bàn cờ đã đầy
    }

}