package controller;

import model.Subject;
import facade.BestelFacade;

public class Broodjes_BelegViewController implements Observer{
    private BestelFacade bestelfacade;
    public Broodjes_BelegViewController(BestelFacade bestelfacade) {
        this.bestelfacade = bestelfacade;
    }

    @Override
    public void update() {

    }
}
