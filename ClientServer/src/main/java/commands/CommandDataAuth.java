package commands;

import java.io.Serializable;

public class CommandDataAuth implements Serializable {
    String login;
    String password;

    public CommandDataAuth(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "commands.CommandDataAuth{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
