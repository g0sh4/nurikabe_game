package csv_txt;

import com.opencsv.*;
import com.opencsv.exceptions.CsvException;
import interaction.Settings;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OpenCsvData {

    public List<String[]> csvData;

    private String[] easyNames;
    private String[] mediumNames;
    private String[] hardNames;


    public OpenCsvData(String fileName) throws IOException, CsvException {
        FileReader fr = new FileReader(new File(fileName));
        CSVParser praser = new CSVParserBuilder().withSeparator(',').build();
        CSVReader csvReader = new CSVReaderBuilder(fr)
                                    .withCSVParser(praser)
                                    .build();
        csvData = csvReader.readAll();
    }

    public ArrayList<String[]> getBoardNames() {
        ArrayList<String> boardNames = new ArrayList<>();
        for (int i = 1; i < csvData.size(); i++) {
            boardNames.add(csvData.get(i)[0]);
        }
        String[] names = boardNames.toArray(new String[0]);

        ArrayList<Integer> onesIndexes = new ArrayList<>();
        //selection by level
        for (int i = 0; i<names.length; i++) {
            if (names[i].equals("1")) {
                onesIndexes.add(i);
            }
        }

        easyNames = Arrays.copyOfRange(names, onesIndexes.get(0), onesIndexes.get(1));
        mediumNames = Arrays.copyOfRange(names, onesIndexes.get(1), onesIndexes.get(2));
        hardNames = Arrays.copyOfRange(names, onesIndexes.get(2), names.length);

        ArrayList<String[]> listOfNames = new ArrayList<>();
        listOfNames.add(easyNames);
        listOfNames.add(mediumNames);
        listOfNames.add(hardNames);

        System.out.println(listOfNames);

        return listOfNames;
    }

    public String getBoardDescription(String name, int x) {
        ArrayList<Integer> indexes = new ArrayList<>();

        for (String[] y: csvData) {
            if (y[0].equals(name)){
                indexes.add(csvData.indexOf(y));
            }
        }

        int index = indexes.get(x);

        return csvData.get(index)[2];
    }

    public String getBoardSolution(String name, int x) {
        ArrayList<Integer> indexes = new ArrayList<>();

        for (String[] y: csvData) {
            if (y[0].equals(name)){
                indexes.add(csvData.indexOf(y));
            }
        }

        int index = indexes.get(x);

        return csvData.get(index)[3];
    }

    public String getBoardSaved(String name, int x) {
        ArrayList<Integer> indexes = new ArrayList<>();

        for (String[] y: csvData) {
            if (y[0].equals(name)){
                indexes.add(csvData.indexOf(y));
            }
        }

        int index = indexes.get(x);

        return csvData.get(index)[4];
    }
    public void addUserChanges(int row, String[]changedBoard) throws IOException {


        String[] buffor = csvData.get(row);
        ArrayList<String> scripts = new ArrayList<String>();
        scripts.add(buffor[0]);
        scripts.add(buffor[1]);
        scripts.add(buffor[2]);
        scripts.add(buffor[3]);
        scripts.add(changedBoard[0]);

        String[] strings = scripts.toArray(String[]::new);
        File file = new File(Settings.path + "/boards.csv");
        FileWriter outputfile = new FileWriter(file);
        CSVWriter writer = new CSVWriter(outputfile);
        csvData.remove(row);
        csvData.add(row, strings);
        writer.writeAll(csvData);
        writer.close();
    }
}