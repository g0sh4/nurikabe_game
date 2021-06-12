package csv;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OpenCsvData {

    public List<String[]> csvData = new ArrayList<>();

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

    //ta metoda dorobilem kopiuj wklej z tej wyzej tylko zmieniony index z 2 na 3
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
}