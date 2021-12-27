package model;

import model.database.BelegDB;
import model.database.BroodjesDB;
import model.domain.Beleg;
import model.domain.Broodje;
import model.domain.DomainException;
import model.domain.Item;
import model.domain.bestelling.Bestelling;
import model.domain.bestelling.BestellingEvent;

import java.util.Map;
import java.util.Observable;

public class BestelFacade extends Observable {
    private BroodjesDB broodjesDB;
    private BelegDB belegDB;
    private Bestelling bestelling;
    private int nextOrderID;

    public BestelFacade(String fileType) {
        broodjesDB = BroodjesDB.getInstance(fileType);
        belegDB = BelegDB.getInstance(fileType);
        nextOrderID = 1;
    }

    public Map<String, Broodje> getBroodjes() {
        return broodjesDB.getAll();
    }

    public Map<String, Beleg> getBeleg() {
        return belegDB.getAll();
    }

    public void saveVoorraad() {
        broodjesDB.save();
        belegDB.save();
    }

    public void startNewOrder() {
        bestelling = new Bestelling(nextOrderID);
        nextOrderID ++;
    }

    public int getOrderID() {
        return bestelling.getId();
    }

    public void addNewItem(Broodje b) {
        try {
            bestelling.addBroodje(b);
            broodjesDB.setVoorraad(b, b.getVoorraad()-1);
            setChanged();
            notifyObservers(BestellingEvent.ADD_BROODJE);
        } catch (DomainException d) {
            System.out.println(d.getMessage());
        }
    }

    public Bestelling getBestelling() {
        return bestelling;
    }

    public void addBeleg(Item item, Beleg beleg) {
        if (item == null) return;
        bestelling.addBeleg(item, beleg);
        belegDB.setVoorraad(beleg, beleg.getVoorraad()-1);
        setChanged();
        notifyObservers(BestellingEvent.ADD_BELEG);
    }


    public double calculatePrice() {
        double total = 0;
        for (Item i : bestelling.getItems()) {
            total += i.calculatePrice();
        }
        return total;
    }

    public void addSameItem(Item item) {
       bestelling.addSameBroodje(item.getBroodje(), item.getBeleg());
       broodjesDB.setVoorraad(item.getBroodje(), item.getBroodje().getVoorraad()-1);
       for (Beleg b : item.getBeleg()) belegDB.setVoorraad(b, b.getVoorraad()-1);

        setChanged();
        notifyObservers(BestellingEvent.ADD_SAME_BROODJE);
    }

    public void deleteItem(Item itemToDelete) {
        bestelling.deleteBroodje(itemToDelete);

        setChanged();
        notifyObservers(BestellingEvent.REMOVE_BROODJE);
    }
}
