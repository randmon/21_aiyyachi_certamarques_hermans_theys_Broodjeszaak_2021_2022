package model.domain.bestelling.bestellingStates;

import model.domain.bestelling.BestellingContext;

public class Afgesloten implements BestellingState {
    @Override
    public void annuleren(BestellingContext context) {
        context.setState(new Canceled());
    }

    @Override
    public void betaal(BestellingContext context) {
        context.setState(new Betaald());
    }

    @Override
    public String toString() {
        return "afgesloten";
    }
}
