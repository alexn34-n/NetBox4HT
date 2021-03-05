import java.io.Serializable;

public class CommandDataCreateDid implements Serializable {
    private String dirName;

    public CommandDataCreateDid(String dirName) {
        this.dirName = dirName;
    }

    public String getDirName() {
        return dirName;
    }
}
