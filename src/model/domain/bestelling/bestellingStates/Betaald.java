package model.domain.bestelling.bestellingStates;

import model.domain.bestelling.BestellingContext;

public class Betaald implements BestellingState {
    @Override
    public void zendNaarKeuken(BestellingContext context) {
        context.setState(new InWachtrij());
    }

    @Override
    public String toString() {
        return "betaald";
    }
}
