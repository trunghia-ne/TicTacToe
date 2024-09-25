package controller;


import model.MyModel;
import view.MyView;

/**
 * A class for the controller of a TicTacToe game
 *
 * @author Trung Nghia
 */
public class GameController extends Controller {
    //
    public GameController(MyModel theModel, MyView theView) {
        super(theModel, theView);
        theView.addTicTacToeListener(new TicTacToeListener(theModel, theView));
    }
}