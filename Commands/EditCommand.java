package Commands;

import contacts.CompanyContact;
import contacts.Contact;
import contacts.PersonContact;

import java.time.LocalDateTime;

public class EditCommand implements Command, CheckCorrectness {
    private Contact con;
    private int index;

    public void setIndex(int index){
        this.index = index;
    }

    public void setContact(Contact con){
        this.con = con;
    }



    @Override
    public void execute() {
        if (con != null){
            con = phoneBook.getContact(index);
        }

        if (con instanceof CompanyContact){
            CompanyContact cc = (CompanyContact) con;
            System.out.println("Select a field(name, address, number)");
            String field = scan.nextLine();
            switch (field){
                case "name":{
                    cc = (CompanyContact) changeName(cc);
                    phoneBook.replaceContacts(con, cc);
                    break;
                }
                case "address":{
                    cc = (CompanyContact) changeAddress(cc);
                    phoneBook.replaceContacts(con, cc);
                    break;
                }
                case "number":{
                    cc = (CompanyContact) changeNumber(cc);
                    phoneBook.replaceContacts(con, cc);
                    break;
                }
            }
            System.out.println("Saved \n");
            System.out.println(con.toString()+"\n");

        } else if (con instanceof PersonContact){
            PersonContact pc = (PersonContact) con;
            System.out.println("Select a field (name, surname, birth, gender, number)");
            String field = scan.nextLine();
            switch (field){
                case "name":{
                    pc = (PersonContact) changeName(pc);
                    phoneBook.replaceContacts(con, pc);
                    break;
                }
                case "surname":{
                    pc = (PersonContact) changeSurname(pc);
                    phoneBook.replaceContacts(con,pc);
                    break;
                }
                case "birth":{
                    pc = (PersonContact) changeBirthDate(pc);
                    phoneBook.replaceContacts(con,pc);
                    break;
                }
                case "gender":{
                    pc = (PersonContact) changeGender(pc);
                    phoneBook.replaceContacts(con,pc);
                    break;
                }
                case "number":{
                    pc = (PersonContact) changeNumber(pc);
                    phoneBook.replaceContacts(con, pc);
                    break;
                }
            }
            System.out.println("Saved \n");
            System.out.println(con.toString()+"\n");
        }
    }

    private static Contact changeName(Contact contact){
        System.out.println("Enter name: ");
        String name = scan.nextLine();
        contact.setName(name);
        contact.setTimeLastEdit(LocalDateTime.now().withSecond(0).withNano(0));
        return contact;
    }

    private static Contact changeSurname(PersonContact contact){
        System.out.println("Enter surname: ");
        String surname = scan.nextLine();
        contact.setSurname(surname);
        contact.setTimeLastEdit(LocalDateTime.now().withSecond(0).withNano(0));
        return contact;
    }

    private static Contact changeBirthDate(PersonContact contact){
        System.out.println("Enter birth date: ");
        String birthDate = scan.nextLine();
        if (!CheckCorrectness.checkDate(birthDate)){
            System.out.println("Bad birth date!");
            birthDate = "[no data]";
        }
        contact.setBirthDate(birthDate);
        contact.setTimeLastEdit(LocalDateTime.now().withSecond(0).withNano(0));
        return contact;
    }

    private static Contact changeGender(PersonContact contact){
        System.out.println("Enter gender(M, F): ");
        String gender = scan.nextLine();
        if (gender.equals("M")){
            gender = "M";
        }else if (gender.equals("F")){
            gender = "F";
        } else {
            gender = "[no data]";
        }
        contact.setGender(gender);
        contact.setTimeLastEdit(LocalDateTime.now().withSecond(0).withNano(0));
        return contact;
    }

    private static Contact changeNumber(Contact contact){
        System.out.println("Enter phone number: ");
        String phoneNumber = scan.nextLine();
        if (!CheckCorrectness.checkNumber(phoneNumber)){
            System.out.println("Wrong number format");
            phoneNumber = "[no data]";
        }
        contact.setPhoneNumber(phoneNumber);
        contact.setTimeLastEdit(LocalDateTime.now().withSecond(0).withNano(0));
        return contact;
    }

    private static Contact changeAddress(CompanyContact contact){
        System.out.println("Enter address: ");
        String address = scan.nextLine();
        contact.setAddress(address);
        contact.setTimeLastEdit(LocalDateTime.now().withSecond(0).withNano(0));
        return contact;

    }




}
