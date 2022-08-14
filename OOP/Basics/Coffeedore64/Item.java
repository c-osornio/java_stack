public class Item {
    
    // MEMBER VARIABLES
    private String name;
    private double price;
    private int index;
    
    // CONSTRUCTOR
    //   Takes a name and price as arguments 
    //   and sets them accordingly
    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // GETTERS & SETTERS  - for name and price
    // getter
    public String getName() {
        return name;
    }
    
    // setter
    public void setName(String name) {
        this.name = name;
    }

    // getter
    public double getPrice() {
        return price;
    }

    // setter
    public void setPrice(double price) {
        this.price = price;
    }

    // getter
    public int getIndex() {
        return index;
    }

    // setter
    public void setIndex(int index) {
        this.index = index;
    }
}