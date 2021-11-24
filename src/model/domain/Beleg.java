package model.domain;

public class Beleg {
    private String naam;
    private double prijs;
    private int besteld;

    public Beleg(String naam, double prijs, int besteld) {
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
}
