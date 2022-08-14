import java.util.ArrayList;

public class CoffeeKiosk {
    
    // MEMBER VARIABLES
    private ArrayList<Item> menu;
    private ArrayList<Order> orders;

    // CONSTRUCTOR 
    public CoffeeKiosk() {
        this.menu = new ArrayList<Item>();
        this.orders = new ArrayList<Order>();
    }

    // METHODS
    public void addMenuItem(String name, double price) {
        // creates a new item and add to menu ArrayList
        Item newItem = new Item(name, price); 
        menu.add(newItem);
        // Get the index of the new item and assign it as the index member variable
        int index = menu.indexOf(newItem);
        newItem.setIndex(index);
    }

    public void displayMenu() {
        for (Item item : menu) {
            System.out.printf("%s %s -- $%.2f\n", item.getIndex(), item.getName(), item.getPrice());
        }
    }

    public void newOrder() {
        
    	// Shows the user a message prompt and then sets their input to a variable, name
        System.out.println("Please enter customer name for new order:");
        String name = System.console().readLine();
    
        // Create a new order with the given input string
        Order newOrder = new Order(name);

        // Show the user the menu, so they can choose items to add.
        displayMenu();

    	// Prompts the user to enter an item number
        System.out.println("Please enter a menu item index or q to quit:");
        String itemNumber = System.console().readLine();
        
        // Write a while loop to collect all user's order items
        // Get the item object from the menu, and add the item to the order
        // Ask them to enter a new item index or q again, and take their input
        while(!itemNumber.equals("q")) {
            int i = Integer.parseInt(itemNumber);
            if(i < menu.size()) {
                newOrder.addItem(menu.get(i));
            } else {
                System.out.println("Please choose a valid item from the menu.");
            }
            System.out.println("Please enter another menu item index or q to quit:");
            itemNumber = System.console().readLine();
        }
        // After you have collected their order, print the order details 
    	// as the example below. You may use the order's display method.
        newOrder.display();
        orders.add(newOrder);
    }

    // Create a method that lets an admin add menu items manually, using what you now know about getting user input.
    public void addMenuItemByInput(){
        System.out.print("Please enter the new menu item's name: ");
        String name = System.console().readLine();
        System.out.print("Please enter the price for the new menu item: $");
        double price = Double.parseDouble(System.console().readLine());
        addMenuItem(name, price);
        displayMenu();
    }
}