package myLogging;

import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Date;

public abstract class Logger implements IFileOPS{

    public static String getDate(){
        Date currentDate = new Date();
        String str = String.format("%tc", currentDate );
        return str;

    }

    public static void setLog(String str){
        File f = new File("Log.txt");
        try{
            IFileOPS.createFile(f);
            FileWriter writeLog = new FileWriter(f,true);
            writeLog.write(getDate()+": "+str+"\n");
            writeLog.close();
        }catch(IOException e)
        {
            e.getStackTrace();
        }
    }

}
