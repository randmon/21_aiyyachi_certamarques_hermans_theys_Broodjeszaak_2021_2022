package model.domain.bestelling.bestellingStates;

import model.domain.Broodje;
import model.domain.bestelling.BestellingContext;

public class InBestelling implements BestellingState {
    public InBestelling() {

    }

    @Override
    public void addBroodje(Broodje broodje, BestellingContext context) {
        //TODO voer uit
    }

    @Override
    public void addBeleg() {
        BestellingState.super.addBeleg();
    }
}
