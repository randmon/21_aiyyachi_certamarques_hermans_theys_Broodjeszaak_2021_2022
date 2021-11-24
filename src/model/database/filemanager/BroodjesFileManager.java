package model.database.filemanager;

import model.domain.Broodje;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class BroodjesFileManager extends  FileManagerTemplate<Broodje>{
    String path = "src/bestanden/broodjes.txt";
    @Override
    public TreeMap<Broodje, Integer> loadFromFile() {
        File broodjesFile = new File(path);
        TreeMap<Broodje, Integer> broodjes = new TreeMap<>(Comparator.comparing(Broodje::getNaam));

        //TODO read from file

        return broodjes;
    }

    @Override
    public void saveToFile(TreeMap<Broodje, Integer> lijst) {
        try {
            FileWriter writer = new FileWriter(path);
            for(Map.Entry<Broodje, Integer> entry : lijst.entrySet()){
                String result = entry.getKey().getNaam() + "," + entry.getKey().getPrijs() + "," + entry.getValue() + "," + entry.getKey().getBesteld();
                writer.write(result + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
