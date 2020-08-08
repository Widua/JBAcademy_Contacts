package Commands;

public class CountCommand implements Command {
    @Override
    public void execute() {
        System.out.println("the Phone Book has "+phoneBook.getSize()+" records");
    }

    public static int size(){
        return phoneBook.getSize();
    }
}
