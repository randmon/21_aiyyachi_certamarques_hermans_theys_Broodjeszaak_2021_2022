package model.domain.bestelling.bestellingStates;

import model.domain.bestelling.BestellingContext;

public class InBestelling implements BestellingState {
    @Override
    public void addBroodje(BestellingContext context) {
        return;
    }

    @Override
    public void addBeleg(BestellingContext context) {
        return;
    }

    @Override
    public void addSameBroodje(BestellingContext context) {
        return;
    }

    @Override
    public void verwijderBroodje(BestellingContext context) {
        return;
    }

    @Override
    public void afsluiten(BestellingContext context) {
        context.setState(new Afgesloten());
    }

    @Override
    public void annuleren(BestellingContext context) {
        context.setState(new Canceled());
    }

    @Override
    public String toString() {
        return "in bestelling";
    }
}
