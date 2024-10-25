## **ExpenseTracker**

# **Overview**

This is an Expense Tracker application built in java that allows a user to manage and view expenses and prints them to a tetx file for readablity. This program uses command line arguments to run the application. You can add, delete, edit, and list all expenses that have been added to the txt file. You can also get a total summary of the total amount spent by asking for a summary.

### **Instructions**:
- **Adding Expense**: To add an expense you must use the template "java .\ExpenseTracker.java add --description *'description to be listed'* --amount *'dollar amount'* " Must be in this format to run.
- **Deleting Expense**: "java .\ExpenseTracker.java edit" just put edit and the program will ask user for the id and new amount and description they want to replace with.
- **Listing Expenses**: "java .\ExpenseTracker.java list" Just putting list into the command line will list all current records of expenses within the txt file.
- **Dollar amount of all expenses**: "java .\ExpenseTracker.java summary" Putting summary will give add up all the money that is listed in the txt file and print back the total to the user.

  ### **Prerequisites**
- Java Development Kit (JDK) 8 or higher
- A terminal or command-line interface to run the program

### **Installation**
1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/expensetracker.git
   ```
2. Navigate to the project directory:
   ```bash
   cd expensetracker
   ```
3. Compile the Java files:
   ```bash
   javac ExpenseTracker.java
   ```

### 3. **Usage Examples**
Provide clear, real-world examples of the commands to run the application:
### **Usage Examples**
- To add an expense:
  ```bash
  java ExpenseTracker add --description "Groceries" --amount 45.99
  ```
- To delete an expense:
  ```bash
  java ExpenseTracker delete --id 3
  ```
  - To edit all expenses:
  ```bash
  java ExpenseTracker edit
  ```
- To list all expenses:
  ```bash
  java ExpenseTracker list
  ```
  - To get expenses total:
  ```bash
  java ExpenseTracker summary
  ```







