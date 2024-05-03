/**
 * A class to represent a mobile phone.
 */
public class Mobile extends Gadget {
    // Additional attribute
    private int callingCreditMinutes;

    // Constructor
    public Mobile(String model, double price, int weight, String size, int callingCreditMinutes) {
        super(model, price, weight, size); // Call superclass constructor
        this.callingCreditMinutes = callingCreditMinutes;
    }

    // Accessor method for callingCreditMinutes
    public int getCallingCreditMinutes() {
        return callingCreditMinutes;
    }

    // Method to add calling credit
    public void addCallingCredit(int creditToAdd) {
        if (creditToAdd > 0) {
            callingCreditMinutes += creditToAdd;
        } else {
            System.out.println("Please enter a positive amount to add calling credit.");
        }
    }

    // Method to make a phone call
    public void makeCall(String phoneNumber, int durationMinutes) {
        if (callingCreditMinutes >= durationMinutes) {
            System.out.println("Calling " + phoneNumber + " for " + durationMinutes + " minutes.");
            callingCreditMinutes -= durationMinutes;
        } else {
            System.out.println("Insufficient calling credit to make the call.");
        }
    }

    // Method to display details of the mobile
    public void display() {
        super.display(); // Call display method of the GadgetClass
        System.out.println("Calling Credit Remaining: " + callingCreditMinutes + " minutes");
    }
}
