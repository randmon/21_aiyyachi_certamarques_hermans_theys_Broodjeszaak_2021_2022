package model.domain.bestelling;

public abstract class BestellingState {
    public abstract void doAction(BestellingContext context);
}
