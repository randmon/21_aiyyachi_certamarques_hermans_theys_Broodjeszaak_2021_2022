package model.database;

import model.database.filemanager.BelegFileManagerStrategyFactory;
import model.domain.Beleg;

import java.util.Comparator;
import java.util.TreeSet;

public class BelegDB extends DB<Beleg> {
    private static BelegDB instance;

    private BelegDB(String fileType) {
        super(
                BelegFileManagerStrategyFactory.getInstance().createBelegStrategy(fileType),
                new TreeSet<>(Comparator.comparing(Beleg::getNaam)));
    }

    //Singleton pattern
    public static BelegDB getInstance(String fileType) {
        if(instance == null) instance = new BelegDB(fileType);
        return instance;
    }


}
