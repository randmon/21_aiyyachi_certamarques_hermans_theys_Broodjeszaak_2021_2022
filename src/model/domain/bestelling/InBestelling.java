package model.domain.bestelling;

public class InBestelling extends BestellingState {
    @Override
    public void doAction(BestellingContext context) {
        System.out.println("In Bestelling state");
        context.setState(this);
    }

}
