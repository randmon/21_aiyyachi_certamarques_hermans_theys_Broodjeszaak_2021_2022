package model.domain;

public abstract class Product {
    private String naam;
    private double prijs;
    private int voorraad, besteld;

    public Product(String naam, double prijs, int voorraad, int besteld) {
        setNaam(naam);
        setPrijs(prijs);
        setVoorraad(voorraad);
        setBesteld(besteld);
    }

    //GETTERS

    public String getNaam() {
        return naam;
    }

    public double getPrijs() {
        return prijs;
    }

    public int getVoorraad() {
        return voorraad;
    }

    public int getBesteld() {
        return besteld;
    }

    //SETTERS

    public void setNaam(String naam) {
        if (naam == null || naam.isEmpty()) throw new DomainException("Naam mag niet leeg zijn");
        this.naam = naam;
    }

    public void setPrijs(double prijs) {
        if (prijs < 0) throw new DomainException("Prijs mag niet negatief zijn");
        this.prijs = prijs;
    }

    public void setVoorraad(int voorraad) {
        if (voorraad < 0) throw new DomainException("Voorraad mag niet negatief zijn");
        this.voorraad = voorraad;
    }

    public void setBesteld(int besteld) {
        if (besteld < 0) throw new DomainException("Aantal besteld mag niet negatief zijn");
        this.besteld = besteld;
    }

    @Override
    public String toString() {
        return getNaam() + "," + getPrijs() + "," + getVoorraad() + "," + getBesteld();
    }
}
