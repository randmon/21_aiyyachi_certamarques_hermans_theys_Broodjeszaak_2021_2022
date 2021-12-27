package model.database;

import model.database.filemanager.BelegFileManagerStrategyFactory;
import model.domain.Beleg;

import java.util.TreeMap;

public class BelegDB extends DB<Beleg> {
    private static BelegDB instance;

    private BelegDB(String fileType) {
        super(
                BelegFileManagerStrategyFactory.getInstance().createBelegStrategy(fileType),
                new TreeMap<>()
        );
    }

    //Singleton pattern
    public static BelegDB getInstance(String fileType) {
        if(instance == null) instance = new BelegDB(fileType);
        return instance;
    }

    @Override
    public void setVoorraad(Beleg b, int amount) {
        b.setVoorraad(amount);
    }
}
