package model.domain.korting;

import model.domain.bestelling.Bestelling;

public class TienProcent extends Korting {

    @Override
    public double berekenKorting(Bestelling bestelling) {
        return bestelling.getPrice() * 0.9;
    }
}
