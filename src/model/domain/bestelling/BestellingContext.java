package model.domain.bestelling;

import model.domain.bestelling.bestellingStates.BestellingState;

public class BestellingContext {
    private BestellingState state;

    public BestellingContext() {
        this.state = null;
    }
    public void setState(BestellingState state) {
        this.state = state;
    }

    public BestellingState getState() {
        return state;
    }
}
