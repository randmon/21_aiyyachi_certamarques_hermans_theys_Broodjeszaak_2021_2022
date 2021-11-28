package model.database.filemanager;

import model.domain.Beleg;
import model.domain.Broodje;
import model.domain.DomainException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class BelegFileManager extends FileManagerTemplate<Beleg> {

    public BelegFileManager() {
        super("src/bestanden/beleg.txt");
    }

    @Override
    public Set<Beleg> loadFromFile(){
        File file = new File(path);
        Set<Beleg> belegsoorten = new TreeSet<>(Comparator.comparing(Beleg::getNaam));

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] params = line.split(",");

                try {
                    String naam = params[0];
                    double prijs = Double.parseDouble(params[1]);
                    int voorraad = Integer.parseInt(params[2]);
                    int besteld = Integer.parseInt(params[3]);

                    belegsoorten.add(new Beleg(naam, prijs, voorraad, besteld));
                } catch (DomainException de) {
                    System.out.println(de.getMessage());
                } catch (NumberFormatException nfe) {
                    System.out.println("Error reading line in " + path);
                }
            }

            scanner.close();
            System.out.println("Successfully loaded " + belegsoorten.size() + " products from " + path);
        } catch (FileNotFoundException fnfe){
            System.out.println(path + " doesn't exist.");
        } catch (Exception e) {
            System.out.println("Error found reading " + path);
        }
        return belegsoorten;
    }

    @Override
    public void saveToFile(Set<Beleg> belegSet) {
        try {
            FileWriter writer = new FileWriter(path);
            for(Beleg b : belegSet){
                String result = b.toString();
                writer.write(result + "\n");
            }
            writer.close();
            System.out.println("Succesfully wrote " + belegSet.size() + " lines to " + path);
        } catch (IOException e) {
            System.out.println("File error!!");
            e.printStackTrace();
        }
    }
}
