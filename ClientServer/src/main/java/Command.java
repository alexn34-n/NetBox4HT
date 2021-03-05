import java.io.Serializable;
import java.util.ArrayList;

public class Command implements Serializable {
    private CommandType type;
    private Object data;

    public Command authCommand(String login, String password) {
        Command command = new Command();
        command.type = CommandType.AUTH;
        command.data = new CommandDataAuth(login,password);
        return command;
    }

    public Command listFilesCommand(){
        Command command = new Command();
        command.type=CommandType.LS;
        command.data= new CommandDataListFiles();
        return command;
    }
    public Command changeDirectory(String directory){
        Command command = new Command();
        command.type=CommandType.CD;
        command.data= new CommandDataChangeDirectory(directory);
        return command;
    }
    public Command unknownCommand(String error){
        Command command= new Command();
        command.type= CommandType.UNKNOWN;
        command.data= new CommandDataUnknown(error);
        return command;
    }

    public Command successAuth (String login){
        Command command = new Command();
        command.type = CommandType.AUTH_OK;
        command.data = new CommandResultOK("Авторизация прошла успешно!", login);
        return command;
    }

    public Command sendListFiles(ArrayList<String> filesList){
        Command command = new Command();
        command.type=CommandType.LS_OK;
        command.data=new CommandDataSendListFiles(filesList);
        return command;
    }

    public Command getFileFromServer (String fileName){
        Command command = new Command();
        command.type = CommandType.GET;
        command.data = new CommandDataGetFile(fileName);
        return command;
    }

    public Command sendFile (String fileName, Long fileSize){
        Command command = new Command();
        command.type = CommandType.SEND;
        command.data = new CommandDataSendFile(fileName, fileSize);
        return  command;
    }


    public Command file (byte[] buffer, int ptr){
        Command command= new Command();
        command.type=CommandType.FILE;
        command.data=new FileInBuffer(buffer,ptr);
        return command;
    }
    public Command error (String error){
        Command command = new Command();
        command.type = CommandType.ERROR;
        command.data = new CommandDataError(error);
        return command;
    }

    public Command createNewDir(String dirName){
        Command command = new Command();
        command.type= CommandType.CREATE;
        command.data= new CommandDataCreateDid(dirName);
        return command;
    }

    public Command success(String message){
        Command command = new Command();
        command.type = CommandType.OK;
        command.data = new CommandResultOK("Операция успешно выполнена!", message);
        return command;
    }

    public CommandType getType() {
        return type;
    }

    public Object getData() {
        return data;
    }
}
