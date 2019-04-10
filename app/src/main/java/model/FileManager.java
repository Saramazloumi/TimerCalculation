package model;

import android.content.Context;
import android.widget.Toast;

import java.io.File;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class FileManager {

    private Context context;
    public String FILE = "result.text";

    public FileManager(Context context){ this.context = context;}

    public void  writeInFile (ArrayList<StoreInformation> information){
        try{

            File path = new File(context.getFilesDir(),FILE);
            OutputStreamWriter osr = new OutputStreamWriter(context.openFileOutput(FILE,Context.MODE_PRIVATE));

            for(StoreInformation si: information){
                osr.write(si.toString());
            }
            Toast.makeText(context, "Results saved in " + path, Toast.LENGTH_SHORT).show();
            osr.close();
        }catch(Exception e){
            Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }

//    public String readFromFile(){
//
//
//
//
//    }
}