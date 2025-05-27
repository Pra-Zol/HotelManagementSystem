public class DeluxeQueenRoom extends Room {
    private boolean hasBalcony;

    // Default constructor
    public DeluxeQueenRoom() {
        super(); // Calling parent class constructor
        this.hasBalcony = false; // suppose Default value
    }

    // Parameterized constructor
    public DeluxeQueenRoom(int roomID, String features, String description, double price, boolean hasBalcony) {
        super(roomID, features, description, price); // Calling parent class constructor
        this.hasBalcony = hasBalcony;
    }

    // get and set method
    public boolean hasBalcony() {
        return hasBalcony;
    }

    public void setHasBalcony(boolean hasBalcony) {
        this.hasBalcony = hasBalcony;
    }

    // using Override to set a price based on balcony availability
    @Override
    public void setPrice(double price) {
        if (hasBalcony) {
            super.setPrice(price + 50); // suppose 50 $ extra if has balcony on the room
        } else {
            super.setPrice(price);
        }
    }

    // toString method to return all details of the room
    @Override
    public String toString() {
        return "Deluxe Queen Room - " + super.toString() + ", Has Balcony: " + hasBalcony;
    }
}
