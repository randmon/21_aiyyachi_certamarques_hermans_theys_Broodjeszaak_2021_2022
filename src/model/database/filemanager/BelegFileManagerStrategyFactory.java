package model.database.filemanager;

import model.domain.Beleg;

public class BelegFileManagerStrategyFactory {

    private static BelegFileManagerStrategyFactory instance;

    private BelegFileManagerStrategyFactory() {}

    public FileManagerStrategy<Beleg> createBelegStrategy(String fileType) {
        String className = FileManagerStrategyEnum.valueOf(fileType).getClassName("Beleg");
        try {
            Class<?> fileManagerClass = Class.forName(className);
            return (FileManagerStrategy<Beleg>) fileManagerClass.newInstance();
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid FileManagerStrategy!");
        }
    }

    //Singleton pattern
    public static BelegFileManagerStrategyFactory getInstance() {
        if(instance == null) instance = new BelegFileManagerStrategyFactory();
        return instance;
    }
}
