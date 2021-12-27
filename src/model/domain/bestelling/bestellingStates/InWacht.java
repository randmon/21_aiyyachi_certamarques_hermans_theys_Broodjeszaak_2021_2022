package model.domain.bestelling.bestellingStates;

import model.domain.bestelling.BestellingContext;
import model.domain.bestelling.bestellingStates.BestellingState;

public class InWacht extends BestellingState {
    @Override
    public void doAction(BestellingContext context) {
        System.out.println("In Waiting state");
        context.setState(this);
    }
}
