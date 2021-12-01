package utilities;

import java.util.ArrayList;

public abstract class FileManagerTemplate {
    protected String path;

    public FileManagerTemplate(String path) {
        setPath(path);
    }

    public abstract ArrayList<ArrayList<String>> loadFromFile();

    public abstract void saveToFile(ArrayList<ArrayList<String>> list);

    private void setPath(String path) {
        if (path == null || path.isEmpty()) throw new IllegalArgumentException("Pad mag niet leeg zijn");
        this.path = path;
    }
}
