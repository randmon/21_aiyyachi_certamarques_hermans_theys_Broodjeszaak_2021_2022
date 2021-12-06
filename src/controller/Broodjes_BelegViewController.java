package controller;

import model.BestelFacade;
import model.domain.Beleg;
import model.domain.Broodje;
import view.panels.SandwichOverviewPane;

import java.util.Map;
import java.util.Observable;
import java.util.Observer;

public class Broodjes_BelegViewController implements Observer {
    private final BestelFacade model;
    private SandwichOverviewPane view;

    public Broodjes_BelegViewController(String fileType) {
        this.model = new BestelFacade(fileType);
        this.model.addObserver(this);
    }

    public Map<String, Broodje> getBroodjes() {
        return model.getBroodjes();
    }

    public Map<String, Beleg> getBeleg() {
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
