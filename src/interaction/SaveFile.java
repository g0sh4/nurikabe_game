package interaction;

import java.io.*;

public class SaveFile {

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

            }catch(IOException ioe){
                ioe.printStackTrace();
            }

        }
    }

}
