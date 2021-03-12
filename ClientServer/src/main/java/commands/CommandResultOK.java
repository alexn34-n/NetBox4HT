package commands;

import java.io.Serializable;

public class CommandResultOK implements Serializable {
    String result;
    String login;

    public CommandResultOK(String result, String login) {
        this.result = result;
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public String getResult() {
        return result;
    }

}
