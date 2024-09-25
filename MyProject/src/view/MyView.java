package view;

import java.awt.event.ActionListener;

/**
 * A class for the model of a TicTacToe board
 *
 * @author Trung Nghia
 */
public interface MyView {
    void addTicTacToeListener(ActionListener listener);

    void setButtonText(char c, int row, int col);

    void displayMessage(String message);

    void resetBoard();

    void addSwitchModeListener(ActionListener listener);

    void updateSwitchButtonText(boolean isTwoPlayerMode);
}
