package model.database.filemanager;

import model.domain.Broodje;

public class BroodjesFileManagerStrategyFactory {
    private static BroodjesFileManagerStrategyFactory instance;

    private BroodjesFileManagerStrategyFactory() {}

    public FileManagerStrategy<Broodje> createBroodjesStrategy(String fileType) {
        String className = FileManagerStrategyEnum.valueOf(fileType).getClassName("Broodjes");
        try {
            Class<?> fileManagerClass = Class.forName(className);
            return (FileManagerStrategy<Broodje>) fileManagerClass.newInstance();
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid FileManagerStrategy!");
        }
    }

    //Singleton pattern
    public static BroodjesFileManagerStrategyFactory getInstance() {
        if(instance == null) instance = new BroodjesFileManagerStrategyFactory();
        return instance;
    }
}
