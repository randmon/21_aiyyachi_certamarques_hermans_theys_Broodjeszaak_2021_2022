package model.domain.bestelling.bestellingStates;

import model.domain.bestelling.BestellingContext;

public class InWachtrij implements BestellingState {
    @Override
    public void startBereiding(BestellingContext context) {
        context.setState(new InBereiding());
    }

    @Override
    public String toString() {
        return "in wachtrij";
    }
}
