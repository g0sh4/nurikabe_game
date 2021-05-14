import Gui.Gui;
import Gui.GuiMenu;
import com.opencsv.exceptions.CsvException;
import csv.OpenCsvData;
import interaction.StartGame;

import java.io.IOException;

public class Main {
    //adding main
    public static void main(String[] args) throws IOException, CsvException {
        new StartGame();
        OpenCsvData openCsvData = new OpenCsvData("src/csv/boards.csv");
        System.out.println(openCsvData.csvData.get(1)[2]);
        System.out.println(openCsvData.getBoardNames());
    }
}
