package controller;

import model.BestelFacade;
import model.domain.Beleg;
import model.domain.Broodje;

import model.domain.bestelling.BestellingEvent;
import view.AdminView;

import java.util.*;

public class AdminViewController implements Observer {
    private final BestelFacade model;
    private AdminView view;

    public AdminViewController(BestelFacade model) {
        this.model = model;
        this.model.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        BestellingEvent event = (BestellingEvent) arg;
        if (event == null) return;

        if (event.equals(BestellingEvent.SEND_TO_KITCHEN)) {
            view.refresh();
        }
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

    public List<String> getFileStrategies() {
        return model.getFileStrategies();
    }

    public String getSaveStrategy(){
        return model.getSaveStrategy();
    }

    public String getKortingStrategy(){
        return model.getKortingStrategy();
    }

    public void setProperties(Map<String, String> properties) {
        model.setProperties(properties);
    }

    public List<String> getKortingStrategies() {
        return model.getKortingLijst();
    }
}
