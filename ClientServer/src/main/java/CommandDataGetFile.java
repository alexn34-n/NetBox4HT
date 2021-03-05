import java.io.Serializable;

public class CommandDataGetFile implements Serializable {
    String fileName;

    public CommandDataGetFile(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }
}
