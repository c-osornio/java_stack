import java.util.ArrayList;
import java.text.*;

public class CafeUtil {

    // Implement the getStreakGoal method and test.
    int getStreakGoal(int numWeeks) {
        int result = 0;
        for (int i = 1; i <= numWeeks; i++) {
            result += i;
        }
        return result;
    }

    // Implement the getOrderTotal method and test.
    double getOrderTotal(double[] prices) {
        double total = 0;
        for (int i = 0; i < prices.length; i++) {   
            total += prices[i];
        }
        return total;
    }

    // Implement the displayMenu method and test.
    void displayMenu(ArrayList<String> menuItems) {
        for (int i = 0; i < menuItems.size(); i++) {   
            System.out.println( i + " " + menuItems.get(i));
        }
    }

    // Implement the addCustomer method and test.
    void addCustomer(ArrayList<String> customers) {
        System.out.println("Please enter your name:");
        String userName = System.console().readLine();   // get user input from the terminal and store it in the variable  userName
        System.out.println("Hello, " + userName + "!");
        System.out.println("There are " + customers.size() + " people in front of you" );
        customers.add(userName); // to add customer to ArrayList
        System.out.println(customers);
    }

    // Ninja Bonus: Implement the printPriceChart method.
    // Senpai Bonus: Take $0.50 more off of the original price every time the quantity increases.
    void printPriceChart(String product, double price, int maxQuantity) {
        System.out.println(product);
        double discount = 0.00;
        for (int quantity = 1; quantity <= maxQuantity; quantity++) {
            System.out.printf("%s - $%.2f \n", quantity, ((quantity * price) - discount));  // Sensei bonus:  Format the prices as currency.
            discount += 0.50;
        }
    }

    // Ninja Bonus: Overload the displayMenu method.
    boolean displayMenu(ArrayList<String> menuItems, ArrayList<Double> prices) {
        if (menuItems.size() != prices.size()) {
            return false;
        }
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.printf("%s %s -- $%.2f \n", i, menuItems.get(i), prices.get(i));
        }
        return true;
    }

    // Sensei Bonus! Make a method addCustomers where a barista can enter multiple customers.
    void addCustomers(ArrayList<String> customerList) {
        boolean finished = false;
        String input;
        while (!finished) {
            System.out.println("Please enter a customer name. When finshed enter 'q':");
            input = System.console().readLine();
            if (input.equals("q") || input.equals("Q") ) {
                finished = true;
                return;
            }
            customerList.add(input);
            System.out.printf("%s was added to the list. \n", input);
            System.out.println(customerList);
        }
    }
}