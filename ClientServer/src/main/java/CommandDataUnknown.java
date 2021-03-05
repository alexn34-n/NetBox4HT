import java.io.Serializable;

public class CommandDataUnknown implements Serializable {
    String error;
    public CommandDataUnknown(String error) {
        this.error=error;
    }

    public String getError() {
        return error;
    }
}
