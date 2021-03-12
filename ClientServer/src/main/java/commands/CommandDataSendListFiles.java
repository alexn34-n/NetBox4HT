package commands;

import java.io.Serializable;
import java.util.ArrayList;

public class CommandDataSendListFiles implements Serializable {
    ArrayList<String> filesList;

    public CommandDataSendListFiles(ArrayList<String> files){
        this.filesList=files;
    }

    public ArrayList<String> getFiles() {
        return filesList;
    }
}
