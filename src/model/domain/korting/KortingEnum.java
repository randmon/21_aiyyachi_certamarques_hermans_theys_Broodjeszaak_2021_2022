package model.domain.korting;

public enum KortingEnum {
    GEEN("Geen korting", "GeenKorting"),
    TIEN_PROCENT ("10% korting op ganse bestelling", "TienProcent"),
    GOEDKOOPSTE_GRATIS ("Goedkoopste broodje met beleg gratis", "GoedkoopsteGratis");

    private final String text, classname;

    KortingEnum(String text, String classname) {
        this.text = text;
        this.classname = classname;
    }

    public String getText() {
        return text;
    }

    public String getClassName() {
        return "model.domain.korting." + classname;
    }
}