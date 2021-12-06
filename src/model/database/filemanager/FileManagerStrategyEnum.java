package model.database.filemanager;

public enum FileManagerStrategyEnum {
    TXT("TXT", "TXTFileManager"), EXCEL("EXCEL", "ExcelFileManager");

    private final String fileType, className;

    FileManagerStrategyEnum(String fileType, String className) {
        this.fileType = fileType;
        this.className = className;
    }

    public String getFileType() {
        return fileType;
    }

    public String getClassName(String type) {
        return  "model.database.filemanager." + type + className;
    }
}
