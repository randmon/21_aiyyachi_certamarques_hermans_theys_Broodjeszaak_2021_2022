package model.domain.bestelling;

import model.domain.Beleg;
import model.domain.Broodje;
import model.domain.DomainException;
import model.domain.Item;

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
    }

    public int getId() {
        return id;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void startOrder() {
        context.getState().start(context);
    }

    public void addBroodje(Broodje broodje) {
        context.getState().addBroodje(context);

        if (broodje.getVoorraad() < 1) throw new DomainException(broodje.getNaam() + " broodje is niet meer in voorraad!");
        items.add(new Item(broodje, new ArrayList<>()));
    }

    public void addBeleg(Item item, Beleg beleg) {
        context.getState().addBeleg(context);

        if (beleg.getVoorraad() < 1) throw new DomainException(beleg.getNaam() + " is niet meer in voorraad!");
        item.addBeleg(beleg);
    }

    public void addSameBroodje(Broodje broodje, List<Beleg> beleg) {
        context.getState().addSameBroodje(context);

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

    public void removeBroodje(Item item) {
        context.getState().verwijderBroodje(context);
        items.remove(item);
    }

    public void closeOrder() {
        context.getState().afsluiten(context);
    }

    public double getPrice() {
        double total = 0;
        for (Item i : items) {
            total += i.calculatePrice();
        }
        return total;
    }

    public void cancelOrder() {
        context.getState().annuleren(context);
    }

    public void pay() {
        context.getState().betaal(context);
    }

    public void sendToKitchen() {
        context.getState().zendNaarKeuken(context);
    }

    public void startBereiding() {
        context.getState().startBereiding(context);
    }

    public void finishOrder() {
        context.getState().afwerken(context);
    }
}
