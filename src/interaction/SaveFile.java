package interaction;

import com.opencsv.exceptions.CsvException;

import java.io.*;

public class SaveFile {

    public SaveFile() throws IOException, CsvException {
        FileInputStream instream = null;
        FileOutputStream outstream = null;

        if(new File(Settings.path + "/boards.csv").exists()){


        }else{

            try{
                File infile =new File("csv_files/boards.csv");
                File outfile =new File(Settings.path + "/boards.csv");
                outfile.createNewFile();
                instream = new FileInputStream(infile);
                outstream = new FileOutputStream(outfile);
                byte[] buffer = new byte[1024];
                int length;

                while ((length = instream.read(buffer)) > 0){
                    outstream.write(buffer, 0, length);
                }
                instream.close();
                outstream.close();

            }catch(IOException ioe){
                ioe.printStackTrace();
            }

        }
    }

}
