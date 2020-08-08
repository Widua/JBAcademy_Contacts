package Commands;

import PhoneBook.PhoneBook;
import contacts.CompanyContact;
import contacts.PersonContact;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class AddCommand implements Command, CheckCorrectness {

    @Override
    public void execute() {
        System.out.println("Enter the type (person, organization):");
        String type = scan.nextLine();
        switch (type){
            case "organization":{
                addOrganization();
                break;
            }
            case "person":{
                addPerson();
            }
        }
    }

    private void addOrganization(){
        System.out.println("Enter the organization name: ");
        String orgName = scan.nextLine();
        System.out.println("Enter the address: ");
        String address = scan.nextLine();
        System.out.println("Enter the number: ");
        String number = scan.nextLine();
        if (!CheckCorrectness.checkNumber(number)){
            System.out.println("Wrong number format!");
            number = "[no number]";
        }
        CompanyContact contact = new CompanyContact();
        contact.setName(orgName);
        contact.setAddress(address);
        contact.setPhoneNumber(number);
        contact.setTimeLastEdit(LocalDateTime.now().withSecond(0).withNano(0));
        contact.setTimeCreated(LocalDateTime.now().withSecond(0).withNano(0));

        phoneBook.addContact(contact);

    }

    private void addPerson(){
        System.out.println("Enter the name: ");
        String name = scan.nextLine();

        System.out.println("Enter the surname: ");
        String surname = scan.nextLine();

        System.out.println("Enter the birth date: ");
        String bdate = scan.nextLine();

        if (!CheckCorrectness.checkDate(bdate)){
            System.out.println("Bad birth date!");
            bdate = "[no data]";
        }

        System.out.println("Enter the gender(M, F): ");
        String gender = scan.nextLine();

        if(!gender.equals("M") || !gender.equals("F")){
            System.out.println("Bad gender!");
            gender = "[no data]";
        }

        System.out.println("Enter the number: ");
        String number = scan.nextLine();
        if (!CheckCorrectness.checkNumber(number)){
            System.out.println("Wrong number format!");
            number = "[no number]";
        }
        PersonContact contact = new PersonContact();
        contact.setName(name);
        contact.setSurname(surname);
        contact.setBirthDate(bdate);
        contact.setGender(gender);
        contact.setPhoneNumber(number);
        contact.setTimeCreated(LocalDateTime.now().withSecond(0).withNano(0));
        contact.setTimeLastEdit(LocalDateTime.now().withSecond(0).withNano(0));
        phoneBook.addContact(contact);
    }


}
