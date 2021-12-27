package model.domain.bestelling;

import model.domain.Beleg;
import model.domain.Broodje;
import model.domain.DomainException;
import model.domain.Item;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Een bestelling mag meerdere items bevatten.
 * */
public class Bestelling {
    private final int id;
    private int nextItemID;
    private final Map<Integer, Item> items;
    private BestellingContext context;

    public Bestelling(int id, Map<Integer, Item> items) {
        this.id = id;
        this.items = items;
        nextItemID = -1;
        context = new BestellingContext();
        context.setState(new InBestelling());
        context.getState().doAction(context);
    }

    public Bestelling(int id) {
        this(id, new TreeMap<>());
    }

    public int getId() {
        return id;
    }

    public Map<Integer, Item> getItems() {
        return items;
    }

    public void addBroodje(Broodje broodje) {
        if (broodje.getVoorraad() < 1) throw new DomainException("Dit broodje is niet meer in voorraad!");

        items.put(getNextItemID(), new Item(broodje, new ArrayList<>()));
    }

    public void addBeleg(Item item, Beleg beleg) {
        if (beleg.getVoorraad() < 1) throw new DomainException("Dit beleg is niet meer in voorraad!");

        item.addBeleg(beleg);
    }

    public void addSameBroodje(Broodje broodje, List<Beleg> beleg) {
        //Check if broodje and beleg in stock
        if (broodje.getVoorraad() < 0) throw new DomainException("Dit broodje is niet meer in voorraad!");
        for (Beleg b : beleg) {
            if (b.getVoorraad() < 1) throw new DomainException("Dit beleg is niet meer in voorraad!");
        }

        items.put(getNextItemID(), new Item(broodje, beleg));
    }

    public void deleteBroodje(int itemID) {
        items.remove(itemID);
    }

    private int getNextItemID() {
        nextItemID++;
        return nextItemID;
    }
}
