// FamilySuite.java
public class FamilySuite extends Room {
    private int queenBeds;
    private int singleBeds;

    // Default constructor
    public FamilySuite() {
        super();
        this.queenBeds = 1;
        this.singleBeds = 2;
    }

    // Parameterized constructor
    public FamilySuite(int roomID, String features, String description, double price, int queenBeds, int singleBeds) {
        super(roomID, features, description, price);
        this.queenBeds = queenBeds;
        this.singleBeds = singleBeds;
        setPrice(price);
    }

    // Getter and Setter methods for queenBeds and singleBeds
    public int getQueenBeds() {
        return queenBeds;
    }

    public void setQueenBeds(int queenBeds) {
        this.queenBeds = queenBeds;
    }

    public int getSingleBeds() {
        return singleBeds;
    }

    public void setSingleBeds(int singleBeds) {
        this.singleBeds = singleBeds;
    }

    @Override
    public void setPrice(double price) {
        double discountedPrice = price - (price * 0.2); // 20% discount
        super.setPrice(discountedPrice);
    }

    // Override toString method to return details about the FamilySuite
    @Override
    public String toString() {
        return "Family Suite Room ID: " + getRoomID() + "\n"
                + "Features: " + getFeatures() + "\n"
                + "Description: " + getDescription() + "\n"
                + "Price after 20% discount: $" + getPrice() + "\n"
                + "Queen Beds: " + queenBeds + ", Single Beds: " + singleBeds;
    }
}
