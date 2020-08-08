package contacts;



public class PersonContact extends Contact {

    String surname;
    String birthDate;
    String gender;

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSurname() { return surname; }
    public void setBirthDate(String date){
        this.birthDate = date;
    }

    public String getBirthDate(){
        return birthDate;
    }

    public String getGender(){
        return gender;
    }

    @Override
    public String toString(){
      return "Name: "+ this.getName() + "\n"
      + "Surname: "+this.getSurname()+"\n"
      + "Birth date: "+this.getBirthDate()+"\n"
      + "Gender: "+this.getGender()+"\n"
      + "Number: "+ this.getPhoneNumber()+"\n"
      +"Time created: "+ getTimeCreated()+"\n"
      +"Time last edit: "+ getTimeLastEdit();
    }

}
