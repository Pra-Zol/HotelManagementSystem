// TwoBedroomFamilySuite.java
public class TwoBedroomFamilySuite extends Room {
    private int queenBeds;
    private int attachedBathrooms;

    // Default constructor
    public TwoBedroomFamilySuite() {
        super(); //
        this.queenBeds = 2;
        this.attachedBathrooms = 2;
    }

    // Parameterized constructor
    public TwoBedroomFamilySuite(int roomID, String features, String description, double price, int queenBeds,
            int attachedBathrooms) {
        super(roomID, features, description, price);
        this.queenBeds = queenBeds;
        this.attachedBathrooms = attachedBathrooms;
        setPrice(price);
    }

    // Getter and Setter methods for queenBeds and attachedBathrooms
    public int getQueenBeds() {
        return queenBeds;
    }

    public void setQueenBeds(int queenBeds) {
        this.queenBeds = queenBeds;
    }

    public int getAttachedBathrooms() {
        return attachedBathrooms;
    }

    public void setAttachedBathrooms(int attachedBathrooms) {
        this.attachedBathrooms = attachedBathrooms;
    }

    @Override
    public void setPrice(double price) {
        double discountedPrice = price - (price * 0.05); // 5% discount
        super.setPrice(discountedPrice);
    }

    @Override
    public String toString() {
        return "Two Bedroom Family Suite Room ID: " + getRoomID() + "\n"
                + "Features: " + getFeatures() + "\n"
                + "Description: " + getDescription() + "\n"
                + "Price after 5% discount: $" + getPrice() + "\n"
                + "Queen Beds: " + queenBeds + ", Attached Bathrooms: " + attachedBathrooms;
    }
}
