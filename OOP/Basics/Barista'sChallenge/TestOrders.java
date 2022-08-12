import java.util.ArrayList;

public class TestOrders {
    public static void main(String[] args) {
        // Menu
        Item item1 = new Item("drip coffee", 3.50);
        Item item2 = new Item("mocha", 4.25);
        Item item3 = new Item("latte", 2.99);
        Item item4 = new Item("cappucino", 2.75);

        //Create 2 orders for unspecified guests (without specifying a name);
        Order order1 = new Order();
        Order order2 = new Order();
        
        //Create 3 orders using the overloaded constructor to give each a name for the order.
        Order order3 = new Order("Charlie");
        Order order4 = new Order("Aidee");
        Order order5 = new Order("Kai");

        //Add at least 2 items to each of the orders using the addItem method you wrote.
        order1.addItem(item1);
        order1.addItem(item2);
        order2.addItem(item2);
        order2.addItem(item2);
        order3.addItem(item3);
        order3.addItem(item4);
        order3.addItem(item4);
        order4.addItem(item1);
        order4.addItem(item1);
        order5.addItem(item3);
        order5.addItem(item4);

        // Test the results and the display method by calling the display method on all of your orders.
        order1.display();
        order2.display();
        order3.display();
        order4.display();
        order5.display();

        // Test your getStatusMessage functionality by setting some orders to ready and printing the messages for each order.
        order1.setReady(true);
        order3.setReady(true);
        System.out.println(order1.getStatusMessage());
        System.out.println(order2.getStatusMessage());
        System.out.println(order3.getStatusMessage());
        System.out.println(order4.getStatusMessage());
        System.out.println(order5.getStatusMessage());

        // Test the total by printing the return value like so: System.out.println(order1.getOrderTotal());
        System.out.println(order1.getOrderTotal());
        System.out.println(order2.getOrderTotal());
        System.out.println(order3.getOrderTotal());
        System.out.println(order4.getOrderTotal());
        System.out.println(order5.getOrderTotal());
    }
} 