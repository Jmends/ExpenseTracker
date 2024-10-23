import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ExpenseManager {
    private List<Expense> expenses;
    private static final String FILE_NAME = "C:\\Users\\jonat\\Desktop\\ExpenseTracker\\Expenses.txt";

    public ExpenseManager() {
        expenses = new ArrayList<>();
        loadExpenses();
    }

    public void loadExpenses() {
        DateTimeFormatter dateformatter = DateTimeFormatter.ofPattern("dd-MM-yy");
        try (BufferedReader read = new BufferedReader(new FileReader(FILE_NAME))) {
            if (Files.exists(Paths.get(FILE_NAME))) {
                String line;
                while ((line = read.readLine()) != null) {
                    if (line.trim().isEmpty()) {
                        continue;
                    }

                    String[] data = line.split(" ");
                    if (data.length < 4) {
                        System.out.println("Skipping malformed line: " + line);

                    }
                    try {
                        int id = Integer.parseInt(data[0]);
                        LocalDate date = LocalDate.parse(data[1], dateformatter);
                        String description = data[2];
                        double amount = Double.parseDouble(data[3]);
                        expenses.add(new Expense(id, date, description, amount));

                    } catch (NumberFormatException e) {
                        System.out.println(e.getMessage());
                    }

                }

            }

        } catch (IOException e) {
            System.out.println("Error in loading expenses: " + e.getMessage());
        }
    }

    public void saveExpenses() {
        try (BufferedWriter write = new BufferedWriter(new FileWriter(FILE_NAME))) {
            DateTimeFormatter dateformatter = DateTimeFormatter.ofPattern("dd-MM-yy");
            for (Expense expense : expenses) {
                String formattedDate = expense.getDate().format(dateformatter);
                write.write(expense.getID() + " " + formattedDate + " " + expense.getDescription() + " "
                        + expense.getAmount());
                write.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error in saving expense: " + e.getMessage());
        }
    }

    public void addExpense(double amount, String description) {
        int id = generateUniqueID();
        Expense expense = new Expense(id, description, amount);
        expenses.add(expense);
        saveExpenses();
        System.out.println("Expense " + expense.getID() + " added");

    }

    private int generateUniqueID() {
        Random random = new Random();
        int id;
        do {
            id = random.nextInt(1000);
        } while (idExists(id));
        return id;

    }

    private boolean idExists(int id) {
        for (Expense expense : expenses) {
            if (expense.getID() == id) {
                return true;
            }
        }
        return false;
    }

    public void deleteExpense(int id) {
        boolean expenseFound = false;

        for (int i = 0; i < expenses.size(); i++) {
            if (expenses.get(i).getID() == id) {
                expenses.remove(i);
                saveExpenses();
                System.out.println("Expense " + id + " has been deleted");
                expenseFound = true;
                break;

            }

        }
        if (!expenseFound) {
            System.out.println("Expense " + id + " not found");
        }
    }

    public void editExpense(int id, String newDescription, double newAmount) {
        boolean expenseFound = false;

        for (Expense expense : expenses) {
            if (expense.getID() == id) {
                expense.setDescription(newDescription);
                expense.setAmount(newAmount);
                saveExpenses();
                System.out.println("Expense " + id + " has been edited");
                expenseFound = true;
                break;
            }

        }
        if (!expenseFound) {
            System.out.println("Expense " + id + " not found");
        }
    }

    public void listExpense() {
        System.out.println("ID - Date - Description - Amount");
        for (Expense expense : expenses) {
            System.out.println(expense);
        }
    }

    public void summary() {
        double total = 0;

        for (Expense expense : expenses) {
            total += expense.getAmount();
        }
        System.out.println("Total expense: " + total);
    }
}
