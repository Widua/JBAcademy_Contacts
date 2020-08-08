package Commands;

import contacts.CompanyContact;
import contacts.Contact;
import contacts.PersonContact;

public class ListCommand implements Command {
    String decision;
    @Override
    public void execute() {
        CommandController comcon = new CommandController();
        phoneBook.listContacts();
            System.out.println("[list] Enter action([number], back)");
            decision=scan.nextLine();
            if (decision.equals("back")){
                return;
            }
            int index = Integer.parseInt(decision);
            index = index -1;
            Contact con = phoneBook.getContact(index);
            if (con instanceof PersonContact){
                PersonContact ps = (PersonContact) con;
                System.out.println(ps.toString());
                System.out.println();
            }else if (con instanceof CompanyContact){
                CompanyContact cc = (CompanyContact) con;
                System.out.println(cc.toString());
                System.out.println();
            }
            RecordCommand record = new RecordCommand();
            record.chooseRecord(con, index);
            comcon.setCommand(record);
            comcon.executeCommand();


    }



}
