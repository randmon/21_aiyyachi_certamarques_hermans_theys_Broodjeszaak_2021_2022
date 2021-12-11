package model.domain;

import java.util.List;

/**
 * Een item is een rij in een bestelling
 * Elke item heeft een broodje en een lijst van beleg
 * */
public class Item {
    private final String broodje;
    private final List<String> beleg;

    public Item(String broodje, List<String> beleg) {
        this.broodje = broodje;
        this.beleg = beleg;
    }

    public void addBeleg(String beleg) {
        this.beleg.add(beleg);
    }

    public String getBeleg() {
        return String.join(", ", beleg);
    }

    public String getBroodje() {
        return broodje;
    }
}
