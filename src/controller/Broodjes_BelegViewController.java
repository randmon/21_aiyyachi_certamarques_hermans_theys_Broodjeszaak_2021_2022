package controller;

import facade.BestelFacade;
import model.domain.Broodje;
import view.panels.SandwichOverviewPane;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Broodjes_BelegViewController implements Observer {
    private BestelFacade model;
    private SandwichOverviewPane view;

    public Broodjes_BelegViewController(BestelFacade model) {
        this.model = model;
        this.model.addObserver(this);
    }

    public List<Broodje> getBroodjesList() {
        return model.getBroodjesList();
    }



    @Override
    public void update(Observable o, Object arg) {

    }
}
