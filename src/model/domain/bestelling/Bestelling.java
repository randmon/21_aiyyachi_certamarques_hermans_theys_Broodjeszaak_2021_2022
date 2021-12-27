package model.domain.bestelling;

import model.domain.Beleg;
import model.domain.Broodje;
import model.domain.DomainException;
import model.domain.Item;
import model.domain.bestelling.bestellingStates.InWacht;

import java.util.*;

/**
 * Een bestelling mag meerdere items bevatten.
 * */
public class Bestelling {
    private final Set<Item> items;
    private BestellingContext context;
    private final int id;

    public Bestelling(int id) {
        this.id = id;
        this.items = new LinkedHashSet<>();
        context = new BestellingContext();
        context.setState(new InWacht());
        context.getState().doAction(context);
    }

    public int getId() {
        return id;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void addBroodje(Broodje broodje) {
        if (broodje.getVoorraad() < 1) throw new DomainException(broodje.getNaam() + " broodje is niet meer in voorraad!");

        items.add(new Item(broodje, new ArrayList<>()));
    }

    public void addBeleg(Item item, Beleg beleg) {
        if (beleg.getVoorraad() < 1) throw new DomainException(beleg.getNaam() + " is niet meer in voorraad!");

        item.addBeleg(beleg);
    }

    public void addSameBroodje(Broodje broodje, List<Beleg> beleg) {
        Item item = new Item(broodje, new ArrayList<>(beleg));

        //Check if it is possible to add all the ingredients
        int broodjeVoorraad = item.getBroodje().getVoorraad();
        if (broodjeVoorraad < 1) throw new DomainException(broodje.getNaam() + " broodje is niet meer in voorraad!");

        Map<Beleg, Integer> belegMap = new HashMap<>();
        for (Beleg b : item.getBeleg()) {
            belegMap.put(b, belegMap.getOrDefault(b, 0) + 1);
        }

        for (Map.Entry<Beleg, Integer> entry : belegMap.entrySet()) {
            if (entry.getValue() > entry.getKey().getVoorraad()) {
                throw new DomainException(entry.getKey().getNaam() + " is niet meer in voorraad!");
            }
        }

        items.add(item);
    }

    public void deleteBroodje(Item item) {
        items.remove(item);
    }
}
