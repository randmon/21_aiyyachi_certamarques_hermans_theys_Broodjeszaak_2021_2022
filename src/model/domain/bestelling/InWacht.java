package model.domain.bestelling;

public class InWacht extends BestellingState {
    @Override
    public void doAction(BestellingContext context) {
        System.out.println("In Waiting state");
        context.setState(this);
    }
}
