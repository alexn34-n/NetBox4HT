package commands;

import java.io.Serializable;

public class CommandDataChangeDirectory implements Serializable {
    String path;

    public CommandDataChangeDirectory(String path){
        this.path=path;
    }

    public String getPath() {
        return path;
    }

    @Override
    public String toString() {
        return "commands.CommandDataChangeDirectory{" +
                "path='" + path + '\'' +
                '}';
    }

}
