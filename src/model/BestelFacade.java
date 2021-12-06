package model;

import model.database.BelegDB;
import model.database.BroodjesDB;
import model.domain.Beleg;
import model.domain.Broodje;

import java.util.Map;
import java.util.Observable;

public class BestelFacade extends Observable {
    BroodjesDB broodjesDB;
    BelegDB belegDB;

    public BestelFacade(String fileType) {
        broodjesDB = BroodjesDB.getInstance(fileType);
        belegDB = BelegDB.getInstance(fileType);
    }

    public Map<String, Broodje> getBroodjes() {
        return broodjesDB.getAll();
    }

    public Map<String, Beleg> getBeleg() {
        return belegDB.getAll();
    }

    public void saveVoorraad() {
        broodjesDB.save();
        belegDB.save();
    }
}
