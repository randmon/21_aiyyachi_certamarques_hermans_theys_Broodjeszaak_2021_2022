package model;

import model.database.BroodjesDB;
import model.database.BelegDB;
import model.domain.Beleg;
import model.domain.Broodje;

import java.util.Observable;
import java.util.Set;

public class BestelFacade extends Observable {
    BroodjesDB broodjesDB;
    BelegDB belegDB;

    public BestelFacade(String fileType) {
        broodjesDB = BroodjesDB.getInstance(fileType);
        belegDB = BelegDB.getInstance(fileType);
    }

    public Set<Broodje> getBroodjes() {
        return broodjesDB.getAll();
    }

    public Set<Beleg> getBeleg() {
        return belegDB.getAll();
    }

    public void saveVoorraad() {
        broodjesDB.save();
        belegDB.save();
    }
}
