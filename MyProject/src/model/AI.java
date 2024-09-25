package model;

/**
 * A class for the model of a TicTacToe board
 *
 * @author Trung Nghia
 */
public class AI {
    private final MyModel theModel;
    private final char aiPlayer;
    private final char humanPlayer;

    public AI(MyModel theModel, char aiPlayer, char humanPlayer) {
        this.theModel = theModel;
        this.aiPlayer = aiPlayer;
        this.humanPlayer = humanPlayer;
    }

    public int[] makeMove() {
        int bestScore = Integer.MIN_VALUE;
        int[] bestMove = new int[]{-1, -1}; // Khởi tạo nước đi tốt nhất

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (theModel.isEmptyCell(i, j)) {
                    theModel.doMove(i, j); // Thử nước đi
                    int score = minimax(0, false); // Gọi đệ quy minimax, false vì lượt tiếp theo là của người
                    theModel.undoMove(i, j); // Hoàn tác nước đi

                    if (score > bestScore) {
                        bestScore = score;
                        bestMove = new int[]{i, j};
                    }
                }
            }
        }

        return bestMove;
    }

    private int minimax(int depth, boolean isMaximizing) {
        char winner = theModel.findWinner();
        if (winner == aiPlayer) {
            return 10 - depth;
        } else if (winner == humanPlayer) {
            return depth - 10;
        } else if (theModel.isTiedGame()) {
            return 0;
        }

        int bestScore;
        if (isMaximizing) { // Lượt của AI (maximizing player)
            bestScore = Integer.MIN_VALUE;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (theModel.isEmptyCell(i, j)) {
                        theModel.doMove(i, j);
                        bestScore = Math.max(bestScore, minimax(depth + 1, false));
                        theModel.undoMove(i, j);
                    }
                }
            }
        } else { // Lượt của người chơi (minimizing player)
            bestScore = Integer.MAX_VALUE;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (theModel.isEmptyCell(i, j)) {
                        theModel.doMove(i, j);
                        bestScore = Math.min(bestScore, minimax(depth + 1, true));
                        theModel.undoMove(i, j);
                    }
                }
            }
        }
        return bestScore;
    }
}
