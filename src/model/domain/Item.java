package model.domain;

import java.util.List;

/**
 * Een item is een rij in een bestelling
 * Elke item heeft een broodje en een lijst van beleg
 * */
public class Item {
    private final Broodje broodje;
    private final List<Beleg> beleg;

    public Item(Broodje broodje, List<Beleg> beleg) {
        this.broodje = broodje;
        this.beleg = beleg;
    }

    public void addBeleg(Beleg beleg) {
        this.beleg.add(beleg);
    }

    public List<Beleg> getBeleg() {
        return beleg;
        //return String.join(", ", beleg);
    }

    public Broodje getBroodje() {
        return broodje;
    }
}
