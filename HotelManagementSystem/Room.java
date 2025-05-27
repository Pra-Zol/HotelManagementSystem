import java.util.ArrayList;

public class Room {
    private int roomID;
    private String features;
    private String description;
    private double price;
    private ArrayList<Amenity> amenities;

    // default constructur
    public Room() {
        this.roomID = 0;
        this.features = "unknown";
        this.description = "unknown";
        this.price = 200.0; // Default minimum price
        this.amenities = new ArrayList<>();
    }

    // parameterized constructur
    public Room(int roomID, String features, String description, double price) {
        this.roomID = roomID;
        this.features = features;
        this.description = description;
        this.price = price;
        this.amenities = new ArrayList<>();
    }

    // get and set method
    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    // methods
    public void addAmenity(Amenity amenity) {
        amenities.add(amenity);
    }

    public void removeAmenity(Amenity amenity) {
        amenities.remove(amenity);
    }

    public ArrayList<Amenity> getAmenities() {
        return amenities;
    }

    // calculater to add the price of amenities
    public double calculatePrice() {
        double totalPrice = price;
        for (Amenity amenity : amenities) {
            totalPrice += amenity.getPrice();
        }
        return totalPrice;

    }

    // toString Method
    public String toString() {
        return "Room ID: " + roomID + ", Features: " + features + ", Description: " + description
                + ", Base Price: $" + price + ", Total Price with Amenities: $" + calculatePrice();
    }
}
