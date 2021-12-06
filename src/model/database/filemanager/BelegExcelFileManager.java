package model.database.filemanager;

import model.domain.Beleg;
import model.domain.DomainException;
import utilities.ExcelManagerTemplate;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class BelegExcelFileManager extends ExcelManagerTemplate implements FileManagerStrategy<Beleg> {

    public BelegExcelFileManager() {
        super("src/bestanden/beleg.xls");
    }

    @Override
    public Set<Beleg> load() {
        Set<Beleg> beleg = new TreeSet<>(Comparator.comparing(Beleg::getNaam));
        ArrayList<ArrayList<String>> list = this.loadFromFile();

        for (ArrayList<String> params : list) {
            try {
                String naam = params.get(0);
                double prijs = Double.parseDouble(params.get(1));
                int voorraad = Integer.parseInt(params.get(2));
                int besteld = Integer.parseInt(params.get(3));

                beleg.add(new Beleg(naam, prijs, voorraad, besteld));
            } catch (DomainException de) {
                System.out.println(de.getMessage());
            } catch (NumberFormatException nfe) {
                System.out.println("Error reading line in " + path);
            }
        }
        return beleg;
    }

    @Override
    public void save(Set<Beleg> belegSet) {
        ArrayList<ArrayList<String>> list = new ArrayList<>();
        for(Beleg b : belegSet){
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
