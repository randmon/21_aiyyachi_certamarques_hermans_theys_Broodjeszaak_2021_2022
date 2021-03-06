package utilities;

import excel.ExcelPlugin;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public abstract class ExcelManagerTemplate extends FileManagerTemplate {

    private final ExcelPlugin excelPlugin = new ExcelPlugin();

    public ExcelManagerTemplate(String path) {
        super(path);
    }

    @Override
    public ArrayList<ArrayList<String>> loadFromFile() {
        File file = new File(path);
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        try {
            result =  excelPlugin.read(file);
            System.out.println("Successfully loaded " + result.size() + " products from " + path);
        } catch (IOException | BiffException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void saveToFile(ArrayList<ArrayList<String>> list) {
        File file = new File(path);
        try {
            excelPlugin.write(file, list);
        } catch (IOException | BiffException | WriteException e) {
            System.out.println("File error!!");
            e.printStackTrace();
        }
        System.out.println("Succesfully wrote " + list.size() + " lines to " + path);
    }
}
