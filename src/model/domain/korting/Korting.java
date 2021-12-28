package model.domain.korting;

import model.domain.bestelling.Bestelling;

public abstract class Korting {
    public abstract double berekenKorting(Bestelling bestelling);
}
