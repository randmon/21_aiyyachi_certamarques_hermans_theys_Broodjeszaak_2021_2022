package model.domain.bestelling.bestellingStates;

import model.domain.bestelling.BestellingContext;

public class InBereiding implements BestellingState {
    @Override
    public void afwerken(BestellingContext context) {
        context.setState(new Finished());
    }

    @Override
    public String toString() {
        return "in bereiding";
    }
}
