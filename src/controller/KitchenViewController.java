package controller;

import model.BestelFacade;

import java.util.Observable;
import java.util.Observer;

public class KitchenViewController implements Observer {
    private final BestelFacade model;

    public KitchenViewController(BestelFacade model) {
        this.model = model;
        this.model.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        //TODO
    }
}
