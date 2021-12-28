package model.domain.korting;

import model.domain.bestelling.Bestelling;

public class GeenKorting extends Korting {
    @Override
    public double berekenKorting(Bestelling bestelling) {
        return bestelling.getPrice();
    }
}
