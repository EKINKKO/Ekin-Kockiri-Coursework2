/**
 * This is a class to represent the GadgetClass
 */
public class Gadget {
    // Attributes
    private String model;
    private double price;
    private int weight;
    private String size;

    // Constructor
    public Gadget(String model, double price, int weight, String size) {
        this.model = model;
        this.price = price;
        this.weight = weight;
        this.size = size;
    }

    // Accessor methods
    /**
     * This is to get and return the model 
     */
    public String getModel() {
        return model;
    }

    /**
     * this is to get and return the price of the gadget 
     */
    public double getPrice() {
        return price;
    }

    /**
     * to get and return the weight of the gadget 
     */
    public int getWeight() {
        return weight;
    }

    /**
     * to get and return the size of the gadget 
     */
    public String getSize() {
        return size;
    }

    // Display method
    /**
     * this is to display the properties of the Gadget 
     */
    public void display() {
        System.out.println("Model: " + model);
        System.out.println("Price: £" + price);
        System.out.println("Weight: " + weight + " grams");
        System.out.println("Size: " + size);
    }
}
