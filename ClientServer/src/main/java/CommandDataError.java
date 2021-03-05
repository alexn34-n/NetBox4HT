import java.io.Serializable;

public class CommandDataError implements Serializable {
    String error;

    public CommandDataError(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }
}
