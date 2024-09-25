import controller.GameController;
import model.GameModel;
import model.MyModel;
import view.GameBoardView;
import view.MyView;

/**
 * A class for the model of a TicTacToe board
 *
 * @author Trung Nghia
 */
public class TicTacToeDeMo {
    public static void main(String[] args) {
        MyView theView = new GameBoardView();
        MyModel theModel = new GameModel(3);
        new GameController(theModel, theView);
    }

}
