package model.domain;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Een bestelling mag meerdere items bevatten.
 * */
public class Bestelling {
    private final int id;
    private int nextItemID;
    private final Map<Integer, Item> items;

    public Bestelling(int id, Map<Integer, Item> items) {
        this.id = id;
        this.items = items;
        nextItemID = -1;
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

        items.put(getNextItemID(), new Item(broodje.getNaam(), new ArrayList<>()));
    }

    public void addBeleg(int itemID, Beleg beleg) {
        if (beleg.getVoorraad() < 1) throw new DomainException("Dit beleg is niet meer in voorraad!");

        items.get(itemID).addBeleg(beleg.getNaam());
    }

    public void addSameBroodje(Broodje broodje, List<Beleg> beleg) {
        //Check if broodje and beleg in stock
        if (broodje.getVoorraad() < 0) throw new DomainException("Dit broodje is niet meer in voorraad!");
        for (Beleg b : beleg) {
            if (b.getVoorraad() < 1) throw new DomainException("Dit beleg is niet meer in voorraad!");
        }

        List<String> belegnamen = beleg.stream().map(Product::getNaam).collect(Collectors.toList());

        items.put(getNextItemID(), new Item(broodje.getNaam(), belegnamen));
    }

    public void deleteBroodje(int itemID) {
        items.remove(itemID);
    }

    private int getNextItemID() {
        nextItemID++;
        return nextItemID;
    }
}
