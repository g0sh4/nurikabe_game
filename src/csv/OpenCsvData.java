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
import java.util.List;

public class OpenCsvData {

    public List<String[]> csvData = new ArrayList<>();


    public OpenCsvData(String fileName) throws IOException, CsvException {
        FileReader fr = new FileReader(new File(fileName));
        CSVParser praser = new CSVParserBuilder().withSeparator(',').build();
        CSVReader csvReader = new CSVReaderBuilder(fr)
                                    .withCSVParser(praser)
                                    .build();
        csvData = csvReader.readAll();
    }

    public ArrayList<String> getBoardNames() {
        ArrayList<String> boardNames = new ArrayList<>();
        for (int i = 1; i < csvData.size(); i++) {
            boardNames.add(csvData.get(i)[0]);
        }
        return boardNames;
    }
}
