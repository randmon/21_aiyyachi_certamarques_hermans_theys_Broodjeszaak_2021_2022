package controller;

import model.BestelFacade;
import model.domain.bestelling.Bestelling;
import model.domain.bestelling.BestellingEvent;
import view.KitchenView;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class KitchenViewController implements Observer {
    private final BestelFacade model;
    private KitchenView view;

    public KitchenViewController(BestelFacade model) {
        this.model = model;
        this.model.addObserver(this);
    }

    public void setView(KitchenView view) {
        this.view = view;
    }

    @Override
    public void update(Observable o, Object arg) {
        BestellingEvent event = (BestellingEvent) arg;
        if (event == null) return;
        if (event.equals(BestellingEvent.SEND_TO_KITCHEN) ||
                event.equals(BestellingEvent.IN_BEREIDING) ||
                event.equals(BestellingEvent.AFGEWERKT)) {
            view.refreshWachtrij();
        }
    }

    public int getInWachtrij() {
        return model.getInWachtrij();
    }

    public Bestelling getNextInRij() {
        return model.getNextInRij();
    }

    public List<String> getItemsForKitchen() {
        return model.getItemsForKitchen();
    }

    public void afwerken() {
        model.afwerken();
    }
}
