import java.time.LocalDate;

public class Expense {
    private int id;
    private LocalDate date;
    private String description;
    private double amount;

    public Expense(int id, String description, double amount) {
        this.id = id;
        this.date = LocalDate.now();
        this.description = description;
        this.amount = amount;
    }

    public Expense(int id,LocalDate date, String description, double amount){
        this.id = id;
        this.date = date;
        this.description = description;
        this.amount = amount;
    }

    public int getID() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public String toString() {
        return id + "\t" + date + "\t" + description + "\t" + amount;
    }

}