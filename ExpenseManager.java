import java.util.ArrayList;
import java.util.List;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;

public class ExpenseManager {
    private List<Expense> expenses;
    private static final String FILE_NAME = "Expenses.txt";

    public ExpenseManager() {
        expenses = new ArrayList<>();
    }

    public void loadExpenses() {

    }

    public void saveExpenses() {
        try (BufferedWriter write = new BufferedWriter(new FileWriter(FILE_NAME))) {
            DateTimeFormatter dateformatter = DateTimeFormatter.ofPattern("dd-MM-yy");
            for (Expense expense : expenses) {
                String formattedDate = expense.getDate().format(dateformatter);
                write.write(String.format("%d,%s,%s,%.2f\n", expense.getID(), formattedDate, expense.getDescription(),
                        expense.getAmount()));
            }
        } catch (IOException e) {
            System.out.println("Error in saving expense: " + e.getMessage());
        }
    }

    public void addExpense(double amount, String description) {
        int id = expenses.size() + 1;
        Expense expense = new Expense(id, description, amount);
        expenses.add(expense);

        System.out.println("Expense " + expense.getID() + " added");

    }

    public void deleteExpense(int id) {

    }

    public void editExpense(int id, String newDescription, double newAmount) {

    }

    public void listExpense() {

    }
}
