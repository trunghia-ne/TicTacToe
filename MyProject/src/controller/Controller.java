package controller;

import model.AI;
import model.MyModel;
import view.MyView;

/**
 * A class for the model of a TicTacToe board
 *
 * @author Trung Nghia
 */
public abstract class Controller {
    protected MyModel theModel;
    protected MyView theView;
    protected AI aiPlayer;

    public Controller(MyModel theModel, MyView theView) {
        this.theModel = theModel;
        this.theView = theView;
    }
}