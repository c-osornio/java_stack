public class TestOrders {
    public static void main(String[] args) {
        
        CoffeeKiosk coffeeKiosk = new CoffeeKiosk();

        // Menu
        coffeeKiosk.addMenuItem("drip coffee", 3.50);
        coffeeKiosk.addMenuItem("mocha", 4.25);
        coffeeKiosk.addMenuItem("latte", 2.99);
        coffeeKiosk.addMenuItem("cappucino", 2.75);


        coffeeKiosk.addMenuItemByInput();
        coffeeKiosk.newOrder();
    }
} 