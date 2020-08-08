package Commands;

import PhoneBook.PhoneBook;
import contacts.Contact;

import java.util.Scanner;

public interface Command {
    Scanner scan = new Scanner(System.in);
    PhoneBook phoneBook = new PhoneBook();
    void execute();
}



