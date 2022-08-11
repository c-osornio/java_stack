import java.util.ArrayList;

// Create the testing file TestOrders and complete the rest of the tasks inside the testing file.
public class TestOrders {
    public static void main(String[] args) {
    
        // Create 4 item variables of type Item and instantiate each as an Item object. Name them item1, item2 etc.
        // Set the price and the name for each -- "mocha", "latte", "drip coffee" and "capuccino" (price is up to you!)
        // Menu items
        Item item1 = new Item("mocha", 3.50);
        Item item2 = new Item("latte", 4.75 );
        Item item3 = new Item("drip coffee", 2.99);
        Item item4 = new Item("capuccino", 3.25);

        // Create 4 order variables of type Order and instantiate each as an Order object. Name them order1, order2 etc.
        // Order variables -- order1, order2 etc.
        Order order1 = new Order();
        Order order2 = new Order();
        Order order3 = new Order();
        Order order4 = new Order();

        // Set each order's name -- "Cindhuri", "Jimmy", "Noah", "Sam".
        order1.name = "Cindhuri";
        order2.name = "Jimmy";
        order3.name = "Noah";
        order4.name = "Sam";

        // Print the order1 variable to the console to see what happens.
        System.out.println(order1);  // shows the object name and the location in memory

        // Predict what will happen if you print order1.total
        System.out.println(order1.total); // Prints the default

        // Add item1 to order2's item list and increment the order's total.
        order2.items.add(item1);
        order2.total += item1.price;

        // order3 ordered a cappucino. Add the cappuccino to their order list and to their tab.
        order3.items.add(item4);
        order3.total += item4.price;

        // order4 added a latte. Update accordingly.
        order4.items.add(item2);
        order4.total += item2.price;

        // Cindhuri’s order is now ready. Update her status.
        order1.ready = true;

        // Sam ordered more drinks - 2 lattes. Update their order as well.
        order4.items.add(item2);
        order4.items.add(item2);
        order4.total += item2.price * 2;

        // Jimmy’s order is now ready. Update his status.
        order2.ready = true;

        // Application Simulations
        // Use this example code to test various orders' updates
        System.out.println("----------Testing Orders ----------");
        System.out.printf("Name: %s\n", order1.name);
        System.out.printf("Total: $%.2f\n", order1.total);
        System.out.printf("Ready: %s\n\n", order1.ready);

        System.out.printf("Name: %s\n", order2.name);
        System.out.printf("Total: $%.2f\n", order2.total);
        System.out.printf("Ready: %s\n\n", order2.ready);

        System.out.printf("Name: %s\n", order3.name);
        System.out.printf("Total: $%.2f\n", order3.total);
        System.out.printf("Ready: %s\n\n", order3.ready);

        System.out.printf("Name: %s\n", order4.name);
        System.out.printf("Total: $%.2f\n", order4.total);
        System.out.printf("Ready: %s\n\n", order4.ready);
    }
}
