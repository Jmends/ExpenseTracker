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


    public int getId() {
        return this.id;
    }

   
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }


    public String toString() {
        return id + "\t" + date + "\t" + description + "\t" + amount;
    }

}