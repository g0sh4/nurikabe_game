package csv_txt;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class OpenTxtData {

    public String path;
    private final String filePath = "csv_txt_files/path.txt";

    public OpenTxtData() throws IOException {
        Scanner myReader = new Scanner(new File(filePath));
        if (myReader.hasNext()){
            path = myReader.next();
        }
    }

    public void setPathInFile(String path) throws IOException {
        FileWriter fileWriter = new FileWriter(filePath);
        fileWriter.write(path);
        fileWriter.close();
    }

    public String getPathIfExist(){
        if (path == null){
            return null;
        }
        else return path;
    }
}
