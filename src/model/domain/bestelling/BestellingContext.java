package model.domain.bestelling;

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
