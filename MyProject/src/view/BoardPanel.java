package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * A class for the model of a TicTacToe board
 *
 * @author Trung Nghia
 */
public class BoardPanel extends JPanel {
    private JButton[][] board;
    private int size;

    public BoardPanel(int size) {
        this.size = size;
        setLayout(new GridLayout(size, size));
        createBoard(size);
        setPreferredSize(new Dimension(300, 300));
    }

    public void createBoard(int size) {
        this.size = size;
        board = new JButton[size][size];
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                board[row][col] = new JButton("---");
                board[row][col].putClientProperty("row", row);
                board[row][col].putClientProperty("col", col);
                add(board[row][col]);
            }
        }
    }

    public void addTicTacToeListener(ActionListener ticTacToeListener) {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++)
                board[row][col].addActionListener(ticTacToeListener);
        }
    }

    public void setButtonText(char c, int row, int col) {
        board[row][col].setText(Character.toString(c));
    }

    public void resetBoard() {
        for (JButton[] row : board) {
            for (JButton button : row) {
                button.setText("---");
            }
        }
    }
}
