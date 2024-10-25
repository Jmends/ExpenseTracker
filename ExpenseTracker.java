import java.util.Scanner;
public class ExpenseTracker {
    public static void main(String[] args) {
        ExpenseManager manager = new ExpenseManager();
        Scanner scan = new Scanner(System.in);

        if (args.length == 0) {
            System.out.println("Please provide a command");
            return;
        }

        String command = args[0];
        

        switch (command) {
            case "add":
                if (args.length == 5 && args[1].equals("--description")
                        && args[3].equals("--amount")) {
                    String description = args[2];
                    double amount = Double.parseDouble(args[4]);
                    manager.addExpense(amount, description);

                }
                break;
            case "delete":
                if(args.length == 3){
                    int id = Integer.parseInt(args[2]);
                    manager.deleteExpense(id);
                }
                break;
            case "edit":
                if(args.length == 1){
                    manager.listExpense();
                    System.out.println("What is the ID of the expense youd like to edit? ");
                    int newID = scan.nextInt();

                    scan.nextLine();

                    System.out.println("What is the new description? ");
                    String newDescription = scan.nextLine();

                    System.out.println("What is the new amount? ");
                    double newAmount = scan.nextDouble();

                    manager.editExpense(newID, newDescription, newAmount);


                }
                break;
            case "list":
                if(args.length == 1){
                    manager.listExpense();
                }
                break;
            case "summary":
                if(args.length == 1){
                    manager.summary();
                }
                break;
            default:
                break;
        }
    }
}
