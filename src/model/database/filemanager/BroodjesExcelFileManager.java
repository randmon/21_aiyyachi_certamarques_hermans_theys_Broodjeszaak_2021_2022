package model.database.filemanager;

import model.domain.Broodje;
import model.domain.DomainException;
import utilities.ExcelManagerTemplate;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class BroodjesExcelFileManager extends ExcelManagerTemplate implements FileManagerStrategy<Broodje> {

    public BroodjesExcelFileManager() {
        super("src/bestanden/broodjes.xls");
    }

    @Override
    public Set<Broodje> load() {
        Set<Broodje> broodjes = new TreeSet<>(Comparator.comparing(Broodje::getNaam));
        ArrayList<ArrayList<String>> list = this.loadFromFile();

        for (ArrayList<String> params : list) {
            try {
                String naam = params.get(0);
                double prijs = Double.parseDouble(params.get(1));
                int voorraad = Integer.parseInt(params.get(2));
                int besteld = Integer.parseInt(params.get(3));

                broodjes.add(new Broodje(naam, prijs, voorraad, besteld));
            } catch (DomainException de) {
                System.out.println(de.getMessage());
            } catch (NumberFormatException nfe) {
                System.out.println("Error reading line in " + path);
            }
        }
        return broodjes;
    }

    @Override
    public void save(Set<Broodje> broodjes) {
        ArrayList<ArrayList<String>> list = new ArrayList<>();
        for(Broodje b : broodjes){
            ArrayList<String> result = new ArrayList<>();
            result.add(b.getNaam());
            result.add(String.valueOf(b.getPrijs()));
            result.add(String.valueOf(b.getVoorraad()));
            result.add(String.valueOf(b.getBesteld()));

            list.add(result);
        }
        this.saveToFile(list);
    }
}
