package controller;

import facade.BestelFacade;
import model.domain.Beleg;
import model.domain.Broodje;
import view.panels.SandwichOverviewPane;

import java.util.Observable;
import java.util.Observer;
import java.util.Set;

public class Broodjes_BelegViewController implements Observer {
    private final BestelFacade model;
    private SandwichOverviewPane view;

    public Broodjes_BelegViewController() {
        this.model = new BestelFacade();
        this.model.addObserver(this);
    }

    public Set<Broodje> getBroodjes() {
        return model.getBroodjes();
    }

    public Set<Beleg> getBeleg() {
        return model.getBeleg();
    }

    @Override
    public void update(Observable o, Object arg) {
        //Update tables in view
        view.refreshBroodjes();
        view.refreshBeleg();
    }

    public void saveVoorraad() {
        model.saveVoorraad();
    }
}
