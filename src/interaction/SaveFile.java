package interaction;

import java.io.File;

public class SaveFile {
    public String fileName ="boards.csv";
    public SaveFile(String pathName){


        if(new File(pathName, fileName).exists()){
            //jeśli jest już plik o takiej nazwie w tym pliku
            File file = new File(fileName);

        }else{
            //zapis pliku w tym katalogu

        }
    }
}
