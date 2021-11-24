package model.database;

import model.database.filemanager.BroodjesFileManager;
import model.domain.Beleg;
import model.domain.Broodje;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class BroodjesDB {
    //Map met broodjes en hun voorraad
    private final TreeMap<Broodje, Integer> broodjes;

    public BroodjesDB() {
        this.broodjes = new TreeMap<>(Comparator.comparing(Broodje::getNaam));

        broodjes.put(new Broodje("test1", 1, 1), 1);
    }

    public TreeMap<Broodje, Integer> getBroodjesInAlfabetischeVolgorde(){
        return broodjes;
    }

    public Broodje getBroodjeByName(String name) {
        return null;
    }

    public void addBroodjes() {
        BroodjesFileManager fileManager = new BroodjesFileManager();
        broodjes.putAll(fileManager.loadFromFile());
        System.out.println(broodjes);
    }

    public void save() {
        BroodjesFileManager fileManager = new BroodjesFileManager();
        fileManager.saveToFile(broodjes);
    }
}
