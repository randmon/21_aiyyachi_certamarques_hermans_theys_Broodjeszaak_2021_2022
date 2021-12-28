package model.domain.bestelling;

import model.domain.bestelling.bestellingStates.BestellingState;
import model.domain.bestelling.bestellingStates.InWacht;

public class BestellingContext {
    private BestellingState state;

    public BestellingContext() {
        this.state = new InWacht();
    }

    public void setState(BestellingState state) {
        this.state = state;
    }

    public BestellingState getState() {
        return state;
    }
}
