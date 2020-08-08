package Commands;

import PhoneBook.PhoneBook;
import Serialization.SerializationUtils;

import java.io.IOException;

public class LoadPhoneBookCommand implements Command {
    String fileName;
    @Override
    public void execute() {
        try {
            loadFile();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void loadFileName(String fileName) {
        this.fileName = fileName;
    }

    public void loadFile() throws IOException, ClassNotFoundException {
        phoneBook.switchPhoneBook((PhoneBook) SerializationUtils.deserializeObject(fileName));
    }
}
