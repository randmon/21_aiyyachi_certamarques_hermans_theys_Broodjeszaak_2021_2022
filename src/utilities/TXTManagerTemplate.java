package utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public abstract class TXTManagerTemplate extends FileManagerTemplate {

    public TXTManagerTemplate(String path) {
        super(path);
    }

    @Override
    public ArrayList<ArrayList<String>> loadFromFile() {
        File file = new File(path);

        ArrayList<ArrayList<String>> result = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] params = line.split(",");
                ArrayList<String> l = new ArrayList<>(Arrays.asList(params));
                result.add(l);
            }

            scanner.close();
            System.out.println("Successfully loaded " + result.size() + " products from " + path);
        } catch (FileNotFoundException fnfe){
            System.out.println(path + " doesn't exist.");
        } catch (Exception e) {
            System.out.println("Error found reading " + path);
        }
        return result;
    }

    @Override
    public void saveToFile(ArrayList<ArrayList<String>> list) {
        try {
            FileWriter writer = new FileWriter(path);
            for (ArrayList<String> line : list) {
                writer.write(
                        line.get(0) + "," + line.get(1) + "," + line.get(2) + "," + line.get(3)+ "\n"
                );
            }
        } catch (IOException e) {
            System.out.println("File error!!");
            e.printStackTrace();
        }
        System.out.println("Succesfully wrote " + list.size() + " lines to " + path);
    }

}
