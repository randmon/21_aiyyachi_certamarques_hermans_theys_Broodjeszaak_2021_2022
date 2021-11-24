package model.database.filemanager;

import model.domain.Beleg;

import java.util.*;

public class BelegFileManager extends FileManagerTemplate<Beleg> {

    public BelegFileManager() {
        super("bestanden/beleg.txt");
    }

    @Override
    public Set<Beleg> loadFromFile(){
        //TODO implement
        return null;
    }

    @Override
    public void saveToFile(Set<Beleg> belegSet) {
        //TODO implement
    }
}
