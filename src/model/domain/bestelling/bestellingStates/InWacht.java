package model.domain.bestelling.bestellingStates;

import model.domain.bestelling.BestellingContext;

public class InWacht implements BestellingState {

    @Override
    public void start(BestellingContext context) {
        context.setState(new InBestelling());
    }

    @Override
    public String toString() {
        return "in wacht";
    }
}
