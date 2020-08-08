package PhoneBook;

import contacts.CompanyContact;
import contacts.Contact;
import contacts.PersonContact;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class PhoneBook implements Serializable {
    private static final long serialVersionUID = 1L;

    private ArrayList <Contact> phoneBook = new ArrayList<>();

    public void addContact(Contact contact){
        phoneBook.add(contact);
    }

    public void removeContact(Contact contact){
        phoneBook.remove(contact);
    }

    public int getSize(){ return phoneBook.size(); }

    public ArrayList<Contact> getPhoneBook(){
        return phoneBook;
    }

    public void switchPhoneBook(PhoneBook phoneBook){
        this.phoneBook = phoneBook.getPhoneBook();
    }

    public Contact getContact(int index){ return phoneBook.get(index); }

    public void replaceContacts(Contact baseContact , Contact toReplace){
        phoneBook.remove(baseContact);
        phoneBook.add(toReplace);
    }

    public void listContacts(){
        int i =1;
        for (Contact contact : phoneBook) {
            if (contact instanceof PersonContact){
                PersonContact personContact = (PersonContact) contact;
                System.out.println(i + ". "+personContact.getName()+" "+personContact.getSurname());
            } else if (contact instanceof CompanyContact){
                CompanyContact companyContact = (CompanyContact) contact;
                System.out.println(i+". "+ companyContact.getName());
            }
            i+=1;
        }
        System.out.println("");
    }

    public int searchByName(String name){
        for (int i=0 ; i < phoneBook.size() ; i++){
            if (phoneBook.get(i).getName().equals(name)){
                return i;
            }
        }
        return 0;
    }


}
