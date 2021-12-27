package model.domain.bestelling.bestellingStates;

import model.domain.bestelling.BestellingContext;
import model.domain.bestelling.bestellingStates.BestellingState;

public class InBestelling extends BestellingState {
    @Override
    public void doAction(BestellingContext context) {
        System.out.println("In Bestelling state");
        context.setState(this);
    }

}
