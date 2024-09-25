package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * A class for the model of a TicTacToe board
 *
 * @author Trung Nghia
 */
public class GameBoardView extends JFrame implements MyView {
    private final JButton switchModeButton;
    private final BoardPanel boardPanel;
    private final JLabel messageLabel; // Thêm label để hiển thị thông báo

    public GameBoardView() {
//		int size = getSizeToCreateBoard();
        boardPanel = new BoardPanel(3);
        setTitle("Tic Tac Toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        messageLabel = new JLabel(); // Khởi tạo messageLabel
        add(messageLabel, BorderLayout.SOUTH); // Thêm messageLabel vào JFrame
        switchModeButton = new JButton("Chuyển sang chế độ 2 người chơi");
        add(switchModeButton, BorderLayout.NORTH);
        add(boardPanel, BorderLayout.CENTER); // Thêm boardPanel vào JFrame

        pack();
        centerWindow();
        setVisible(true);
    }

    private void centerWindow() {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width / 2 - getSize().width / 2, dim.height / 2 - getSize().height / 2);
    }


    @Override
    public void addTicTacToeListener(ActionListener listener) {
        boardPanel.addTicTacToeListener(listener);
    }

    @Override
    public void setButtonText(char c, int row, int col) {
        boardPanel.setButtonText(c, row, col);
    }

    @Override
    public void displayMessage(String message) {
        messageLabel.setText(message);
        JOptionPane.showMessageDialog(this, message);
    }

    @Override
    public void resetBoard() {
        boardPanel.resetBoard();
    }

    // Phương thức cho phép gán sự kiện vào nút
    public void addSwitchModeListener(ActionListener listener) {
        switchModeButton.addActionListener(listener);
    }

    // Phương thức thay đổi văn bản của nút khi chế độ thay đổi
    public void updateSwitchButtonText(boolean isTwoPlayerMode) {
        if (isTwoPlayerMode) {
            switchModeButton.setText("Chuyển sang chế độ chơi với AI");
        } else {
            switchModeButton.setText("Chuyển sang chế độ 2 người chơi");
        }
    }
}
