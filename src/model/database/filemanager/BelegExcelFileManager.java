package model.database.filemanager;

import model.domain.Beleg;
import model.domain.DomainException;
import utilities.ExcelManagerTemplate;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;


public class BelegExcelFileManager extends ExcelManagerTemplate implements FileManagerStrategy<Beleg> {

    public BelegExcelFileManager() {
        super("src/bestanden/beleg.xls");
    }

    @Override
    public Map<String, Beleg> load() {
        Map<String, Beleg> belegMap = new TreeMap<>();
        ArrayList<ArrayList<String>> list = this.loadFromFile();

        for (ArrayList<String> params : list) {
            try {
                String naam = params.get(0);
                double prijs = Double.parseDouble(params.get(1));
                int voorraad = Integer.parseInt(params.get(2));
                int besteld = Integer.parseInt(params.get(3));

                belegMap.put(naam, new Beleg(naam, prijs, voorraad, besteld));
            } catch (DomainException de) {
                System.out.println(de.getMessage());
            } catch (NumberFormatException nfe) {
                System.out.println("Error reading line in " + path);
            }
        }
        return belegMap;
    }

    @Override
    public void save(Map<String, Beleg> belegMap) {
        ArrayList<ArrayList<String>> list = new ArrayList<>();
        for(Map.Entry<String, Beleg> entry : belegMap.entrySet()){
            ArrayList<String> result = new ArrayList<>();
            Beleg b = entry.getValue();
            result.add(entry.getKey());
            result.add(String.valueOf(b.getPrijs()));
            result.add(String.valueOf(b.getVoorraad()));
            result.add(String.valueOf(b.getBesteld()));

            list.add(result);
        }
        this.saveToFile(list);
    }
}
