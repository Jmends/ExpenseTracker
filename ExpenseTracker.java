
public class ExpenseTracker {
    public static void main(String[] args) {
        ExpenseManager manager = new ExpenseManager();

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
                break;
            case "list":
                break;
            case "summary":
                break;
            default:
                break;
        }
    }
}
