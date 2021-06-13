package csv;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class OpenTxtData {

    public String path;
    private final String filePath = "csv_files/path.txt";

    public OpenTxtData() throws IOException {
        Scanner myReader = new Scanner(new File(filePath));
        if (myReader.hasNext()){
            path = myReader.next();
        }
    }

    public void setPathInFile(String path) throws IOException {
        FileWriter fileWriter = new FileWriter(filePath);
        fileWriter.write(path);
    }

    public String getPathIfExist(){
        if (path == null){
            return null;
        }
        else return path;
    }
}