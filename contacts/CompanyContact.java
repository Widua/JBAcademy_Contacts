package contacts;

public class CompanyContact extends Contact {
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString(){
        return "Organization name: "+ getName()+"\n"
                + "Address: "+ getAddress()+"\n"
                + "Number: "+getPhoneNumber()+"\n"
                +"Time created: "+ getTimeCreated()+"\n"
                +"Time last edit: "+ getTimeLastEdit();

    }

}
