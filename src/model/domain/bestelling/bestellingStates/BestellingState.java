package model.domain.bestelling.bestellingStates;

import model.domain.bestelling.BestellingContext;

public abstract class BestellingState {
    public abstract void doAction(BestellingContext context);
}
