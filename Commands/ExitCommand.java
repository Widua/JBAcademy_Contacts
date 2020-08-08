package Commands;

import Serialization.SerializationUtils;

import java.io.IOException;

public class ExitCommand implements Command {

    @Override
    public void execute() {

        try {
            saveFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.exit(0);
    }

    public void saveFile() throws IOException {
        SerializationUtils.serializeObject(phoneBook,"phonebook.db");
    }

}
