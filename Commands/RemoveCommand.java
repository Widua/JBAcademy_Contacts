package Commands;

import contacts.Contact;

public class RemoveCommand implements Command{

    int index;
    Contact con;

    public void setIndex(int index){
        this.index = index;
    }

    public void setContact(Contact con){
        this.con = con;
    }

    @Override
    public void execute() {
        Contact con = phoneBook.getContact(index);
        phoneBook.removeContact(con);
        System.out.println("Record removed");

    }
}
