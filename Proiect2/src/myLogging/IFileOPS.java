package myLogging;

import java.io.File;
import java.io.IOException;

public interface IFileOPS {

    static void createFile(File f){
        try{
            f.createNewFile();
        }
        catch(IOException e){
            e.getStackTrace();
        }
    }

}
