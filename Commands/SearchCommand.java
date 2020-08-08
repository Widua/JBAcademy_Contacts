package Commands;

import contacts.CompanyContact;
import contacts.Contact;
import contacts.PersonContact;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchCommand implements Command{
    CommandController cc = new CommandController();

    @Override
    public void execute() {
        System.out.println("Enter search query: ");
        String toSearch = scan.nextLine();
        ArrayList<Contact> findedContacts = searchMatching(toSearch);
        int i=1;
        System.out.println("Found "+findedContacts.size()+" results: ");
        for (Contact contact : findedContacts) {
            if (contact instanceof PersonContact){
                PersonContact con = (PersonContact) contact;
                System.out.println(i+". "+con.getName()+" "+con.getSurname());
                i+=1;
            } else if (contact instanceof CompanyContact){
                CompanyContact con = (CompanyContact) contact;
                System.out.println(i+". "+con.getName());
                i+=1;
            }
        }
        System.out.println("[search] Enter action ([number], back, again): ");
        String action = scan.nextLine();
        if (action.equals("again")){
            execute();
        } else if (action.equals("back")){
            return;
        }else {
            int index = Integer.parseInt(action);
            index = index-1;
            RecordCommand record = new RecordCommand();
            Contact con = findedContacts.get(index);
            System.out.println(con.toString());
            record.chooseRecord(con, phoneBook.searchByName(findedContacts.get(index).getName()) );
            System.out.println("");

            cc.setCommand(record);
            cc.executeCommand();
        }


    }

    public ArrayList<Contact> searchMatching(String toSearch){
        ArrayList<Contact> finded = new ArrayList<>();
        Pattern pattern = Pattern.compile(toSearch, Pattern.CASE_INSENSITIVE);
        for (Contact contact : phoneBook.getPhoneBook()) {
            if (contact instanceof PersonContact){
                PersonContact pc = (PersonContact) contact;
                String find = pc.getName()+" "+pc.getSurname()+" "+pc.getPhoneNumber();
                Matcher match = pattern.matcher(find);
                if (match.find()){
                    finded.add(pc);
                }
            } else if (contact instanceof CompanyContact){
                CompanyContact cc = (CompanyContact) contact;
                String find = cc.getName()+" "+cc.getPhoneNumber();
                Matcher match = pattern.matcher(find);
                if (match.find()){
                    finded.add(cc);
                }

            }

        }

        return finded;
    }


}
