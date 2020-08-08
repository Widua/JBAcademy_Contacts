package contacts;

import Commands.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        CommandController controller = new CommandController();
        for(int i=0 ; i<args.length ; i++){
            switch (args[i]){
                case "open":{
                    LoadPhoneBookCommand lpbc = new LoadPhoneBookCommand();
                    lpbc.loadFileName(args[i+1]);
                    controller.setCommand(lpbc);
                    controller.executeCommand();
                }
            }
        }
        Scanner scan = new Scanner(System.in);

        while (true){
            System.out.println("[menu] Enter action (add, list, search, count, exit): ");
            String action = scan.nextLine();

            switch (action){
                case "add":{
                    AddCommand add = new AddCommand();
                    controller.setCommand(add);
                    controller.executeCommand();
                    System.out.println();
                    break;
                }
                case "list":{
                    ListCommand list = new ListCommand();
                    controller.setCommand(list);
                    controller.executeCommand();
                    break;
                }
                case "search":{
                    SearchCommand search = new SearchCommand();
                    controller.setCommand(search);
                    controller.executeCommand();
                    break;
                }
                case "count":{
                    CountCommand count = new CountCommand();
                    controller.setCommand(count);
                    controller.executeCommand();
                    System.out.println();
                    break;
                }
                case "exit":{
                    ExitCommand exit = new ExitCommand();
                    controller.setCommand(exit);
                    controller.executeCommand();
                }

            }
        }
    }
}
