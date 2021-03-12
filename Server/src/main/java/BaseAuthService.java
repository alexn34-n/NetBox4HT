import java.sql.*;

public class BaseAuthService {
    private Connection connection;
    private PreparedStatement regPrepStm;
    private PreparedStatement authPrepStm;
    private PreparedStatement changeNickStw;

    public BaseAuthService(){
        try {
            connect();
        } catch (SQLException|ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection= DriverManager.getConnection("jdbc:sqlite:Enter1.db");
    }

    public void disconnect() {
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void regStatement () throws SQLException {
        regPrepStm = connection.prepareStatement("INSERT INTO users (nick,login,password) VALUES (?,?,?);");
    }
    public void authStatement () throws SQLException {
        authPrepStm = connection.prepareStatement("SELECT * FROM users WHERE login= ? AND password= ?;");
    }

    public String checkAuth(String login, String password){
        try {
            authStatement();
            authPrepStm.setString(1,login);
            authPrepStm.setString(2,password);
            ResultSet rez = authPrepStm.executeQuery();
            if (rez.next()) {
                System.out.println(login+ " прошел авторизацию.");

                return login;
            }
            else {

                return null;
            }

        } catch (SQLException throwables) {

            throwables.printStackTrace();
        }
        finally {

            try {
                authPrepStm.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }
}


