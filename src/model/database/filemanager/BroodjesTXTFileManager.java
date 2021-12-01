package model.database.filemanager;

import model.domain.Broodje;
import model.domain.DomainException;
import utilities.FileManagerTemplate;
import utilities.TXTManagerTemplate;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class BroodjesTXTFileManager extends TXTManagerTemplate implements FileManagerStrategy<Broodje> {

    public BroodjesTXTFileManager() {
        super("src/bestanden/broodjes.txt");
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
