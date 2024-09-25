package controller;

import model.AI;
import model.MyModel;
import view.MyView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A class for the model of a TicTacToe board
 *
 * @author Trung Nghia
 */

public class TicTacToeListener extends Controller implements ActionListener {
    private final char humanPlayer = 'X'; // Người chơi là 'X'
    private final char aiPlayerChar = 'O'; // AI là 'O'
    private boolean isTwoPlayerMode = false;

    public TicTacToeListener(MyModel theModel, MyView theView) {
        super(theModel, theView);
        this.aiPlayer = new AI(theModel, aiPlayerChar, humanPlayer);
        theView.addSwitchModeListener(e -> switchMode());
    }

    // Phương thức để chuyển qua lại giữa chế độ 2 người chơi và AI
    private void switchMode() {
        isTwoPlayerMode = !isTwoPlayerMode; // Đảo trạng thái giữa hai chế độ
        if (isTwoPlayerMode) {
            theView.displayMessage("Chuyển sang chế độ 2 người chơi.");
            resetGame2();
        } else {
            theView.displayMessage("Chuyển sang chế độ chơi với AI.");
            resetGame2();
        }
        theView.updateSwitchButtonText(isTwoPlayerMode); // Cập nhật văn bản nút
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        int row = (int) btn.getClientProperty("row");
        int col = (int) btn.getClientProperty("col");

        // Nếu ở chế độ 2 người chơi, luân phiên giữa hai người chơi
        if (isTwoPlayerMode) {
            char currentPlayer = theModel.getTurn();
            if (theModel.doMove(row, col)) {
                theView.setButtonText(currentPlayer, row, col);
                checkGameOver();
            }
        } else { // Nếu không thì chơi với AI
            if (theModel.getTurn() == humanPlayer && theModel.doMove(row, col)) {
                theView.setButtonText(humanPlayer, row, col);
                checkGameOver();
                aiTurn(); // Gọi AI sau lượt của người chơi
            }
        }
    }

    private void aiTurn() {
        if (theModel.getTurn() == aiPlayerChar && !theModel.isBoardFull()) { // Kiểm tra lượt và bàn cờ chưa đầy
            int[] move = aiPlayer.makeMove();
            int row = move[0];
            int col = move[1];

            if (theModel.doMove(row, col)) {
                theView.setButtonText(aiPlayerChar, row, col);
                checkGameOver();
            } else {
                aiTurn(); // Gọi đệ quy nếu nước đi không hợp lệ (thử lại)
            }
        }
    }

    private void checkGameOver() {
        char winner = theModel.findWinner();
        if (winner != '\0') {
            theView.displayMessage("Player " + winner + " has won!");
            resetGame();
        } else if (theModel.isTiedGame()) {
            theView.displayMessage("Draw!");
            resetGame();
        }
    }

    private void resetGame() {
        new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                Thread.sleep(2000); // Delay 1 giây
                return null;
            }

            @Override
            protected void done() {
                theModel.resetGame();
                theView.resetBoard();
                // Thêm logic khác sau khi reset nếu cần (ví dụ: thông báo bắt đầu ván mới)
            }
        }.execute();
    }

    private void resetGame2() {
        theModel.resetGame();
        theView.resetBoard();
    }

}