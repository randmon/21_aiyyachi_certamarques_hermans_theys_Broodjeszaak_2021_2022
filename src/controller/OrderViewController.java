package controller;

import model.BestelFacade;
import model.domain.Beleg;
import model.domain.Broodje;
import model.domain.Item;
import model.domain.bestelling.Bestelling;
import model.domain.bestelling.BestellingEvent;
import view.OrderView;

import java.util.*;

public class OrderViewController implements Observer {
    private final BestelFacade model;
    private OrderView view;

    public OrderViewController(BestelFacade model) {
        this.model = model;
        this.model.addObserver(this);
    }

    public void setView(OrderView view) {
        this.view = view;
    }

    @Override
    public void update(Observable o, Object arg) {
        BestellingEvent event = (BestellingEvent) arg;
        if (event == null) return;
        List<BestellingEvent> list = Arrays.asList(
                BestellingEvent.ADD_BROODJE,
                BestellingEvent.ADD_BELEG,
                BestellingEvent.ADD_SAME_BROODJE,
                BestellingEvent.REMOVE_BROODJE,
                BestellingEvent.CANCEL_ORDER,
                BestellingEvent.SEND_TO_KITCHEN
        );

        if (list.contains(event)) {
            view.refreshOrder();
        }
    }

    public List<Broodje> getBroodjes() {
        Map<String, Broodje> broodjeMap = model.getBroodjes();

        return new ArrayList<>(broodjeMap.values());
    }

    public List<Beleg> getBeleg() {
        Map<String, Beleg> belegMap = model.getBeleg();
        return new ArrayList<>(belegMap.values());
    }

    public void startNewOrder() {
        model.startNewOrder();
    }

    public int getOrderID() {
        return model.getOrderID();
    }

    public void addBroodje(Broodje b) {
        model.addBroodje(b);
    }

    public Bestelling getBestelling() {
        return model.getBestelling();
    }

    public void addBelegToItem(Item item, Beleg beleg) {
        model.addBeleg(item, beleg);
    }

    public void addSameItem(Item selectedItem) {
        model.addSameItem(selectedItem);
    }

    public void deleteItem(Item itemToDelete) {
        model.deleteItem(itemToDelete);
    }

    public void cancelOrder() {
        model.cancelOrder();
    }

    public double closeOrder(String korting) {
        return model.closeOrder(korting);
    }

    public void pay() {
        model.pay();
    }

    public void toKitchen() {
        model.toKitchen();
    }

    public List<String> getKortingLijst() {
        return model.getKortingLijst();
    }
}
