package interaction;

import com.opencsv.exceptions.CsvException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SaveFile {
    //public String fileName ="csv_files/boards.csv";
    public String fileName ="boards.csv";
    public SaveFile(String pathName) throws IOException {
        FileInputStream instream = null;
        FileOutputStream outstream = null;

        if(new File(pathName, fileName).exists()){
            try{
                File infile =new File("csv_files/boards.csv");
                File outfile =new File(pathName+"\\"+fileName);
                instream = new FileInputStream(infile);
                outstream = new FileOutputStream(outfile);
                byte[] buffer = new byte[1024];
                int length;

                while ((length = instream.read(buffer)) > 0){
                    outstream.write(buffer, 0, length);
                }

                instream.close();
                outstream.close();

                System.out.println("File copied successfully!!");

            }catch(IOException ioe){
                ioe.printStackTrace();
            }

        }else{

            try{
                File infile =new File("csv_files/boards.csv");
                File outfile =new File(pathName+"\\"+fileName);
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

                System.out.println("File copied successfully!!");

            }catch(IOException ioe){
                ioe.printStackTrace();
            }

        }
    }
    public static void main(String[] args) throws IOException, CsvException {
    //SaveFile saveFile = new SaveFile("D:\\STUDIA\\SEMESTR_2\\ANALIZA 2");

    }
}
