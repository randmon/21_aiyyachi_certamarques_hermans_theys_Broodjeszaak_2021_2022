package model.domain;

import java.util.List;

public class Broodje {
    private String naam;
    private double prijs;
    private int besteld;
    private List<Beleg> belegLijst;

    public Broodje(String naam, double prijs, int besteld) {
        this.naam = naam;
        this.prijs = prijs;
        this.besteld = besteld;
    }

    public String getNaam() {
        return naam;
    }

    public double getPrijs() {
        return prijs;
    }

    public int getBesteld() {
        return besteld;
    }

    public List<Beleg> getBelegLijst() {
        return belegLijst;
    }

    public void addBeleg(Beleg beleg) {
        if (beleg != null) {
            belegLijst.add(beleg);
        }
    }

    public void addBeleg(List<Beleg> belegLijst) {
        belegLijst.addAll(belegLijst);
    }

    @Override
    public String toString() {
        return naam;
    }
}
