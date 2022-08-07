public class CafeJava {
    public static void main(String[] args) {
        // APP VARIABLES
        // Lines of text that will appear in the app.
        String generalGreeting = "Welcome to Cafe Java, ";
        String orderedMessage = ", ordered ";
        String pendingMessage = ", your order will be ready shortly.";
        String readyMessage = ", your order is ready.";
        String displayTotalMessage = "Your total is $%.2f.\n";
        String errorMessage = "Sorry for the mix-up, your new calcuated total is $%.2f.\n";

        // Menu variables // Create 3 more drink price variables, for drip coffee, latte
        // and cappucino following the same camel case naming convention.
        double mochaPrice = 3.50;
        double dripCoffeePrice = 2.75;
        double lattePrice = 3.25;
        double cappucinoPrice = 4.99;

        // Customer name variables // Create 3 more customer variables for Sam, Jimmy
        // and Noah, following the same variable naming convention in the example.
        String customer1 = "Cindhuri";
        String customer2 = "Sam";
        String customer3 = "Jimmy";
        String customer4 = "Noah";

        // Order completions // Create the order status flag (true/false) for each
        // customer, following the variable naming convention in the example.
        boolean isReadyOrder1 = false;
        boolean isReadyOrder2 = false;
        boolean isReadyOrder3 = false;
        boolean isReadyOrder4 = true;

        // APP INTERACTION SIMULATION

        // Cindhuri ordered a coffee. Print to the console the correct status message,
        // based on her order status.
        System.out.println(generalGreeting + customer1);
        System.out.println(customer1 + orderedMessage + "one mocha.");
        System.out.printf(displayTotalMessage, mochaPrice);
        System.out.println(customer1 + pendingMessage);
        System.out.println("*****************************************************");

        // Noah ordered a cappucino. Use an if statement to check the status of his
        // order and print the correct status message. If it is ready, also print the
        // message to display the total.
        System.out.println(generalGreeting + customer4);
        System.out.println(customer4 + orderedMessage + "one cappucino.");
        if (isReadyOrder4) {
            System.out.println(customer4 + readyMessage);
            System.out.printf(displayTotalMessage, cappucinoPrice);
        } else {
            System.out.println(customer4 + pendingMessage);
        }
        System.out.println("*****************************************************");

        // Sam just ordered 2 lattes, print the message to display their total. Next,
        // use an if statement to print the appropriate order status message. Change the
        // isReady flag value from true to false or vice versa in order to test your
        // control logic (if-statement).
        System.out.println(generalGreeting + customer2);
        System.out.println(customer2 + orderedMessage + "two lattes.");
        System.out.printf(displayTotalMessage, (lattePrice * 2));
        if (isReadyOrder2) {
            System.out.println(customer4 + readyMessage);
        } else {
            System.out.println(customer4 + pendingMessage);
        }
        isReadyOrder2 = true; // Sam's order is now ready
        if (isReadyOrder2) {
            System.out.println(customer4 + readyMessage);
        } else {
            System.out.println(customer4 + pendingMessage);
        }
        System.out.println("*****************************************************");

        // Jimmy just realized he was charged for a coffee but had ordered a latte.
        // Print the total message with the new calculated total (what he owes) to make
        // up the difference.
        System.out.println(generalGreeting + customer3);
        System.out.println(customer3 + orderedMessage + "one latte.");
        System.out.printf(errorMessage, (lattePrice - dripCoffeePrice));
    }
}