package model.database.filemanager;

import model.domain.Beleg;

import java.io.File;
import java.util.Map;
import java.util.TreeMap;

public class BelegFileManager extends FileManagerTemplate<Beleg>{
    String path = "bestanden/beleg.txt";
    @Override
    public TreeMap<Beleg, Integer> loadFromFile(){
        File broodjesFile = new File(path);

        return null;
    }

    @Override
    public void saveToFile(TreeMap<Beleg, Integer> lijst) {

    }
}
