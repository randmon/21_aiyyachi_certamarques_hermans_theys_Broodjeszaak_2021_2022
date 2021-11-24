package model.database;

import model.domain.Beleg;
import model.domain.Broodje;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class BelegDB {
    private final TreeMap<Beleg, Integer> belegTreeSet;

    private BelegDB() {
        this.belegTreeSet = new TreeMap<>(Comparator.comparing(Beleg::getNaam));
    }

    public Map<Beleg, Integer> getBeleg() {
        return belegTreeSet;
    }

    public Broodje getBelegByName(String name) {
        return null;
    }

    public void addBeleg(Broodje broodje) {

    }


}
