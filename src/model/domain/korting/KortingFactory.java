package model.domain.korting;

import model.database.filemanager.BroodjesFileManagerStrategyFactory;
import model.domain.DomainException;

public class KortingFactory {
    public static KortingFactory instance;

    public Korting getKorting(String text) {
        KortingEnum kortingEnum = null;
        for (KortingEnum k : KortingEnum.values()){
            if (k.getText().equals(text)) {
                kortingEnum = k;
                break;
            }
        }
        try {
            if (kortingEnum == null) throw new DomainException();
            String className = kortingEnum.getClassName();
            Class<?> kortingClass = Class.forName(className);
            return (Korting) kortingClass.newInstance();
        } catch (Exception e) {
            throw new DomainException("Ongeldige korting");
        }
    }

    //Singleton pattern
    public static KortingFactory getInstance() {
        if(instance == null) instance = new KortingFactory();
        return instance;
    }
}
