
public class DeluxeSpaRoom extends Room {
    private boolean hasHotTub;

    // Default constructor
    public DeluxeSpaRoom() {
        super(); // use to call parent class constructor
        this.hasHotTub = false;
    }

    // Parameterized constructor
    public DeluxeSpaRoom(int roomID, String features, String description, double price, boolean hasHotTub) {
        super(roomID, features, description, price); // Calling parent class constructor
        this.hasHotTub = hasHotTub;
    }

    // Getter and setter for hasHotTub
    public boolean hasHotTub() {
        return hasHotTub;
    }

    public void setHasHotTub(boolean hasHotTub) {
        this.hasHotTub = hasHotTub;
    }

    @Override
    public void setPrice(double price) {
        if (hasHotTub) {
            super.setPrice(price + 80); // Adding extra $80 if the room has a hot tub
        } else {
            super.setPrice(price);
        }
    }

    // toString method to return all details of the room
    @Override
    public String toString() {
        return "Deluxe Spa Room - " + super.toString() + ", Has Hot Tub: " + hasHotTub;
    }
}
