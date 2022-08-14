import java.util.ArrayList;
    
// Here we're creating a new data type called Order
public class Order {
    
    // MEMBER VARIABLES
    private String name; // default value of null
    private boolean ready; // default value false
    private ArrayList<Item> items;
    
    // CONSTRUCTOR
    // No arguments, sets name to "Guest", initializes items as an empty list.
    public Order() {
        this.name = "Guest";
        items = new ArrayList<Item>();
    }
    
    // OVERLOADED CONSTRUCTOR
    // Takes a name as an argument, sets name to this custom name.
    // Initializes items as an empty list.
    public Order(String name) {
        this.name = name;
        items = new ArrayList<Item>();
    }
    
    // ORDER METHODS
    public void addItem(Item item) {
        this.items.add(item);
    }

    public String getStatusMessage() {
        return ready ? "Your order is ready." : "Thank you for waiting. Your order will be ready soon.";
    }
    
    public double getOrderTotal() {
        double total = 0.00;
        for(Item i: this.items) {
            total += i.getPrice();
        } 
        return total;
    }

    public void display() {
        System.out.printf("\nCustomer Name: %s\n", this.name);
        for(Item i: this.items) {
            System.out.printf("%s - $%.2f\n", i.getName(), i.getPrice());
        }
        System.out.println("Total: $" + this.getOrderTotal());
        }

    // GETTERS & SETTERS
    // getter
    public String getName() {
        return name;
    }
    
    // setter
    public void setName(String name) {
        this.name = name;
    }

    // getter
    public boolean getReady() {
        return ready;
    }

    // setter
    public void setReady(boolean ready) {
        this.ready = ready;
    }

    // getter
    public ArrayList<Item> getItems() {
        return items;
    }

    // setter
    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
}
