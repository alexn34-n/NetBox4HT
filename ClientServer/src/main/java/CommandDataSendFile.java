import java.io.Serializable;

public class CommandDataSendFile implements Serializable {
    String fileName;
    Long FileSize;

    public CommandDataSendFile(String fileName, Long fileSize) {
        this.fileName = fileName;
        FileSize = fileSize;
    }

    public String getFileName() {
        return fileName;
    }

    public long getFileSize() {
        return FileSize;
    }
}
