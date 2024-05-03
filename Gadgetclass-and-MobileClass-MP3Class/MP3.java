/**
 * A class to represent an MP3 player.
 */
public class MP3 extends Gadget {
    // Additional attribute
    private int availableMemory; // in megabytes

    // Constructor
    public MP3(String model, double price, int weight, String size, int availableMemory) {
        super(model, price, weight, size); // Call superclass constructor
        this.availableMemory = availableMemory;
    }

    // Accessor method for availableMemory
    public int getAvailableMemory() {
        return availableMemory;
    }

    // Method for downloading music
    public void downloadMusic(int memoryRequired) {
        if (memoryRequired <= availableMemory) {
            availableMemory -= memoryRequired;
            System.out.println("Music downloaded successfully.");
        } else {
            System.out.println("Insufficient memory to download music.");
        }
    }

    // Method for deleting music
    public void deleteMusic(int memoryFreed) {
        availableMemory += memoryFreed;
        System.out.println("Music deleted successfully.");
    }

    // Method to display details of the MP3 player
    public void display() {
        super.display(); // Call display method of the GadgetClass
        System.out.println("Available Memory: " + availableMemory + "MB");
    }
}
