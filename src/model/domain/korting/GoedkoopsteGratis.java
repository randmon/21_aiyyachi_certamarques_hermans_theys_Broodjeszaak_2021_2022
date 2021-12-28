package model.domain.korting;

import model.domain.Item;
import model.domain.bestelling.Bestelling;

import java.util.Comparator;
import java.util.TreeSet;

public class GoedkoopsteGratis extends Korting {
    @Override
    public double berekenKorting(Bestelling bestelling) {
        TreeSet<Item> sorted = new TreeSet<>(Comparator.comparing(Item::calculatePrice));
        sorted.addAll(bestelling.getItems());
        double goedkoopste = sorted.first().calculatePrice();
        return bestelling.getPrice() - goedkoopste;
    }
}