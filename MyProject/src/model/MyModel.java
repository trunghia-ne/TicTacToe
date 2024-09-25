package model;

/**
 * A class for the model of a TicTacToe board
 *
 * @author Trung Nghia
 */
public interface MyModel {
    boolean doMove(int row, int col);

    char findWinner();

    boolean isTiedGame();

    char getTurn();

    void resetGame();

    boolean isEmptyCell(int row, int col);

    void undoMove(int row, int col);

    boolean isBoardFull();
}
