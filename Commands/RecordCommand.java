package Commands;

import contacts.Contact;

public class RecordCommand implements Command {
    private CommandController cc = new CommandController();
    private Contact con;
    private int index;
    @Override
    public void execute() {
        String action;
        while (true){
        System.out.println("[record] Enter action (edit, delete, menu)");
        action = scan.nextLine();
        switch (action){
            case "edit":{
                EditCommand edit = new EditCommand();
                cc.setCommand(edit);
                edit.setContact(con);
                edit.setIndex(index);
                System.out.println("");
                cc.executeCommand();
                break;
            }
            case "delete":{
                RemoveCommand rm = new RemoveCommand();
                cc.setCommand(rm);
                System.out.println("");
                cc.executeCommand();
                break;

            }
            case "menu":{
                System.out.println("");
                return;
            }
        }
    }
    }
    public void chooseRecord(Contact con, int index) {
        this.con = con;
        this.index = index;
    }

}
