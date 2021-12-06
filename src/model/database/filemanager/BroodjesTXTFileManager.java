package model.database.filemanager;

import model.domain.Broodje;
import model.domain.DomainException;
import utilities.TXTManagerTemplate;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class BroodjesTXTFileManager extends TXTManagerTemplate implements FileManagerStrategy<Broodje> {

    public BroodjesTXTFileManager() {
        super("src/bestanden/broodjes.txt");
    }

    @Override
    public Map<String, Broodje> load() {

        Map<String, Broodje> broodjes = new TreeMap<>();
        ArrayList<ArrayList<String>> list = this.loadFromFile();

        for (ArrayList<String> params : list) {
            try {
                String naam = params.get(0);
                double prijs = Double.parseDouble(params.get(1));
                int voorraad = Integer.parseInt(params.get(2));
                int besteld = Integer.parseInt(params.get(3));

                broodjes.put(naam, new Broodje(naam, prijs, voorraad, besteld));
            } catch (DomainException de) {
                System.out.println(de.getMessage());
            } catch (NumberFormatException nfe) {
                System.out.println("Error reading line in " + path);
            }
        }
        return broodjes;
    }

    @Override
    public void save(Map<String, Broodje> broodjes) {
        ArrayList<ArrayList<String>> list = new ArrayList<>();
        for(Map.Entry<String, Broodje> entry : broodjes.entrySet()){
            ArrayList<String> result = new ArrayList<>();
            Broodje b = entry.getValue();
            result.add(entry.getKey());
            result.add(String.valueOf(b.getPrijs()));
            result.add(String.valueOf(b.getVoorraad()));
            result.add(String.valueOf(b.getBesteld()));

            list.add(result);
        }
        this.saveToFile(list);
    }
}
