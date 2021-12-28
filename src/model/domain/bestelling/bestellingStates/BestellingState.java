package model.domain.bestelling.bestellingStates;

import model.domain.Broodje;
import model.domain.bestelling.BestellingContext;

public interface BestellingState {
    default void addBroodje(Broodje broodje, BestellingContext context){
        return;
    }

    default void addBeleg() {
        return;
    }
}
