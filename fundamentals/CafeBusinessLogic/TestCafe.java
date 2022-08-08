import java.util.ArrayList;
import java.util.Arrays;


public class TestCafe {
    public static void main(String[] args) {

        /* ============ App Test Cases ============= */
        CafeUtil appTest = new CafeUtil();
        System.out.println("\n----- Streak Goal Test -----");
        System.out.printf("Purchases needed by week 10: %s \n\n", appTest.getStreakGoal(10));
    
        System.out.println("----- Order Total Test-----");
        double[] lineItems = {3.5, 1.5, 4.0, 4.5};
        System.out.printf("Order total: %s \n\n",appTest.getOrderTotal(lineItems));
        
        System.out.println("----- Display Menu Test-----");
        
        ArrayList<String> menu = new ArrayList<String>();
        menu.add("drip coffee");
        menu.add("cappuccino");
        menu.add("latte");
        menu.add("mocha");
        appTest.displayMenu(menu);
    
        // Sensei Bonus: Implement the addCustomers method.
        System.out.println("\n----- Add Customer Test-----");
        ArrayList<String> customers = new ArrayList<String>();
        // --- Test 4 times ---
        for (int i = 0; i < 4; i++) {
            appTest.addCustomer(customers);
            System.out.println("\n");
        }

        System.out.println("----- Price Chart Test-----");
        appTest.printPriceChart("Columbian Coffee Grounds",15.00, 3);
        appTest.printPriceChart("Senpai Test Coffee", 2.00, 4);    

        System.out.println("----- Display Menu NINJA BONUS Test-----");
        ArrayList<Double> prices = new ArrayList<Double>();
        prices.add(1.5); 
        prices.add(3.5); 
        prices.add(4.5); 
        prices.add(3.5); 
        appTest.displayMenu(menu, prices);

        System.out.println("\n----- Barista Adding Test-----");
        ArrayList<String> newCustomers = new ArrayList<String>();
        appTest.addCustomers(newCustomers);
    }
}
