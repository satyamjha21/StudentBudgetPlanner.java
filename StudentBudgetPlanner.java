import java.util.*;

class Expense {
    String category;
    double amount;

    Expense(String category, double amount) {
        this.category = category;
        this.amount = amount;
    }
}

public class StudentBudgetPlanner {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Expense> expenses = new ArrayList<>();

        double monthlyBudget = 0;

        System.out.println("===== STUDENT BUDGET PLANNER =====");
        System.out.print("Enter your monthly budget: ");
        monthlyBudget = sc.nextDouble();

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Add Expense");
            System.out.println("2. View All Expenses");
            System.out.println("3. Show Total Spent");
            System.out.println("4. Show Remaining Budget");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    sc.nextLine(); // clear buffer
                    System.out.print("Enter category (Food/Travel/Hostel/etc): ");
                    String category = sc.nextLine();

                    System.out.print("Enter amount: ");
                    double amount = sc.nextDouble();

                    expenses.add(new Expense(category, amount));
                    System.out.println("Expense added successfully!");
                    break;

                case 2:
                    if (expenses.isEmpty()) {
                        System.out.println("No expenses recorded.");
                    } else {
                        System.out.println("\n--- Expense List ---");
                        for (Expense e : expenses) {
                            System.out.println("Category: " + e.category + 
                                               " | Amount: ₹" + e.amount);
                        }
                    }
                    break;

                case 3:
                    double total = 0;
                    for (Expense e : expenses) {
                        total += e.amount;
                    }
                    System.out.println("Total Spent: ₹" + total);
                    break;

                case 4:
                    double spent = 0;
                    for (Expense e : expenses) {
                        spent += e.amount;
                    }

                    double remaining = monthlyBudget - spent;

                    System.out.println("Monthly Budget: ₹" + monthlyBudget);
                    System.out.println("Total Spent: ₹" + spent);
                    System.out.println("Remaining Budget: ₹" + remaining);

                    if (remaining < 0) {
                        System.out.println("⚠️ Budget exceeded!");
                    } else if (remaining < monthlyBudget * 0.2) {
                        System.out.println("⚠️ Warning: Budget almost finished!");
                    } else {
                        System.out.println("You're within budget 👍");
                    }
                    break;

                case 5:
                    System.out.println("Exiting Student Budget Planner...");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
