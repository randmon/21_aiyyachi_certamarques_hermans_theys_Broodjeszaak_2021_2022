package model.domain.bestelling.bestellingStates;

import model.domain.bestelling.BestellingContext;
import model.domain.bestelling.bestellingStates.BestellingState;

public class InWacht implements BestellingState {
    @Override
    public void doAction(BestellingContext context) {
        System.out.println("In Waiting state");
    }
}
