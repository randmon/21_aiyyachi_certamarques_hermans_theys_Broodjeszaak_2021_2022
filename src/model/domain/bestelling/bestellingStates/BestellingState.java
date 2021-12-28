package model.domain.bestelling.bestellingStates;

import model.domain.DomainException;
import model.domain.bestelling.BestellingContext;

public interface BestellingState {
    default void start(BestellingContext context) {
        throw new DomainException("Kan bestelling niet starten want het is " + context.getState());
    }

    default void addBroodje(BestellingContext context){
        throw new DomainException("Kan broodje niet toevoegen want de bestelling is " + context.getState());
    }

    default void addBeleg(BestellingContext context) {
        throw new DomainException("Kan beleg niet toevoegen want de bestelling is " + context.getState());
    }

    default void addSameBroodje(BestellingContext context){
        throw new DomainException("Kan zelfde broodje niet toevoegen want de bestelling is " + context.getState());
    }

    default void verwijderBroodje(BestellingContext context) {
        throw new DomainException("Kan broodje niet verwijderen want de bestelling is " + context.getState());
    }

    default void afsluiten(BestellingContext context) {
        throw new DomainException("Kan bestelling niet afsluiten want de bestelling is " + context.getState());
    }

    default void annuleren(BestellingContext context) {
        throw new DomainException("Kan bestelling niet annuleren want de bestelling is " + context.getState());
    }

    default void betaal(BestellingContext context) {
        throw new DomainException("Kan bestelling niet betalen want de bestelling is " + context.getState());
    }

    default void zendNaarKeuken(BestellingContext context) {
        throw new DomainException("Kan bestelling niet naar keuken sturen want de bestelling is " + context.getState());
    }

    default void startBereiding(BestellingContext context) {
        throw new DomainException("Kan bestelling niet bereiden want de bestelling is~" + context.getState());
    }

    default void afwerken(BestellingContext context) {
        throw new DomainException("Kan bestelling niet afwerken want de bestelling is " + context.getState());
    }
}
