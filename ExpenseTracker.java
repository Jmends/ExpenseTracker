
public class ExpenseTracker {
    public static void main(String[] args) {
        ExpenseManager manager = new ExpenseManager();
        

        if(args.length == 0){
            System.out.println("Please provide a command");
            return;
        }

        String command = args[0];

        switch (command) {
            case "add":
                break;
            case "delete":
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
