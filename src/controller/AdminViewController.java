package controller;

import model.BestelFacade;
import model.domain.Beleg;
import model.domain.Broodje;

import model.domain.bestelling.BestellingEvent;
import view.AdminView;
import view.panels.SandwichOverviewPane;
import view.panels.StatisticsPane;

import java.util.Map;
import java.util.Observable;
import java.util.Observer;

public class AdminViewController implements Observer {
    private final BestelFacade model;
    private AdminView view;

    public AdminViewController(BestelFacade model) {
        this.model = model;
        this.model.addObserver(this);
    }

    public void setView(AdminView view) {
        this.view = view;
    }

    public Map<String, Broodje> getBroodjes() {
        return model.getBroodjes();
    }

    public Map<String, Beleg> getBeleg() {
        return model.getBeleg();
    }



    @Override
    public void update(Observable o, Object arg) {
        BestellingEvent event = (BestellingEvent) arg;
        if (event == null) return;

        if (event.equals(BestellingEvent.SEND_TO_KITCHEN)) {
            view.refresh();
        }
    }

    public void saveVoorraad() {
        model.saveVoorraad();
    }
}
